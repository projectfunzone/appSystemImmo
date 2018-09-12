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
					listeImages : [],
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
					},

					lat : "",
					lng : ""
				}

			} else {
				$scope.locIn = {
					id : undefined,
					categorie : "",
					type : "",
					surface : "",
					noChambre : "",
					photos : [],
					listeImages : [],
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
					},
					lat : "",
					lng : ""
				}

				$scope.locIn.proprietaire = $rootScope.locAdd.proprietaire;

			}

			$scope.add = function() {
				
				  
				locationProvider.geoAdresse($scope.locIn.adresse.pays,$scope.locIn.adresse.rue,$scope.locIn.adresse.cp,$scope.locIn.adresse.ville, function(calback) {
                    if ((calback != 0) && (calback != "")) {
                        // $scope.montrerMap=true;
                        $scope.map = calback;
                        $scope.locIn.lat = $scope.map[0].lat;
                        $scope.locIn.lng = $scope.map[0].lon;
                         
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
                });
 
				
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

		})

.controller("locationCtrlGet",
		function($scope, locationProvider, $rootScope, $location) {
			$scope.indice = false;
			$scope.id = undefined;
			$scope.msg = "";

			$rootScope.location = {
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
				caution : "",
				loyer : "",
				charge : "",
				bail : "",
				garniture : ""
			};

			$scope.rechercher = function() {
				// appel de la fonction du locationProvider afin de récupérer
				// la location
				locationProvider.getById($scope.id, function(donnees) {

					if (typeof donnees == 'object') {
						$rootScope.location = donnees;
						$scope.indice = true;
						console.log("est ce que je suis dans le c");
						$location.path("location/fiche");

					} else {
						$scope.indice = false;
						$scope.msg = "la location recherchée n'existe pas"
					}
					;

				})
			}

		}).controller("locationCtrlFiche",
		function($scope, locationProvider, $location, $rootScope) {

			if ($rootScope.location.id == undefined) {
				$rootScope.location = {
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
					caution : "",
					loyer : "",
					charge : "",
					bail : "",
					garniture : ""
				};
			}

			$scope.addVisiteLien = function(locationIn) {
				$rootScope.location = locationIn;
				console.log($rootScope.location)
				$location.path("visite/add");

			}

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
					listeImages : [],
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
				listeImages : [],
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
				$location.path("location/update");
			}

		})