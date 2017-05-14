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
var x =  urlParams.teacherName[0];
var app = angular.module("showgamesforteacher_app", []);
app.controller("showgamesforteacher", function($scope, $http) {
   url = "http://localhost:8080/ShowGamesForTeacher"+"/"+x ;
   
	var config = {
		headers : {
			'Content-Type' : 'application/json;charset=utf-8;'
		}
	}
	
        $http.get(url, config).then(function(response) {
        	
        	$scope.games = response.data;
        	
        	
        	
        
  
  
  
        }
        , function(response) {
        	
			$scope.postResultMessage = "Fail!";
		});
	$scope.cancel = function(gamename){
		url = "http://localhost:8080/Cancelgame/"+gamename+"/"+x ;
		 
		 $http.get(url).then(function(response) {
	     	
	     	$scope.games = response.data;
	     	
	     	
	     	
	     



	     }
	     , function(response) {
	     	
				$scope.postResultMessage = "Fail!";
			});
		
		
	}
	 
    
});