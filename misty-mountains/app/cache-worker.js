var CACHE_STRATEGY = "fallback";
var WORKER_NAME = "cache-worker";

this.addEventListener('fetch', function(event) {
    event.respondWith(cache.handleRequest(event.request));
});

this.addEventListener('install', function(){
    console.log(WORKER_NAME + ' installed');
});

this.addEventListener('activate', function(){
    console.log(WORKER_NAME + ' activated');
    console.log('['+cache.name+'] started');
});

var cache = {
    name: 'static-cache'
    , strategy: {
        'fallback': {
            handleRequest: function(request) {
                var fetchRequest = request.clone();
                if (request.method === 'GET') {
                    return cache.handleRequestFromNetwork(fetchRequest).catch(function(){
                        console.log('%c Request handled from network [KO] ['+request.url+'] ', 'background: #eb5858; color: #FFFFFF');
                        return cache.handleRequestFromCache(request);
                    });
                } else {
                    return cache.handleRequestFromNetwork(fetchRequest).catch(function(error){
                        console.log('%c Request handled from network [KO][RETRY] ['+request.url+'] ', 'background: #eb5858; color: #FFFFFF');
                        cache.pendingRequests.addRequestToPending(request);
                        throw error;
                    });
                }
            }
        }
    }
    , pendingRequests: {
        queue : []

        , processing: false

        , addRequestToPending: function(request) {
            cache.pendingRequests.queue.push(request);
        }

        , handlePendingRequests: function(){
            if (!cache.pendingRequests.processing && cache.pendingRequests.queue.length > 0) {
                var request = cache.pendingRequests.queue[0];
                cache.handleRequestFromNetwork(request).then(function(){
                    cache.pendingRequests.processing = false;
                    cache.pendingRequests.dropSuccessfulRequest();
                    cache.pendingRequests.handlePendingRequests();
                }).catch(function() {
                    cache.pendingRequests.processing = false;
                });
            }
        }
        , dropSuccessfulRequest: function() {
            var remainingRequests = [];
            for (var key in cache.pendingRequests.queue) {
                if (key != 0) {
                    remainingRequests.push(cache.pendingRequests.queue[key]);
                }
            }
            cache.pendingRequests.queue = remainingRequests;
        }
    }

    , cacheResponse: function(request, response) {
        // Only cache GET requests with valid responses
        if(!response || response.status !== 200 || response.type !== 'basic' || request.method !== 'GET') {
            return response;
        }
        var responseToCache = response.clone();

        caches.open(cache.name).then(function(cache) {
            cache.put(request, responseToCache);
        });
        return response;
    }

    , handleRequest: function(request) {
        return cache.strategy[CACHE_STRATEGY].handleRequest(request);
    }

    , handleRequestFromNetwork: function(request){
        // IMPORTANT: Clone the request. A request is a stream and
        // can only be consumed once. Since we are consuming this
        // once by cache and once by the browser for fetch, we need
        // to clone the response
        var fetchRequest = request.clone();
        return fetch(fetchRequest).then(function(response) {
            console.log('%c Request handled from network [OK] ['+fetchRequest.url+'] ', 'background: #63c956; color: #FFFFFF');
            // Check if we received a valid response
            cache.cacheResponse(request, response);
            return response;
        });
    }

    , handleRequestFromCache: function(request){
        // IMPORTANT: Clone the request. A request is a stream and
        // can only be consumed once. Since we are consuming this
        // once by cache and once by the browser for fetch, we need
        // to clone the response
        var fetchRequest = request.clone();
        return caches.match(fetchRequest).then(function(response) {
            if (response) {
                console.log('%c Request handled from cache [OK] ['+fetchRequest.url+'] ', 'background: #63c956; color: #FFFFFF');
            } else {
                console.log('%c Request handled from cache [KO] ['+fetchRequest.url+'] ', 'background: #eb5858; color: #FFFFFF');
            }
            return response;
        });
    }
};


setInterval(cache.pendingRequests.handlePendingRequests, 10000);