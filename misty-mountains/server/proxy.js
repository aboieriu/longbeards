/* global require, module */
var urlCheck = require('./url-check');
var http = require('http');

var configParams =  {
    backendHost: 'localhost'
    , backendPathPrefix: ''
    , backendPort: '9090'
};

module.exports = {
    handleProxyCall: function(request, response) {
        if (urlCheck.shouldProxyCall(request.url)) {
            var originalRequest = request.url;
            var proxiedRequest = configParams.backendHost + ':' + configParams.backendPort + configParams.backendPathPrefix + request.url;

            console.log( '----------------------------------------------------------------------------------------------------' );
            console.log( '      ['+request.method+']', originalRequest );
            console.log( ' [REDIRECT]', 'http://' + proxiedRequest);

            var proxyRequest = http.request({
                host: configParams.backendHost,
                port: configParams.backendPort,
                method: request.method,
                path: configParams.backendPathPrefix + request.url.replace('/api/', '/'),
                headers: request.headers
            });

            proxyRequest.on('error', function(e) {
                var _error = e;
                setTimeout(function() {
                    console.log( '----------------------------------------------------------------------------------------------------' );
                    console.log( '   !! [' + proxyRequest.method.red + ']', 'http://' + proxiedRequest );
                    console.log( '    [ERROR]', _error.message);
                }, 0);
            });

            proxyRequest.addListener( 'response', function( proxyResponse ) {
                proxyResponse.addListener( 'data', function( chunk ) {
                    response.write( chunk, 'binary' );
                } );
                proxyResponse.addListener( 'end', function() {
                    response.end();
                } );
                response.writeHead( proxyResponse.statusCode, proxyResponse.headers );
            } );

            request.addListener( 'data', function( chunk ) {
                proxyRequest.write( chunk, 'binary' );
            } );

            request.addListener( 'end', function() {
                proxyRequest.end();
            } );

            request.addListener( 'error', function(arg0, arg1, arg2) {
                console.error("[ERROR]", arg0, arg1, arg2);
            } );
            return true;
        }
        return false;
    }
}
