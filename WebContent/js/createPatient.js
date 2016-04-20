var rootURL = "http://localhost:8080/MedicalAssignment4PartB/rest";

function addPatientInfo() {
	console.log('addPatientInfo')
//	alert("entered add patient");
	var patientData = {
		"patientId" : $("#patId").val(),
		"name" : $("#name").val(),
		"age" : $("#age").val(),
		"gender" : $("#gender").val(),
		"phone" : $("#phone").val(),
		"address" : $("#address").val()
	};
//	alert(JSON.stringify(patientData));

	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "http://localhost:8080/MedicalAssignment4PartB/rest/patient",
		dataType : "json",
		data : JSON.stringify(patientData),
		success : function(data) {
			alert("userCreatedSuccesfully");

		},
		error : function(er) {
			alert(er);
		},
		failure : function(errormsg) {
			alert(errormsg);
		}
	});
}