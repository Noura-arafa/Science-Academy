alert("hello");
var app = angular.module('Signup_app', []);
app.controller("UserController", function($scope, $http) {
	//alert("in the scope");
    $scope.signup = function(){
    	alert("in scope");
    url = "http://localhost:8080/SignupAsTeacher";
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
	"type" : "Teacher",
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
            	window.location.href = "TeacherHome.html";
            }
        }
        , function(response) {
        	alert(response.data);
			$scope.postResultMessage = "Fail!";
		});
    }
});