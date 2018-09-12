/*
 * Controllers pour la gestion des conseillers
 */

monApp.controller("conseillerCtrlFindAll",
		function($scope, conseillerProvider, $rootScope, $location) {
	
			conseillerProvider.getListe(function(donnees) {
				$scope.liste = donnees;
				
			})
			
			// initialiser le conseiller de rootScope
			$rootScope.coUpdate = {
				id : undefined,
				nom : "",
				mdp : "",
			};
		}).controller("conseillerCtrlAdd",
		function($scope, conseillerProvider, $location) {

			// initialiser l'objet dans le model du scope
			$scope.coForm = {
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
		}).controller("conseillerCtrlGet",
		function($scope, conseillerProvider) {

			$scope.indice = false;
			$scope.id = undefined;
			$scope.msg = "";
			$scope.search = function() {

				// appel de la fonction get de 'conseillerProvider' afin de
				// récupérer le
				// conseiller
				conseillerProvider.get($scope.id, function(donnees) {

					if (typeof donnees == 'object') {
						$scope.co = donnees;
						$scope.indice = true;
					} else {
						$scope.indice = false;
						$scope.msg = "le conseiller recherché n'existe pas"
					}
					;

				})
			}
		}).controller("conseillerCtrlUpdate",
		function($scope, conseillerProvider, $location, $rootScope) {

			// initialiser l'objet dans le model du scope s'il n'est pas dans le
			// rootscope

			if ($rootScope.coUpdate.id == undefined) {

				$scope.coModif = {
					id : undefined,
					nom : "",
					mdp : ""
				};
			} else {
				// si le rootScope est utilisé, alors on initialise coModif avec
				$scope.coModif = $rootScope.coUpdate;
			}

			// la fonction update à partir du bouton d'appel "modifier"
			$scope.update = function() {

				// appel de la fonction service pour modifier dans la bd
				conseillerProvider.update($scope.coModif, function(retour) {
					$scope.msg = "";
					// redirection vers l'accueil
					$location.path("liste");
				})
			}

		}).controller("conseillerCtrlDelete",
		function($scope, conseillerProvider, $location) {
			$scope.id = undefined;

			// la fonction appeler à partir du bouton
			$scope.delet = function() {

				// appel de la fonction service pour supprimer dans la bd
				conseillerProvider.delet($scope.id, function(retour) {
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
