/*
 * Controllers pour la gestion des conseillers
 */

monApp.controller("conseillerCtrlFindAll",
		function($scope, conseillerProvider, $location) {
			conseillerProvider.getListe(function(donnees) {
				$scope.liste = donnees;

			})
		}).controller("conseillerCtrlAdd",
		function($scope, conseillerProvider, $location) {

			// initialiser l'objet dans le model du scope
			$scope.clForm = {
				id : "",
				nom : "",
				mdp : ""
			}
			// la fonction ajouter à partir du bouton d'appel "add"
			$scope.add = function() {

				// appel de la fonction service pour ajouter dans la bd
				conseillerProvider.add($scope.coForm, function(donnees) {
					if (typeof donnees == 'object') {
						$scope.msg = "";
						// redirection vers l'accueil
						$location.path("liste");
					} else {
						$scope.msg = "L'enregistrement a échoué ! ";
					}
				})
			}
		})
			