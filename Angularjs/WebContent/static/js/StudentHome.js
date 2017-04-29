
var app = angular.module("studenthome_app", []);
app.controller("studenthomeController", function($scope, $http) {
    url = "http://localhost:8080/ShowALLcoureses";
	var config = {
		headers : {
			'Content-Type' : 'application/json;charset=utf-8;'
		}
	}
	
        $http.get(url, config).then(function(response) {
        	$scope.courses = response.data;	
        
        }
        , function(response) {
        	
			$scope.postResultMessage = "Fail!";
		});
    
});