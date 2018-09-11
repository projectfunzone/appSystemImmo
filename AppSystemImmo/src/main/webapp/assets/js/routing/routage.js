//Configuration de la table de routage
monApp.config(function($routeProvider) {
	$routeProvider.otherwise({redirectTo: "/accueil"});
});


monApp.config(function($routeProvider) {
	
	//****************************************************************************************************************
	// Camille: routage pour la location
	$routeProvider.when("/location/liste", {templateUrl: "views/locationListe.html", controller: "locationCtrlListe"})
	.when("/location/get", {templateUrl: "views/locationGet.html", controller: "locationCtrlGet"})
	.when("/location/add", {templateUrl: "views/locationAdd.html", controller: "locationCtrlAdd"})
	.when("/location/update", {templateUrl: "views/locationUpdate.html", controller: "locationCtrlUpdate"})
	.when("/location/delete", {templateUrl: "views/locationDelete.html", controller: "locationCtrlDelete"})
	.when ("/location/fiche", {templateUrl:"views/locationFiche.html", controller: "locationCtrlFiche"})
	
	//****************************************************************************************************************
	// Demba: routage pour l'achat
	$routeProvider.when("/achat/liste", {templateUrl: "views/achatListe.html", controller: "achatCtrlFindAll"})
	.when("/achat/get", {templateUrl: "views/achatGet.html", controller: "achatCtrlGet"})
	.when("/achat/add", {templateUrl: "views/achatAdd.html", controller: "achatCtrlAdd"})
	.when("/achat/update", {templateUrl: "views/achatUpdate.html", controller: "achatCtrlUpdate"})
	.when("/achat/delete", {templateUrl: "views/achatDelete.html", controller: "achatCtrlDelete"})
	.when ("/achat/fiche", {templateUrl:"views/achatFiche.html", controller: "achatCtrlFiche"})
	
	//****************************************************************************************************************
	// Amandine: routage pour la visite
	$routeProvider.when("/visite/liste", {templateUrl:"views/visiteListe.html", controller: "visiteCrltGetAll"})
	.when ("/visite/add", {templateUrl:"views/visiteAdd.html", controller: "visiteCtrlAdd"})
	.when ("/visite/get", {templateUrl:"views/visiteGet.html", controller: "visiteCtrlGet"})
	.when ("/visite/update", {templateUrl:"views/visiteUpdate.html", controller: "visiteCtrlUpdate"})
	.when ("/visite/delete", {templateUrl:"views/visiteDelete.html", controller: "visiteCtrlDelete"})
	
	//****************************************************************************************************************
	// Thibault: routage pour le client
	$routeProvider.when("/client/liste", {templateUrl:"views/clientListe.html", controller: "clientCtrlFindAll"})
	.when ("/client/add", {templateUrl:"views/clientAdd.html", controller: "clientCtrlAdd"})
	.when ("/client/get", {templateUrl:"views/clientGet.html", controller: "clientCtrlGet"})
	.when ("/client/update", {templateUrl:"views/clientUpdate.html", controller: "clientCtrlUpdate"})
	.when ("/client/delete", {templateUrl:"views/clientDelete.html", controller: "clientCtrlDelete"})
	
	//****************************************************************************************************************
	// JD : routage pour le propriétaire
	$routeProvider.when("/proprietaire/liste", {templateUrl:"views/proprietaireListe.html", controller: "proprietaireCtrlFindAll"})
	.when ("/proprietaire/add", {templateUrl:"views/proprietaireAdd.html", controller: "proprietaireCtrlAdd"})
	.when ("/proprietaire/get", {templateUrl:"views/proprietaireGet.html", controller: "proprietaireCtrlGet"})
	.when ("/proprietaire/update", {templateUrl:"views/proprietaireUpdate.html", controller: "proprietaireCtrlUpdate"})
	.when ("/proprietaire/delete", {templateUrl:"views/proprietaireDelete.html", controller: "proprietaireCtrlDelete"})
	.when ("/proprietaire/fiche", {templateUrl:"views/proprietaireFiche.html", controller: "proprietaireCtrlFiche"})
	
	//****************************************************************************************************************
	// Ewen : routage pour le conseiller
	$routeProvider.when("/conseiller/liste", {templateUrl:"views/conseillerListe.html", controller: "conseillerCtrlFindAll"})
	.when ("/conseiller/add", {templateUrl:"views/conseillerAdd.html", controller: "conseillerCtrlAdd"})
	.when ("/conseiller/get", {templateUrl:"views/conseillerGet.html", controller: "conseillerCtrlGet"})
	.when ("/conseiller/update", {templateUrl:"views/conseillerUpdate.html", controller: "conseillerCtrlUpdate"})
	.when ("/conseiller/delete", {templateUrl:"views/conseillerDelete.html", controller: "conseillerCtrlDelete"})
	.when ("/conseiller/fiche", {templateUrl:"views/conseillerFiche.html", controller: "conseillerCtrlFiche"})

});
