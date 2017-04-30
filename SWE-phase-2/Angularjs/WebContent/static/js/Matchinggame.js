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
var y =  urlParams.email[0];

var app = angular.module("Matchingame_app", []);
app.controller("MatchinggameController", function($scope, $http) {
	$scope.create= function(){
		
	
   url = "http://localhost:8080/creatematchinggame"+"/"+x+"/"+y ;
   
	var config = {
		headers : {
			'Content-Type' : 'application/json;charset=utf-8;'
		}
	}
	var col1 =[$scope.question1,$scope.question2,$scope.question3];
	var col2=[$scope.question11,$scope.question22,$scope.question33];
	var ans =[$scope.answer1,$scope.answer2,$scope.answer3];
	var data={
			"gameName" : $scope.gamename,
			"column1" :col1,
			"column2" :col2,
			"modelanswer":ans
	}

        $http.post(url, data,config).then(function() {
        	
        	window.location.href = "PlayMatchingGame.html?gamename="+$scope.gamename+"&email="+ y;
  
  
        }
        , function(response) {
        	
			$scope.postResultMessage = "Fail!";
		});
	}
});