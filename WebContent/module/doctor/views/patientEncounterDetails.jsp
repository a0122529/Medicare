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
<title>Insert title here</title>
</head>
<body> --%>

<div class="container" ng-init="details()">
	<div class="row">
		<div class="col-lg-12">
			<nav class="navbar navbar-default">
				<div class="col-lg-10">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">PATIENT MEDICAL PAGE</a>
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
			<br>
			<ul class="nav nav-sidebar nav-pills nav-stacked">
				<li><a href="#/doctor">Home</a></li>
				<li class="active"><a href="#">Patient Encounter</a></li>
				<!-- <li><a href="#/labRequestsAndResults">Lab R&R</a></li> -->
				<li><a href="#">Assessment</a></li>
			</ul>
			<br> <br>
			<div class="panel panel-default">
				<div class="panel-heading">Patient Info</div>
				<div class="panel-body">
					<div class="controls controls-row row-fluid">
						<div class="col-lg-6">
							Ref. Id: <input type="text" class="form-control" id="patRefNum"
								style="width: 80px; height: 25px;" readonly="readonly"
								value="{{encounterList[0].patient.refNumber}}" /> Name: <input
								type="text" class="form-control" id="name" readonly="readonly"
								style="width: 80px; height: 25px;"
								value="{{encounterList[0].patient.name}}" />
						</div>
						<div class="col-lg-6">

							Age: <input type="text" class="form-control" id="age"
								value="{{encounterList[0].patient.age}}" readonly="readonly"
								style="width: 80px; height: 25px;" /> Gender: <input
								type="text" class="form-control" id="gender"
								value="{{encounterList[0].patient.gender}}" readonly="readonly"
								style="width: 80px; height: 25px;" />

							<!-- Phone: <input type="text"
									class="form-control" id="phone" readonly="readonly"
									style="width: 80px; height: 25px;" /> -->
						</div>
						<div class="col-lg-6">
							Address: <input type="text" class="form-control" id="address"
								value="{{encounterList[0].patient.address}}" readonly="readonly"
								style="width: 200px; height: 65px;" />
						</div>
					</div>
				</div>
			</div>
			<div>
				<h4>Update Diagnosis - Enc Id {{encounter.encounterId}}</h4>
				<input type="text" class="form-control" id="diag" id="diagnosis"
					ng-model="diagnosis" style="width: 258px; height: 65px;"
					value="{{encounter.diagnosis}}" /> <br> <input type="button"
					class="btn btn-primary" name="addVital" id="addvital"
					value="Update Diagnosis" ng-click="updateEnc()">
			</div>
		</div>
		<div class="col-lg-9">
			<h3 style="margin-left: 12px;">Patient Encounter Details</h3>
			<div class="col-lg-9">
				<div class="panel panel-default">
					<div class="panel-heading">Encounter History</div>
					<br>
					<h5>Click on below encounters to see patient visit details</h5>
					<div class="panel-body">
						<table class="table table-bordered table-striped"
							id="encounterTable">
							<thead>
								<tr>
									<th>Encounter Id</th>
									<th>Chief Complaint</th>
									<th>Diagnosis</th>
									<th>Doctor</th>
									<th>Status</th>
								</tr>
							</thead>
							<tbody ng-repeat="encounters in encounterList"
								ng-click="go(encounters)">
								<tr>
									<td>{{encounters.encounterId}}</td>
									<td>{{encounters.chiefComplaint}}</td>
									<td>{{encounters.diagnosis}}</td>
									<td>{{encounters.attDoctor}}</td>
									<td>{{encounters.encStatus}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="panel panel-default">
					<div class="panel-heading">
						<b>VITAL SIGN - ENCOUNTER ID {{encounter.encounterId}}</b>
					</div>
					<br>
					<div class="panel-body">
						<table class="table table-bordered table-striped" id="vitalTable">
							<thead>
								<tr>
									<th>Weight</th>
									<th>Resp Rate</th>
									<th>Glucose Level</th>
									<th>BP</th>
									<th>BMI</th>
									<th>Pulse</th>
									<th>Height</th>
									<th>Skin Condition</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>{{vitalSign.weight}}</td>
									<td>{{vitalSign.respRate}}</td>
									<td>{{vitalSign.glucoseLevel}}</td>
									<td>{{vitalSign.bp}}</td>
									<td>{{vitalSign.bmi}}</td>
									<td>{{vitalSign.pulse}}</td>
									<td>{{vitalSign.height}}</td>
									<td>{{vitalSign.skinCondition}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="col-sm-4">
					<table class="table table-bordered table-striped" id="symptoms"
						style="color: red; background-color: pink;">
						<thead>
							<tr>
								<th>Symptoms</th>
							</tr>
						</thead>
						<tbody ng-repeat="sym in symptoms">
							<tr>
								<td>{{sym}}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-sm-4">
					<table class="table table-bordered table-striped" id="allergies"
						style="color: red; background-color: pink;">
						<thead>
							<tr>
								<th>Allergies</th>
							</tr>
						</thead>
						<tbody ng-repeat="allergy in allergies">
							<tr>
								<td>{{allergy}}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-sm-4">
					<table class="table table-bordered table-striped" id="activeMeds"
						style="color: red; background-color: pink;">
						<thead>
							<tr>
								<th>Active Meds</th>
							</tr>
						</thead>
						<tbody ng-repeat="med in medications">
							<tr>
								<td>{{med}}</td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
			<!-- <div class="col-sm-9">
				<div class="panel panel-default">
					<div class="panel-heading">
						<b>VITAL SIGN - ENCOUNTER ID {{encounter.encounterId}}</b>
					</div>
					<br>
					<div class="panel-body">
						<table class="table table-bordered table-striped" id="vitalTable">
							<thead>
								<tr>
									<th>Weight</th>
									<th>Resp Rate</th>
									<th>Glucose Level</th>
									<th>BP</th>
									<th>BMI</th>
									<th>Pulse</th>
									<th>Height</th>
									<th>Skin Condition</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>{{vitalSign.weight}}</td>
									<td>{{vitalSign.respRate}}</td>
									<td>{{vitalSign.glucoseLevel}}</td>
									<td>{{vitalSign.bp}}</td>
									<td>{{vitalSign.bmi}}</td>
									<td>{{vitalSign.pulse}}</td>
									<td>{{vitalSign.height}}</td>
									<td>{{vitalSign.skinCondition}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div> -->
			<div class="col-sm-9">
				<div class="col-sm-8">
					<a ng-href="#/labRequestsAndResults"><input type="button"
						class="btn btn-primary" name="addVital" id="addvital"
						value="Lab Test Request"></a>
				</div>
				<div class="col-sm-4">
					<a ng-href="#/prescription"><input type="button"
						class="btn btn-primary" name="addVital" id="addvital"
						value="Prescribe Prescription"></a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 	<!-- <script src="js/viewPatients.js"></script> -->
<!-- </body>
</html> -->
