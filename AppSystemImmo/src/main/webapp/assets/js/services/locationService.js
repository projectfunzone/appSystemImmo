monApp.factory("locationProvider", function($http) {
	
	//ajouter une location
	function add(locIn, callBack) {
		$http(
				{
					method: "POST",
					url: "http://localhost:8080/AppSystemImmo/location/add",
					data:angular.toJson(locIn),
					headers : {'Content-Type':'application/json'}
				}).then(function successCallback(response) {
					// stocker les données dans la callBack, afin de les transferer au
					// controller, d'une manière asynchrone
					callBack(response.data);
				}, function errorCallback(response) {
					console.log("-------erreur")
				});
	}
	
	
	
	return {
		adds:add
	}
	
	
});