var app = angular.module('app', []);

app.config(["$routeProvider", "$httpProvider",
  function($routeProvider, $httpProvider) {
    $httpProvider.defaults.headers['common']['Accept'] = 'application/json';
    $routeProvider
      .when('/', { //Ce qui est dans la barre d'adresse...
        templateUrl: 'views/login.html',  //...correspond à cette page html
        controller: "loginController" // Ma vue est controlée par ce controlleur là
      }) 
      .when('/view', {
        templateUrl: 'views/view.html',
        controller: "viewController"
      })
      .when('/ppe/:plotId', {
        templateUrl: 'views/ppe.html',
        controller: "ppeController"
      })  

      .otherwise({
        redirectTo: '/' // Par défaut
      });
  }
]);
