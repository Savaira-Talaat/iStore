# Istore Project
[![forthebadge](https://forthebadge.com/images/featured/featured-built-with-love.svg)](https://forthebadge.com)[![forthebadge](https://forthebadge.com/images/featured/featured-powered-by-electricity.svg)](https://forthebadge.com)

Istore est une application de gestion de stocks en Java, incluant une interface utilisateur. L'application permet aux utilisateurs de consulter et modifier les inventaires des magasins tout en respectant un système de permissions basé sur les rôles (admin et employé).

## Description du projet
Ce projet consiste à développer une application de gestion de stocks en Java, avec une interface utilisateur permettant de gérer les stocks d'un ou plusieurs magasins. L'application offre une authentification sécurisée permettant aux utilisateurs de créer un compte et de se connecter. Selon leur rôle (administrateur ou employé), les utilisateurs peuvent consulter, ajouter, modifier ou supprimer des articles dans l'inventaire d'un magasin.

Fonctionnalités principales :
Gestion des utilisateurs : Création, lecture, mise à jour et suppression des comptes utilisateurs avec un système de rôles (admin/employé).
Authentification sécurisée : Création de comptes via email et mot de passe, connexion avec vérification de sécurité et le mot de passe est haché grâce à librairie JBencrypt.
Gestion des magasins et des inventaires : Les administrateurs peuvent ajouter ou supprimer des magasins, et gérer l'inventaire de chaque magasin. Les employés peuvent consulter l'inventaire et modifier les quantités des articles.
Gestion des articles : Les articles ont des propriétés comme l'id, le nom, le prix et la quantité disponible. La quantité ne peut pas être inférieure à 0.

### Pré-requis
Avant de pouvoir exécuter l'application, assurez-vous que votre environnement de développement soit correctement configuré. Voici les éléments nécessaires pour faire fonctionner ce projet :
1. Java Development Kit (JDK)
Version requise : Java 8 ou supérieure.
Téléchargez et installez le JDK depuis le site officiel de Java ou via un gestionnaire de paquets comme SDKMAN.
2. IDE (Environnement de développement intégré)
Utilisez un IDE pour développer et exécuter le projet, tel que :
IntelliJ IDEA (Celui que nous avons utilisé pour le projet.)
Eclipse
3. Base de données :
Une base de données MySQL est utilisée pour stocker les données de ce projet. Il faudrait donc penser à créer une base de donnée (le fichier de la base de donnée se trouve dans le dossier). Si vous êtes sous MAC veillez à modifier le port associé au lien pour la connexion à la base de donnée dans src/database/ConnexionDatabase.java.
4. Bibliothèques supplémentaires
Un gestionnaire de dépendance tel que Maven pour télécharger et gérer les dépendances vous sera utile pour le bon déroulement du programme.

#### Comment lancer le projet
Ouvrez le projet dans votre IDE, rendez vous dans la classe "Main" et exécuter le fichier. Vous aurez l'interface d'inscription/connexion qui se lancera, vous pourrez créer un compte en suivant les instructions, une fois le compte créé un rôle "employé" vous sera automatiquement attribué.
