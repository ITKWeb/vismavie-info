app.controller('addPlotController', ['$scope', 'Network', '$location', function($scope, network, $location) {

var myUser;	
	
    // Pouvoir accéder aux information de l'utilisateur qui est connecté (sa ferme, ses plots)
    network.getUser(function(user) {
        myUser = user;
    });

    //On crée ici les méthodes qui correspondent à celles du service network.js et qui sont en rapport avec la modification/création des données

	$scope.clickOnCancel = function(){
		$location.path('/view');
	};
	
	
	$scope.clickOnAdd = function(){
		myUser.farm[0].plots[myUser.farm[0].plots.length] = $scope.plot2Add;
		network.modifyPlot();
		$location.path('/view');
	};
	
	
}]);