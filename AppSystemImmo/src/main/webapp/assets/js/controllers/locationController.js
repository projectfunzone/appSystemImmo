monApp.controller("locationCtrlAdd", function($scope, locationProvider,
		$location) {

	$scope.habitation = true;
	$scope.commercial = false;
	$scope.terrain = false;
	// initialiser l'objet dans le model du scope
	$scope.locIn = {
		categorie : "",
		type : "",
		surface : "",
		noChambre : "",
		statut : "",
		dateSoumis : "",
		adresse : {
			rue : "",
			cp : "",
			ville : "",
			pays : ""
		},
		dateDispo : "",
		revenueCadastre : "",
		caution : "",
		loyer : "",
		charge : "",
		bail : "",
		garniture : ""
	}

	$scope.add = function() {
		locationProvider.adds($scope.locIn, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";
				// redirection vers l'accueil
				$location.path("accueil");
			} else {
				$scope.msg = "L'ajout a échoué ! ";
			}
		})
	}

	// méthode pour permettre de changer la vue lors de la selection de la
	// catégorie : n'affiche que les types de la catégorie concerné
	$scope.RadioChange = function(s) {
		$scope.CategorieSelected = s;

		if (s == "Habitation") {
			$scope.habitation = true;
			$scope.commercial = false;
			$scope.terrain = false;
		}

		if (s == "Commercial") {
			$scope.habitation = false;
			$scope.commercial = true;
			$scope.terrain = false;
		}

		if (s == "Terrain") {
			$scope.habitation = false;
			$scope.commercial = false;
			$scope.terrain = true;
		}
	};

		
}).controller("locationCtrlUpdate", function($scope, locationProvider,
		$location) {

	$scope.habitation = true;
	$scope.commercial = false;
	$scope.terrain = false;
	// initialiser l'objet dans le model du scope
	$scope.locIn = {
		id:"",
		categorie : "",
		type : "",
		surface : "",
		noChambre : "",
		statut : "",
		dateSoumis : "",
		adresse : {
			rue : "",
			cp : "",
			ville : "",
			pays : ""
		},
		dateDispo : "",
		revenueCadastre : "",
		caution : "",
		loyer : "",
		charge : "",
		bail : "",
		garniture : ""
	}
	
	$scope.update = function() {
		locationProvider.updates($scope.locIn, function(donnees) {
		
				$scope.msg = "";
				// redirection vers l'accueil
				$location.path("accueil");
		})
	}

	// méthode pour permettre de changer la vue lors de la selection de la
	// catégorie : n'affiche que les types de la catégorie concerné
	$scope.RadioChange = function(s) {
		$scope.CategorieSelected = s;

		if (s == "Habitation") {
			$scope.habitation = true;
			$scope.commercial = false;
			$scope.terrain = false;
		}

		if (s == "Commercial") {
			$scope.habitation = false;
			$scope.commercial = true;
			$scope.terrain = false;
		}

		if (s == "Terrain") {
			$scope.habitation = false;
			$scope.commercial = false;
			$scope.terrain = true;
		}
	};

}).controller("locationCtrlListe", 
		function($scope, locationProvider){
	locationProvider.getListes(function(donnees){
		$scope.liste=donnees;
	})
	
	
	

})