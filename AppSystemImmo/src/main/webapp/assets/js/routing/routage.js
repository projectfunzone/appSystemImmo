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
	
	//****************************************************************************************************************
	// Demba: routage pour l'achat
	$routeProvider.when("/achat/liste", {templateUrl: "views/achatListeVue.html", controller: "achatCtrlFindAll"})
	.when("/achat/get", {templateUrl: "views/achatGetVue.html", controller: "achatCtrlGet"})
	.when("/achat/add", {templateUrl: "views/achatAddVue.html", controller: "achatCtrlAdd"})
	.when("/achat/update", {templateUrl: "views/achatUpdateVue.html", controller: "achatCtrlUpdate"})
	.when("/achat/delete", {templateUrl: "views/achatDeleteVue.html", controller: "achatCtrlDelete"})
});
