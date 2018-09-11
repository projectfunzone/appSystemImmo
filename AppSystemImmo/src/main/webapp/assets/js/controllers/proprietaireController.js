// création des controllers qui concernent la classe Propriétaire
monApp
		.controller(
				"proprietaireCtrlAdd",
				function($scope, proprietaireProvider, $location) {

					// initialiser l'objet (le formulaire d'ajout) dans le model
					// du scope
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
						telPro : "",
						mail : ""
					}

					// appel de la fonction ajouter lorsque l'on clique sur le
					// bouton "ajouter"
					// de la vue
					$scope.add = function() {

						// appel de la fonction service pour ajouter le
						// propriétaire dans la bd
						proprietaireProvider
								.addS(
										$scope.proprioForm,
										function(donnees) {
											if (typeof donnees == 'object') {
												$scope.msg = "";

												// redirection vers la page
												// d'accueil
												$location
														.path("proprietaire/liste");

											} else {
												$scope.msg = "L'ajout du propriétaire a échoué, veuillez essayer de nouveau";
											}
										})
					}
				})

		.controller(
				"proprietaireCtrlGet",
				function($scope, proprietaireProvider, $rootScope, $location) {
					$scope.indice = false;
					$scope.id = undefined;
					$scope.msg = "";

					$rootScope.proprio = {
						nom : "",
						prenom : "",
						adresse : {
							rue : "",
							cp : "",
							ville : "",
							pays : ""
						},
						telPrive : "",
						telPro : "",
						mail : ""
					}

					$scope.get = function() {
						// appel de la fonction du proprietaireProvider afin de
						// récupérer le propriétaire
						proprietaireProvider
								.getS(
										$scope.id,
										function(donnees) {
											if (typeof donnees == 'object') {
												$rootScope.proprio = donnees;
												$scope.indice = true;

												$location
														.path("proprietaire/fiche");
											} else {
												$scope.indice = false;
												$scope.msg = "Le propriétaire que vous recherchez n'est pas répertorié dans nos fichiers"
											}
										})
					}
				})

		.controller(
				"proprietaireCtrlFiche",
				function($scope, proprietaireProvider, $location, $rootScope) {
					$rootScope.proprio;
					console.log($rootScope.proprio.id)

					proprietaireProvider.getListeLocByProprioS(
							$rootScope.proprio.id, function(donnees) {

								// stocker les informations récupérées par
								// l'intermédiaire du proprietaireService
								$scope.listeLoc = donnees;

							});

					proprietaireProvider.getListeAchatByProprioS(
							$rootScope.proprio.id, function(donnees) {

								// stocker les informations récupérées par
								// l'intermédiaire du proprietaireService
								$scope.listeAchat = donnees;

							});

				})

		.controller(
				"proprietaireCtrlFindAll",
				function($scope, proprietaireProvider, $location, $rootScope) {
					// appel de la fonction de proprietaireProvider qui permet
					// de récupérer la liste
					proprietaireProvider.getListeS(function(donnees) {

						// stocker les informations récupérées par
						// l'intermédiaire du proprietaireService
						$scope.liste = donnees;

					});

					// fonction appelée à partir du lien supprimer de la liste
					$scope.deleteLien = function(proprioIn) {
						proprietaireProvider.deletS(proprioIn.id, function(
								retour) {
							// mettre à jour la liste
							proprietaireProvider.getListeS(function(donnees) {
								// stocker les données récupéré de service
								$scope.liste = donnees;
							})
						})
					}

					// initialiser le propriétaire de rootscop
					$rootScope.proprioUpdate = {
						id : undefined,
						nom : "",
						prenom : "",
						adresse : {
							rue : "",
							cp : "",
							ville : "",
							pays : ""
						},
						telPrive : "",
						telPro : "",
						mail : ""
					};

					// fonction appelée à partir du lien modifier de la liste
					$scope.updateLien = function(proprioIn) {
						$rootScope.proprioUpdate = proprioIn;

						// aller dans la vue modifier
						$location.path("proprietaire/update");

					}

					// méthode qui permet de récupérer les information du
					// propriétaire lors de la cr"ation d'un bien à louer
					$rootScope.locAdd = {
						proprietaire : {
							id : undefined,
							nom : "",
							prenom : "",
							adresse : {
								rue : "",
								cp : "",
								ville : "",
								pays : ""
							},
							telPrive : "",
							telPro : "",
							mail : ""
						}
					};

					// fonction appelée pour créer une location associé au
					// propriétaire
					$scope.addLocationLien = function(proprioIn) {
						$rootScope.locAdd.proprietaire = proprioIn;
						// aller dans la vue modifier
						$location.path("location/add");

					}

					// méthode qui permet de récupérer les information du
					// propriétaire lors de la cr"ation d'un bien à vendre
					$rootScope.achatAdd = {
						proprietaire : {
							id : undefined,
							nom : "",
							prenom : "",
							adresse : {
								rue : "",
								cp : "",
								ville : "",
								pays : ""
							},
							telPrive : "",
							telPro : "",
							mail : ""
						}
					};

					// fonction appelée pour créer un bien à vendre associé au
					// propriétaire
					$scope.addAchatLien = function(proprioIn) {
						$rootScope.achatAdd.proprietaire = proprioIn;
						// aller dans la vue modifier
						$location.path("achat/add");

					}

				})

		.controller(
				"proprietaireCtrlUpdate",
				function($scope, proprietaireProvider, $location, $rootScope) {
					// initialiser l'objet dans le modèle du scope

					if ($rootScope.proprioUpdate.id == undefined) {
						$scope.proprioModif = {
							id : undefined,
							nom : "",
							prenom : "",
							adresse : {
								rue : "",
								cp : "",
								ville : "",
								pays : ""
							},
							telPrive : "",
							telPro : "",
							mail : ""
						}
					} else {

						$scope.proprioModif = $scope.proprioUpdate;

					}

					// la fonction update appelée à partir du bouton
					// modifier de la
					// vue
					$scope.update = function() {
						// appel de la fonction service pour modifier dans la bd
						proprietaireProvider
								.updateS(
										$scope.proprioModif,
										function(retour) {
											$scope.msg = "";
											if (retour == 'OK') {
												// rediriger vers accueil
												$location
														.path("proprietaire/liste");
											} else {
												$scope.msg = "Les informations n'ont pas pu être modifiées";
											}

										});
					}

				})

		.controller(
				"proprietaireCtrlDelete",
				function($scope, proprietaireProvider, $location) {
					$scope.id = undefined;

					// la fonction rechercher appelée à partir du bouton
					// supprimer de la
					// vue
					$scope.delet = function() {
						// appel de la fonction service pour supprimer dans la
						// bd
						proprietaireProvider.deletS($scope.id,
								function(retour) {
									if (retour == 'OK') {
										// rediriger vers accueil
										$location.path("proprietaire/liste");
									} else {
										$scope.msg = "La suppression a échoué";
									}
								})
					}

				});
