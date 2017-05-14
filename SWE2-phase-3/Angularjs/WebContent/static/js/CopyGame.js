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
var  y =urlParams.email[0];
var z = urlParams.gamename[0];
var app = angular.module("Copygame_app", []);
app.controller("CopyController", function($scope, $http) {
	$scope.CopyGame = function(){
		url = "http://localhost:8080/CopyGame/"+y+"/"+z+"/"+$scope.Newgamename+"/"+$scope.CourseName;
	 var config = {
				headers : {
					'Content-Type' : 'application/json;charset=utf-8;'
				}
			}
	 $http.get(url, config).then(function(response) {
		 
		 if(response.data == true)
			 {
			 window.location.href = "Showgames.html?course="+$scope.CourseName+"&email="+y;
			 
			 }
	 }
	 , function(response) {
	        
			$scope.postResultMessage = "Fail!";
		});
	}
});