<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html ng-app="BasicHttpAuthExample">
<head>
<meta charset="UTF-8">
<title>Medicare</title>
<!-- General css -->
<link href="css/datepicker.css" rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script> -->
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<!-- 	<div class="col-lg-2" style="margin-top: 7px;">
				<a href="#" class="btn btn-primary"> <span
					class="glyphicon glyphicon-log-out"></span> Log out
				</a>
			</div> -->
			<div ng-view></div>
		</div>
	</div>

	<div class="credits text-center">&copy;Kshitij Kaushik</div>

	<script src="//code.jquery.com/jquery-2.0.3.min.js"></script>
	<script src="//code.angularjs.org/1.5.0/angular.js"></script>
	<script src="//code.angularjs.org/1.5.0/angular-route.js"></script>
	<script src="//code.angularjs.org/1.5.0/angular-cookies.js"></script>
	<script src="module/scripts/app.js"></script>

	<!-- modules/authentication -->
	<script src="module/login/services.js"></script>
	<script src="module/login/controllers.js"></script>
	<script src="module/nurse/services.js"></script>
	<script src="module/nurse/controllers.js"></script>
	<script src="module/doctor/services.js"></script>
	<script src="module/doctor/controllers.js"></script>
<!-- 	<script src="module/nurse/commonController.js"></script> -->


	<!-- modules/home -->


	<!-- General JS -->
	<script src="js/jquery-1.7.1.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>

</body>
</html>