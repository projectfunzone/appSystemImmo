/**Créer mes controllers*/

monApp
.controller("achatCtrlFindAll",
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
					//**********************************************//
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
				photos : [],
				listeImages:[],
				revenueCadastre : "",
				statut : "",
				type : "",
				etat : "",
				prixDemande : "",
				surface:""
			};

			/** appel de la fonction à partir du lien de la liste pour modifier un achat*/
			$scope.updateLien = function(achatIn) {
				$rootScope.achatUpdate = achatIn;

				// aller dans la vue modif
				$location.path("update");
			}
//*****************************************************************************************************
		}).controller("achatCtrlGet", function($scope, achatProvider) {
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

	$scope.habitation = true;
	$scope.commercial = false;
	$scope.terrain = false;
	// initialiser l'objet dans le model du scope
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
			listeImages:[],
			revenueCadastre : "",
			statut : "",
			type : "",
			etat : "",
			prixDemande : "",
			surface:""
	}

	// la fonction ajouter à partir du bouton d'appel "ajouter"
	$scope.ajouter = function() {

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
	// méthode pour permettre de changer la vue lors de la selection de la
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
	
	
	
	
	
})
//**************************************************************************************************
.controller("achatCtrlUpdate",
		function($scope, achatProvider, $location, $rootScope) {

	$scope.habitation = true;
	$scope.commercial = false;
	$scope.terrain = false;
			// initialiser l'objet dans le model du scope s'il n'est pas dans le
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
					listeImages:[],
					revenueCadastre : "",
					statut : "",
					type : "",
					etat : "",
					prixDemande : "",
					surface:""
				};
			} else {
				// si le rootScope est utilisé, alors on initialise achatModif avec
				$scope.achatModif = $rootScope.achatUpdate;
			}

			// la fonction modifier à partir du bouton d'appel "modifier"
			$scope.modifier = function() {

				// appel de la fonction service pour modifier dans la bd
				achatProvider.update($scope.achatForm, function(donnees) {
					if (typeof donnees == 'object') {
						$scope.msg = "";
						// redirection vers l'accueil
						$location.path("achat/liste");
					} else {
						$scope.msg = "La modification de l'ajout a échoué ! ";
					}
				})
			}			
			// méthode pour permettre de changer la vue lors de la selection de la
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

//*****************************************************************************************************
		})
		.controller("achatCtrlDelete",
		function($scope, achatProvider, $location) {
			$scope.id = undefined;

			/** la fonction appeler à partir du bouton*/
			$scope.delet = function() {

				// appel de la fonction service pour supprimer dans la bd
				achatProvider.delet($scope.id, function(retour) {
					if (retour == 'OK') {
						$scope.msg = "";
						// redirection vers l'accueil
						$location.path("achat/liste");
					} else {
						$scope.msg = "La suppression de l'achat a échoué ! ";
					}
				})
			}
		})

//*****************************************************************************************
//********************Le controlleur pour envoyer un mail**********************************
//*****************************************************************************************
.controller('sentMailCntrl',function($scope, $http){
	  $scope.sendMail = function(demba){
	    console.log(demba.toEmail);
	    var mailJSON ={
	        "key": "xxxxxxxxxxxxxxxxxxxxxxx",
	        "message": {
	          "html": ""+demba.mailBody,
	          "text": ""+demba.mailBody,
	          "subject": ""+demba.subject,
	          "from_email": "sender@sending.domain.com",
	          "from_name": "Support",
	          "to": [
	            {
	              "email": ""+demba.toEmail,
	              "name": "John Doe",
	              "type": "to"
	            }
	          ],
	          "important": false,
	          "track_opens": null,
	          "track_clicks": null,
	          "auto_text": null,
	          "auto_html": null,
	          "inline_css": null,
	          "url_strip_qs": null,
	          "preserve_recipients": null,
	          "view_content_link": null,
	          "tracking_domain": null,
	          "signing_domain": null,
	          "return_path_domain": null
	        },
	        "async": false,
	        "ip_pool": "Main Pool"
	    };
	    var apiURL = "https://mandrillapp.com/api/1.0/messages/send.json";
	    $http.post(apiURL, mailJSON).
	      success(function(data, status, headers, config) {
	        alert('successful email send.');
	        $scope.form={};
	        console.log('successful email send.');
	        console.log('status: ' + status);
	        console.log('data: ' + data);
	        console.log('headers: ' + headers);
	        console.log('config: ' + config);
	      }).error(function(data, status, headers, config) {
	        console.log('error sending email.');
	        console.log('status: ' + status);
	      });
	  }
	});