// création du service concernant la classe Propriétaire

monApp
		.factory(
				"proprietaireProvider",
				function($http) {

					// récupérer la liste des propriétaires de la bd
					function getListe(callBack) {

						// récupérer la liste à partir du serveur
						$http(
								{
									method : "GET",
									url : "http://localhost:8080/AppSystemImmo/proprietaire/liste"
								}).then(function successCallBack(reponse) {
							callBack(reponse.data);
						}, function errorCallBack(reponse) {

						});

					}

					// récupérer un propriétaire par son ID
					function get(id, callBack) {
						$http
								.get(
										"http://localhost:8080/AppSystemImmo/proprietaire/get",
										{
											params : {
												pId : id
											}
										}).then(
										function successCallback(response) {
											callBack(response.data);
										}, function errorCallback(response) {

										});
					}

					// ajouter un proprietaire dans la bd
					function add(proprioIn, callBack) {
						$http(
								{
									method : "POST",
									url : "http://localhost:8080/AppSystemImmo/proprietaire/add",
									data : angular.toJson(proprioIn),
									headers : {
										'Content-Type' : 'application/json'
									}
								}).then(function successCallBack(reponse) {
							// stocker les information dans le callback pour les
							// envoyer au
							// controller de manière asynchrone
							callBack(reponse.data);
						}, function errorCallBack(reponse) {

						});
					}

					// modifier un propriétaire dans la base de données
					function update(proprioIn, callBack) {
						$http(
								{
									method : "PUT",
									url : "http://localhost:8080/AppSystemImmo/proprietaire/update",
									data : angular.toJson(proprioIn),
									headers : {
										'Content-Type' : 'application/json'
									}
								}).then(function successCallback(response) {
							callBack(response.data);
						}, function errorCallback(response) {

						});
					}

					// supprimer un propriétaire de la bd
					function delet(id, callBack) {
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/AppSystemImmo/proprietaire/delete/"
											+ id
								}).then(function successCallback(response) {
							callBack(response.statusText);
						}, function errorCallback(response) {

						});
					}

					// les différents retours de la fonction factory
					return {
						addS : add,
						getListeS : getListe,
						getS : get,
						updateS : update,
						deletS : delet
					}

				});