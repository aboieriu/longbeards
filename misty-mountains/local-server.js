var http = require( 'http' );
var staticController = require('./server/static');
var proxyController = require('./server/proxy');

http.createServer(function( request, response ) {
    if (proxyController.handleProxyCall(request, response)) {
        return;
    } else {
        staticController.handleStaticRequest(request, response);
    }
} ).listen( 9091 );