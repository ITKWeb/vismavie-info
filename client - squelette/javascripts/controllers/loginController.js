app.controller('loginController', ['$scope', 'Network', '$location', function($scope, network, $location) {

    //On cree ici les méthodes qui correspondent à celles du service network.js et qui sont en rapport avec le login
    $scope.clickOnLogin = function() {
       
       //la méthode login prend en paramètre une callback (méthode à créer exécutée en cas de succès de la requete), un login et un password (mais lesquels ?)
        network.login( /*maCallBack, monLogin, monPassword*/ ) ;
    };

    //Un exemple de routage
    $scope.clickOnFakeBouton = function() {
        $location.path('/view');
    };

}]);
