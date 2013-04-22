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

    $scope.getRaw = function() {
        if ($scope.query.length > 2) {
            $http.get('service/search?q=' + $scope.query, {headers: {'Accept': 'text/plain'}}).success(function(data) {
                $scope.raw = data;
            });
        } else {
            $scope.raw = "Oops, your search query is not long enough. Pow!";
        }
    }
}

function LangCtrl($scope, $http) {
    $http.get('service/languages').success(function(data) {
        $scope.languages = data;
    });

    $scope.getRaw = function() {
        $http.get('service/languages', {headers: {'Accept': 'text/plain'}}).success(function(data) {
            $scope.raw = data;
        });
    }
}
