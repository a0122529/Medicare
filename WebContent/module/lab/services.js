'use strict';

angular.module('Lab')

.factory(
 'LabService',
 [ 'Base64', '$http', '$cookieStore', '$rootScope', '$timeout',
 function(Base64, $http, $cookieStore, $rootScope, $timeout) {
	 var service = {};
	 
	 service.LabAssistantReq =  function(callback) {
		 $http.get(
					'http://localhost:8080/MedicalFinalProject/rest/lab/labAssistantRequest').success(
					function(data, status) {
						callback(data);
					});
	 		};
	 service.AllLabAssistant = function(callback){
       		 $http.get('http://localhost:8080/MedicalFinalProject/rest/lab/allLabEmployees')
       		 .success(function (data, status, header, config){
       			 callback(data, header);
       		 });
       	};
     service.UpdateWorkReq = function(workReq, callback){
      		 $http.put('http://localhost:8080/MedicalFinalProject/rest/lab/updateWorkReq',workReq)
      		 .success(function (data, status, header, config){
      			 callback(data, header);
      		 });
      	};
      	
       	
	 	return service;
 	} ]);