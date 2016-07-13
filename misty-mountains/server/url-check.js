/* globals module */
module.exports = {

    shouldProxyCall: function(requestURL) {
        return this.isApiCall(requestURL);
    }

    , isApiCall: function (requestURL) {
        return (/^\/api\/.*/).test(requestURL);
    }
};
