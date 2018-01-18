<div id="content" class="content">
         
    Modifier un Article
    
    // up_accueil_post.php est la page où on aura le formulaire pour faire la modif + le script php pour l'UPDATE
         
<form action="test2.php" method="GET" name="submit">   
<?php
 
    // ici j'appelle mon fichier de config pour me connecter à la bdd

	$bdd = new PDO('mysql:host=anteros.istic.univ-rennes1.fr;dbname=base_16011592;charset=utf8', 'user_16011592', '051081912');

 
$requete = $bdd->query('SELECT id, titre FROM accueil');
?>
   
    <select name="id">
<?php
while($donnees = $requete->fetch()){
?>
<option value="<?php echo $donnees['id']; ?>"><?php echo htmlspecialchars($donnees['titre']); ?></option>
<?php
    }
?>
    </select>
<?php
$requete->closeCursor();
?>
    <input type="submit" name="submit" value="Modifier" />
</form>
 
<br />
         
    </div>