
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

var app = angular.module("CreateCourse_app", []);
app.controller("CreateCourseController", function($scope, $http) {
	
    $scope.createcourse = function(){
    url = "http://localhost:8080/CreateCourse";
	var config = {
		headers : {
			'Content-Type' : 'application/json;charset=utf-8;'
		}
	}
	
    var data={
   "courseName":$scope.courseName,
   "CourseOwner":$scope.CourseOwner
    };
        $http.post(url, data, config).then(function(response) {
        	if(response.data==null){
        		alert("already created")
        	}
        	else{
        		window.location.href ="Showgames.html?course="+courseName+"&email="+x;
        	}
        }
        , function(response) {
			$scope.postResultMessage = "Fail!";
		});
    }
});