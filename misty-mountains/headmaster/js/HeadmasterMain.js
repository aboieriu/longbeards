'use strict';

/* Controllers */
'use strict';
var app = angular.module('MMMain', []);
app.baseService = "http://localhost:9091/api";
app.basePath = "http://localhost:9091/app";

angular.module('MMMain').controller('AppCtrl', ['$scope', '$http', function($scope, $http) {
    $http.get(app.baseService + "/treasure").then(function(response){
        $scope.treasure = response.data;
        $scope.newTreasures = [];
        $scope.stats = getTreasureStats(response.data);

        if('serviceWorker' in navigator){
            navigator.serviceWorker.addEventListener('message', function(event){
                var newTreasures = JSON.parse(event.data);
                for (var key in newTreasures) {
                    $scope.newTreasures.push(newTreasures[key]);
                }
                $scope.$apply();
            });
        }
    });

    var getTreasureStats = function(data) {
        if (data) {
            var stats = {
                total:0
                , coin: {
                    count:0
                    , value:0
                }
                , rubin: {
                    count:0
                    , value:0
                }
            };
            for (var key in data) {
                var item = data[key];
                stats.total = stats.total + item.value;
                if (item.type === 'coin') {
                    stats.coin.count++;
                    stats.coin.value = stats.coin.value + item.value;
                } else {
                    stats.rubin.count++;
                    stats.rubin.value= stats.rubin.value + item.value;
                }
            }
            return stats;
        }
    }
}]);