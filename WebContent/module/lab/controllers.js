'use strict';

var app = angular.module('Lab');

app.controller('LabController', [ '$scope', '$rootScope', '$routeParams',
		'$filter', 'LabService',
		function($scope, $rootScope, $routeParams, $filter, LabService) {
			LabService.LabAssistantReq($rootScope.emp, function(data, header) {
				$scope.workRequestList = data;
				
			});

			$scope.allLabAssistants = function() {
				$scope.dataLoading = true;
				LabService.AllLabAssistant(function(data, header) {
//					alert(JSON.stringify(data));
					$rootScope.labAssistantList = data;
				});
			}

			$scope.go = function(wr) {
				$scope.wr = wr;				
				var labAssistant;
				
				$scope.labAssistant = wr.employee.name;
				
			};

			$scope.updateWorkReq = function() {
				$scope.dataLoading = true;
				var employee1 = {};
				employee1.name = $scope.labAssistant;
				// filtering out the object
				var newTemp = $filter("filter")($rootScope.labAssistantList, {name:$scope.labAssistant});
				$scope.wr.employee = newTemp[0];
			
				LabService.UpdateWorkReq($scope.wr, function(data, header) {
					
					$scope.workRequestList = data;
//					alert(JSON.stringify($scope.workRequestList));

				})
			}
		} ]);