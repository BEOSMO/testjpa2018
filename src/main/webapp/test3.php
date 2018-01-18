

<?php

try

{

    // On se connecte à MySQL

    $bdd = new PDO('mysql:host=anteros.istic.univ-rennes1.fr;dbname=base_16011592;charset=utf8', 'user_16011592', '051081912');


}

catch(Exception $e)

{

    // En cas d'erreur, on affiche un message et on arrête tout

        die('Erreur : '.$e->getMessage());

}


// Si tout va bien, on peut continuer


// On récupère tout le contenu de la table ElectronicDevice

$reponse = $bdd->query('SELECT * FROM ElectronicDevice');


// On affiche chaque entrée une à une

while ($donnees = $reponse->fetch())

{

?>

    <p>

    <strong>Device</strong> : <?php echo $donnees['id']; ?><br />

    Les watts : <?php echo $donnees['watts']; ?>, person_id :<?php echo $donnees['p_id']; ?> <br />

   </p>

<?php

}


$reponse->closeCursor(); // Termine le traitement de la requête


?>