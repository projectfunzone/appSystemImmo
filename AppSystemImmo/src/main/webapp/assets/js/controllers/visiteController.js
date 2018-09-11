/**
 * Création des controllers de visite
 */

// Récuperer la liste
monApp
		.controller("visiteCrltGetAll",
				function($scope, visiteProvider, $rootScope) {
					visiteProvider.getListes(function(donnees) {
						$scope.liste = donnees;
					})

					// Faire le lien supprimer et modifier
					$scope.deletelien = function(id) {
						visiteProvider.deletes(id, function(retour) {
							// mettre à jour la liste
							visiteProvider.getListes(function(donnees) {
								// stocker les données recup de service
								// (collback)
								$scope.liste = donnees;
							})
						})
					}

					// initialiser la visite de root scope pour lien modifier
					// visite
					$rootScope.vUpdate = {
						id : undefined,
						date : "",
					}
					// fonction appelé à partir du lien de la liste pour
					// modifier
					$scope.updateLien = function(vIn) {
						$rootScope.vUpdate = vIn
					}

					// aller dans la vue modif
					// $location.path("visite/Update");

				})

		// Fonction ajouter une visite
		.controller(
				"visiteCtrlAdd",
				function($scope, visiteProvider, clientProvider, $location,
						$rootScope) {
					
					// appel de la fonction Liste de 'clientProvider'
					clientProvider.getListe(function(donnees) {
						// stocker les données récupéré de service
						$scope.listeClient = donnees;
					})

					// méthode qui permet de récupérer les information d'une
					// vente
					// lors de la cr"ation d'une visite
					$rootScope.achat;
					$rootScope.location;
					$scope.bien;

					$scope.visiteForm = {
						date : "",
						client : {
							id : undefined
						},
						achat : {
							id : undefined
						},
						location : {
							id : undefined
						},
						conseiller : {
							id : undefined
						}
					};

					$scope.visiteForm.achat = $rootScope.achat;
					$scope.visiteForm.location = $rootScope.location;

					
					//permet d'assigner les informations dans bien sur l'affichage de la page visiteAdd.html
					if ($rootScope.location != null ) {
						$scope.bien=$rootScope.location
					} else if ($rootScope.achat != null) {
						$scope.bien=$rootScope.achat
					}
					
					
					console.log($rootScope.location)
					// foctionnaliter du bouton ajouter de la vue
					$scope.adds = function() {

						visiteProvider
								.adds(
										$scope.visiteForm,
										function(donnees) {
											if (typeof donnees == 'object') {
												$scope.msg = "";
												// rediriger vers la page liste
												$location.path("visite/liste");
											} else {
												$scope.msg = "L'ajout de votre visite a échoué!"
											}
										})

					}

				})

		.controller(
				"visiteCtrlUpdate",
				function($scope, visiteProvider, $location, $rootScope) {
					if ($rootScope.vUpdate.id == undefined) {

						$scope.vModif = {
							date : "",
							client : {
								id : undefined
							},
							achat : {
								id : undefined
							},
							conseiller : {
								id : undefined
							}
						}
					} else {
						$scope.vModif = $rootScope.vUpdate;
					}

					// fonction du bouton modifier de la vue
					$scope.updates = function() {
						visiteProvider
								.updates(
										$scope.vModif,
										function(donnees) {
											if (typeof donnees == 'object') {
												$scope.msg = "";
												$location.path("visite/liste");
											} else {
												$scope.msg = "La modification a échoué!"
											}
										})
					}

				}).controller("visiteCtrlDelete",
				function($scope, visiteProvider, $location) {
					$scope.id = undefined;

					// la fonction appeler à partir du bouton
					$scope.delet = function() {

						// appel de la fonction service pour supprimer dans la
						// bd
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
