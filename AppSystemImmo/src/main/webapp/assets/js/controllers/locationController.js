monApp.controller("locationCtrlAdd", function($scope, locationProvider, $location) {
	
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
})