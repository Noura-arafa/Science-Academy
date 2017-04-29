
var app = angular.module("CreateCourse_app", []);
app.controller("CreateCourseController", function($scope, $http) {
	//alert("in the scope");
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
        		//render l showgames in coursecoursepage
        	}
        }
        , function(response) {
        	alert(response.data);
			$scope.postResultMessage = "Fail!";
		});
    }
});