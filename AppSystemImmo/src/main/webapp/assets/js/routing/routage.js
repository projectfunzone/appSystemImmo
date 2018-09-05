//Configuration de la table de routage
monApp.config(function($routeProvider) {
	$routeProvider.when("/liste", {templateUrl: "views/listeVue.html", controller: "findAllCtrl"})
	.when("/rech", {templateUrl: "views/rechercheVue.html", controller: "getOneCtrl"})
	.when("/add", {templateUrl: "views/ajoutVue.html", controller: "addCtrl"})
	.when("/update", {templateUrl: "views/modifVue.html", controller: "updateCtrl"})
	.when("/delete", {templateUrl: "views/supprVue.html", controller: "deleteCtrl"})
	.otherwise({redirectTo: "/liste"});
});

