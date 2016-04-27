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
		'SpecificService',
		function($scope, $rootScope, $routeParams, PateintDetailsService,
				EncounterDetailsService, SpecificService) {

			$scope.allDiagnosis = function() {

				PateintDetailsService.AllDiagnosis(function(data) {
					$scope.diagnosisList = data;
				});
			}

			$scope.specificPatients = function(diagnosisName) {
				$scope.dataLoading = true;
				var diagnosis = {};
				diagnosis.diagnosisName = diagnosisName;
				SpecificService.SpecificPatients(diagnosis, function(data,
						header) {
					
					$scope.encounterList = data;
				})
			}

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

			$scope.updateEnc = function(encounter) {

				// var diagnosis = $scope.diagnosis;
				$scope.dataLoading = true;
				EncounterDetailsService.UPDATEENCOUNTER(encounter, function(
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
app.controller('SpecificPatientController', [ '$scope', '$rootScope',
		'SpecificService', function($scope, $rootScope, SpecificService) {
			// $scope.specificPatients = function(diagnosis) {
			// $scope.dataLoading = true;
			// SpecificService.SpecificPatients(diagnosis, function(data,
			// header) {
			// $scope.PatientList = data;
			// })
			// }
		} ]);