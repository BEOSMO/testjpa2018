# Ce projet est composé de deux parties (TP 2 et TP 4)

# TP 2 de Systèmes d'informations répartis


## Objectifs du TP

1. Comprendre les mécanismes de JPA
2. Réaliser une application en utilisant JPA en se plaçant dans un cadre classique de développement sans serveur d’application au départ.

## Sujet

L’objectif de ce projet est de construire une application type réseau social permettant de comparer 
sa consommation électrique avec ses amis, ses voisins etc. dans la lignée de opower.

## Le modèle métier de projet

On utilise le concept de Personne ayant un nom un prénom, un mail, une ou plusieurs résidence. 
Chaque résidence a une taille, un nombre de pièce, des chauffages, des équipements électroniques. 
Ses équipements ont une consommation moyenne en Watt/h.

![model](https://cloud.githubusercontent.com/assets/15005875/24684497/b92f1ffe-19a6-11e7-9628-f9a097ea34e2.png)


## Démarrage de la base de données

Nous utilisons le script de démarrage de la base de données (run-hsqldb-server.sh) 
et le script du démarrage du Manager (show-hsqldb.sh).

On modifie notre fichier de persistance.xml pour la connexion de la base de donnée

```
<properties>
        <property name="hibernate.dialect" value="org.hibernate.dialect.HSQLDialect"/>
	<property name="hibernate.hbm2ddl.auto" value="create"/>
    	<property name="toplink.target-database" value="HSQL"/>
        <property name="hibernate.connection.driver_class" value="org.hsqldb.jdbcDriver"/>
        <property name="hibernate.connection.username" value="sa"/>
        <property name="hibernate.connection.password" value=""/>
        <property name="hibernate.connection.url" value="jdbc:hsqldb:hsql://localhost/"/>
        <property name="hibernate.max_fetch_depth" value="3"/>  
</properties>
```
Dans notre fichier de pom.xml nous utilisons ces dépendances au dessous.
```
<dependency>
	<groupId>org.hibernate</groupId>
	<artifactId>hibernate-entitymanager</artifactId>
	<version>4.1.7.Final</version>
</dependency>
<dependency>
	<groupId>org.hsqldb</groupId>
	<artifactId>hsqldb</artifactId>
	<version>2.2.8</version>
</dependency>		
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>5.1.21</version>
</dependency>
```
##  Les classes en entité. 
Nous avons 5 classes en entité
1. Person.java
2. Home.java
3. ElectonicDevice.java
4. Heater.java

Chaque classe est une entité : donc on utilise l'annotation @Entity pour que JPA comprenne qu'il s'agit d'une entité et qu'il va créer une table portant le même nom que la classe.
Toutes les entités possèdent  un id ayant pour annotation @Id



## Le Chargement des données dans la base 

Dans notre fichier  JpaTest java on définit une variable du type "EntityManager" qui nous permet d'utiliser les fonctions de "select","insert","update", etc. entre JPA, API et la base de données et la variable du type "EntityManagerFactory" nous permet de créer la classe entity Manager.

Pour mettre à jour les données régulièrement on fait toutes les actions dans la transaction.

```
public class JpaTest {
	
```		




# TP 4 de Systèmes d'informations répartis

## Objective

1. Comprendre les mécanismes des Servlet
2. Réaliser une application Web en utilisant Combinant JPA et les Servlet
3. Comprendre les principes d’une architecture Rest
4. Comprendre les bénéfices d’un framework comme Jersey

## Sujet 

L’objectif de ce projet est de continuer le développement d’une application type
réseau social permettant de comparer sa consommation électrique avec ses amis, ses voisins,etc. dans la lignée de opower.

## Etape 1 Chargement des dépendances

Tout d’abord, nous avons modifié notre fichier pom.xml pour ajouter les dépendances nécessaires

```
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>javax.servlet-api</artifactId>
	<version>3.0.1</version>
	<scope>provided</scope>
</dependency>
```
## Insertion et visualisation dés données en utilisant les  Servlets

Nous avons crée 2 formulaires


Même principe pour ce qui concerne les maisons.

## Création des Servlets
Précédemment, nous avons mis  «/UserInfo » et « /HomeInfo » comme action des formulaires. Ces deux url référencie  l’url de notre  servlet soit en GET ou bien en POST, les servlets jouent un rôle de contrôleurs dans notre application 

Donc nous avons crée une servlet pour chaque formulaire comme ceci:

### HomeInfo.java - UserInfo.java

Dans la partie doGet,

on crée une variable de type collection pour récupérer et afficher les données qui sont dans notre base
```
Collection<Home> result = manager.createQuery("Select h From Home h", Home.class).getResultList();
    out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations sur les maisons</H1>\n" + "<UL>\n");
		for (Home h : result) {
		out.println("<LI> maison : " + h+ "\n");	
		}
		out.println("</UL>\n" + "</BODY></HTML>");
```

Dans la partie doPost,

Ici on crée une maison à partir de données envoyées dans le formulaire home.html
```
		this.ManagerSingleton = ManagerSingleton.getInstance();
		EntityManager manager = this.ManagerSingleton.getManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Home home = new Home();
		home.setNombre_de_piece(Long.valueOf(request.getParameter("piece")));
		home.setTaille(Long.valueOf(request.getParameter("taille")));
		manager.persist(home);
		tx.commit();
		out.println("Enregistrement effectué");

```

Pareil pour la servlet UserInfo.







