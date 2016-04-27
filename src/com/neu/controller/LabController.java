package com.neu.controller;

import java.util.ArrayList;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neu.dao.impl.LabDAOImpl;
import com.neu.dao.impl.LoginDAOImpl;
import com.neu.dao.impl.NurseDAOImpl;
import com.neu.model.Employee;
import com.neu.model.WorkRequest;

@Controller
@Path("/lab")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LabController {

	@Autowired
	private LabDAOImpl labDAOImpl;

	@Autowired
	private NurseDAOImpl nurseDAOImpl;

	@POST
	@Path("/labAssistantRequest")
	public ArrayList<WorkRequest> fetchLabRequests(Employee employee) {
		ArrayList<WorkRequest> wr = labDAOImpl.fetchLabRequest(employee);
		return wr;
	}
	
	

	@GET
//	@RolesAllowed("lab")
	@PermitAll
	@Path("/allLabEmployees")
	public ArrayList<Employee> getAllDocs() {
		ArrayList<Employee> empList = nurseDAOImpl.findSpecificEmployees(3);
		return empList;
	}
	
	@PUT
//	@RolesAllowed("lab")
	@PermitAll
	@Path("/updateWorkReq")
	public ArrayList<WorkRequest> updateWorkRequest(WorkRequest workRequest){
		ArrayList<WorkRequest> wr = labDAOImpl.updateWorkReq(workRequest);
		return wr;
	}
	
	
}
