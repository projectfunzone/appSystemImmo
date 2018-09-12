/*
 * Service pour la gestion des Clients
 * 
 */

monApp.factory("clientProvider", function($http) {

	// récupérer la liste
	function getListes(callBack) {
		// récupérer la liste à partir du serveur
		$http({
			method : "GET",
			url : "http://localhost:8080/AppSystemImmo/client/liste"
		}).then(function successCallback(response) {
			// stocker les données dans la callBack, afin de les
			// transferer au
			// controller, d'une manière asynchrone
			callBack(response.data);
		}, function errorCallback(response) {
			callBack(response.data)
		});

	}

	// récupérer un client avec son id
	function gets(id, callBack) {

		// récupérer la liste à partir du serveur
		$http({
			method : "GET",
			url : "http://localhost:8080/AppSystemImmo/client/get",
			params : {
				pId : id
			}
		}).then(function successCallback(response) {
			// stocker les données dans la callBack, afin de les transferer
			// au controller, d'une manière asynchrone
			callBack(response.data);
		}, function errorCallback(response) {
			callBack(response.data)
		});

	}

	// ajouter un client
	function adds(clIn, callBack) {
		$http({
			method : "POST",
			url : "http://localhost:8080/AppSystemImmo/client/add",
			// format d'envoi
			data : angular.toJson(clIn),
			// format de reception
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			// stocker les données dans la callBack, afin de les
			// transferer au controller, d'une manière asynchrone
			callBack(response.data);
		}, function errorCallback(response) {
			callBack(response.data)
		});
	}

	// modifier un client dans la bd
	function updates(clIn, callBack) {
		$http({
			method : "PUT",
			url : "http://localhost:8080/AppSystemImmo/client/update",
			data : angular.toJson(clIn),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			// stocker les données dans la callBack, afin de les
			// transferer au controller, d'une manière asynchrone
			callBack(response.data);
		}, function errorCallback(response) {
			callBack(response.data)
		});
	}

	// supprimer un client
	function delets(id, callBack) {
		$http({
			method : "DELETE",
			url : "http://localhost:8080/AppSystemImmo/client/delete/" + id,
		}).then(function successCallback(response) {
			// stocker les données dans la callBack, afin de les
			// transferer au controller, d'une manière asynchrone
			callBack(response.statusText);
		}, function errorCallback(response) {
			callBack(response.statusText)
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

});
