/**
 * Création des controllers de visite
 */

//Récuperer la liste
monApp.controller("visiteCrltGetAll", 
		function($scope, visiteProvider){
	visiteProvider.getListes(function(donnees){
		$scope.liste=donnees;
	})
	
	
	
//Fonction ajouter une visite
}).controller("visiteCtrlAdd", function($scope, visiteProvider, $location){
		$scope.visiteForm={
				date:""
		};
		
		//foctionnaliter du bouton ajouter de la vue
		$scope.adds=function(){
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


.controller("visiteCtrlUpdate", function($scope, visiteProvider, $location, $rootScope) {
	if($rootScope.vUpdate.id==undefined){

	$scope.vModif={
			date:""
		
	}
	}else{
		$scope.vModif=$rootScope.vUpdate;
	}
	
	//fonction du bouton modifier de la vue
	$scope.updates=function(){
		visiteProvider.updates($scope.vModif, function(donnees){
			if(typeof donnees=='object'){
				$scope.msg="";
				$location.path("liste");
			}else{
				$scope.msg="La modification a échoué!"
			}
		})
	}
	
	

	
}).controller("visiteCtrlDelete",
		function($scope, visiteProvider, $location) {
	$scope.id = undefined;

	// la fonction appeler à partir du bouton
	$scope.deletes = function() {

		// appel de la fonction service pour supprimer dans la bd
		visiteProvider.deletes($scope.id, function(retour) {
			if (retour == 'OK') {
				$scope.msg = "";
				// redirection vers l'accueil
				$location.path("liste");
			} else {
				$scope.msg = "La suppression a échoué ! ";
			}
		})
	}
});



