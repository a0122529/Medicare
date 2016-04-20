package com.neu.controller;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neu.dao.impl.PatientDAOImpl;
import com.neu.model.Patient;

@Controller
@Path("/nurse")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NurseController {

	@Autowired
	private PatientDAOImpl patientDAOImpl;
	
	
	@POST
	@Path("/addPatient")
	// @PermitAll
	@RolesAllowed("nurse")
	public void addPatient(Patient patient) {
		patientDAOImpl.addPatient(patient);
	}
	
	@POST
	@RolesAllowed("nurse")
	@Path("/addEncounterDetails")
	public void addPatientEncounter(Patient patient) {
		System.out.println(patient.getRefNumber());
		patientDAOImpl.addPatientEncounter(patient);

	}
}
