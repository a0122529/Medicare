'use strict';

var app = angular.module('Doctor');

app.controller('DoctorController', [ '$scope', '$rootScope',
		function($scope, $rootScope) {
			$scope.name = $rootScope.name;
			$scope.patientList = $rootScope.patientList;
			$scope.personId = $rootScope.personId;
		} ]);

app.controller('PatientDetailsController', [
		'$scope',
		'$rootScope',
		'$routeParams',
		'PateintDetailsService',
		'EncounterDetailsService',
		function($scope, $rootScope, $routeParams, PateintDetailsService,
				EncounterDetailsService) {

			$scope.details = function() {
				$scope.refNumber = $routeParams.refNumber;
				$rootScope.refNumber = $routeParams.refNumber;
				PateintDetailsService.Details($scope.refNumber, function(data) {
					$scope.encounterList = data;
				});
			}
			$scope.go = function(encounters) {
				var vitalSign = {};
				$rootScope.encounter = encounters;
				$rootScope.vitalSign = encounters.vitalSign;
				$rootScope.allergies = encounters.allergy.name.split(",");
				$rootScope.symptoms = encounters.symptom.name.split(",");
				$rootScope.medications = encounters.medication.name.split(",");
			}

			$scope.emailSummary = function(encounter) {
				$scope.dataLoading = true;
				EncounterDetailsService.EmailSummary(encounter, function(data,
						header) {

				})
			}

			$scope.updateEnc = function() {
				var diagnosis = $scope.diagnosis;
				// alert(diagnosis);
				$scope.dataLoading = true;
				EncounterDetailsService.UPDATEENCOUNTER(diagnosis, function(
						data, header) {

				})
			}
		} ])

app.controller('DoctorLabController', [
		'$scope',
		'$rootScope',
		'$routeParams',
		'DoctorLabService',
		'PatientPrescription',
		function($scope, $rootScope, $routeParams, DoctorLabService,
				PatientPrescription) {

			$scope.patientWorkReq = function() {
				$scope.dataLoading = true;
				DoctorLabService.PatientWorkReq($rootScope.encounter, function(
						data, header) {
					$scope.workRequestList = data;
				})
			};

			$scope.createTestReq = function() {
				var docName = $rootScope.name;
				var workRequest = $scope.workRequest;
				workRequest.attDoctor = docName;
				workRequest.patientRefNum = $rootScope.refNumber;
				workRequest.status = "Open";
				workRequest.encounter = $rootScope.encounter;
				$scope.dataLoading = true;
				DoctorLabService.CreateTestReq(workRequest, function(data,
						header) {
					$scope.workRequestList = data;
				})
			};
		} ]);

app.controller('PrescriptionController', [ '$scope', '$rootScope', '$filter',
		'PatientPrescription',
		function($scope, $rootScope, $filter, PatientPrescription) {
			$scope.allDrugs = function() {
				$scope.dataLoading = true;
				PatientPrescription.AllDrugs(function(data) {
					$rootScope.drugList = data;
				});
			};

			$scope.addDrug = function(encounter) {
				$scope.dataLoading = true;
				PatientPrescription.AddDrug(encounter, function(data) {
					$scope.errorDrugs = data
				});

				PatientPrescription.UpdateReq(encounter, function(data) {
					$scope.encounter = data
				})

			}

		} ])
app.controller('SpecificPatientController', [
		'$scope',
		'$rootScope', 'SpecificService',
		function($scope, $rootScope, $SpecificService) {
//
//			$scope.addEncounter = function() {
//				alert(JSON.stringify($scope.date));
//				$scope.dataLoading = true;
//				EncounterService.AddEncounter($scope.encounter,
//						$scope.vitalSign, $scope.allergies, $scope.symptoms,
//						$scope.medications, $scope.date,
//						function(data, header) {
//
//						})
//			}
		} ]);