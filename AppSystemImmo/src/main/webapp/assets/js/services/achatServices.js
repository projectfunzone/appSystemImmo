//création de mon service

monApp
		.factory(
				"achatProvider",
				function($http) {

					/** récupérer la liste du serveur*/
					function recupListe(callBack) {
						/** récupérer la liste à partir du serveur*/
						$http(
								{
									method : "GET",
									url : "http://localhost:8080/AppSystemImmo/achat/liste"
								}).then(function successCallback(response) {
							/** stocker les données dans la callBack, afin de les
							 transferer au controller, d'une manière asynchrone*/
							callBack(response.data);
						}, function errorCallback(response) {

						});
					}

					/** récupérer un ajout avec son id*/
					function rech(id, callBack) {

						$http
								.get(
										"http://localhost:8080/AppSystemImmo/achat/get",
										{
											params : {
												pId : id
											}
										}).then(
										function successCallback(response) {
											/** stocker les données dans la callBack, afin de les transferer au controller, d'une manière
											asynchrone*/
											callBack(response.data);
										}, function errorCallback(response) {

										});

					}

					/** ajouter un achat dans la bd*/
					function ajout(achatIn, callBack) {
						$http(
								{
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

						});
					}

					// modifier un etudiant dans la bd
					function modif(achatIn, callBack) {
						$http(
								{
									method : "PUT",
									url : "http://localhost:8080/AppSystemImmo/achat/upd",
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
							callback(response.data)
						});
					}

					// supprimer un ajout
					function delets(id, callBack) {
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/AppSystemImmo/achat/delete/"
											+ id,
								}).then(function successCallback(response) {
							// stocker les données dans la callBack, afin de les
							// transferer au
							// controller, d'une manière asynchrone
							callBack(response.statusText);
						}, function errorCallback(response) {
							callback(response.statusText)
						});
					}

					// le retour de ma fonction factory
					return {
						getListe : recupListe,
						getById : rech,
						add : ajout,
						update : modif,
						delet : delets
					}

				});