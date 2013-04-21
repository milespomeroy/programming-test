'use strict';

/* Controllers */


function SearchCtrl($scope, $http) {
    $scope.search = function() {
        if ($scope.query.length > 2) {
            $http.get('service/search?q=' + $scope.query).success(function(data) {
                $scope.tweets = data;
                $scope.searchedFor = $scope.query;
                $scope.showResults = true;
            });
        }
    }
}

function LangCtrl($scope, $http) {
    $http.get('service/languages').success(function(data) {
        $scope.languages = data;
    });
}
