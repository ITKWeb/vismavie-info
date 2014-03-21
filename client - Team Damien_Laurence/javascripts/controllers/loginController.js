app.controller('loginController', ['$scope', 'Network', '$location', function($scope, network, $location) {

    //On cree ici les méthodes qui correspondent à celles du service network.js et qui sont en rapport avec le login
    $scope.clickOnLogin = function() {
       
       //la méthode login prend en paramètre une callback (méthode à créer exécutée en cas de succès de la requete), un login et un password (mais lesquels ?)
        network.login(ValidConnection, $scope.login, $scope.password /*maCallBack, monLogin, monPassword*/ ) ;
    };

    //Un exemple de routage
    var ValidConnection = function(user) {
		if (user.userId === undefined) {
			         window.alert("Login et/ou mot de passe incorrect");
		}
		else {
		$location.path('/view');	
		}
        
    };

}]);
