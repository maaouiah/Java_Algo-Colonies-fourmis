Projet Master 2 (Java) : Contrôle Continu Système Complexe
===================

###Algorithme de colonies fourmis au problème du voyageur de commerce:

####Principe d’un algorithme de colonies fourmis au problème du voyageur de commerce: 

- D'un point de vue générale, l'algorithme de colonies fourmis basé sur l'aspect «Partage un savoir commun» qui permet de guider leurs futurs choix. Autrement dit, il permet d'indiquer les directions à suivre. Il est inspiré de comportement des fourmis, pour le but de rechercher le chemin optimal dans un graphe. Chaque fois qu'un individu découvre une solution au problème, bonne ou mauvaise, il enrichit la connaissance collective de la colonie qu'elle permet d'aider un nouvel individu d'indiquer son choix. Retournant à la dénomination naturelle, les individus sont des fourmis qui vont se déplacer à la recherche une source de nourriture. À chaque déplacement, les fourmis sécrètent des substances chimiques s'appellent phéromones permet d'indiquer leurs congénères si un chemin est intéressant ou non. C'est-à-dire si un chemin se retrouve fortement phéromones, cela signifiera que beaucoup de fourmis l'ont jugé comme faisant partie d'une solution intéressante et que les fourmis suivantes devront la considérer avec intérêt. Dans notre solution, pour éviter le risque apparaît lorsqu'un chemin non-optimal est marqué, j'ai pris soin de diminuer automatiquement le niveau de phéromone de tout le système. Ainsi, dans le but de remonter l'intérêt des autres chemins qui pourraient faire partie de la solution optimale. Ce paramètre est l'un des paramètres principaux de notre solution, il indique le taux d'évaporation des phéromones.

####Solution : 

#####Introduction : 

- Les itérations de l'algorithme correspondent aux déplacements des fourmis. Pour aller d'un nœud du graphe à un autre, chaque fourmi aura besoin de connaître la liste des nœuds qu'elle a déjà parcourus et les nœuds encore à parcourir. À chaque nœud, la fourmi étudie les itérations possibles calculant leurs niveaux de phéromones respectifs. Une fois arrivée à destination, la fourmi connaît la longueur totale de la solution qu'elle a trouvée. Elle recommence de refaire le chemin en sens inverse pour augmenter ce taux des phéromones et enrichir la connaissance collective de la colonie. 

#####Implémentation :

- Toutes les fourmis sont créées avec le premier état, j'ai donné le droit à l’utilisateur de faire entrer le nombre de fourmis qu’elles vont parcourir le graphe, le nombre de sommets (villes), le taux de phéromones initiales à chaque sommet et l’intervalle de distance entre les sommets. 

- Dans notre programme la classe InputUser.java gérer les inputs de l’utilisateur. Cette classe composée par 4 fonctions : 

	• La fonction InputNombreVille() : récupère le nombre de sommets saisi par l’utilisateur. 

	• La fonction InputNombreFourmis() : récupère le nombre de fourmis saisie par l’utilisateur. 

	• La fonction CreatMatriceDistance() : créer le matrice de distance entre les sommets, les valeurs de matrice définie aléatoirement entre la distance minimale et maximale qu’elles sont choisies par l’utilisateur. La dimension de matrice est le nombre de sommets n (n x n). 

	• La fonction CreatMatricePheromones() : créer le matrice de phéromones entre les sommets, les valeurs initiales de matrice choisie par l’utilisateur. 

	• La fonction CreateListeVilleNonViste() : créer un vecteur contient les indices de sommets. 

- La classe AlgoFourmisVoygComerc qui va contenir le gros du traitement de notre programme. Elle se charge de gérer les parcours de fourmis, de marquer les chemins avec des phéromones et chercher le chemin optimal. Elle est composée par 5 fonctions : 

	• La fonction CalculPheromone() : Pour passer d'une sommet (ville) à l'autre, une fourmi doit analyser les choix possibles. Le choix des villes suivantes en tenant compte de la connaissance collective est une simple roulette aléatoire. 

	• La fonction UpdatePheromone() : Une fois arrivée à destination, le parcours sauvegardé dans un vecteur dynamique donc on refait le chemin en sens inverse pour augmenter le taux de phéromones de ce parcours qui permet enrichir la connaissance collective de la colonie. 

	• La fonction VaporationPheromone() : Après certain temps, le taux de phéromones de chaque sommets baissé automatiquement à travers cette fonction. Elle parcourt tous les sommets et minimiser le taux de phéromones de chaque sommet. Tout naturellement, les chemins les plus courts vont se retrouver plus phéromonés que les autres. 

	• La fonction TraitementAlgoFourmis() : Elle se charge de donner à chaque fourmi une destination à suivre qu'elle soit en recherche ou en train de revenir, elle calcule la somme de distances entre les sommets. Afin de chaque parcours, elle sauvegarde la distance et les sommets de chemin. 

	• La fonction TraitementAlgoFourmis() : Cette fonction permet d’itérer sur le nombre de fourmis et de refaire l’ensemble des traitements nécessaires et se charge de donner le chemin optimal et sa distance associée.