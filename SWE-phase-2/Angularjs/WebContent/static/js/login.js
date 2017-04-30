
var app = angular.module("Login_app", []);
app.controller("LoginController", function($scope, $http) {
	
    $scope.loginT= function(){
    	
    url = "http://localhost:8080/Login";
	var config = {
		headers : {
			'Content-Type' : 'application/json;charset=utf-8;'
		}
	}
	
    var data={
	"email" : $scope.email,
	"password" : $scope.password
	
    };
        $http.post(url, data, config).then(function(response) {
        	
        	if(response.data == false){
               alert("error email or password")
            }
            else if(response.data == true){
              
            	window.location.href = "TeacherHome.html?email="+ $scope.email;
          	  
            }
           
        }
        , function(response) {
        
			$scope.postResultMessage = "Fail!";
		});
    }
        	
        $scope.loginS= function(){
        	
        url = "http://localhost:8080/Login";
    	var config = {
    		headers : {
    			'Content-Type' : 'application/json;charset=utf-8;'
    		}
    	}
    	
        var data={
    	"email" : $scope.email,
    	"password" : $scope.password
    	
        };
            $http.post(url, data, config).then(function(response) {
            	
            	if(response.data == false){
                    alert("error email or password")
                }
                else if(response.data == true){
                   
                	window.location.href = "StudentHome.html?email="+ $scope.email;
              	  
                }
               
            }
            , function(response) {
            	
    			$scope.postResultMessage = "Fail!";
    		});
        }
    
});