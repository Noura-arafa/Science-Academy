
var app = angular.module("teacherhome_app", []);
app.controller("teacherhomeController", function($scope, $http) {
    url = "http://localhost:8080/ShowALLcoureses";
	var config = {
		headers : {
			'Content-Type' : 'application/json;charset=utf-8;'
		}
	}
	
        $http.get(url, config).then(function(response) {
        	
        	$scope.courses = response.data;
        	$scope.showgamesincourses = function(courseName){
        		window.location.href = "Showgames.html?course="+courseName;
        	}
  
        	$scope.createcourses= function(){
        		//rendring
        	}
  
        }
        , function(response) {
        	
			$scope.postResultMessage = "Fail!";
		});
    
});