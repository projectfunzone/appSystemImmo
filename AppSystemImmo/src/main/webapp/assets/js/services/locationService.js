monApp.factory("locationProvider", function($http) {
	
	//ajouter une location
	function add(locIn, callBack) {
		for ( var i in locIn.photos) {
			photo = {
				image : locIn.photos[i].base64
			};
			
			locIn.listeImages.push(photo);
		}
		
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
	
	
	function update(locIn, callBack) {
		$http(
				{
					method: "PUT",
					url: "http://localhost:8080/AppSystemImmo/location/update",
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
	
	// récupérer la liste du serveur
	function getListe(callBack) {
		// récupérer la liste à partir du serveur
		$http({
			method : "GET",
			url : "http://localhost:8080/AppSystemImmo/location/liste"
		}).then(function successCallback(response) {
			// stocker les données dans la callBack, afin de les transferer au
			// controller, d'une manière asynchrone
			callBack(response.data);
		}, function errorCallback(response) {

		});
	}
	
	// ***************************************************************************************
	/** récupérer une location avec son id */
	function rech(id, callBack) {
		console.log("est ce que je suis dans le service");
		$http.get("http://localhost:8080/AppSystemImmo/location/get", {
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
			console.log("----------erreur dans recup d'une location by id: "+response.statusText);
		});

	}
	
	function del (id, callBack) {
		$http({
			method : "DELETE",
			url : "http://localhost:8080/AppSystemImmo/location/delete/"+id
		}).then(function successCallback(response) {
			// stocker les données dans la callBack, afin de les transferer au
			// controller, d'une manière asynchrone
			console.log("------success")
			callBack(response.statusText);
		}, function errorCallback(response) {
			console.log("------erreur")
			callBack(response.statusText);
		});
	}
	
	return {
		adds:add,
		updates:update,
		getListes:getListe,
		dels: del,
		getById : rech
	}
	
	
});