/**Créer mes controllers*/

monApp.controller("achatCtrlFindAll",
		function($scope, achatProvider, $rootScope, $location) {
	
			/** appel de la function getListe de mon achatProvider*/
			/** ici la function a l'intérieur de getListe représente l'accès au callBack dans le service*/
	
			achatProvider.getListe(function(donnees) {
				/** stocker les données récupéré de service*/
				$scope.liste = donnees;
			})

			/** appel de la fonction à partir du lien de la liste pour supprimer un achat*/
			$scope.deleteLien = function(achatIn) {
				achatProvider.delet(achatIn.id, function(retour) {

					/** mettre à jour la liste de la page d'accueil*/
					achatProvider.getListe(function(donnees) {
						/** stocker les données récupéré de service*/
						$scope.liste = donnees;
					})
				});

			}
//*****************************************************************************************************
			/** initialiser l'achat de rootScope*/
			$rootScope.achatUpdate = {
				id : undefined,
				adresse :{
						cp : "",
						pays : "",
						rue : "",
						ville : "",
						},
				categorie : "",
				dateDispo : "",
				dateSoumis : "",
				noChambre : "",
				photo : "",
				revenueCadastre : "",
				statut : "",
				type : "",
				etat : "",
				prixDemande : ""
			};

			/** appel de la fonction à partir du lien de la liste pour modifier un achat*/
			$scope.updateLien = function(achatIn) {
				$rootScope.achatUpdate = achatIn;

				// aller dans la vue modif
				$location.path("update");
			}
//*****************************************************************************************************
		}).controller("achatCtrlGetOne", function($scope, achatProvider) {
	$scope.indice = false;
	$scope.id = undefined;
	$scope.msg = "";
	$scope.rechercher = function() {
		// appel de la fonction du achatProvider afin de récupérer l'achat
		achatProvider.getById($scope.id, function(donnees) {

			if (typeof donnees == 'object') {
				$scope.achat = donnees;
				$scope.indice = true;
			} else {
				$scope.indice = false;
				$scope.msg = "l'achat recherché n'existe pas"
			}
			;

		})
	}
//*****************************************************************************************************
}).controller("achatCtrlAdd", function($scope, achatProvider, $location) {

	// initialiser l'objet dans le model du scope
	$scope.achatForm = {
			cp : "",
			pays : "",
			rue : "",
			ville : "",
			categorie : "",
			dateDispo : "",
			dateSoumis : "",
			noChambre : "",
			photo : "",
			revenueCadastre : "",
			statut : "",
			type : "",
			etat : "",
			prixDemande : ""
	}

	// la fonction ajouter à partir du bouton d'appel "ajouter"
	$scope.ajouter = function() {

		// appel de la fonction service pour ajouter dans la bd
		achatProvider.add($scope.achatForm, function(donnees) {
			if (typeof donnees == 'object') {
				$scope.msg = "";
				// redirection vers l'accueil
				$location.path("liste");
			} else {
				$scope.msg = "L'ajout d'achat a échoué ! ";
			}
		})
	}
})
//**************************************************************************************************
.controller("achatCtrlupdate",
		function($scope, achatProvider, $location, $rootScope) {

			// initialiser l'objet dans le model du scope s'il n'est pas dans le
			// rootscope

			if ($rootScope.achatUpdate.id == undefined) {

				$scope.achatModif = {
					id : undefined,
					cp : "",
					pays : "",
					rue : "",
					ville : "",
					categorie : "",
					dateDispo : "",
					dateSoumis : "",
					noChambre : "",
					photo : "",
					revenueCadastre : "",
					statut : "",
					type : "",
					etat : "",
					prixDemande : ""
				};
			} else {
				// si le rootScope est utilisé, alors on initialise achatModif avec
				$scope.achatModif = $rootScope.achatUpdate;
			}

			// la fonction modifier à partir du bouton d'appel "modifier"
			$scope.modifier = function() {

				// appel de la fonction service pour modifier dans la bd
				achatProvider.update($scope.achatModif, function(donnees) {
					if (typeof donnees == 'object') {
						$scope.msg = "";
						// redirection vers l'accueil
						$location.path("liste");
					} else {
						$scope.msg = "La modification de l'ajout a échoué ! ";
					}
				})
			}
//*****************************************************************************************************
		}).controller("achatCtrldelete",
		function($scope, achatProvider, $location) {
			$scope.id = undefined;

			// la fonction appeler à partir du bouton
			$scope.supprimer = function() {

				// appel de la fonction service pour supprimer dans la bd
				achatProvider.delet($scope.id, function(retour) {
					if (retour == 'OK') {
						$scope.msg = "";
						// redirection vers l'accueil
						$location.path("liste");
					} else {
						$scope.msg = "La suppression de l'achat a échoué ! ";
					}
				})
			}
		});