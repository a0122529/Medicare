$(document)
		.ready(
				function() {

					var sPageURL = window.location.search.substring(1);
					var sURLVariables = sPageURL.split('&');
					for (var i = 0; i < sURLVariables.length; i++) {
						var sParameterName = sURLVariables[i].split('=');
						var patient = 0;
						if (sParameterName[0] == 'patientId') {
							patient = sParameterName[1];
						}
					}

					var personData = {
						"patientId" : patient

					};
					// alert(JSON.stringify(personData));
					$
							.ajax({
								type : 'POST',
								contentType : 'application/json',
								url : "http://localhost:8080/MedicalAssignment4PartB/rest/doctor/viewPatientDetails",
								dataType : "json",
								data : JSON.stringify(personData),
								success : function(data) {
									//
									var val = JSON.stringify(data);
									var json = $.parseJSON(val);
									$('#patId').val(json.patientId);
									$('#name').val(json.name);
									$('#age').val(json.age);
									$('#gender').val(json.gender);
									$('#phone').val(json.phone);
									$('#address').val(json.address);

									var table = $('#encounterTable');

									for (var j = 0; j < json.encounter.length; j++) {

										table
												.append("<tr><td><a  href = 'javascript:void(0)' onclick = 'getOtherInfo("
														+ json.encounter[j].encounterId
														+ " )' >"
														+ json.encounter[j].encounterId
														+ "</a></td><td>"
														+ json.encounter[j].chiefComplaint
														+ "</td><td>"
														+ json.encounter[j].diagnosis
														+ "</td><td>"
														+ json.encounter[j].doctor
														+ "</td></tr>");
									}
								},
								error : function(er) {
									alert("error");
								},
								failure : function(errormsg) {
									alert(errormsg);
								}
							});
				});

function getOtherInfo(id) {
	var input = document.createElement("input");
	input.setAttribute("type", "hidden");
	input.setAttribute("id", "encIdHidden");
	input.setAttribute("name", "encIdHidden");
	input.setAttribute("value", id);
	document.getElementById("patId").appendChild(input);
	var personData = {
		"encounterId" : id
	};

	$
			.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : "http://localhost:8080/MedicalAssignment4PartB/rest/doctor/viewOtherDetails",
				dataType : "json",
				data : JSON.stringify(personData),
				success : function(data) {

					var val = JSON.stringify(data);
					var json = $.parseJSON(val);
					var vitalTable = $('#vitalTable');

					vitalTable.append("<tr><td>" + json.vitalSign.weight
							+ "</td><td>" + json.vitalSign.respRate
							+ "</td><td>" + json.vitalSign.glucoseLevel
							+ "</td><td>" + json.vitalSign.bp + "</td><td>"
							+ json.vitalSign.bmi + "</td><td>"
							+ json.vitalSign.pulse + "</td><td>"
							+ json.vitalSign.height + "</td></tr>");

					var symptoms = $('#symptoms');

					for (var j = 0; j < json.symptomsList.length; j++) {

						symptoms.append("<tr><td>" + json.symptomsList[j]
								+ "</td></tr>");
					}

					var allergy = $('#allergies');

					for (var j = 0; j < json.allergiesList.length; j++) {

						allergy.append("<tr><td>" + json.allergiesList[j]
								+ "</td></tr>");
					}

					var meds = $('#activeMeds');

					for (var j = 0; j < json.activeMedsList.length; j++) {

						meds.append("<tr><td>" + json.activeMedsList[j]
								+ "</td></tr>");
					}
				},
				error : function(er) {
					alert("error");
				},
				failure : function(errormsg) {
					alert(errormsg);
				}
			});

}

function addDiag() {
	id = $("#encIdHidden").val();
	diagnosis = $("#diag").val();
	// alert("hidden is " + id)
	var encounterData = {
		"encounterId" : id,
		"diagnosis" : diagnosis
	};
	$
			.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : "http://localhost:8080/MedicalAssignment4PartB/rest/doctor/updateDiagnosis",
				dataType : "json",
				data : JSON.stringify(encounterData),
				success : function(data) {
					alert("Diasnosis updated for encounter id " + id);

				},
				error : function(er) {
					alert(er);
				},
				failure : function(errormsg) {
					alert(errormsg);
				}
			});
}