app.factory("Network", ["$http", "$location",
						function ($http, $location) {

							var isLoginMocked = true;
							var userMock;
							var userReal;

							function mygetUser(callback){
								if (isLoginMocked) {
									callback(userMock);
								} else {
									callback(userReal);
								}
							}

							function login(callback, login, password) {
								if (isLoginMocked === true) {
									if ((login === "aaa") && (password === "aaa")) {
										userMock = {"userId":1,"login":"aaa","password":"aaa","farm":[{"farmId":1,"name":"La ferme","plots":[{"plotId":1,"name":"Ma belle parcelle","area":33.5,"longitude":47.63,"latitude":2.22},{"plotId":2,"name":"Ma pas belle parcelle","area":37.5,"longitude":42.68,"latitude":1.22}]}]}; 
										callback(userMock);// On renvoie l'user mocké
									} else {
										callback({});//simule identification loupée = onjet vide
									}
								} else {
									//post = envoi au serveur du login et du mot de passe
									$http.post("rest/login",{login:login, password:password})
									.success(function(data){
										userReal = data; //En cas de succes l'utilisateur reel est mis a jour puis on fais la callback de loginController (routage vers la vue)
										callback(data); //Renvoie l'utilisateur
									})
								}
							}

							function modifyPlot (){
								console.log(userMock.farm[0].plots);
							}

							//Definition publique des fonctions (signature)
							return {

								getUser: function(callback) {
									mygetUser(callback);
								},

								login: function(callback, log, pass) {
									console.log("login");
									login(callback, log, pass);
								},

								modifyPlot: function() {
									modifyPlot();
								}
							};

						}]);
