var app = angular.module("SignupS_app", []);
app.controller("StudentController", function($scope, $http) {
	
    $scope.signup = function(){
    	
    url = "http://localhost:8080/SignupAsStudent";
	var config = {
		headers : {
			'Content-Type' : 'application/json;charset=utf-8;'
		}
	}
	
    var data={
   "name" : $scope.username,
	"password" : $scope.password,
	"country" : $scope.country,
	"college" :$scope.college,
	"type" : "Student",
	"email" : $scope.email,
	"age" : $scope.age
    };
        $http.post(url, data, config).then(function(response) {
        	
        	
            if(response.data == null){
                alert("Fail");
            }
            else{
            	window.location.href = "StudentHome.html";
            }
        }
        , function(response) {
        
			$scope.postResultMessage = "Fail!";
		});
    }
});