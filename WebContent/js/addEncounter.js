function searchPatientById() {
	console.log('searchPatientById')
	var patientData = {
		"patientId" : $("#patId").val(),
	};
	$
			.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : "http://localhost:8080/MedicalAssignment4PartB/rest/patient/searchById",
				dataType : "json",
				data : JSON.stringify(patientData),
				success : function(data) {
					var val = JSON.stringify(data);
					var json = $.parseJSON(val);
					$('#patId').val(data.patientId);
					$('#name').val(data.name);
				},
				error : function(er) {
					alert(er);
				},
				failure : function(errormsg) {
					alert(errormsg);
				}
			});
}

function addAllEncounter() {
	console.log('addAllEncounter')
	var str = $("#medication").val();
	var med = str.split(",");
	var str2 = $("#allergy").val();
	var allergies = str2.split(",");
	var str3 = $("#symptom").val();

	var symptoms = str3.split(",");
	var patientData = {
		patientId : $("#patId").val(),
		chiefComplaint : $("#cc").val(),
		doctor : $("#doctor").val(),
		vitalSign : {
			respRate : $("#respRate").val(),
			weight : $("#weight").val(),
			bp : $("#bp").val(),
			height : $("#height").val(),
			glucoseLevel : $("#glevel").val(),
			bmi : $("#bmi").val(),
			pulse : $("#pulse").val()
		},
		activeMedsList : med,
		allergiesList : allergies,
		symptomsList : symptoms
	};
//	alert(JSON.stringify(patientData));

	$
			.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : "http://localhost:8080/MedicalAssignment4PartB/rest/patient/addEncounter",
				dataType : "json",
				data : JSON.stringify(patientData),
				success : function(data) {
					alert("encounter created successfully");
				}
			});
}