<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<nav class="navbar navbar-default">
				<div class="col-lg-10">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">View Your Patients <b>
								Dr. {{name}}</b></a>
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
							ng-href="#/patientEncounterDetails/{{patient.refNumber}}/">{{patient.refNumber}}</a></td>
						<td>{{patient.name}}</td>
					</tr>
				</tbody>

			</table>
		</div>
	</div>
</div>
