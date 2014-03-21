app.controller('ppeController', ['$scope', 'Network', '$location', function($scope, network, $location) {

    // Pouvoir accéder aux information de l'utilisateur qui est connecté (sa ferme, ses plots)
    network.getUser(function(user) {
        $scope.user = user;
    });

    //On crée ici les méthodes qui correspondent à celles du service network.js et qui sont en rapport avec la modification/création des données

}]);
