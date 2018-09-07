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
	.controller("visiteCtrlAdd", function($scope, visiteProvider, $location){
		$scope.visiteForm={
				date:""
		};
		
		//foctionnaliter du bouton ajouter de la vue
		$scope.add=function(){
			visiteProvider.adds($scope.visiteForm, function(donnees){
				if(typeof donnees=='object'){
					$scope.msg="";
					//rediriger vers la page liste
					$location.path("liste");
				}else{
					$scope.msg="L'ajout de votre visite a échoué!"
				}
			})
			
		}
		
	})
	
	
});