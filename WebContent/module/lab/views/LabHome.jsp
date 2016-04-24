<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<nav class="navbar navbar-default">
				<div class="col-lg-10">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">Lab Home - Lab Assistant
							{{name}}</a>
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
				<li class="active"><a href="#/lab">LabHome </a></li>
			</ul>
		</div>

		<div class="col-lg-9">
			<div class="col-lg-12">
				<h3>Lab Results</h3>
				<table class="table table-bordered table-hover table-striped"
					id="patients">
					<thead>
						<tr>
							<th>Patient Id</th>
							<th>Test ID</th>
							<th>Test Name</th>
							<th>Date</th>
							<th>Attending Doctor</th>
							<th>Lab Attendant</th>
							<th>Instructions</th>
							<th>Result</th>
							<th>Status</th>
						</tr>
					</thead>

					<tbody ng-repeat="wr in workRequestList" ng-click="go(wr)">
						<tr>
							<td>{{wr.patientRefNum}}</td>
							<td>{{wr.testId}}</td>
							<td>{{wr.testName}}</td>
							<td>{{wr.date}}</td>
							<td>{{wr.attDoctor}}</td>
							<td>{{wr.employee.name}}</td>
							<td>{{wr.testInstructions}}</td>
							<td>{{wr.testResult}}</td>
							<td>{{wr.status}}</td>
						</tr>
					</tbody>

				</table>
			</div>

			<div class="col-lg-12">
				<hr>
				<h3>Test No Information</h3>
				<div class="col-lg-4">
					Test Name <input type="text" class="form-control" id="note" readonly="readonly"
						value="{{wr.testName}}" />
				</div>
				<div class="col-lg-4">
					Test Result <input type="text" class="form-control" id="note" ng-model = "wr.testResult"
						value="{{wr.testResult}}" />
				</div>
				<div class="col-lg-4">
					Status <Select type="text" class="form-control" id="status" ng-model = "wr.status"
						name="status" style="width: 230px; height: 35px;">
						<option>Open</option>
						<option>Pending</option>
						<option>Close</option>
					</Select>
				</div>
				<div class="col-lg-12">
					<hr>
					<div class="col-lg-4" ng-init="allLabAssistants()">
						Lab Assistant <Select type="text" class="form-control" id="status" ng-model = "labAssistant"
							name="status" style="width: 230px; height: 35px;">
							<option ng-repeat="labAss in labAssistantList">{{labAss.name}}</option>
						</Select>
					</div>
					<div class="col-lg-4">
						Additional Info:
						<textarea type="text" class="form-control" id="note" ng-model = "wr.additionalInfo"
							style="width: 235px; height: 100px;">{{wr.additionalInfo}}</textarea>
					</div>
				</div>
				<div class="col-lg-12">
					<hr>
					<div class="col-lg-4">
						<input type="submit" class="btn btn-lg btn-primary btn-block"
							name="addInfo" id="addInfo" value="Update Test" ng-click="updateWorkReq()"/>
					</div>
					<div class="col-lg-4">
						<input type="submit" class="btn btn-lg btn-primary btn-block"
							name="addInfo" id="addInfo" value="Send Notification" ng-click="sendEmailToDoc(wr)" />
					</div>
				</div>
			</div>
		</div>
	</div>