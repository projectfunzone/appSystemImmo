/**
 * Création du service consulter les listes des visites
 */
monApp.factory(
	"visiteProvider",
	function($http){
		
		function getListe(callBack){
			//recup la liste à partir du serveur serveur
			$http({
				methode:"GET",
				url: "http://localhost:8080/AppSystemImmo/visite/liste"
			}).then (function successCallback(response){
				callBack(response.data);
			}, function errorCallback(response){
				
			});
		}
			
	//ajouter une visite dans la liste de données
		function add(eIn, callBack) {
			$http(
					{
						method : "POST",
						url : "http://localhost:8080/AppSystemImmo/visite/add",
						data : angular.toJson(eIn),
						headers : {
							'Content-Type' : 'application/json'
						}
					}).then(function successCallback(response) {
				callBack(response.data);
			}, function errorCallback(response) {

			});
		}
		
		
	//Modifier une visite dans la liste de données
		function update(eIn, callBack) {
			$http(
					{
						method : "PUT",
						url : "http://localhost:8080/AppSystemImmo/visite/update",
						data : angular.toJson(eIn),
						headers : {
							'Content-Type' : 'application/json'
						}
					}).then(function successCallback(response) {
				callBack(response.data);
			}, function errorCallback(response) {
				callback(response.data)
			});
		}
		
		//supprimer une visite dans la liste de données
		function delet(id, callBack) {
			$http(
					{
						method : "DELETE",
						url : "http://localhost:8080/AppSystemImmo/visite/delete/"
								+ id,
					}).then(function successCallback(response) {
				// stocker les données dans la callBack, afin de les
				// transferer au
				// controller, d'une manière asynchrone
						callBack(response.statusText);
			}, function errorCallback(response) {
				
				callback(response.statusText);
				
			});
		}
		
		
		
		
			//retour de la fonction dfactory
			return{
				getListes: getListe,
				adds: add,
				updates: update,
				deletes:delet
				
			}
			
		
	});
