app.controller('viewController', ['$scope', 'Network', '$location', function($scope, network, $location) {

    // Pouvoir accéder aux information de l'utilisateur qui est connecté (sa ferme, ses plots)
    $scope.disp = false;
    network.getUser(function(user) {
        $scope.user = user;
    });

    	$scope.userLogin=$scope.user.login;

    $scope.clickOnPen = function(plot) {
       
       	$location.path('/ppe/'+plot.plotId);
    };


    $scope.display = function() {

       	$scope.disp = !($scope.disp);

    };
    //On crée ici les méthodes qui correspondent à celles du service network.js et qui sont en rapport avec l'affichage des données

    $scope.valid = function() {

var newPlot =  {plotId : $scope.user.farm[0].plots.length+1, name : $scope.newName, area : $scope.newArea, latitude : $scope.newLatitude, longitude : $scope.newLongitude};
       $scope.user.farm[0].plots[$scope.user.farm[0].plots.length] = newPlot;

          	network.create(function(user){
    	}, $scope.user);
    };


}]);
