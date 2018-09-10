monApp.controller("locationCtrlAdd",
		function($scope, locationProvider, $location, $rootScope) {

			$scope.habitation = true;
			$scope.commercial = false;
			$scope.terrain = false;

			// initialiser l'objet dans le model du scope
			if ($rootScope.locAdd.proprietaire.id == undefined) {
				$scope.locIn = {
					id : undefined,
					categorie : "",
					type : "",
					surface : "",
					noChambre : "",
					photos : [],
					listeImages:[],
					statut : "",
					dateSoumis : "",
					adresse : {
						rue : "",
						cp : "",
						ville : "",
						pays : ""
					},
					dateDispo : "",
					revenueCadastre : "",
					caution : "",
					loyer : "",
					charge : "",
					bail : "",
					garniture : "",
					proprietaire : {
						id : undefined
					}
				}
				console.log("test if")
			} else {
				$scope.locIn = {
						id : undefined,
						categorie : "",
						type : "",
						surface : "",
						noChambre : "",
						photos : [],
						listeImages:[],
						statut : "",
						dateSoumis : "",
						adresse : {
							rue : "",
							cp : "",
							ville : "",
							pays : ""
						},
						dateDispo : "",
						revenueCadastre : "",
						caution : "",
						loyer : "",
						charge : "",
						bail : "",
						garniture : "",
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
					}
						
				$scope.locIn.proprietaire = $rootScope.locAdd.proprietaire;
				console.log("test else")
			}

			

			$scope.add = function() {
				locationProvider.adds($scope.locIn, function(donnees) {
					if (typeof donnees == 'object') {
						$scope.msg = "";
						// redirection vers l'accueil
						$location.path("/location/liste");
					} else {
						$scope.msg = "L'ajout a échoué ! ";
					}
				})
			}

			// méthode pour permettre de changer la vue lors de la selection de
			// la
			// catégorie : n'affiche que les types de la catégorie concerné
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

		}).controller("locationCtrlUpdate",
		function($scope, locationProvider, $location, $rootScope) {

			// initialiser l'objet dans le model du scope
			if ($rootScope.locUpdate.id == undefined) {
				$scope.locIn = {
					id : undefined,
					categorie : "",
					type : "",
					surface : "",
					noChambre : "",
					photos : [],
					listeImages:[],
					statut : "",
					dateSoumis : "",
					adresse : {
						rue : "",
						cp : "",
						ville : "",
						pays : ""
					},
					dateDispo : "",
					revenueCadastre : "",
					caution : "",
					loyer : "",
					charge : "",
					bail : "",
					garniture : ""
				}

				$scope.habitation = true;
				$scope.commercial = false;
				$scope.terrain = false;

			} else {
				$scope.locIn = $rootScope.locUpdate;

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

			$scope.update = function() {

				locationProvider.updates($scope.locIn, function(donnees) {

					$scope.msg = "";
					// redirection vers l'accueil
					$location.path("location/liste");
				})
			}

			// méthode pour permettre de changer la vue lors de la selection de
			// la
			// catégorie : n'affiche que les types de la catégorie concerné
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

		}).controller("locationCtrlListe",
		function($scope, $rootScope, locationProvider, $location) {
			locationProvider.getListes(function(donnees) {
				$scope.liste = donnees;
			})

			$scope.deleteLien = function(id) {
				locationProvider.dels(id, function(retour) {
					// mettre à jour la liste
					locationProvider.getListes(function(donnees) {
						// stocker les données récupéré de service
						$scope.liste = donnees;
					})
				})
			}

			$rootScope.locUpdate = {
				id : undefined,
				categorie : "",
				type : "",
				surface : "",
				noChambre : "",
				photos : [],
				listeImages:[],
				statut : "",
				dateSoumis : "",
				adresse : {
					rue : "",
					cp : "",
					ville : "",
					pays : ""
				},
				dateDispo : "",
				revenueCadastre : "",
				caution : "",
				loyer : "",
				charge : "",
				bail : "",
				garniture : ""
			};

			$scope.updateLien = function(lIn) {
				$rootScope.locUpdate = lIn;
				console.log("----" + lIn.id);
				console.log("-----" + $rootScope.locUpdate.id);
				$location.path("location/update");
			}

		})