package com.neu.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.dao.HibernateUtil;
import com.neu.model.Allergies;
import com.neu.model.Employee;
import com.neu.model.Encounter;
import com.neu.model.Login;
import com.neu.model.Medications;
import com.neu.model.Patient;
import com.neu.model.Role;
import com.neu.model.Symptoms;

public class Test {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub

		 Session session = HibernateUtil.getSessionFactory().openSession();
		 Transaction tx = session.beginTransaction();
		
		 Role docRole = new Role();
		 Role nurseRole = new Role();
		
		 docRole.setRoleName("doctor");
		 nurseRole.setRoleName("nurse");
		
		 Employee doctorEmp = new Employee();
		 Employee nurseEmp = new Employee();
		
		 doctorEmp.setName("Lalit Wadhwani");
		 doctorEmp.setAge(29);
		 doctorEmp.setGender("Male");
		 doctorEmp.setDob(new Date());
		 doctorEmp.setRole(docRole);
		 doctorEmp.setWorkplace("Hospital1");
		
		 nurseEmp.setName("Susan Miranda");
		 nurseEmp.setAge(21);
		 nurseEmp.setGender("Female");
		 nurseEmp.setDob(new Date());
		 nurseEmp.setRole(nurseRole);
		 nurseEmp.setWorkplace("Hospital1");
		
		 Login docLogin = new Login();
		 Login nurseLogin = new Login();
		
		 docLogin.setUsername("doctor");
		 docLogin.setPassword("123");
		 docLogin.setRole(docRole);
		 docLogin.setEmployee(doctorEmp);
		
		 nurseLogin.setUsername("nurse");
		 nurseLogin.setPassword("123");
		 nurseLogin.setRole(nurseRole);
		 nurseLogin.setEmployee(nurseEmp);
		
		 session.save(docRole);
		 session.save(nurseRole);
		 session.save(doctorEmp);
		 session.save(nurseEmp);
		 session.save(docLogin);
		 session.save(nurseLogin);
		
		 tx.commit();
		 session.close();

//		Patient patient = new Patient();
//		patient.setRefNumber("ref111");
//		Encounter e = new Encounter();
//		e.setChiefComplaint("1st comp");
//		e.setAttDoctor("kusum kumar");
//		Allergies a = new Allergies();
//		Allergies a2 = new Allergies();
//		a.setName("all1");
//		a2.setName("all2");
//		Medications m = new Medications();
//		Medications m2 = new Medications();
//		m2.setName("med2");
//		Symptoms s = new Symptoms();
//		Symptoms s2 = new Symptoms();
//		s.setName("sym1");
//		s2.setName("sym2");
//		e.getAllergiyList().add(a);
//		e.getAllergiyList().add(a2);
//		e.getMedList().add(m);
//		e.getMedList().add(m2);
//		e.getSymptomsList().add(s);
//		e.getSymptomsList().add(s2);
//		patient.getEncounterList().add(e);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		String jsonInString = mapper.writeValueAsString(patient);
//		System.out.println(jsonInString);

	}

}
