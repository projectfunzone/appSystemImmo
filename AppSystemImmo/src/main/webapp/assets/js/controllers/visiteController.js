/**
 * Création des controllers de visite
 */

//Récuperer la liste
monApp.controller("visiteCrltGetAll", 
		function($scope, visiteProvider, $rootScope, $location){
	visiteProvider.getListes(function(donnees){
		$scope.liste=donnees;
	})
	
	
	
//Fonction acjouter une visite
	.controller("visiteCtrlAdd", function)
	
	
});