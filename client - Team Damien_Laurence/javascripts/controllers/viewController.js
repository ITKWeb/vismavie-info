app.controller('viewController', ['$scope', 'Network', '$location', function($scope, network, $location) {
	
var plotLink;
	
	
	// Pouvoir accéder aux information de l'utilisateur qui est connecté (sa ferme, ses plots)
	network.getUser(function(user) {
		$scope.user = user;
	});


	//On crée ici les méthodes qui correspondent à celles du service network.js et qui sont en rapport avec l'affichage des données

	$scope.clickOnModif = function(plot){
		//window("modifier la parcelle n°" + plot.plotId);
		$scope.showModifPopUp= true;
		plotLink = plot;
		$scope.plot2Modif = {};
		$scope.plot2Modif.name = plot.name;
		$scope.plot2Modif.area = plot.area;
		$scope.plot2Modif.latitude = plot.latitude;
		$scope.plot2Modif.longitude = plot.longitude;
	}

	$scope.clickOnDel = function(plot){
		//window.alert("supprimer");
	}

	$scope.clickOnAdd = function(){
		//window.alert("supprimer");
		$location.path('/addPlot');
	}
	
	$scope.hide=function(){
			$scope.showModifPopUp=false;
	};
	
	
	$scope.save=function(){
		$scope.showModifPopUp=false;
		plotLink.name = $scope.plot2Modif.name;
		plotLink.area = $scope.plot2Modif.area;
		plotLink.latitude = $scope.plot2Modif.latitude;
		plotLink.longitude = $scope.plot2Modif.longitude;
		network.modifyPlot();
	};
	         
}]);
