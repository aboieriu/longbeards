'use strict';

/* Controllers */
'use strict';
var app = angular.module('MMMain', []);
app.baseService = "http://localhost:9091/api";
app.basePath = "http://localhost:9091/app";

angular.module('MMMain').controller('AppCtrl', ['$scope', '$http', function($scope, $http) {
    $scope.score = 0;

    var settings = {
        tile: {
            width:65
            , height:67
        }
        , treasure: {
            coin:500
            , rubin: 750
        }
    };

    var game = {
        map: {
            generate: function($element){
                var width = $element.width();
                var height = $element.height();
                var matrixWidth = Math.floor(width/settings.tile.width);
                var matrixHeight = Math.floor(height/settings.tile.height);

                var map = [];

                for (var x = 0; x < matrixWidth; x++){
                    var mapRow = [];
                    for (var y = 0; y < matrixHeight; y++){
                        var cell = {
                            coin:game.util.containsGold()
                        };

                        if (!cell.coin){
                            cell.rubin = game.util.containsRubin()
                        }
                        mapRow.push(cell);
                    }
                    map.push(mapRow)
                }

                return map;
            }
        }
        , util: {
            containsGold: function() {
                return Math.floor(Math.random() * (10 - 0 + 1)) + 0 > 6;
            }
            , containsRubin: function() {
                return Math.floor(Math.random() * (10 - 0 + 1)) + 0 > 8;
            }
        }
    };

    $scope.map = game.map.generate(jQuery(".mm-grid"));

    $scope.addScoreOnCoin = function(){
        $scope.score = $scope.score + settings.treasure.coin;
        $scope.$apply();
        updateTreasureUpdateRequest('coin');
    };
    $scope.addScoreOnRubin = function(){
        $scope.score = $scope.score + settings.treasure.rubin;
        $scope.$apply();
        updateTreasureUpdateRequest('rubin');
    };

    $http.get(app.baseService + "/dwarves").then(function(response){
        $scope.dwarves = response.data;
    });

    $scope.pickDwarf = function(dwarfId) {
        for (var key in $scope.dwarves) {
            var target = $scope.dwarves[key];
            if (target.id == dwarfId) {
                game.dwarf = target;
            }
        }
        $scope.dwarves = null;
    };

    var updateTreasureUpdateRequest = function(type) {
        if (game.dwarf) {
            var treasure = {
                "type": type,
                "value": settings.treasure[type],
                "dwarf": {
                    "id": game.dwarf.id
                }
            }
        }

        $http({
            url:app.baseService + "/treasure"
            , method:'POST'
            , data: treasure
        });
    }


}]).directive('mmTile', ['$rootScope', function($rootScope) {
    return {
        link:function($scope, element){
            var parent = jQuery(element);
            var target = parent.find('.dirt');
            target.on('click', function(){
                var containsCoin = parent.find('.coin.ng-hide').size() === 0;
                var containsRubin = parent.find('.rubin.ng-hide').size() === 0;
                target.addClass('hide');
                if (containsCoin) {
                    $scope.addScoreOnCoin();
                }
                if (containsRubin) {
                    $scope.addScoreOnRubin();
                }
                target.off('click');
            })
        }
    }
}]);