app.controller('loginController', ['$scope', 'Network', '$location', function($scope, network, $location) {

    //On cree ici les méthodes qui correspondent à celles du service network.js et qui sont en rapport avec le login
    $scope.clickOnLogin = function() {
       
       //la méthode login prend en paramètre une callback (méthode à créer exécutée en cas de succès de la requete), un login et un password (mais lesquels ?)
        network.login(function(user) {
        if (user.userId === undefined) {
        	window.alert("N'importe quoi!");
        } else {
        	$location.path('/view');
        }
    },
        $scope.login, $scope.password ) ;
    };

    //Un exemple de routage
    $scope.clickOnFakeBouton = function() {
        $location.path('/view');
        // recuperer mdp ds serveur associe au scope.login
        // verifier que meme chose que scope.password
        window.alert($scope.login);
    };

}]);
