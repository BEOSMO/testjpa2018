<div id="content" class="content">
         
   Modifier un Article
          
<?php
 
$bdd = new PDO('mysql:host=anteros.istic.univ-rennes1.fr;dbname=base_16011592;charset=utf8', 'user_16011592', '051081912');  // toujours la connexion à la base de données
 
if(!isset($_GET['id'])) {
 header('Location: test.php');  // si dans ma table aucune valeur ne correspond à l'id selectionnée, je reviens sur la page de sélection des articles qui s'appelle donc up_accueil.php
 die();
}
 
$requete = $bdd->prepare('SELECT * FROM PERSON WHERE id = :id');
$requete->bindValue(':id', $_GET['id'], PDO::PARAM_INT);
$requete->execute();
$donnees = $requete->fetch(PDO::FETCH_ASSOC);
$requete->closeCursor();
 
if(!empty($donnees)) {
 if(isset($_POST['submit'])) {
  $newImage = '';
   
  if(!empty($_FILES['image']['tmp_name'])) {
   $extensions_valides = array( 'jpg' , 'jpeg' , 'gif' , 'png' );
   $extension_upload = strtolower( substr( strrchr($_FILES['image']['name'], '.'), 1));
    
   if($_FILES['image']['size'] <= 2097152 & in_array($extension_upload, $extensions_valides)) {
    $nom = 'images/user/'.basename("image".time().".".$extension_upload);
    if(move_uploaded_file($_FILES['image']['tmp_name'], 'images/user/'.basename("image".time().".".$extension_upload)))
     $newImage = $nom;
   }
  }
   
  $reqStr = 'UPDATE accueil SET titre = :titre, contenu = :contenu ';
  if(!empty($newImage)) $reqStr .= ', imgurl = :imgurl ';
  $reqStr .= 'WHERE id = :id';
   
  $update = $bdd->prepare($reqStr);
  $update->bindValue(':id', $donnees['id'], PDO::PARAM_INT);
  $update->bindValue(':titre', $_POST['titre'], PDO::PARAM_STR);
  $update->bindValue(':contenu', $_POST['contenu'], PDO::PARAM_STR);
  if(!empty($newImage)) $update->bindValue(':imgurl', $newImage, PDO::PARAM_STR);
  $update->execute();
  $update->closeCursor();
   
  $donnees['titre'] = $_POST['titre'];
  $donnees['contenu'] = $_POST['contenu'];
  header('Location: index.php');  // et si tout s'est bien passé je redirige vers la page où se trouve mon article, histoire que l'utilisateur puisse apprécier de suite le fruit de son travail
 }
 
 echo '<form method="POST" action="up_accueil_form.php?id=' . $donnees['id'] . '" enctype="multipart/form-data">  // l'action qui revient donc sur la même page pour faire le traitement
   <label for="titre">Titre de votre article :</label>
   <input type="text" name="titre" id="titre" value="' . htmlspecialchars($donnees['titre']) . '" /><br />
 
   <label for="contenu">Contenu :</label>
   <textarea rows="4" cols="50" name="contenu" id="contenu">' . htmlspecialchars($donnees['contenu']) . '</textarea><br />
 
   Image actuelle de votre article :<br/>
   <img src="' . $donnees['imgurl'] . '" alt="" width="200px"/><br/>
 
   <label for="image">Si vous souhaitez changer l\'image, sélectionnez-la ci-dessous (tous formats | max. 2 Mo) :</label><br />
   <input type="file" name="image" id="image" value="' . htmlspecialchars($donnees['imgurl']) . '"/><br />
   <input type="submit" name="submit" value="Modifier" /><br/><br/>
  </form>';
}
else {
 // L'entrée n'existe pas
}
?>
    </div>