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

					$scope.get = function(id) {
						// appel de la fonction du proprietaireProvider afin de
						// récupérer le propriétaire
						visiteProvider
								.getS(
										id,
										function(donnees) {
											if (typeof donnees == 'object') {
												$rootScope.visite = donnees;

												$location
														.path("visite/fiche");
											} else {
												$scope.indice = false;
												$scope.msg = "erreur"
											}
										})
					}

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
												$location.path("visite/calendar");
											} else {
												$scope.msg = "L'ajout de votre visite a &eacutechou&eacute!"
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
												$scope.msg = "La modification a &eacutechou&eacute!"
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
								$scope.msg = "La suppression a &eacutechou&eacute ! ";
							}
						})
					}
				})
				.controller(
				"visiteCtrlGet",
				function($scope, visiteProvider, $rootScope, $location) {
					
					$scope.id = undefined;
					$scope.msg = "";

					$rootScope.visite;

					$scope.get = function() {
						// appel de la fonction du proprietaireProvider afin de
						// récupérer le propriétaire
						visiteProvider
								.getS(
										$scope.id,
										function(donnees) {
											if (typeof donnees == 'object') {
												$rootScope.visite = donnees;
												

												$location
														.path("visite/fiche");
											} else {
												$scope.indice = false;
												$scope.msg = "La r&eacutef&eacuterence de visite recherch&eacute; n'existe pas"
											}
										})
					}
				})
				.controller(
				"visiteCtrlFiche",
				function($scope, visiteProvider, $location, $rootScope) {
					$rootScope.visite;
					
					// fonction appelée à partir du lien supprimer de la liste
					$scope.deleteLien = function(visiteIn) {
						visiteProvider.deletS(visiteIn.id, function(
								retour) {
							// mettre à jour la liste
							visiteProvider.getListeS(function(donnees) {
								// stocker les données récupéré de service
								$scope.liste = donnees;
							})
						})
					}

					// initialiser le propriétaire de rootscop
					$rootScope.visiteUpdate = {
						
					};

					// fonction appelée à partir du lien modifier de la liste
					$scope.updateLien = function(visiteIn) {
						$rootScope.visiteUpdate = visiteIn;

						// aller dans la vue modifier
						$location.path("visite/update");

					}

				

					
					
				});
