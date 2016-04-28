<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<nav class="navbar navbar-default">
				<div class="col-lg-10">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">View Podiatry Lab Results and
							Requests </a>
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
				<li><a ng-href="#/patientEncounterDetails/{{$routeParams.refNumber}}/">Patient Encounter</a></li>
				<li class="active"><a href="#/labRequestsAndResults">Lab
						R&R</a></li>
			</ul>
		</div>

		<div class="col-lg-9" >
			<div class="col-lg-12" ng-init="patientWorkReq()">
				<h3>Lab Results</h3>
				<table class="table table-bordered table-hover table-striped"
					id="patients">
					<thead>
						<tr>
							<th>Encounter ID</th>
							<th>Test Name</th>
							<th>Lab Assistant</th>
							<th>Result</th>
							<th>Status</th>
							<th>Lab Instruction</th>
						</tr>
					</thead>

					<tbody ng-repeat="workReq in workRequestList">
						<tr>
							<td>{{workReq.encounter.encounterId}}</td>
							<td>{{workReq.testName}}</td>
<!-- 							<td>{{workReq.date}}</td> -->
							<td>{{workReq.employee.name}}</td>
							<td>{{workReq.testResult}}</td>
							<td>{{workReq.status}}</td>
							<td>{{workReq.additionalInfo}}</td>
						</tr>
					</tbody>

				</table>
			</div>

			<div class="col-lg-12">
				<hr>
				<h3>Request Test</h3>
				<div class="col-lg-4">
					Test Name: <Select class="form-control" id="test"
						ng-model="workRequest.testName" name="test"
						style="width: 180px; height: 30px;">
						<option>X-Rays</option>
						<option>Bone Scan</option>
						<option>X-Rays</option>
						<option>MRI</option>
						<option>CT Scan</option>
						<option>Nerve Conduction</option>
						<option>ESR (SED RATE)</option>
						<option>D-dimer</option>
					</Select>
				</div>
				<div class="col-lg-4">
					Doctor Instructions:
					<textarea type="text" class="form-control" id="note"
						ng-model="workRequest.testInstructions"
						style="width: 520px; height: 100px;"></textarea>
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
						name="addInfo" id="addInfo" value="Request Test"
						ng-click="createTestReq()" />
				</div>
			</div>
		</div>
	</div>
</div>
