app.controller('ppeController', ['$scope', 'Network', '$location','$routeParams', function($scope, network, $location, $routeParams) {

    // Pouvoir accéder aux information de l'utilisateur qui est connecté (sa ferme, ses plots)
    network.getUser(function(user) {
        $scope.user = user;
    });


    plot = $scope.user.farm[0].plots[$routeParams.plotId-1];
    $scope.oldName=plot.name;
    $scope.oldArea=plot.area;
    $scope.oldLongitude=plot.longitude;
    $scope.oldLatitude=plot.latitude;

    $scope.clickOnOk = function() {

    		if ($scope.newName === undefined){
    			$scope.user.farm[0].plots[$routeParams.plotId-1].name = $scope.oldName;
    		} else {
    			$scope.user.farm[0].plots[$routeParams.plotId-1].name = $scope.newName;
    		}
    		if ($scope.newArea === undefined){
    			$scope.user.farm[0].plots[$routeParams.plotId-1].area = $scope.oldArea;
    		} else {
    			$scope.user.farm[0].plots[$routeParams.plotId-1].area = $scope.newArea;
    		}
    		if ($scope.newLongitude === undefined){
    			$scope.user.farm[0].plots[$routeParams.plotId-1].longitude = $scope.oldLongitude;
    		} else {
    			$scope.user.farm[0].plots[$routeParams.plotId-1].longitude = $scope.newLongitude;
    		}
    		if ($scope.newLatitude === undefined){
    			$scope.user.farm[0].plots[$routeParams.plotId-1].latitude = $scope.oldLatitude;
    		} else {
    			$scope.user.farm[0].plots[$routeParams.plotId-1].latitude = $scope.newLatitude;
    		}

    	network.modif(function(user){
    		$location.path('/view');
    	}, $scope.user);
       
    };
    //On crée ici les méthodes qui correspondent à celles du service network.js et qui sont en rapport avec la modification/création des données

}]);
