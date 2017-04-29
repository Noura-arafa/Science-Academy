var app = angular.module("SignupS_app", []);
app.controller("StudentController", function($scope, $http) {
	alert("in the scope");
    $scope.signup = function(){
    	alert("in scope");
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
        	alert("blalaa");
        	alert(response.data.email);
            if(response.data == null){
                alert("Fail");
            }
            else{
            	window.location.href = "StudentHome.html";
            }
        }
        , function(response) {
        	alert(response.data);
			$scope.postResultMessage = "Fail!";
		});
    }
});