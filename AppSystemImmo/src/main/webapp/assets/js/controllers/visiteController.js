/**
 * Création des controllers de visite
 */

monApp.controller("gelAll", 
		function($scope, visiteProvider, $rootScope, $location){
	visiteProvider.getListes(function(donnees){
		$scope.liste=donnees;
	})
});