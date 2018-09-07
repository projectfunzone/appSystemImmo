//Créer mes controllers

monApp.controller("AchatCtrlfindAll",
		function($scope, etudiantProvider, $rootScope, $location) {
			// appel de la function getListe de mon etudiantProvider
			// ici la function a l'intérieur de getListe représente l'accès au
			// callBack
			// dans le service
			etudiantProvider.getListe(function(donnees) {
				// stocker les données récupéré de service
				$scope.liste = donnees;
			})

			// appel de la fonction à partir du lien de la liste pour supprimer
			// un
			// etudiant
			$scope.deleteLien = function(eIn) {
				etudiantProvider.delet(eIn.id, function(retour) {

					// mettre à jour la liste de la page d'accueil
					etudiantProvider.getListe(function(donnees) {
						// stocker les données récupéré de service
						$scope.liste = donnees;
					})
				});

			}

			// initialiser l'etudiant de rootScope
			$rootScope.eUpdate = {
				id : undefined,
				nom : "",
				prenom : "",
				age : ""
			};
			// appel de la fonction à partir du lien de la liste pour modifier
			// un
			// etudiant
			$scope.updateLien = function(eIn) {
				$rootScope.eUpdate = eIn;

				// aller dans la vue modif
				$location.path("update");
			}

		}).controller("getOneCtrl", function($scope, etudiantProvider) {
	$scope.indice = false;
	$scope.id = undefined;
	$scope.msg = "";
	$scope.rechercher = function() {
		// appel de la fonction du etudiantProvider afin de récupérer l'etudiant
		etudiantProvider.getById($scope.id, function(donnees) {

			if (typeof donnees == 'object') {
				$scope.etu = donnees;
				$scope.indice = true;
			} else {
				$scope.indice = false;
				$scope.msg = "l'étudiant recherché n'existe pas"
			}
			;

		})
	}
}).controller("addCtrl", function($scope, etudiantProvider, $location) {

	// initialiser l'objet dans le model du scope
	$scope.eForm = {
		nom : "",
		prenom : "",
		age : ""
	}

	// la fonction ajouter à partir du bouton d'appel "ajouter"
	$scope.ajouter = function() {

		// appel de la fonction service pour ajouter dans la bd
		etudiantProvider.add($scope.eForm, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";
				// redirection vers l'accueil
				$location.path("liste");
			} else {
				$scope.msg = "L'ajout a échoué ! ";
			}
		})
	}
})

.controller("updateCtrl",
		function($scope, etudiantProvider, $location, $rootScope) {

			// initialiser l'objet dans le model du scope s'il n'est pas dans le
			// rootscope

			if ($rootScope.eUpdate.id == undefined) {

				$scope.eModif = {
					id : undefined,
					nom : "",
					prenom : "",
					age : ""
				};
			} else {
				// si le rootScope est utilisé, alors on initialise eModif avec
				$scope.eModif = $rootScope.eUpdate;
			}

			// la fonction modifier à partir du bouton d'appel "modifier"
			$scope.modifier = function() {

				// appel de la fonction service pour modifier dans la bd
				etudiantProvider.update($scope.eModif, function(donnees) {
					if (typeof donnees == 'object') {
						$scope.msg = "";
						// redirection vers l'accueil
						$location.path("liste");
					} else {
						$scope.msg = "La modification a échoué ! ";
					}
				})
			}

		}).controller("deleteCtrl",
		function($scope, etudiantProvider, $location) {
			$scope.id = undefined;

			// la fonction appeler à partir du bouton
			$scope.supprimer = function() {

				// appel de la fonction service pour supprimer dans la bd
				etudiantProvider.delet($scope.id, function(retour) {
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