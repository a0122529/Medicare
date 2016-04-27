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
//									alert(JSON.stringify(data));
									callback(data);
								});
					}
					service.AllDiagnosis = function(callback) {
						$http.get(
								'http://localhost:8080/MedicalFinalProject/rest/doctor/allDiagnosis').success(
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
					service.UPDATEENCOUNTER = function(encounter, callback) {
						var encounter = $rootScope.encounter;			
//						encounter.diagnosis = diagnosis;
						$http.put(
								'http://localhost:8080/MedicalFinalProject/rest/doctor/updateDiagnosis'
										,encounter).success(
								function(data, status) {
									callback(data);

								});

					}
					
					service.EmailSummary = function(encounter, callback) {
						$http.post(
								'http://localhost:8080/MedicalFinalProject/rest/doctor/emailSummary'
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
	 
	 service.PatientWorkReq =  function(encounter, callback) {
		 $http.post(
					'http://localhost:8080/MedicalFinalProject/rest/doctor/patientLabRequests'
							,encounter).success(
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
			 
			 service.AddDrug =  function(encounter,  callback) {
				 $http.post(
							'http://localhost:8080/MedicalFinalProject/rest/doctor/drug-AllergyCheck'
									,encounter).success(
							function(data, status) {
								callback(data);
							});
			 		}
			 
			 service. UpdateReq =  function(encounter,  callback) {
				 $http.post(
							'http://localhost:8080/MedicalFinalProject/rest/doctor/updateReq'
									,encounter).success(
							function(data, status) {
								callback(data);
							});
			 		}
			
			 	return service;
		 	} ])
		 	
.factory('SpecificService',
	    ['Base64','$http', '$cookieStore', '$rootScope', '$timeout',
	    function (Base64, $http, $cookieStore, $rootScope, $timeout) {
	    		var service = {};
	    		
        service.SpecificPatients = function(diagnosis, callback){
        	$http.post('http://localhost:8080/MedicalFinalProject/rest/doctor/specificPatients', diagnosis)
            .success(function (data, status, headers, config) {
                callback(data,headers);
            });
        };
        return service;
    }]);