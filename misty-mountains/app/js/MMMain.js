'use strict';

/* Controllers */
'use strict';
var app = angular.module('MMMain', []);

angular.module('MMMain').controller('AppCtrl', ['$scope', function($scope) {
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
    };
    $scope.addScoreOnRubin = function(){
        $scope.score = $scope.score + settings.treasure.rubin;
        $scope.$apply();
    };
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