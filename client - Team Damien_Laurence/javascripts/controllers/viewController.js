app.controller('viewController', ['$scope', 'Network', '$location', function($scope, network, $location) {

	// Pouvoir accéder aux information de l'utilisateur qui est connecté (sa ferme, ses plots)
	network.getUser(function(user) {
		$scope.user = user;
	});

	//On crée ici les méthodes qui correspondent à celles du service network.js et qui sont en rapport avec l'affichage des données

	$scope.clickOnModif = function(plot){
		//window("modifier la parcelle n°" + plot.plotId);
		$scope.showModifPopUp= true;
		$scope.plot2Modif = plot;
	}

	$scope.clickOnDel = function(plot){
		//window.alert("supprimer");
	}

	$scope.hide=function(){
			$scope.showModifPopUp=false;
	};
	         
}]);
