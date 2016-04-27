
<div class="container" ng-app="Doctor"
	ng-controller="PatientDetailsController">
	<div class="row">
		<div class="col-lg-12">
			<nav class="navbar navbar-default">
				<div class="col-lg-10">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">View Patient with specific
							conditions<b> Dr. {{name}}</b>
						</a>
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
			<br> <br>
			<ul class="nav nav-sidebar nav-pills nav-stacked">
				<li class="active"><a href="#/doctor">Home</a></li>
				<li class="active"><a href="#/specificPatients">Specific
						Patients</a></li>
			</ul>
		</div>



		<div class="col-lg-9">
			<hr>
			<div class="col-lg-4">
				<div ng-init="allDiagnosis()">
					<label>Diagnosis List:</label> <Select type="text"
						ng-change="specificPatients(diagnosisName)" class="form-control"
						id="diag" ng-model="diagnosisName" name="person"
						style="width: 180px; height: 25px;">
						<option ng-repeat="diagnosis in diagnosisList">{{diagnosis.diagnosisName}}</option>
					</Select>
				</div>
			</div>
		</div>
		<div class="col-lg-9">
			<br>
			<table class="table table-bordered table-hover table-striped"
				id="patients">
				<thead>
					<tr>
						<th>Patient Name</th>
						<th>Location</th>
					</tr>
				</thead>

				<tbody ng-repeat="encounters in encounterList">
					<tr>
						<td>{{encounters.patient.name}}</td>
						<td>{{encounters.patient.address}}</td>
					</tr>
				</tbody>

			</table>
		</div>
	</div>
</div>
