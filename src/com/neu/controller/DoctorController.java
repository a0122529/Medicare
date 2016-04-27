package com.neu.controller;

import java.util.ArrayList;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.common.PhonesAndMails;
import com.neu.dao.DrugAndAllergyCheckDAO;
import com.neu.dao.impl.DoctorDAOImpl;
import com.neu.dao.impl.DrugAndAllergyCheckImpl;
import com.neu.model.Diagnosis;
import com.neu.model.DrugFailure;
import com.neu.model.Drugs;
import com.neu.model.Encounter;
import com.neu.model.Patient;
import com.neu.model.WorkRequest;

@Controller
@Path("/doctor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DoctorController {

	@Autowired
	private DoctorDAOImpl doctorDAOImpl;

	@Autowired
	private DrugAndAllergyCheckImpl drugAndAllergyCheckImpl;

	final static Logger logger = Logger.getLogger(DoctorController.class);

	@GET
	@PathParam("/{docId}")
	@RolesAllowed("doctor")
	public ArrayList<Patient> doctorPatients(@PathParam(value = "docId") int doctId) {
		return doctorDAOImpl.findDoctorsPatients(doctId);
	}

	@GET
	@RolesAllowed("doctor")
	@Path("/searchPatient/{refNumber}")
	public ArrayList<Encounter> searchPatient(@PathParam(value = "refNumber") String refNumber)
			throws JsonProcessingException {
		// System.out.println(patient.getRefNumber());
		ArrayList<Encounter> encList = doctorDAOImpl.searchPatientByRefNum(refNumber);
		// ObjectMapper mapper = new ObjectMapper();
		// String jsonInString = mapper.writeValueAsString(encList);
		// System.out.println(jsonInString);
		return encList;
	}

	@PUT
	@RolesAllowed("doctor")
	@Path("/updateDiagnosis")
	public void updateDiagnosis(Encounter encounter) {
		doctorDAOImpl.updateDiagnosis(encounter);

	}

	@POST
	@RolesAllowed("doctor")
	@Path("/createLabRequest")
	public ArrayList<WorkRequest> createLabRequest(WorkRequest workRequest) {
		ArrayList<WorkRequest> wr = doctorDAOImpl.createLabRequest(workRequest);
		return wr;
	}

	@POST
	@RolesAllowed("doctor")
	@Path("/patientLabRequests")
	public ArrayList<WorkRequest> getPatientRequest(Encounter encounter) {
		return doctorDAOImpl.getPatientLabRequest(encounter);
	}

	@GET
	@PermitAll
	@Path("/allDrugs")
	public ArrayList<Drugs> getAllDrugs() {
		ArrayList<Drugs> drugList = drugAndAllergyCheckImpl.getAllDrugs();
		return drugList;
	}

	@POST
	@RolesAllowed("doctor")
	@Path("/drug-AllergyCheck")
	public ArrayList<DrugFailure> drugAllergyCheck(Encounter encounter) {
		return drugAndAllergyCheckImpl.drugAllergyCheck(encounter);
	}

	@POST
	@RolesAllowed("doctor")
	@Path("/updateReq")
	public Encounter updateReq(Encounter encounter) {
		return drugAndAllergyCheckImpl.updateReqEncounter(encounter);
	}

	@POST
	@RolesAllowed("doctor")
	@Path("/emailSummary")
	public void sendSummaryMail(Encounter encounter) {
		PhonesAndMails pm = new PhonesAndMails();
		pm.emailSummary(encounter);
	}

	@GET
	@RolesAllowed("doctor")
	@Path("/allDiagnosis")
	public ArrayList<Diagnosis> allDiagnosis() {
		return doctorDAOImpl.allDiagnosis();

	}

	@POST
	@RolesAllowed("doctor")
	@Path("/specificPatients")
	public ArrayList<Encounter> specificPatients(Diagnosis diagnosis) {
		return doctorDAOImpl.findPatientEncUsingDiagnosis(diagnosis);
	}

}
