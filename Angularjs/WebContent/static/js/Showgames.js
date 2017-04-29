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
var x =  urlParams.course[0];

var app = angular.module("showgame_app", []);
app.controller("showgameController", function($scope, $http) {
   url = "http://localhost:8080/ShowGamesInCourse"+"/"+x ;
   alert(x);
	var config = {
		headers : {
			'Content-Type' : 'application/json;charset=utf-8;'
		}
	}
	
        $http.get(url, config).then(function(response) {
        	
        	$scope.games = response.data;
        	
        	$scope.showgamesincourses = function(){
        		//rendring
        	}
  
        	$scope.creategames= function(){
        		//rendring
        	}
  
        }
        , function(response) {
        	
			$scope.postResultMessage = "Fail!";
		});
    
});