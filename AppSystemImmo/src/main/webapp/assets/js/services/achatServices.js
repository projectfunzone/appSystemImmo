//création de mon service

monApp.factory("achatProvider", function($http) {
	var geoURL = 'https://nominatim.openstreetmap.org/search';
	/** récupérer la liste du serveur */
	function recupListe(callBack) {
		/** récupérer la liste à partir du serveur */
		$http({
			method : "GET",
			url : "http://localhost:8080/AppSystemImmo/achat/liste"
		}).then(function successCallback(response) {
			/**
			 * stocker les données dans la callBack, afin de les transferer au
			 * controller, d'une manière asynchrone
			 */
			callBack(response.data);
		}, function errorCallback(response) {
			 console.log("----------erreur dans la liste des achats: "+response.statusText);
			  
		});
	}
	// ***************************************************************************************
	/** récupérer un ajout avec son id */
	function rech(id, callBack) {

		$http.get("http://localhost:8080/AppSystemImmo/achat/get", {
			params : {
				pId : id
			}
		}).then(function successCallback(response) {
			/**
			 * stocker les données dans la callBack, afin de les transferer au
			 * controller, d'une manière asynchrone
			 */
			callBack(response.data);
		}, function errorCallback(response) {
			console.log("----------erreur dans recup d'un achat by id: "+response.statusText);
		});

	}
	// ***************************************************************************************
	/** ajouter un achat dans la bd */
	function ajout(achatIn, callBack) {
		for ( var i in achatIn.photos) {
			photo = {
				image : achatIn.photos[i].base64
			};
			
			achatIn.listeImages.push(photo);
		}


		$http({
			method : "POST",
			url : "http://localhost:8080/AppSystemImmo/achat/add",
			data : angular.toJson(achatIn),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			// stocker les données dans la callBack, afin de les
			// transferer au
			// controller, d'une manière asynchrone
			callBack(response.data);
		}, function errorCallback(response) {
			 console.log("----------erreur dans ajout d'un etudiant: "+response.statusText);
		});
	}
	// ***************************************************************************************
	/** modifier un etudiant dans la bd */
	function modif(achatIn, callBack) {
		$http({
			method : "PUT",
			url : "http://localhost:8080/AppSystemImmo/achat/update",
			data : angular.toJson(achatIn),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			/**
			 * stocker les données dans la callBack, afin de les transferer au
			 * controller, d'une manière asynchrone
			 */
			callBack(response.data);
		}, function errorCallback(response) {
			console.log("----------erreur dans modifier un achat: "+response.statusText);
			callback(response.data)
		});
	}
	// ***************************************************************************************
	/** supprimer un ajout */
	function delets(id, callBack) {
		$http({
			method : "DELETE",
			url : "http://localhost:8080/AppSystemImmo/achat/delete/" + id,
		}).then(
				function successCallback(response) {
					/**
					 * stocker les données dans la callBack, afin de les
					 * transferer au controller, d'une manière asynchrone
					 */
					callBack(response.statusText);
				},
				function errorCallback(response) {
//					console.log("----------erreur dans supprimer un achat: "+ response.statusText);
					callBack(response.statusText)
				});
	}
		
		 function localiserAdresse(pays, rue, cp,localite, calback) {
		        $http(
		                {
		                    method : 'GET',
		                    url : geoURL+ '?format=json'
		                    + "&city="+localite
		                    + '&street='+ rue
		                    + "&postalcode="+cp
		                             
		                }).then(
		                function successCalback(response) {
		                    console.log(response.data);
		                    calback(response.data);
		                },
		                function echecCalback(response) {
		                    console.log("erreur : " + response.status
		                            + " " + response.statusText);
		                });
	}

	/** le retour de ma fonction factory */
	return {
		getListe : recupListe,
		getById : rech,
		add : ajout,
		update : modif,
		delet : delets,
		geoAdresse : localiserAdresse
	}

});