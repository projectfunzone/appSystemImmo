// création du service concernant la classe Propriétaire

monApp.factory("proprietaireProvider", function($http) {

	// récupérer la liste des propriétaires de la bd
	function getListe(callBack) {

		// récupérer la liste à partir du serveur
		$http({
			method : "GET",
			url : "http://localhost:8080/AppSystemImmo/proprietaire/liste"
		}).then(function successCallBack(reponse) {
			callBack(reponse.data);
		}, function errorCallBack(reponse) {

		});

	}

	// ajouter un proprietaire dans la bd
	function add(proprioIn, callBack) {
		$http({
			method : "POST",
			url : "http://localhost:8080/AppSystemImmo/proprietaire/add",
			data : angular.toJson(proprioIn),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallBack(reponse) {
			// stocker les information dans le callback pour les envoyer au
			// controller de manière asynchrone
			callBack(reponse.data);
		}, function errorCallBack(reponse) {

		});
	}

	// les différents retours de la fonction factory
	return {
		addS : add,
		getListeS : getListe
	}

});