package com.neu.controller;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neu.dao.impl.LoginDAOImpl;
import com.neu.model.Employee;
import com.neu.model.Login;

@Controller
@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginController {

	final static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	LoginDAOImpl loginDAOImpl;

	@POST
	@PermitAll
	public Response getLogin(@Valid Login login) {
		Login login1 = loginDAOImpl.fetchLoginInfo(login);
		Employee employee = login1.getEmployee();
		return Response.ok().header("AUTH_KEY", employee.getRole().getRoleName()).entity(employee)
				.build();
	}

}
