'use strict';
 
 angular.module('Patient')

.factory('ContactService',
    ['Base64','$http', '$cookieStore', '$rootScope', '$timeout',
    function (Base64, $http, $cookieStore, $rootScope, $timeout) {
    		var service = {};
        
        	service.AddPatient = function (patient, callback) {
//        		alert(patient.name);
//        		alert(JSON.stringify(patient));
//        		alert(JSON.stringify(person));
            $http.post('http://localhost:8080/MedicalFinalProject/rest/nurse/addPatient', patient)
                .success(function (data, status, headers, config) {
                    callback(data,headers);
                });

        };
        
    	service.SendToPatientEHR = function (patient, callback) {

        $http.post('http://localhost:8080/MedicalFinalProject/rest/nurse/sendToPatientEHR', patient)
            .success(function (data, status, headers, config) {
                callback(data,headers);
            });

    }
        
        	service.AllDoctors = function(callback){
        		 $http.get('http://localhost:8080/MedicalFinalProject/rest/nurse/alldoctors')
        		 .success(function (data, status, header, config){
        			 callback(data, header);
        		 });
        	};
        return service;
    }])

// Patient controller for search patient
.factory('PatientService',
	    ['Base64','$http', '$cookieStore', '$rootScope', '$timeout',
	    function (Base64, $http, $cookieStore, $rootScope, $timeout) {
	    		var service = {};
	    		
        service.SearchPatient = function(refNumber, callback){
//        	alert(refNumber);
        	$http.get('http://localhost:8080/MedicalFinalProject/rest/patient/searchPatient/' + refNumber)
            .success(function (data, status, headers, config) {
                callback(data,headers);
                
            });
        };
        return service;
    }])
 
 .factory('EncounterService',
		    ['Base64','$http', '$cookieStore', '$rootScope', '$timeout',
		    function (Base64, $http, $cookieStore, $rootScope, $timeout) {
		    		var service = {};
		    		
       service.AddEncounter = function(encounter, vitalSign, allergies, symptoms, medications, callback){
//    	   alert("encounter is " + JSON.stringify(encounter));
    	   var patient= {};
    	   patient.refNumber = $rootScope.refNumber1;
    	   encounter.vitalSign = vitalSign;
    	   encounter.allergy = allergies;
    	   encounter.symptom = symptoms;
    	   encounter.medication = medications;
    	   patient.encounterList = [encounter];
//    	   alert("patient is " + JSON.stringify(patient));
        	$http.post('http://localhost:8080/MedicalFinalProject/rest/nurse/addEncounterDetails', patient)
            .success(function (data, status, headers, config) {
                callback(data,headers);
            });
        };
        return service;
		    }]);
