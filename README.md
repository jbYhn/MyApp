# ChuckNorrisJokes
An android app to show list from an API 

Cette appli va nous afficher une liste d'éléments à partir d'un API.
Le but est de pouvoir afficher les éléments de l'API (public de notre choix) 
Puis afficher les détails de chaque élément dès lors qu'on clique sur celui-ci

# Page principale
Voici un apperçu de ma page d'accueil avec la liste des éléments de mon API. Dans mon cas, il s'agit d'une liste de blagues de l'acteur Chuck Norris : https://api.icndb.com/jokes/

![accueil](https://user-images.githubusercontent.com/55489128/82763126-992b5380-9e05-11ea-98f2-6fab751ca19e.png)

# Page de détails
Ensuite une fois qu'on clique sur l'un des éléments, une autre pages s'ouvre avec le détail de l'élément sélectionné.

![detail](https://user-images.githubusercontent.com/55489128/82762588-27053f80-9e02-11ea-9420-c36900efd685.png)


Le bouton previous nous permet de revenir à la page d'accueil afin de resélectionner un autre élément.

# Fonctionalités 


  1. Page principale

    _ Afficher des blagues
    _ Cliquer sur une blague afin d'être redirigé vers la page de détail de la citation choisie

  2. Page Detail

    _ Afficher l'image du personnage (Chuck Norris)
    _ Afficher la blague complète
    _ Retourner vers l'activité principale (Bouton "previous" )

# Tâches

- [x] Mise en place d'une architecture client/server
- [x] Afficher la liste des blagues
- [x] Passer des données d'une page à une autre (Intent)
- [x] Afficher les détails des blagues
- [x] Afficher l'image d'un personnage dans la page détail (Chuck Norris)
- [x] Sauvegarder les données 
- [x] Ajouter un bouton retour en arrière dans la page Detail
