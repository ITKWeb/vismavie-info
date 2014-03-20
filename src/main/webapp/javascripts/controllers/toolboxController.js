app.controller('toolboxController', ['$scope', 'Network', '$location', function($scope, network, $location) {


    $scope.actionClicAngular = function() {
         window.alert("vous avez entré: "+$scope.VariableDansMonControleur);
    };

}]);
