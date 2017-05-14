var app = angular.module("Collaborators_app", []);
app.controller("CollaboratorsController", function($scope, $http) {
   url = "http://localhost:8080/AddGameCollaborator/{gamename}/{newemail}";
   $scope.AddCollaborator = function(){
	   url = "http://localhost:8080/AddGameCollaborator/"+$scope.gameName+"/"+$scope.Email;
	var config = {
		headers : {
			'Content-Type' : 'application/json;charset=utf-8;'
		}
	}
	
	$http.get(url, config).then(function(response) {
		
	}
   
   );
}
});