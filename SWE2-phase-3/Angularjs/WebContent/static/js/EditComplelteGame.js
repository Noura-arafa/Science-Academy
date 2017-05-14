function parseURLParams(url) {
    var queryStart = url.indexOf("?") + 1,
        queryEnd   = url.indexOf("#") + 1 || url.length + 1,
        query = url.slice(queryStart, queryEnd - 1),
        pairs = query.replace(/\+/g, " ").split("&"),
        parms = {}, i, n, v, nv;

    if (query === url || query === "") return;

    for (i = 0; i < pairs.length; i++) {
        nv = pairs[i].split("=", 2);
        n = decodeURIComponent(nv[0]);
        v = decodeURIComponent(nv[1]);

        if (!parms.hasOwnProperty(n)) parms[n] = [];
        parms[n].push(nv.length === 2 ? v : null);
    }
    return parms;
}
var urlString = window.location.href;
urlParams = parseURLParams(urlString);
var x =  urlParams.teacherID[0];
var y =  urlParams.gamename[0];

var app = angular.module("EditComplete_app", []);
app.controller("EditCompleteController", function($scope, $http) {
   url = "http://localhost:8080/editcompletegame"+"/"+x ;
	 $scope.Done = function(){
		 var config = {
					headers : {
						'Content-Type' : 'application/json;charset=utf-8;'
					}
				}
		
	}
	
        
});