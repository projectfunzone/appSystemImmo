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
	// les retour de factory
	return {
		getListe : getListes,
		add : adds,
	}	
	
})
