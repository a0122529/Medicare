'use strict';
 
angular.module('Authentication')
 
.controller('LoginController',
    ['$scope', '$rootScope', '$location', 'AuthenticationService',
    function ($scope, $rootScope, $location, AuthenticationService) {
        // reset login status
        AuthenticationService.ClearCredentials();
 
        $scope.login = function () {
            $scope.dataLoading = true;
            AuthenticationService.Login($scope.username, $scope.password, function(data,headers) {
            var	Nurseemployee;
                if(data.personId > 0) {
                	 $rootScope.Nurseemployee = data.name;
                    AuthenticationService.SetCredentials($scope.username, $scope.password,headers);
                    $location.path('/' +  headers('AUTH_KEY'));
                    $rootScope.name = data.name;
                    $rootScope.patientList = data.patientList;
                    $rootScope.employeeId = data.personId;
                    $rootScope.emp = data;
                } else {
                    $scope.error = response.message;
                    $scope.dataLoading = false;
                }
            });
        };
    }])
    
.controller('LogoutController',
		['$scope', '$rootScope', '$location', 'AuthenticationService',
        function ($scope, $rootScope, $location, AuthenticationService) {
	    AuthenticationService.ClearCredentials();
	 
}]);    