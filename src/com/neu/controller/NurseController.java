package com.neu.controller;

import java.util.ArrayList;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neu.common.PhonesAndMails;
import com.neu.dao.impl.DoctorDAOImpl;
import com.neu.dao.impl.LabDAOImpl;
import com.neu.dao.impl.LoginDAOImpl;
import com.neu.dao.impl.NurseDAOImpl;
import com.neu.dao.impl.PatientDAOImpl;
import com.neu.model.Employee;
import com.neu.model.Encounter;
import com.neu.model.Patient;

@Controller
@Path("/nurse")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NurseController {

	@Autowired
	private PatientDAOImpl patientDAOImpl;

	@Autowired
	private NurseDAOImpl nurseDAOImpl;
	
	

	// @Autowired
	// private DoctorDAOImpl doctorDAOImpl;

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

	@GET
	// @RolesAllowed("nurse")
	@PermitAll
	@Path("/alldoctors")
	public ArrayList<Employee> getAllDocs() {
		ArrayList<Employee> empList = nurseDAOImpl.findSpecificEmployees(1);
		return empList;
	}

	@POST
	@RolesAllowed("nurse")
	@Path("/sendToPatientEHR")
	public void sendEmailToPatient(Patient patient) {	
		Patient foundPatient = nurseDAOImpl.sendEmailToPatient(patient);
		PhonesAndMails pnm = new PhonesAndMails();
		pnm.sendMailOnRequest(foundPatient);
	}
	
	@POST
	@RolesAllowed("nurse")
	@Path("/sendToPhysician")
	public void sendPatientDataToPhy(){
		
	}
	

}
