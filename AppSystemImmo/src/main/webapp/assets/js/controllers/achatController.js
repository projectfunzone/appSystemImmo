/** Créer mes controllers */

monApp
		.controller("achatCtrlFindAll",
				function($scope, achatProvider, $rootScope, $location) {

					/** appel de la function getListe de mon achatProvider */
					/**
					 * ici la function a l'intérieur de getListe représente
					 * l'accès au callBack dans le service
					 */

					achatProvider.getListe(function(donnees) {
						/** stocker les données récupéré de service */
						$scope.liste = donnees;
					})

					/**
					 * appel de la fonction à partir du lien de la liste pour
					 * supprimer un achat
					 */
					$scope.deleteLien = function(achatIn) {
						achatProvider.delet(achatIn.id, function(retour) {

							/** mettre à jour la liste de la page d'accueil */
							achatProvider.getListe(function(donnees) {
								/** stocker les données récupéré de service */
								$scope.liste = donnees;
							})
						});

					}
					// **********************************************//
					/** initialiser l'achat de rootScope */
					$rootScope.achatUpdate = {
						id : undefined,
						adresse : {
							cp : "",
							pays : "",
							rue : "",
							ville : "",
						},
						categorie : "",
						dateDispo : "",
						dateSoumis : "",
						noChambre : "",
						photos : [],
						listeImages : [],
						revenueCadastre : "",
						statut : "",
						type : "",
						etat : "",
						prixDemande : "",
						surface : ""
					};

					/**
					 * appel de la fonction à partir du lien de la liste pour
					 * modifier un achat
					 */
					$scope.updateLien = function(achatIn) {
						$rootScope.achatUpdate = achatIn;

						// aller dans la vue modif
						$location.path("achat/update");
					}
					// *****************************************************************************************************

					$rootScope.achat = {
						id : undefined,
						adresse : {
							cp : "",
							pays : "",
							rue : "",
							ville : "",
						},
						categorie : "",
						dateDispo : "",
						dateSoumis : "",
						noChambre : "",
						photos : [],
						listeImages : [],
						revenueCadastre : "",
						statut : "",
						type : "",
						etat : "",
						prixDemande : "",
						surface : ""
					};

					$scope.addVisiteLien = function(achatIn) {
						$rootScope.achat = achatIn;
						$location.path("visite/add");

					}

				})
		.controller("achatCtrlGet",
				function($scope, achatProvider, $rootScope, $location) {
					$scope.indice = false;
					$scope.id = undefined;
					$scope.msg = "";

					$rootScope.achat = {
						id : undefined,
						adresse : {
							cp : "",
							pays : "",
							rue : "",
							ville : "",
						},
						categorie : "",
						dateDispo : "",
						dateSoumis : "",
						noChambre : "",
						photos : [],
						listeImages : [],
						revenueCadastre : "",
						statut : "",
						type : "",
						etat : "",
						prixDemande : "",
						surface : ""
					};

					$scope.rechercher = function() {
						// appel de la fonction du achatProvider afin de
						// récupérer
						// l'achat
						achatProvider.getById($scope.id, function(donnees) {

							if (typeof donnees == 'object') {
								$rootScope.achat = donnees;
								$scope.indice = true;

								$location.path("achat/fiche");
								console.log("test")

							} else {
								$scope.indice = false;
								$scope.msg = "l'achat recherché n'existe pas"
							}
							;

						})
					}
					// *****************************************************************************************************
				})
		.controller("achatCtrlFiche",
				function($scope, achatProvider, $location, $rootScope) {

					if ($rootScope.achat.id == undefined) {
						$rootScope.achat = {
							id : undefined,
							adresse : {
								cp : "",
								pays : "",
								rue : "",
								ville : "",
							},
							categorie : "",
							dateDispo : "",
							dateSoumis : "",
							noChambre : "",
							photos : [],
							listeImages : [],
							revenueCadastre : "",
							statut : "",
							type : "",
							etat : "",
							prixDemande : "",
							surface : ""
						};
					}

					$scope.addVisiteLien = function(achatIn) {
						$rootScope.achat = achatIn;
						$location.path("visite/add");
						console.log($rootScope.achat.id + "achatController");
					}

				})
		.controller(
				"achatCtrlAdd",
				function($scope, achatProvider, $location, $rootScope) {

					$scope.habitation = true;
					$scope.commercial = false;
					$scope.terrain = false;
					// initialiser l'objet dans le model du scope

					if ($rootScope.achatAdd.proprietaire.id == undefined) {
						$scope.achatForm = {
							adresse : {
								rue : "",
								cp : "",
								ville : "",
								pays : ""
							},
							categorie : "",
							dateDispo : "",
							dateSoumis : "",
							noChambre : "",
							photos : [],
							listeImages : [],
							revenueCadastre : "",
							statut : "",
							type : "",
							etat : "",
							prixDemande : "",
							surface : "",
							proprietaire : {
								id : undefined
							},
							lat : "",
							lng : ""
						}
					} else {
						$scope.achatForm = {
							adresse : {
								rue : "",
								cp : "",
								ville : "",
								pays : ""
							},
							categorie : "",
							dateDispo : "",
							dateSoumis : "",
							noChambre : "",
							photos : [],
							listeImages : [],
							revenueCadastre : "",
							statut : "",
							type : "",
							etat : "",
							prixDemande : "",
							surface : "",
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
							},
							lat : "",
							lng : ""
						}

						$scope.achatForm.proprietaire = $rootScope.achatAdd.proprietaire;
					}

					// la fonction ajouter à partir du bouton d'appel "ajouter"
					$scope.ajouter = function() {
						achatProvider.geoAdresse($scope.achatForm.adresse.pays,$scope.achatForm.adresse.rue,$scope.achatForm.adresse.cp,$scope.achatForm.adresse.ville, function(calback) {
		                    if ((calback != 0) && (calback != "")) {
		                        // $scope.montrerMap=true;
		                        $scope.map = calback;
		                        $scope.achatForm.lat = $scope.map[0].lat;
		                        $scope.achatForm.lng = $scope.map[0].lon;

						// appel de la fonction service pour ajouter dans la bd
		                        	achatProvider.add($scope.achatForm, function(donnees) {
		                        			if (typeof donnees == 'object') {
		                        					$scope.msg = "";
		                        						// redirection vers l'accueil
		                        					$location.path("achat/liste");
		                        			} else {
		                        				$scope.msg = "L'ajout d'achat a échoué ! ";
		                        			}
		                        	})
		                    }
		                });
					}
					// méthode pour permettre de changer la vue lors de la
					// selection de la
					// catégorie : n'affiche que les types de la catégorie
					// concerné
					$scope.RadioChange = function(s) {
						$scope.CategorieSelected = s;

						if (s == "Habitation") {
							$scope.habitation = true;
							$scope.commercial = false;
							$scope.terrain = false;
						}

						if (s == "Commercial") {
							$scope.habitation = false;
							$scope.commercial = true;
							$scope.terrain = false;
						}

						if (s == "Terrain") {
							$scope.habitation = false;
							$scope.commercial = false;
							$scope.terrain = true;
						}
					};

				})
		// **************************************************************************************************
		.controller(
				"achatCtrlUpdate",
				function($scope, achatProvider, $location, $rootScope) {

					// initialiser l'objet dans le model du scope s'il n'est pas
					// dans le
					// rootscope

					if ($rootScope.achatUpdate.id == undefined) {

						$scope.achatModif = {
							id : undefined,
							adresse : {
								rue : "",
								cp : "",
								ville : "",
								pays : ""
							},
							categorie : "",
							dateDispo : "",
							dateSoumis : "",
							noChambre : "",
							photos : [],
							listeImages : [],
							revenueCadastre : "",
							statut : "",
							type : "",
							etat : "",
							prixDemande : "",
							surface : ""
						};

						$scope.habitation = true;
						$scope.commercial = false;
						$scope.terrain = false;
					} else {
						// si le rootScope est utilisé, alors on initialise
						// achatModif
						// avec
						$scope.achatModif = $rootScope.achatUpdate;

						if ($rootScope.locUpdate.categorie == "Habitation") {
							$scope.habitation = true;
							$scope.commercial = false;
							$scope.terrain = false;
						}

						if ($rootScope.locUpdate.categorie == "Commercial") {
							$scope.habitation = false;
							$scope.commercial = true;
							$scope.terrain = false;
						}

						if ($rootScope.locUpdate.categorie == "Terrain") {
							$scope.habitation = false;
							$scope.commercial = false;
							$scope.terrain = true;
						}
					}

					// la fonction modifier à partir du bouton d'appel
					// "modifier"
					$scope.modifier = function() {

						// appel de la fonction service pour modifier dans la bd
						achatProvider
								.update(
										$scope.achatForm,
										function(donnees) {
											if (typeof donnees == 'object') {
												$scope.msg = "";
												// redirection vers l'accueil
												$location.path("achat/liste");
											} else {
												$scope.msg = "La modification de l'ajout a échoué ! ";
											}
										})
					}
					// méthode pour permettre de changer la vue lors de la
					// selection de
					// la
					// catégorie : n'affiche que les types de la catégorie
					// concerné
					$scope.RadioChange = function(s) {
						$scope.CategorieSelected = s;

						if (s == "Habitation") {
							$scope.habitation = true;
							$scope.commercial = false;
							$scope.terrain = false;
						}
						if (s == "Commercial") {
							$scope.habitation = false;
							$scope.commercial = true;
							$scope.terrain = false;
						}
						if (s == "Terrain") {
							$scope.habitation = false;
							$scope.commercial = false;
							$scope.terrain = true;
						}
					};

					// *****************************************************************************************************
				})
		.controller(
				"achatCtrlDelete",
				function($scope, achatProvider, $location) {
					$scope.id = undefined;

					/** la fonction appeler à partir du bouton */
					$scope.delet = function() {

						// appel de la fonction service pour supprimer dans la
						// bd
						achatProvider
								.delet(
										$scope.id,
										function(retour) {
											if (retour == 'OK') {
												$scope.msg = "";
												// redirection vers l'accueil
												$location.path("achat/liste");
											} else {
												$scope.msg = "La suppression de l'achat a échoué ! ";
											}
										})
					}
				});