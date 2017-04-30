var app = angular.module('User', []);
app.controller('UserController', function($scope, $http, $location) {
    $scope.signup= function(){
    url = "/SignupAsTeacher";
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
            if(response.data.equals("email is arleady exist")){
                alert("Fail")
            }
            else{
                alert("Sucess")
            }
        }
        , function(response) {
			$scope.postResultMessage = "Fail!";
		});
    }
});




<script>
function myFunction() {
    location.href = "http://www.cnn.com";
}
    function myFunction2() {
    window.location.assign("https://www.w3schools.com")
    }
</script>