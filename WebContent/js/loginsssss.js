var rootURL = "http://localhost:8080/MedicalAssignment4PartB/rest";

$(function() {

	$('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});

function login() {
	console.log('login');
	var loginData = {
		"username" : $("#username").val(),
		"password" : $("#password").val()
	};

	$
			.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : rootURL + "/login",
				dataType : "json",
				data : JSON.stringify(loginData),
				success : function(data, textStatus, jqXHR) {
					var val = JSON.stringify(data);
					var json = $.parseJSON(val);
					if (json.roleName == "doctor") {
//						alert(json.name);
						window.location = "doctorPanel.jsp?personId=" + json.personId;
					} else if (json.roleName == "nurse") {
//						alert(json.name);
						window.location = "createPatientRecord.jsp?personId="
								+ json.personId;
					}
				}
			});
}
