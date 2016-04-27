
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<nav class="navbar navbar-default">
				<div class="col-lg-10">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">Patient Prescription Page</a>
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
				<li><a href="#/doctor">Home</a></li>
				<li><a href="#">Patient Encounter</a></li>
				<li class="active"><a href="#/prescription">Prescription </a></li>
			</ul>
		</div>

		<div class="col-lg-9">
			<div class="col-lg-12">
				<h3>Presciption</h3>
				<table class="table table-bordered table-hover table-striped"
					id="patients">
					<thead>
						<tr>
							<th>Encounter ID</th>
							<th>Patient Name</th>
							<th>Diagnosis</th>
							<th ng-repeat="drug in encounter.drugs"
								ng-show="encounter.drugs.length">Medicine</th>

						</tr>
					</thead>

					<tbody>
						<tr>
							<td>{{encounter.encounterId}}</td>
							<td>{{encounter.patient.name}}</td>
							<td>{{encounter.diagnosis}}</td>
							<td ng-repeat="d in encounter.drugs">{{d.drugName}}</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="col-lg-12">
				<hr>
				<h3>Add Prescription</h3>
				<div ng-show="errorDrugs.length > 0"  ng-repeat="fail in errorDrugs">
					<h4>Not able to add the following drug to patient order because of allergy</h4>
					<h5 style="color: red;">{{fail.dName}}</h5>
					<h4> Allergy Name </h4>
					<h5 ng-repeat="comp in fail.failedComponents" style="color: blue;">{{comp}}</h5>
				</div>
				<div class="col-lg-4">
					Drugs: <Select class="form-control" id="drug" multiple
						ng-model="encounter.drugs" ng-init="allDrugs()"
						ng-options="dl.drugName for dl in drugList" name="drug">

					</Select>
				</div>


			</div>
			<div class="col-lg-12">
				<hr>
				<div class="col-lg-3">
					<input type="submit" class="btn btn-lg btn-primary btn-block"
						name="adddrug" id="adddrug" value="Add Drug"
						ng-click="addDrug(encounter)" />
				</div>
			</div>
		</div>
	</div>
</div>
