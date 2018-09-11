/*
 * Service pour la gestion des Conseillers
 * 
 */

monApp.factory("conseillerProvider", function($http) {
	// récupérer la liste
	function getListes(callBack) {
		$http({
			method : "GET",
			url : "http://localhost:8080/AppSystemImmo/conseiller/liste"
		}).then(function successCallback(response) {
			// stocker les données dans la callBack, afin de les
			// transferer au
			// controller, d'une manière asynchrone
			callBack(response.data);
		}, function errorCallback(response) {

		});

	}

	// ajouter un conseiller
	function adds(coIn, callBack) {
		$http({
			method : "POST",
			url : "http://localhost:8080/AppSystemImmo/conseiller/add",
			// format d'envoi
			data : angular.toJson(coIn),
			// format de reception
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			// stocker les données dans la callBack, afin de les
			// transferer au controller, d'une manière asynchrone
			callBack(response.data);
		}, function errorCallback(response) {

		});
	}

	// récupérer un conseiller avec son id
	function gets(id, callBack) {

		// récupérer la liste à partir du serveur
		$http({
			method : "GET",
			url : "http://localhost:8080/AppSystemImmo/conseiller/get",
			params : {
				pId : id
			}
		}).then(function successCallback(response) {
			// stocker les données dans la callBack, afin de les transferer
			// au controller, d'une manière asynchrone
			callBack(response.data);
		}, function errorCallback(response) {

		});

	}

	// modifier un conseiller dans la bd
	function updates(coIn, callBack) {
		$http({
			method : "PUT",
			url : "http://localhost:8080/AppSystemImmo/conseiller/update",
			data : angular.toJson(coIn),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			// stocker les données dans la callBack, afin de les
			// transferer au controller, d'une manière asynchrone
			callBack(response.data);
		}, function errorCallback(response) {
			callback(response.data)
		});
	}

	// supprimer un conseiller
	function delets(id, callBack) {
		$http({
			method : "DELETE",
			url : "http://localhost:8080/AppSystemImmo/conseiller/delete/" + id,
		}).then(function successCallback(response) {
			// stocker les données dans la callBack, afin de les
			// transferer au controller, d'une manière asynchrone
			callBack(response.statusText);
		}, function errorCallback(response) {
			callback(response.statusText)
		});
	}

	// les retour de factory
	return {
		getListe : getListes,
		get : gets,
		add : adds,
		update : updates,
		delet : delets
	}

})
