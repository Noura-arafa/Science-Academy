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
var x =  urlParams.gamename[0];
var y=urlParams.email[0];
var app = angular.module("GamePage_app", []);
app.controller("GamePageController", function($scope, $http) {
   
  
	var config = {
		headers : {
			'Content-Type' : 'application/json;charset=utf-8;'
		}
	}
	
	
        $http.get(url, config).then(function(response) {
            $scope.copy= function(){
        		
        		window.location.href = "CopyGame.html?email="+ y+"&gamename="+x;
        	}
            $scope.addcollaborators= function(){
            	//window.location.href ="AddCollaborators.html?gamename="+x;
            }
          $scope.Cancel = function(){
        	  
          }
  
        }
        , function(response) {
        	
			$scope.postResultMessage = "Fail!";
		});
    
});