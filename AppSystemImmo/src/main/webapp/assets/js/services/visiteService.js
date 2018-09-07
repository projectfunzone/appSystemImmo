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
		
		
			//retour de la fonction dfactory
			return{
				getListes: getListe,
				adds: add
				
			}
			
		
	});
