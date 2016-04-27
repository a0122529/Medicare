
<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<nav class="navbar navbar-default">
				<div class="col-lg-10">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">View Patient with specific conditions<b>
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
			<br> <br>
			<ul class="nav nav-sidebar nav-pills nav-stacked">
				<li class="active"><a href="#/doctor">Home</a></li>
				<li class="active"><a href="#/specificPatients">Specific Patients</a></li>
			</ul>
		</div>

		<div class="col-lg-9">
			<h4>Select a Diagnosis</h4>
			<table class="table table-bordered table-hover table-striped"
				id="patients">
				<thead>
					<tr>
						<th>ID</th>
						<th>Patient Name</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<!-- <td><a
							ng-href="#/patientEncounterDetails/{{patient.refNumber}}/">{{patient.refNumber}}</a></td>
						<td>{{patient.name}}</td> -->
					</tr>
				</tbody>

			</table>
		</div>
	</div>
</div>
