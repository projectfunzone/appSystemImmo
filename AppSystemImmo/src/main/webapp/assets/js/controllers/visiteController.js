/**
 * Création des controllers de visite
 */

//Récuperer la liste
monApp.controller("visiteCrltGetAll", 
		function($scope, visiteProvider, $rootScope){
	visiteProvider.getListes(function(donnees){
		$scope.liste=donnees;
	})
	//Faire le lien supprimer et modifier
	$scope.deletelien=function(vIn){
		visiteProvider.deletes(eIn.id, function(retour){
			//mettre à jour la liste
			visiteProvider.getListes(function(donnees){
				//stocker les données recup de service (collback)
				$scope.liste=donnees;
			})
		})	
	}
	
	//initialiser la visite de root scope pour lien modifier visite
	$rootScope.vUpdate={
			id:undefined,
			date:"",	
	}
	//fonction appelé à partir du lien de la liste pour modifier
	$scope.updateLien=function(vIn){
		$rootScope.vUpdate=vIn
	}
	
	//aller dans la vue modif
	//$location.path("visite/Update");
	
})
	

	
	
//Fonction ajouter une visite
.controller("visiteCtrlAdd", function($scope, visiteProvider, $location){
		$scope.visiteForm={
				date:""
		};
		
		//foctionnaliter du bouton ajouter de la vue
		$scope.adds=function(){
			visiteProvider.adds($scope.visiteForm, function(donnees){
				if(typeof donnees=='object'){
					$scope.msg="";
					//rediriger vers la page liste
					$location.path("visite/liste");
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
				$location.path("visite/liste");
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
				$location.path("visite/liste");
			} else {
				$scope.msg = "La suppression a échoué ! ";
			}
		})
	}
});



