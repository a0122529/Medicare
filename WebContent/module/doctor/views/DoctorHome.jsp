<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Medicare</title>
</head>
<body> --%>

<div class="container" ng-app="Doctor" ng-controller="DoctorController">
	<div class="row">
		<div class="col-lg-12">
			<nav class="navbar navbar-default">
				<div class="col-lg-10">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">View Your Patients <b> Dr.
								{{name}}</b></a>
					</div>
				</div>
				<div class="col-lg-2" style="margin-top: 7px;">
					<a href="#" class="btn btn-primary"> <span
						class="glyphicon glyphicon-log-out"></span> Log out
					</a>
				</div>
			</nav>
		</div>
		<div class="col-lg-3">
			<br> <br> <br> <br>
			<ul class="nav nav-sidebar nav-pills nav-stacked">
				<li class="active"><a href="#">Home</a></li>
				<li class="active"><a href="#">Assessment</a></li>
			</ul>
		</div>

		<div class="col-lg-9">
			<h1>Registered Patients</h1>
			<table class="table table-bordered table-hover table-striped"
				id="patients">
				<thead>
					<tr>
						<th>ID</th>
						<th>Patient Name</th>
					</tr>
				</thead>

				<tbody ng-repeat="patient in patientList">
					<tr>
						<td><a
							ng-href="#/patientEncounterDetails/{{patient.refNumber}}">{{patient.refNumber}}</a></td>
						<td>{{patient.name}}</td>
					</tr>
				</tbody>

			</table>
		</div>
		<!-- 	<a ng-repeat="p in patientList"
				ng-href="#/patientDetails/{{p.personId}}" class="list-group-item">{{p.personId}}
				: {{p.name}}</a> -->
	</div>
</div>
<!-- <script src="js/doctorPanel.js"></script> -->
<!-- </body>
</html> -->