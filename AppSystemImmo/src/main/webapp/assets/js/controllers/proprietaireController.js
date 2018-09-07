// création des controllers qui concernent la classe Propriétaire
monApp.controller("proprietaireCtrlAdd", function($scope, proprietaireProvider, $location) {

	// initialiser l'objet (le formulaire d'ajout) dans le model du scope
	$scope.proprioForm = {
		nom : "",
		prenom : "",
		adresse : {
			rue : "",
			cp : "",
			ville : "",
			pays : ""
		},
		telPrive : "",
		telPro : ""
	}

	// appel de la fonction ajouter lorsque l'on clique sur le bouton "ajouter"
	// de la vue
	$scope.add = function() {

		// appel de la fonction service pour ajouter le propriétaire dans la bd
		proprietaireProvider.addS($scope.proprioForm, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";

				// redirection vers la page d'accueil
				$location.path("accueil");

			} else {
				$scope.msg="L'ajout du propriétaire a échoué, veuillez essayer de nouveau";
			}
		})
	}
})

.controller("proprietaireCtrlFindAll", function($scope, proprietaireProvider, $location){
		// appel de la fonction de proprietaireProvider qui permet de récupérer la liste
		proprietaireProvider.getListeS(function(donnees){
			
			// stocker les informations récupérées par l'intermédiaire du proprietaireService
			$scope.liste=donnees;
			
		});
	})