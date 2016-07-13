
var checkNotifications = function() {
    fetch('http://localhost:9090/treasure/new').then(
        function(response) {
            if (response.status !== 200) {
                return;
            }
            response.text().then(function(responseText) {
                var newTreasures = JSON.parse(responseText);
                if (newTreasures.length > 0) {
                    var stats = getTreasureStats(newTreasures);
                    var message = ""+stats.coin.count+" coins and "+stats.rubin.count+" rubins with a total value of " + stats.total;
                    clients.matchAll().then(function(clients) {
                        if (clients.length > 0) {
                            clients.forEach(function(client){
                                client.postMessage(JSON.stringify(newTreasures));
                            })
                        } else {
                            self.registration.showNotification("Your dwarfs gathered new treasures", {
                                body: message
                            });
                        }
                    });
                }
            });
        }
    )
};
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
};
setInterval(checkNotifications, 10000);