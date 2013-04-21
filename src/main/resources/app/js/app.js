'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', []).
  config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/search', {templateUrl: 'partials/tweet-search.html', controller: SearchCtrl});
    $routeProvider.when('/lang', {templateUrl: 'partials/lang.html', controller: LangCtrl});
    $routeProvider.otherwise({redirectTo: '/search'});
  }]);
