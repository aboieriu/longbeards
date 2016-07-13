/* globals require, module, __dirname */
var fs = require('fs');
var zlib = require('zlib');
var url = require( 'url' );
var mime = require('mime');
var rootPath = "./"

module.exports = {
    handleStaticRequest: function(request, response) {
        var path = url.parse( request.url ).pathname;
        var filepath = rootPath + path;

        fs.exists( filepath, function( exists ) {

            console.log( '------------------------------------------------------------------------------------------' );
            console.log( '      ['+request.method+']', request.url );

            if (!exists) {
                console.log( '      [404]'.red, filepath.red );
                response.writeHead( 404, {'Content-Type': 'text/plain' } );
                response.write( '404 Not Found\n' );
                response.write( request.url + ' could not be found\n' );
                response.end();
                return;
            }

            var stats = fs.statSync( filepath );

            if (stats.isDirectory()) {
                var dir = fs.readdirSync( filepath );
                if (dir) {
                    console.log( dir );
                } else {
                    console.log( '  - Directory empty' );
                }
                filepath += 'index.html';
                stats = fs.statSync( filepath );
            }


            var raw = fs.createReadStream(filepath);

            // support compression
            var acceptEncoding = request.headers['accept-encoding'] || '';

            var headers = { 'Content-Type': mime.lookup( filepath ) };
            if (acceptEncoding.match(/\bgzip\b/)) {
                headers['Content-Encoding'] = 'gzip';
                raw.pipe(zlib.createGzip()).pipe(response);
            } else {
                raw.pipe(response);
            }
            response.writeHead(200, headers);
        } );
    }
};
