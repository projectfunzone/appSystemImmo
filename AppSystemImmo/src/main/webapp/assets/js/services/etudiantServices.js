//création de mon service

monApp
		.factory(
				"etudiantProvider",
				function($http) {

					// récupérer la liste du serveur
					function recupListe(callBack) {
						// récupérer la liste à partir du serveur
						$http(
								{
									method : "GET",
									url : "http://localhost:8080/05_a_MVC_REST_IoC_Hibernate/ws/liste"
								}).then(function successCallback(response) {
							// stocker les données dans la callBack, afin de les
							// transferer au
							// controller, d'une manière asynchrone
							callBack(response.data);
						}, function errorCallback(response) {

						});
					}

					// récupérer un étudiant avec son id
					function rech(id, callBack) {

						$http
								.get(
										"http://localhost:8080/05_a_MVC_REST_IoC_Hibernate/ws/byId",
										{
											params : {
												pId : id
											}
										}).then(
										function successCallback(response) {
											// stocker les données dans la
											// callBack, afin de les transferer
											// au
											// controller, d'une manière
											// asynchrone
											callBack(response.data);
										}, function errorCallback(response) {

										});

					}

					// ajouter un etudiant dans la bd
					function ajout(eIn, callBack) {
						$http(
								{
									method : "POST",
									url : "http://localhost:8080/05_a_MVC_REST_IoC_Hibernate/ws/add",
									data : angular.toJson(eIn),
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
					function modif(eIn, callBack) {
						$http(
								{
									method : "PUT",
									url : "http://localhost:8080/05_a_MVC_REST_IoC_Hibernate/ws/upd",
									data : angular.toJson(eIn),
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

					// supprimer un etudiant
					function suppr(id, callBack) {
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/05_a_MVC_REST_IoC_Hibernate/ws/del/"
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
						delet : suppr
					}

				});