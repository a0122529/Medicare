'use strict';

angular.module('Doctor')

.factory(
		'PateintDetailsService',
		[
				'Base64',
				'$http',
				'$cookieStore',
				'$rootScope',
				'$timeout',
				function(Base64, $http, $cookieStore, $rootScope, $timeout) {
					var service = {};

					service.Details = function(refNumber, callback) {

						$http.get(
								'http://localhost:8080/MedicalFinalProject/rest/doctor/searchPatient/'
										+ refNumber).success(
								function(data, status) {
									callback(data);

								});

					};
					return service;
				} ])

.factory(
		'EncounterDetailsService',
		[
				'Base64',
				'$http',
				'$cookieStore',
				'$rootScope',
				'$timeout',
				function(Base64, $http, $cookieStore, $rootScope, $timeout) {
					var service = {};
					service.UPDATEENCOUNTER = function(diagnosis, callback) {
						var encounter = $rootScope.encounter;
						encounter.diagnosis = diagnosis;
//						alert(JSON.stringify(encounter));
						$http.put(
								'http://localhost:8080/MedicalFinalProject/rest/doctor/updateDiagnosis'
										,encounter).success(
								function(data, status) {
									callback(data);

								});

					}
					return service;
				} ])

 .factory(
 'DoctorLabService',
 [ 'Base64', '$http', '$cookieStore', '$rootScope', '$timeout',
 function(Base64, $http, $cookieStore, $rootScope, $timeout) {
	 var service = {};
	 service.CreateTestReq = function(workRequest, callback) {
//		 alert(JSON.stringify(workRequest));
		 $http.post(
					'http://localhost:8080/MedicalFinalProject/rest/doctor/createLabRequest'
							,workRequest).success(
					function(data, status) {
						callback(data);
					});
	 		}
	 
	 service.PatientWorkReq =  function(refNumber, callback) {
//		 alert(refNumber);
		 $http.get(
					'http://localhost:8080/MedicalFinalProject/rest/doctor/patientLabRequests'
							,refNumber).success(
					function(data, status) {
						callback(data);
					});
	 		}
	 	return service;
 	} ])
 	
.factory(
		 'PatientPrescription',
		 [ 'Base64', '$http', '$cookieStore', '$rootScope', '$timeout',
		 function(Base64, $http, $cookieStore, $rootScope, $timeout) {
			 var service = {};
			 service.AllDrugs = function(callback) {
				 $http.get(
							'http://localhost:8080/MedicalFinalProject/rest/doctor/allDrugs').success(
							function(data, status) {
								callback(data);
							});
			 		}
			 service.AddDrug =  function(drug,  callback) {
				 alert(JSON.stringify)
				 $http.get(
							'http://localhost:8080/MedicalFinalProject/rest/doctor/patientLabRequests'
									,drug).success(
							function(data, status) {
								callback(data);
							});
			 		}
			 	return service;
		 	} ]);