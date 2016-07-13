var SERVICE_WORKER_NAME = "API cache worker";
var CACHE_NAME = "api-cache";

this.addEventListener('install', function(){
    console.log(SERVICE_WORKER_NAME + ' insalled!');
});

this.addEventListener('activate', function(){
    console.log(SERVICE_WORKER_NAME + ' activated!');
});