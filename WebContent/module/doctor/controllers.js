'use strict';

var app = angular.module('Doctor');

app.controller('DoctorController', [ '$scope', '$rootScope',
		function($scope, $rootScope) {
			$scope.name = $rootScope.name;
			$scope.patientList = $rootScope.patientList;
			$scope.personId = $rootScope.personId;
		} ]);

app.controller('PatientDetailsController', [ '$scope', '$rootScope',
		'$routeParams', 'PateintDetailsService',
		function($scope, $rootScope, $routeParams, PateintDetailsService) {

			$scope.refNumber = $routeParams.refNumber;
			$rootScope.refNumber = $routeParams.refNumber;
			PateintDetailsService.Details($scope.refNumber, function(data) {
				$scope.encounterList = data;
			});
		} ])

app.controller('EncounterDetailController', [
		'$scope',
		'$rootScope',
		'EncounterDetailsService',
		function($scope, $rootScope, EncounterDetailsService) {
			$scope.go = function(encounters) {
				var vitalSign = {};
				$rootScope.encounter = encounters;
				$rootScope.vitalSign = encounters.vitalSign;
				$rootScope.allergies = encounters.allergy.name.split(",");
				$rootScope.symptoms = encounters.symptom.name.split(",");
				$rootScope.medications = encounters.medication.name.split(",");
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

// app.controller('DoctorLabController', [
// '$scope',
// '$rootScope',
// '$routeParams',
// 'DoctorLabService',
// function($scope, $rootScope, $routeParams, DoctorLabService) {
// $scope.createTestReq = function() {
// var encounter = $routeParams.encounter;
// // alert($scope.diagnosis);
// // alert(JSON.stringify($rootScope.encounter));
//
// var docName = $rootScope.name;
// var workRequest = $scope.workRequest;
// workRequest.attDoctor = docName;
// workRequest.patientRefNum = $rootScope.refNumber;
// workRequest.status = "open";
// // workRequest.encounter =encounter;
//
// $scope.dataLoading = true;
// DoctorLabService.CreateTestReq(workRequest, function(data,
// header) {
// $scope.workRequestList = data;
//				
// })
// }
//
// DoctorLabService.PatientWorkReq("PA-1", function(
// data, header) {
// $scope.workRequestList = data;
// // alert(JSON.stringify($scope.workRequestList));
// })
// } ]);

app.controller('DoctorLabController', [
		'$scope',
		'$rootScope',
		'$routeParams',
		'DoctorLabService',
		'PatientPrescription',
		function($scope, $rootScope, $routeParams, DoctorLabService,
				PatientPrescription) {
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
			// $scope.tags = [
			// { text: 'Tag1' },
			// { text: 'Tag2' },
			// { text: 'Tag3' }
			// ];

			$scope.addDrug = function(drugName) {
				// filtering out the object by drugName
				var drug = $filter("filter")($rootScope.drugList, {name:$scope.drugName});
//				$scope.wr.employee = newTemp[0];
				$scope.dataLoading = true;
				PatientPrescription.AddDrugs(drug[0], function(data) {
					$scope.drugList = data;
				});
			}

		} ]);