$(document)
		.ready(
				function() {
					// alert("entered");
					var sPageURL = window.location.search.substring(1);
					var sURLVariables = sPageURL.split('&');
					for (var i = 0; i < sURLVariables.length; i++) {
						var sParameterName = sURLVariables[i].split('=');
						var person = 0;
						if (sParameterName[0] == 'personId') {
							// alert(sParameterName[1]);
							person = sParameterName[1];
							// return sParameterName[1];
						}
					}

					var personData = {
						"personId" : person

					};
					// alert(JSON.stringify(personData));
					$
							.ajax({
								type : 'POST',
								contentType : 'application/json',
								url : "http://localhost:8080/MedicalAssignment4PartB/rest/doctor",
								dataType : "json",
								data : JSON.stringify(personData),
								success : function(data) {
									// alert("success");
									var val = JSON.stringify(data);
									var json = $.parseJSON(val);
									$('#drName').append(json.name);

									var table = $('#patients');
//									alert(json.patientList.length);
									for (var j = 0; j < json.patientList.length; j++) {
										// alert(json.patientList[j].patientId);
										table
												.append("<tr><td>"
														+ json.patientList[j].patientId
														+ "</td><td><a href = 'patientEncounter.jsp?patientId="
														+ json.patientList[j].patientId
														+ "'>"
														+ json.patientList[j].name
														+ "</a></td></tr>");
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