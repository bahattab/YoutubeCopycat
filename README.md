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
					    Puisque VLC est capable de lire des vidéos à partir d'une URL mais aussi à partir d'un chemin fichier, 
						cette implémentation est plus adaptée au cahier de charges.

		
	 	- en local

	- Barre de recherche
	 	- en mode connecté
	 	- en mode local
	
	- Playlist 
		- Pouvoir sauvegarder des vidéos dans une playlist affichée sur le côté droit de l'écran 
		- Pouvoir lancer une video de la playlist
		- Pouvoir enlever une vidéo de la playlist 
	
	- Multithreading
	    Lancer des vidéos et la recherche sans que l'exécution de l'une ou l'autre soit stoppée

	- Affichage de statistiques
	 	- de la vidéo (nombre de vues,...)
	 	- most watched, suggestions ?

	- Base de données locale pour le mode local




*Road Map du projet 

 - Jour 1 :
	- Bonnes bases de l'interface : espace de visionnage et barre de recherche
		-> Quentin et Valentina
	- API Youtube : streamer une vidéo
		-> Graziella et Timothy

 - Jour 2 :
	- Barre de recherche : recherche avec l'API et affichage des résultats	
		-> Graziella et Valentina
	- Thread :
		-> Timothy et Quentin

 - Jour 3 : 
	- Playlist

 - Jour 4 :
	- Base de données pour version locale 

 - Jour 5 : 
	- Améliorations
	- Vidéo de Soutenance


*Install


*Lancement

RELEASE_DAY_1 : On a mis un .jar avec seulement l'interface. Pour les releases suivantes on expliquera comment compiler le projet avec Maven.




