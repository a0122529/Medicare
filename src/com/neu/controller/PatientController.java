package com.neu.controller;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.jboss.resteasy.spi.validation.ValidateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neu.dao.impl.PatientDAOImpl;
import com.neu.model.Allergies;
import com.neu.model.Employee;
import com.neu.model.Encounter;
import com.neu.model.Medications;
import com.neu.model.Patient;
import com.neu.model.Person;
import com.neu.model.Symptoms;
import com.neu.model.VitalSign;

@Controller
@Path("/patient")
// @ValidateRequest
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PatientController {

	final static Logger logger = Logger.getLogger(PatientController.class);

	@Autowired
	PatientDAOImpl patientDAOImpl;

	@GET
	@RolesAllowed({ "nurse", "doctor" })
	@Path("/searchPatient/{refNumber}")
	public Patient searchPatient(@PathParam(value = "refNumber") String refNumber) {
		Patient patient = patientDAOImpl.searchPatientByRefNum(refNumber);
		return patient;
	}

}
