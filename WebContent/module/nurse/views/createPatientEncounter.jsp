
<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<body>

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<nav class="navbar navbar-default">
				<div class="col-lg-10">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">PATIENT ENCOUNTER PAGE</a>
					</div>
				</div>
				<div class="col-lg-2" style="margin-top: 7px;">
					<a href="#" class="btn btn-primary"> <span
						class="glyphicon glyphicon-log-out"></span> Log out
					</a>
				</div>
				</nav>
			</div>
			<div class="col-lg-12">
				<div class="col-lg-3">
					<br> <br> <br> <br>
					<ul class="nav nav-sidebar nav-pills nav-stacked">
						<li><a href="#/nurse.jsp">Create Patient Info</a></li>
						<li class="active"><a ng-href="#">Create Encounter</a></li>
					</ul>
				</div>

				<div class="col-lg-9">
					<h2>Patient Encounter</h2>
					<div class="col-lg-12" ng-app="Patient"
						ng-controller="PatientController">
						<div class="col-lg-4">
							Patient Reference Number: <input type="text" class="form-control"
								id="patId" placeholder="patient id" ng-model="refNumber"
								style="width: 180px; height: 25px; margin-left: 15px;" />
						</div>
						<div class="col-lg-4">
							<input type="button" class="btn btn-primary" name="search"
								id="search" value="Search Patient"
								style="margin-top: 5px; margin-left: 30px;"
								ng-click="searchPatient(refNumber)">
						</div>

						<div class="col-lg-4">
							Patient Name: <input type="text" class="form-control" id="name"
								style="width: 180px; height: 25px;" readonly="readonly"
								value="{{patient.name}}" />
						</div>

					</div>

					<div class="panel panel-default">
						<hr>
						<div class="panel-heading">
							<h3>Encounter Details</h3>
						</div>
						<div class="panel-body">
							<div class="controls controls-row row-fluid">
								<div class="col-lg-12">
									<div class="col-lg-8">
										Chief Complaint: <input type="text" class="form-control"
											placeholder="chief complaint" id="chiefComplaint"
											ng-model="encounter.chiefComplaint"
											style="width: 180px; height: 25px;" />
									</div>
									<div class="col-lg-4">
										Attending Doctor:<input type="text" class="form-control"
											id="attDoctor" ng-model="encounter.attDoctor"
											style="width: 180px; height: 25px;" />
									</div>
								</div>
								<!-- 
									 Date: <input
										type="text" class="span7" id="address1"
										style="width: 80px; height: 25px;" /> -->
							</div>
						</div>
					</div>
					<!-- 	<input type="button" class="span7" name="addVital" id="addvital"
						value="Add Vital Sign"> -->
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Vital Signs</div>
							<div class="panel-body">
								<div class="controls controls-row row-fluid">
									<div class="col-lg-12">
										<div class="col-lg-4">
											Date: <input type="text" class="form-control" id="date"
												name="date" style="width: 180px; height: 25px;" />
										</div>
										<div class="col-lg-4">
											Resp Rate: <input type="text" class="form-control"
												id="respRate" name="respRate" ng-model="vitalSign.respRate"
												style="width: 180px; height: 25px;" />
										</div>
										<div class="col-lg-4">
											Pulse: <input type="text" class="form-control" id="pulse"
												ng-model="vitalSign.pulse" name="pulse"
												style="width: 180px; height: 25px;" />
										</div>
									</div>
									<div class="col-lg-12">
										<hr>
										<div class="col-lg-4">
											Weight: <input type="text" class="form-control" id="weight"
												ng-model="vitalSign.weight" name="weight"
												style="width: 180px; height: 25px;" />
										</div>
										<div class="col-lg-4">
											BP: <input type="text" class="form-control" id="bp" name="bp"
												ng-model="vitalSign.bp" style="width: 180px; height: 25px;" />
										</div>
										<div class="col-lg-4">
											Height: <input type="text" class="form-control" id="height"
												ng-model="vitalSign.height" name="height"
												style="width: 180px; height: 25px;" />
										</div>
									</div>
									<div class="col-lg-12">
										<hr>
										<div class="col-lg-4">
											Glucose Level: <input type="text" class="form-control"
												ng-model="vitalSign.glucoseLevel" id="glevel" name="glevel"
												style="width: 180px; height: 25px;" />
										</div>
										<div class="col-lg-4">
											BMI: <input type="text" class="form-control" id="bmi"
												ng-model="vitalSign.bmi" name="bmi"
												style="width: 180px; height: 25px;" />
										</div>

										<div class="col-lg-4">
											Skin Condition: <input type="text" class="form-control"
												ng-model="vitalSign.skinCondition" id="skin" name="skin"
												style="width: 180px; height: 25px;"
												placeholder="skin condition" />
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- </div> -->
					<!-- <div class="col-lg-9" ng-app="Patient"
					ng-controller="EncounterController"> -->
					<!-- <div class="col-lg-3"></div> -->
					<div class="col-lg-12">
						<hr>
						<div class="panel panel-default">
							<div class="panel-heading">General Medical History</div>
							<div class="panel-body">
								<div class="col-lg-4">
									<table class="table table-bordered table-striped" id="symptoms"
										style="color: red; background-color: pink;">
										<thead>
											<tr>
												<th>Symptoms/Conditions</th>
											</tr>
										</thead>
										<tbody>

										</tbody>
										<tr>

										</tr>
									</table>
									<input type="text" id="symptoms" ng-model="symptoms.name">
								</div>
								<div class="col-lg-4">
									<table class="table table-bordered table-striped"
										id="allergies" style="color: red; background-color: pink;">
										<thead>
											<tr>
												<th>Active Allergies</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
									<input type="text" id="allergy" ng-model="allergies.name">
								</div>
								<div class="col-lg-4">
									<table class="table table-bordered table-striped"
										id="activeMeds" style="color: red; background-color: pink;">
										<thead>
											<tr>
												<th>Active Medications</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
									<input type="text" id="medication" ng-model="medications.name">
								</div>
							</div>
						</div>
						<input type="button" class="btn btn-primary" name="addVital"
							id="addvital" value="Add All Details"
							ng-click="addEncounter(encounter, vitalSign, allergies, symptoms, medications)">
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- lib -->
	<!-- <script src="js/addEncounter.js"></script> -->
	<script src="js/bootstrap-datepicker.js"></script>

	<script type="text/javascript">
		// When the document is ready
		$(document).ready(function() {

			$('#date').datepicker({
				format : "yyyy-mm-dd"
			});
		});
	</script>
</body>
</html>