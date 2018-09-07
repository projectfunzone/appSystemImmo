monApp.controller("locationCtrlAdd", function($scope, locationProvider, $location) {
	
	
	$scope.habitation=true;
	$scope.commercial=false;
	$scope.terrain=false;
	//initialiser l'objet dans le model du scope
	$scope.locIn = {
			categorie:"",
			type:"",
			surface:"",
			noChambre:"",
			statut:"",
			dateSoumis:"",
			adresse: {
				rue:"",
				cp:"",
				ville:"",
				pays:""
			},
			dateDispo:"",
			revenueCadastre:"",
			photo:"",
			caution:"",
			loyer:"",
			charge:"",
			bail:"",
			garniture:""
	}
	
	$scope.add=function () {
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
	
	
	
    $scope.locIn.categorie = "Male";

    $scope.RadioChange = function (s) {
        $scope.CategorieSelected = s;
        
        if (s == "Habitation") {
        	$scope.habitation=true;
        	$scope.commercial=false;
        	$scope.terrain=false;
        }
        
        if (s == "Commercial") {
        	$scope.habitation=false;
        	$scope.commercial=true;
        	$scope.terrain=false;
        }
        
        if (s == "Terrain") {
        	$scope.habitation=false;
        	$scope.commercial=false;
        	$scope.terrain=true;
        }
    };
	
	
})