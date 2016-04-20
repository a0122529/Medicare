'use strict';

var app = angular.module('Patient')

app.controller('NurseController', [
		'$scope',
		'$rootScope',
		'ContactService',
		function($scope, $rootScope, ContactService) {
			// var service = {};

			$scope.addPatient = function() {
				$scope.dataLoading = true;
				ContactService.AddPatient($scope.patient,
						function(data, header) {

						});
			};
		} ])

app.controller('PatientController', [
		'$scope',
		'$rootScope',
		'PatientService',
		function($scope, $rootScope, PatientService) {
			// var service = {};

			$scope.searchPatient = function() {
				$scope.dataLoading = true;
				PatientService.SearchPatient($scope.refNumber, function(data,
						header) {
					$scope.patient = data;
					$rootScope.refNumber1 = data.refNumber;
				});
			};
		} ])

app.controller('EncounterController', [
		'$scope',
		'$rootScope',
		'EncounterService',
		function($scope, $rootScope, EncounterService) {
			

			$scope.addEncounter = function() {
				$scope.dataLoading = true;
				EncounterService.AddEncounter($scope.encounter,
						$scope.vitalSign, $scope.allergies, $scope.symptoms,
						$scope.medications, function(data, header) {

						})
			}
		} ]);
