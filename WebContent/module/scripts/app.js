'use strict';

// declare modules
angular.module('Authentication', []);
angular.module('Home', []);
angular.module('Contact', []);
angular.module('About', []);
angular.module('Patient', []);
angular.module('Doctor', []);
angular.module('Lab', []);

angular
		.module(
				'BasicHttpAuthExample',
				[ 'Authentication', 'Home', 'Contact', 'About', 'Patient',
						'Doctor', 'Lab', 'ngRoute', 'ngCookies' ])

		.config(
				[
						'$routeProvider',
						function($routeProvider) {

							$routeProvider
									.when(
											'/login',
											{
												templateUrl : 'module/login/views/login.jsp',
												controller : 'LoginController',
												hideMenus : false
											})
									// logout function
									.when(
											'/logout',
											{
												templateUrl : 'module/login/views/login.jsp',
												controller : 'LogoutController'
											})
									// route for the about page
									.when(
											'/doctor',
											{
												templateUrl : 'module/doctor/views/DoctorPanel.jsp',
												controller : 'DoctorController'
											})

									.when(
											'/specificPatients',
											{
												templateUrl : 'module/doctor/views/specificPatients.jsp',
												controller : 'SpecificPatientController'
											})

									.when(
											'/patientEncounterDetails/:refNumber',
											{
												templateUrl : 'module/doctor/views/patientEncounterDetails.jsp',
												controller : 'PatientDetailsController',
												refNumber : 'refNumber'
											})

									.when(
											'/labRequestsAndResults',
											{
												templateUrl : 'module/doctor/views/LabTests.jsp',
												controller : 'DoctorLabController',
											// encounter : 'encounter'
											})

									.when(
											'/prescription',
											{
												templateUrl : 'module/doctor/views/Prescription.jsp',
												controller : 'PrescriptionController',
											})

									// route for the contact page
									.when(
											'/nurse',
											{
												templateUrl : 'module/nurse/views/NurseHome.jsp',
												controller : 'NurseController'
											})

									.when(
											'/createEncounter',
											{
												templateUrl : 'module/nurse/views/createPatientEncounter.jsp',
												controller : 'EncounterController'
											})

									.when(
											'/lab',
											{
												templateUrl : 'module/lab/views/LabHome.jsp',
												controller : 'LabController'
											})

									.otherwise({
										redirectTo : '/login'
									});
						} ])

		.run(
				[
						'$rootScope',
						'$location',
						'$cookieStore',
						'$http',
						function($rootScope, $location, $cookieStore, $http) {
							// keep user logged in after page refresh
							$rootScope.globals = $cookieStore.get('globals')
									|| {};
							if ($rootScope.globals.currentUser) {
								$http.defaults.headers.common['Authorization'] = 'Basic '
										+ $rootScope.globals.currentUser.authdata; // jshint
								// ignore:line
								$http.defaults.headers.common['AUTH_KEY'] = $rootScope.globals.currentUser.authKey; // jshint
								// ignore:line

							}

							$rootScope.$on('$locationChangeStart', function(
									event, next, current) {
								// redirect to login page if not logged in
								if ($location.path() !== '/login'
										&& !$rootScope.globals.currentUser) {
									$location.path('/login');
								}
							});
						} ]);