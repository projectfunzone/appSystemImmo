//Configuration de la table de routage
monApp.config(function($routeProvider) {
	$routeProvider.otherwise({redirectTo: "/accueil"});
});

//routage pour la location
monApp.config(function($routeProvider) {
	$routeProvider.when("/location/liste", {templateUrl: "views/locationListe.html", controller: "locationCtrlListe"})
	.when("/location/get", {templateUrl: "views/locationGet.html", controller: "locationCtrlGet"})
	.when("/location/add", {templateUrl: "views/locationAdd.html", controller: "locationCtrlAdd"})
	.when("/location/update", {templateUrl: "views/locationUpdate.html", controller: "locationCtrlUpdate"})
	.when("/location/delete", {templateUrl: "views/locationDelete.html", controller: "locationCtrlDelete"})
});
