/*
 * Controllers pour la gestion des Clients
 */

monApp.controller("clientCtrlFindAll", function($scope, clientProvider, $rootScope, $location) {

	// appel de la fonction Liste de 'clientProvider'
	clientProvider.getListe(function(donnees) {
		// stocker les données récupéré de service
		$scope.liste = donnees;
	})

	// initialiser le client de rootScope
	$rootScope.clUpdate = {
		id : undefined,
		num : "",
		nom : "",
		prenom : "",
		telPrive : "",
		adresse : {
			rue : "",
			cp : "",
			ville : "",
			pays : ""
		}
	};
	
	// appel de la fonction à partir du lien de la liste pour modifier un client
	$scope.updateLien = function(clIn) {
		$rootScope.clUpdate = clIn;

		// aller dans la vue modif
		$location.path("client/update");
	}
	
	// appel de la fonction à partir du lien de la liste pour supprimer un
	// client
	$scope.deleteLien = function(clIn) {
				clientProvider.delet(clIn.id, function(retour) {

					// mettre à jour la liste de la page d'accueil
					clientProvider.getListe(function(donnees) {
						// stocker les données récupéré de service
						$scope.liste = donnees;
					})
				});

			}

}).controller("clientCtrlGet", function($scope, clientProvider) {

	$scope.indice = false;
	$scope.id = undefined;
	$scope.msg = "";
	$scope.search = function() {

		// appel de la fonction get de 'clientProvider' afin de récupérer le
		// client
		clientProvider.get($scope.id, function(donnees) {

			if (typeof donnees == 'object') {
				$scope.cl = donnees;
				$scope.indice = true;
			} else {
				$scope.indice = false;
				$scope.msg = "le client recherché n'existe pas"
			}
			;

		})
	}
}).controller("clientCtrlAdd", function($scope, clientProvider, $location) {

	// initialiser l'objet dans le model du scope
	$scope.clForm = {
		id : "",
		num : "",
		nom : "",
		prenom : "",
		telPrive : "",
		adresse : {
			rue : "",
			cp : "",
			ville : "",
			pays : ""
		}
	}

	// la fonction ajouter à partir du bouton d'appel "add"
	$scope.add = function() {

		// appel de la fonction service pour ajouter dans la bd
		clientProvider.add($scope.clForm, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";
				// redirection vers l'accueil
				$location.path("liste");
			} else {
				$scope.msg = "L'enregistrement a échoué ! ";
			}
		})
	}
}).controller("clientCtrlUpdate",
		function($scope, clientProvider, $location, $rootScope) {

			// initialiser l'objet dans le model du scope s'il n'est pas dans le
			// rootscope

			if ($rootScope.clUpdate.id == undefined) {

				$scope.clModif = {
					id : undefined,
					num : "",
					nom : "",
					prenom : "",
					telPrive : "",
					adresse : {
						rue : "",
						cp : "",
						ville : "",
						pays : ""
					}
				};
			} else {
				// si le rootScope est utilisé, alors on initialise clModif avec
				$scope.clModif = $rootScope.clUpdate;
			}

			// la fonction update à partir du bouton d'appel "modifier"
			$scope.update = function() {

				// appel de la fonction service pour modifier dans la bd
				clientProvider.update($scope.clModif, function(donnees) {
					if (typeof donnees == 'object') {
						$scope.msg = "";
						// redirection vers l'accueil
						$location.path("liste");
					} else {
						$scope.msg = "La modification a échoué ! ";
					}
				})
			}

		}).controller("clientCtrlDelete",
		function($scope, clientProvider, $location) {
			$scope.id = undefined;

			// la fonction appeler à partir du bouton
			$scope.delet = function() {

				// appel de la fonction service pour supprimer dans la bd
				clientProvider.delet($scope.id, function(retour) {
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