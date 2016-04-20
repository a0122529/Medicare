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
									alert(JSON.stringify(data));
								});

					};
					return service;
				} ]);

//.factory(
//		'PateintLoadService',
//		[
//				'Base64',
//				'$http',
//				'$cookieStore',
//				'$rootScope',
//				'$timeout',
//				function(Base64, $http, $cookieStore, $rootScope, $timeout) {
//					var service = {};
//
//					service.LoadPatients = function(doctorId, callback) {
//
//						$http.get(
//								'http://localhost:8080/MedicalFinalProject/rest/doctor/'
//										+ doctorId).success(
//								function(data, status) {
//									callback(data);
//								});
//
//					};
//					return service;
//				} ]);
