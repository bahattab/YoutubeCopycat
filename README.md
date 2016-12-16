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
	
	- Playlist --> Jour 3 : Complètement implémentée !
		- Pouvoir sauvegarder des vidéos dans une playlist affichée sur le côté droit de l'écran 
		- Pouvoir lancer une video de la playlist
		- Pouvoir enlever une vidéo de la playlist

		--> Jour3 : Pouvoir sauvegarder une playlist et la reouvrir dans l'application 

	
	- Multithreading --> Implémentée par libvlc dans la release 2
		Lancer des vidéos et la recherche sans que l'exécution de l'une ou l'autre soit stoppée.
		VLC : l'utilisation de vlc permet directement de faire des recherches sans stoper une vidéo et vice versa.

	- Affichage de statistiques
		- de la vidéo (nombre de vues,...) --> Jour 3: c'est fait ! Ces statistiques s'affichent en dessous de la vidéo qui est jouée
		- suggestions  --> Jour 3 : Implémentée ! Le bouton avec un coeur permet d'afficher dans l'onglet résultats des vidéos qui ressemblent à celles qui sont sur la Playlist.
		- most watched sur Youtube 

	- Base de données locale pour le mode local --> Implémentée dans la release 4
		Lancer des vidéos locale en parcourant un explorer de fichier. Nous avons préféré cette option à l'utilisation d'une base de donnée, qui serait longue à implémenter contrairement à l'utilisation de liste d'objets java.
		Sauvegarde d'une playlist en local, import d'une playlist locale dans l'application.




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

	- On peut désormais visionner une vidéo donnée comme résultat d'une recherche en cliquant dessus
	- On peut déclencher la lecture d'une vidéo à partir d'un objet avec un ID de vidéo
	- On a ajouté des boutons de contrôle pour la vidéo vlc (pause, stop, suivant, barre de volume)
	- la fonctionnalité de playlist a été COMPLETEMENT implémentée, c'est-à-dire qu'on peut :
		- Ajouter la vidéo visionnée à la playlist
		- Enlever une vidéo de la playlist
		- Sauvergarder la playlist
		- Recharger une playlist
	--> Ce fut l'étape la plus complexe d'aujourd'hui : on s'est mis tous d'accord sur comment les objets devraient intéragir entre eux pour que cela marche bien 
	- Nous avons rajouté un bouton "suggestions" (avec un coeur comme icône) qui permet d'afficher sur l'onglet de résultats des vidéos qui ressemblent à celles d'une playlist



 - Jour 4 :
	Objectifs:
	- Base de données pour version locale 
	--> (Jour 3) Finalement, on ne fera pas une base de données locale comme on en avait l'intention car de notre point de vue, mettre en place une donnée de base SQL et la classe qui l'interface est un travail très long et qui apporte peu au fonctionnement de l'application.
	--> (Jour 3) On permettra à la place à l'utilisateur d'ajouter ses vidéos locales aux playlists qu'il peut ensuite sauvergarder et importer.
	--> (Jour 3) Ouverture des videos locales
		-> Graziella
	--> (Jour 3) Boutton et fonctionnalité vidéo populaires d'aujourd'hui en France (et dans le monde ?)
		->Quentin
	--> (Jour 3) Perfectionner les playlists et l'interface
		->Timothy 
	--> (Jour 3) Pop-up avec les commentaires de la vidéo
		-> Valentina

		
	Resultats:
	- Une vidéo locale peut maintenant être lue par le lecteur. Cette vidéo peut aussi être ajoutée à la playlist.
	- Une version graphiquement plus jolie est maintenant disponible. 
	- Un bouton "settings" permet d'ajouter à la main une clé API youtube. Cette fonctionnalité n'est pas encore totalement disponible.
	- Un bouton permettant d'afficher les 10 vidéos les plus vues aujourd'hui est implémentée.
	- Un tab contenant des listes de playlists est aussi disponible. Il contient les playlists que l'utilisateur a enregistré et lui permet d'en choisir une a charger.
	- L'interface est maintenant plus claire, avec des indications sur les boutons.
	- La diagramme de classe a été mis à jour afin de prendre en compte les nouvelles fonctionnalités que nous n'avions pas prévu d'ajouter (comme l'ajout d'une liste de playlist visible, etc.)
	- L'importation et la sauvegarde de playlist a été améliorée.
	
 - Jour 5 : 
 	Objectifs :
	- Améliorations visuelles
	- Amélioration de la fonctionnalité "settings"
	- Ajouter la fonctionnalité permettant de cliquer sur "suivant" dans une playlist.
	- Montage Vidéo de Soutenance + Démo finale
	
	Resultats :
	- Des améliorations ont été apportées à l'interface graphique. Le panel contenant la playlist est maintenant légèrement transparent.
	- Un bouton permettant de changer le titre d'une vidéo a été ajouté
	- La durée des vidéos est maintenant correctement affichée (si celle-ci dure moins de une minute ou plus d'une heure)
	- Il est maintenant possible de cliquer sur "suivant" et "précédent" lorsque des vidéos sont disponibles dans la playlist courrante. 

*Install

 - Pour pouvoir avoir accès à l'API Youtube en executant le .jar, il faut avoir une clé dans un fichier youtube.properties situé dans le même dossier que le .jar. Ce fichier est disponible dans la release de chaque jour, avec le binaire .jar et il contient déjà une clé de démonstration.
 - Pour pouvoir visionner la vidéo, vous devrez installer VLC sur votre machine :
  - sudo apt-get install vlc 
 - L'application marche sous Windows et Linux. Néanmoins, pour les utilisateurs de Ubuntu et dérivés, VLC peut être configuré pour ne pas lire des vidéos depuis YouTube. Si vous avez un écran noir à la lecture d'une vidéo, veuillez exécuter les commandes suivantes dans un terminal (Linux) : 
  - sudo apt-get install curl
  - sudo rm /usr/lib/vlc/lua/playlist/youtube.*
  - sudo curl "http://git.videolan.org/?p=vlc.git;a=blob_plain;f=share/lua/playlist/youtube.lua;hb=HEAD" -o /usr/lib/vlc/lua/playlist/youtube.lua

Enjoy ! 

*Lancement

 - RELEASE_DAY_1 : On a mis un .jar avec seulement l'interface. Pour les releases suivantes on expliquera comment compiler le projet avec Maven.
 
 - RELEASE_DAY_2 : Un .jar contenant une interface utilisateur est fournie. La fonctionnalité de recherche est disponible et celle de lecture de video est en cours d'implémentation. Une vidéo test est lancée dès le lancement de l'application (lien codé en dur). Dans les jours qui suivent, il sera possible de lancer n'importe quelle vidéo. Le fichier youtube.properties contenant la clé d'accès à l'API Youtube doit être placée dans le même dossier que le .jar.
 
 - RELEASE_DAY_3 : Un .jar contenant une interface utilisateur est fournie. Le fichier youtube.properties contenant la clé d'accès à l'API Youtube doit être placé dans le même dossier que le .jar. Dans cette version l'utilisateur peut :
  - Un message d'information s'affiche lorsque on lance l'application et présente les différentes fonctionnalités. On peut le retrouver en cliquant sur le bouton home
  - Une vidéo est lancée par défaut sur le video player
  - La recherche est totalement fonctionnelle et vous pouvez lancer une vidéo depuis les résultats en ciquant dessus.
  - Une vidéo lancée peut être ajoutée à la Playlist courante (affichée à droite). Cette playlist peut être sauvergardée et rechargée par l'utilisateur ultérieurement. 
  - Un bouton "Suggestions" (avec un icône de coeur) permet de générer des suggestions à partir de la playlist courante que vous avez constituée.
  
  - RELEASE_DAY_4 : Un .jar contenant une interface utilisateur est fournie. Le fichier youtube.properties contenant la clé d'accès à l'API Youtube doit être placé dans le même dossier que le .jar. Un message d'information s'affiche lorsque on lance l'application et présente les différentes fonctionnalités. On peut le retrouver en cliquant sur le bouton home. Une vidéo est lancée par défaut sur le video player Dans cette version, l'utilisateur peut : 
  - rechercher des vidéos par mot clé; et lancer une vidéo depuis les résultats en ciquant dessus.
  - ajouter à la Playlist courante (affichée à droite) la vidéo lue. Cette playlist peut être sauvergardée et rechargée par l'utilisateur ultérieurement. Il peut aussi supprimer la playlist courante d'un seul clique. 
  - voir des suggestions à partir de la playlist courante à l'appuie d'un bouton "Suggestions" (avec un icône de coeur).
  - voir les 10 vidéos les plus vues dans la journée l'appuie d'un bouton "Most popular videos" (avec un icône de podium).
  - voir une liste de playlists dans un onglet prévu à cet effet et charger l'une d'entre elle dans la playlist courante.
  - lire une vidéo locale en appuyant sur le bouton "local search" qui ouvre un explorer de fichier. L'utilisateur peut alors choisir un fichier a charger. Il pourra ensuite lire la video et l'ajouter à sa playlist de la même façon que pour les vidéos en ligne.
  





