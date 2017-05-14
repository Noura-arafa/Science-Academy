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
var y=urlParams.email[0];
var app = angular.module("showgame_app", []);
app.controller("showgameController", function($scope, $http) {
   url = "http://localhost:8080/ShowGamesInCourse"+"/"+x ;
  
	var config = {
		headers : {
			'Content-Type' : 'application/json;charset=utf-8;'
		}
	}
	
	
        $http.get(url, config).then(function(response) {
        	
        	$scope.games = response.data;
        	$scope.playgame= function(gameName){
        		url="http://localhost:8080/gametype"+"/"+gameName;
        		$http.get(url,config).then(function(response){
        			$scope.type=response.data;
            		if($scope.type==true){
            			window.location.href = "PlayMatchingGame.html?gamename="+gameName+"&email="+ y;
            		}
            		else{
            			window.location.href = "PlayCompleteGame.html?gamename="+gameName+"&email="+ y;
            		}
        		});
        		
        	
        	}
  
        	$scope.creategames= function(){
        		
        		window.location.href = "CreateGame.html?course="+x+"&email="+ y;
        	}
            $scope.copy= function(gameName){
        		
        		window.location.href = "CopyGame.html?email="+ y+"&gamename="+gameName;
        	}
            $scope.addcollaborators= function(){
            	window.location.href ="AddCollaborators.html";
            }
            $scope.Settings = function(){
            	window.location.href ="GamePage.html?email="+ y+"&gamename="+gameName;
            }

  
        }
        , function(response) {
        	
			$scope.postResultMessage = "Fail!";
		});
    
});