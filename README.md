# pcd2016 - A YouTube Copycat
Projet de conception et de développement 2016.
(This project is licensed under the terms of the Apache License 2.0)

Groupe NaN : Timothy Garwood, Graziella Husson, Quentin Thareau et Valentina Zelaya

*Fonctionnalités 

	- Interface facile à utiliser et 'user-friendly'  --> Squelette implémenté
		-Un menu à gauche qui permet de naviguer dans l'application (actionListeners non implémentés)
			-Boutton accueil (Home) : la page d'accueil de l'application 
			-Boutton recherche (Search) : ouvre une barre de recherche qui ouvre une barre de recherche en haut
			-Boutton mode connecté (WiFi) : passer du mode local au mode connecté
		-Un espace de visionnage au centre avec des tabs par video et par résultats de recherche
		-une barre de recherche en haut qui s'ouvre quand on appuie sur le bouton de recherche
		- Un espace playlist à droite.

	- Pouvoir visionner des vidéos --> API Youtube plus difficile à appréhender que prévu
	 	- en mode connecté 
			- Première release : on a essayé d'utiliser un objet type WebView de JavaFX... on a décidé de ne pas garder 
					    cette implémentation car non seulement elle nous obligeait à mélanger JavaFX et Swing,
						mais cela marché moyennement.
			--> Visionnage imparfait et donc non intégré dans la première release
			- Deuxième release : on a décidé d'utiliser la librairie vlcj qui permet d'utiliser un lecteur VLC dans une application Java.
					    Puisque VLC est capable de lire des vidéos à partir d'une URL mais aussi à partir d'un chemin fichier, cette implémentation est plus adaptée au cahier de charges.

		
	 	- en local

	- Barre de recherche
	 	- en mode connecté --> Implémentée dans la release 2 
			Se connecte à l'API Youtube et fait une requete de recherche avec les mots clé rentrés par l'utilisateur. Affiche les résultats dans des box de manière lisible.
	 	- en mode local
	
	- Playlist 
		- Pouvoir sauvegarder des vidéos dans une playlist affichée sur le côté droit de l'écran 
		- Pouvoir lancer une video de la playlist
		- Pouvoir enlever une vidéo de la playlist 
	
	- Multithreading --> Implémentée par libvlc dans la release 2
	    Lancer des vidéos et la recherche sans que l'exécution de l'une ou l'autre soit stoppée.
	    	VLC : l'utilisation de vlc permet directement de faire des recherches sans stoper une vidéo et vice versa.

	- Affichage de statistiques
	 	- de la vidéo (nombre de vues,...)
	 	- most watched, suggestions ?

	- Base de données locale pour le mode local




*Road Map du projet 

 - Jour 1 :
	- Bonnes bases de l'interface : espace de visionnage et barre de recherche (sans action)
		-> Quentin et Valentina
	- API Youtube : streamer une vidéo
		-> Graziella et Timothy

 - Jour 2 :
 	Objectifs : 
	- Barre de recherche : recherche avec l'API et affichage des résultats	
		-> Graziella et Valentina
	- Thread :
		-> Timothy et Quentin
	-> Streamer un vidéo : suite
	
	Résultats :
	- Barre de recherche implémentée sans problèmes
	- Streamer de vidéo : 
	-> utilisation de libvlc à la place d'un mélange de JavaFX et d'un webBrowser. Libvlc permet directement de faire des recherches sans stoper une vidéo et vice versa.
	-> lecture d'une vidéo par défaut au lancement de l'application (lien codé en dur)
	- Statistiques : recherche de vidéos populaires de la journée à travers l'API Youtube. 
	
 - Jour 3 : 
 	Objectifs :
	- Ajouter la fonctionnalité permettant de récupérer une vidéo en cliquant sur le résultat d'une recherche
		-> Graziella
	- Déclencher la lecture d'une vidéo à partir d'un objet avec un ID de vidéo
		-> Timothy
	- Ajout des boutons "pause", "plein écran", etc. pour la vidéo vlc
	
	- Playlist : rajouter des boutons permettant d'ajouter une vidéo à une playlist avec les actions des boutons.
		-> Valentina
	- Vidéos connexes : suggestion à partir d'une vidéo donnée
		-> Quentin
		
	Résultats :
	-

 - Jour 4 :
	- Base de données pour version locale 

 - Jour 5 : 
	- Améliorations
	- Vidéo de Soutenance


*Install
Pour pouvoir avoir accès à l'API Youtube en executant le .jar, il faut avoir une clé dans un fichier youtube.properties situé dans le même dossier que le .jar. Ce fichier est disponible dans la racine de notre repository (il contient déjà une clé de démonstration).

*Lancement

RELEASE_DAY_1 : On a mis un .jar avec seulement l'interface. Pour les releases suivantes on expliquera comment compiler le projet avec Maven.
RELEASE_DAY_2 : Un .jar contenant une interface utilisateur est fournie. La fonctionnalité de recherche est disponible et celle de lecture de video est en cours d'implémentation. Une vidéo test est lancée dès le lancement de l'application (lien codé en dur). Dans les jours qui suivent, il sera possible de lancer n'importe quelle vidéo.




