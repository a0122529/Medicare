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
				<nav class="navbar navbar-default"> <!-- <div class="navbar-header"> -->
				<div class="col-lg-10">
					<a class="navbar-brand" href="#">PATIENT SIGN UP</a>
				</div>
				<div class="col-lg-2" style="margin-top: 7px;">
					<a ng-href="#/login" class="btn btn-primary"> <span
						class="glyphicon glyphicon-log-out"></span> Log out
					</a>
				</div>
				</nav>
			</div>
			<div class="col-lg-3">
				<ul class="nav nav-sidebar nav-pills nav-stacked">
					<li class="active"><a href="#/nurse">Create Patient Info</a></li>
					<li><a ng-href="#/createEncounter">Create Encounter</a></li>
				</ul>

				<br>
				<h4>
					<b>Transfer Patient</b>
				</h4>
				Physician Email-Id: <input type="text" class="form-control"
					id="emailId" name="emailId" id="emailId"
					placeholder="Enter Email Id" ng-model="emailId" /> Patient Ref.
				Number: <input type="text" class="form-control" id="patId"
					name="refNumber" ng-model="refNumber" id="refNumber"
					placeholder="Enter Ref. Num" ng-model="refNumber" /> <input
					type="submit" class="btn btn-lg btn-primary btn-block"
					name="addInfo" id="addInfo" value="Send Email"
					ng-click="sendToPatientEHR(refNumber)" style="margin-top: 17px;" />


				<hr>
				<h4>
					<b>Patient EHR Copy</b>
				</h4>
				Enter Patient Reference Number: <input type="text"
					class="form-control" id="patId" name="refNumber" id="refNumber"
					placeholder="Enter Ref. Num" ng-model="refNumber" /> <br> <input
					type="submit" class="btn btn-lg btn-primary btn-block"
					name="addInfo" id="addInfo" value="Send Email"
					ng-click="sendToPatientEHR(refNumber)" style="margin-top: 17px;" />

			</div>

			<!-- <div class="col-lg-9"> -->
			<h2>Patient Information</h2>
			<div class="col-lg-9">
				<div class="panel panel-default">
					<div class="panel-heading">Add Personal Info</div>
					<div class="panel-body">
						<div class="controls controls-row row-fluid">
							<!-- <form name="patientForm" ng-submit="update(patient)" role="form"> -->
							<div class="col-lg-12">
								<div class="col-lg-4">
									Reference Number: <input type="text" class="form-control"
										id="refNumber" name="refNumber" ng-model="patient.refNumber"
										style="width: 180px; height: 25px;" />
								</div>
								<div class="col-lg-4">
									Name: <input type="text" class="form-control" id="name"
										ng-model="patient.name" style="width: 180px; height: 25px;" />
								</div>
								<div class="col-lg-4">
									Age: <input type="text" class="form-control" id="age"
										ng-model="patient.age" name="age"
										style="width: 180px; height: 25px;" />
								</div>
							</div>
							<div class="col-lg-12">
								<hr>
								<div class="col-lg-4">
									Gender: <Select class="form-control" id="gender"
										ng-model="patient.gender" name="gender"
										style="width: 180px; height: 25px;">
										<option>Male</option>
										<option>Female</option>
									</Select>
								</div>
								<div class="col-lg-4">
									Ethnicity <Select type="text" class="form-control"
										id="ethnicity" ng-model="patient.ethnicity" name="ethnicity"
										style="width: 180px; height: 25px;">
										<option>Hindu</option>
									</Select>
								</div>

								<div class="col-lg-4" ng-init="allDoctors()">
									Doctors <Select type="text" class="form-control" id="doctor"
										ng-model="patient.docName" name="person"
										style="width: 180px; height: 25px;">
										<option ng-repeat="doctor in doctorList">{{doctor.name}}</option>
									</Select>
								</div>

							</div>

							<div class="col-lg-12">
								<hr>
								<div class="col-lg-4">
									Phone: <input type="text" class="form-control" id="phone"
										ng-model="patient.phone" style="width: 180px; height: 25px;" />
								</div>
								<div class="col-lg-8" ng-show="patient.age > 13">
									Smoking <Select type="text" class="form-control" id="smoking"
										ng-model="patient.smoking" name="smoking"
										style="width: 180px; height: 25px;">
										<option>Yes</option>
										<option>No</option>
									</Select>
								</div>
							</div>

							<div class="col-lg-12">
								<hr>
								Address: <input type="text" class="form-control" id="address"
									ng-model="patient.address" />
							</div>
						</div>
						<!-- </form>  -->
					</div>
				</div>
				<br> <input type="submit"
					class="btn btn-lg btn-primary btn-block" name="addInfo"
					id="addInfo" value="Add Patient" ng-click="addPatient(patient)" />
			</div>

		</div>
	</div>
	<!-- 	</div> -->

	<!-- lib -->
	<!-- 	<script src="js/createPatient.js"></script> -->
</body>
</html>