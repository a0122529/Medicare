'use strict';

var app = angular.module('Doctor');

app.controller('DoctorController', [ '$scope', '$rootScope',
		function($scope, $rootScope) {
			$scope.name = $rootScope.name;
			$scope.patientList = $rootScope.patientList;
			$scope.personId = $rootScope.personId;
		} ]);

//app.controller('DoctorPatientsController', [ '$scope', '$routeParams',
//                                     		'DoctorPatientsService',
//                                     		function($scope, $routeParams, PateintLoadService) {
//
//                                     			$scope.doctorId = $rootScope.employeeId;
//
//                                     			PateintLoadService.LoadPatients($scope.doctorId, function(data) {
//                                     				$scope.patientList = data;
//                                     			})
//                                     			
//                                     		}]);


app.controller('PatientDetailsController', [ '$scope', '$routeParams',
		'PateintDetailsService',
		function($scope, $routeParams, PateintDetailsService) {

			$scope.refNumber = $routeParams.refNumber;

			PateintDetailsService.Details($scope.refNumber, function(data) {
				$scope.patient = data;
			})
		}]);