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
				<li><a href="#">Assessment</a></li>
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
							<th>Prescribed Medicine</th>

						</tr>
					</thead>

					<tbody>
						<tr>
							<td>{{encounter.encounterId}}</td>
							<td>{{encounter.patient.name}}</td>
							<td>{{encounter.diagnosis}}</td>
							<td></td>

						</tr>
					</tbody>

				</table>
			</div>

			<div class="col-lg-12">
				<hr>
				<h3>Add Prescription</h3>
				<div class="col-lg-4">
					Test Name: <Select class="form-control" id="test"
						multiple="multiple" ng-model="workRequest.testName" name="test">
						<option>Drug1</option>
						<option>Drug2</option>
						<option>Drug3</option>
						<option>Drug4</option>
					</Select>
				</div>
				<div class="col-lg-4">
					Added Drug
					<textarea type="text" class="form-control" id="note"
						ng-model="workRequest.testInstructions"
						style="width: 520px; height: 80px;"></textarea>
				</div>
				<!-- 	<div class="col-lg-4">
					Lab Assistant: <Select class="form-control" id="test" name="test"
						ng-model="assistantName" style="width: 180px; height: 30px;">
						<option>Name</option>
					</Select>
				</div> -->

			</div>
			<div class="col-lg-12">
				<hr>
				<div class="col-lg-3">
					<input type="submit" class="btn btn-lg btn-primary btn-block"
						name="addInfo" id="addInfo" value="Add Drug"
						ng-click="createTestReq()" />
				</div>
			</div>
		</div>
	</div>
</div>
