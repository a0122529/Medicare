'use strict';

var app = angular.module('Patient')

app.controller('NurseController', [
		'$scope',
		'$rootScope',
		'ContactService',
		'PatientService',
		function($scope, $rootScope, ContactService, PatientService) {

			$scope.sendToPatientEHR = function(refNumber) {
				var patient = {};
				patient.refNumber = refNumber;
				$scope.dataLoading = true;
				ContactService.SendToPatientEHR(patient,
						function(data, header) {

						});
			};

			$scope.addPatient = function() {

				$scope.dataLoading = true;
				ContactService.AddPatient($scope.patient,
						function(data, header) {

						});
			};

			$scope.sendPhyRecord = function(refNumber, emailId) {
				$scope.emaiId = emailId;
				$scope.dataLoading = true;
				PatientService.SearchPatient(refNumber, function(data, header) {
					$rootScope.foundPatient = data;
					$rootScope.foundPatient.phyEmail = emailId;
					ContactService.SendPhyRecord($rootScope.foundPatient,
							function(data, header) {

							});
				});
			};

			$scope.allDoctors = function() {
				// alert("reached here");
				$scope.dataLoading = true;
				ContactService.AllDoctors(function(data, header) {
					$scope.doctorList = data;
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
				alert(JSON.stringify($scope.date));
				$scope.dataLoading = true;
				EncounterService.AddEncounter($scope.encounter,
						$scope.vitalSign, $scope.allergies, $scope.symptoms,
						$scope.medications, $scope.date,
						function(data, header) {

						})
			}
		} ]);
