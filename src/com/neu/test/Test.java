package com.neu.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.controller.NurseController;
import com.neu.dao.HibernateUtil;
import com.neu.model.Allergies;
import com.neu.model.Drugs;
import com.neu.model.Employee;
import com.neu.model.Encounter;
import com.neu.model.Login;
import com.neu.model.Medications;
import com.neu.model.Patient;
import com.neu.model.Role;
import com.neu.model.Symptoms;
import com.neu.model.VitalSign;

public class Test {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
//
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		 Role docRole = new Role();
		 Role nurseRole = new Role();
		 Role labRole = new Role();
		 //
		 docRole.setRoleName("doctor");
		 nurseRole.setRoleName("nurse");
		 labRole.setRoleName("lab");
		
		 Employee doctorEmp = new Employee();
		 Employee nurseEmp = new Employee();
		
		 Employee labEmp = new Employee();
		 doctorEmp.setName("Lalit Wadhwani");
		 doctorEmp.setAge(29);
		 doctorEmp.setGender("Male");
		 doctorEmp.setDob("04/04/1987");
		 doctorEmp.setRole(docRole);
		 doctorEmp.setWorkplace("Hospital1");
		 //
		 nurseEmp.setName("Susan Miranda");
		 nurseEmp.setAge(21);
		 nurseEmp.setGender("Female");
		 nurseEmp.setDob("04/04/1986");
		 nurseEmp.setRole(nurseRole);
		 nurseEmp.setWorkplace("Hospital1");
		
		 labEmp.setName("Aaon Smith");
		 labEmp.setAge(31);
		 labEmp.setGender("Male");
		 labEmp.setDob("04/04/1985");
		 labEmp.setRole(labRole);
		 labEmp.setWorkplace("Hospital1");
		 //
		 Login docLogin = new Login();
		 Login nurseLogin = new Login();
		 Login labLogin = new Login();
		 //
		 docLogin.setUsername("doctor");
		 docLogin.setPassword("123");
		 docLogin.setRole(docRole);
		 docLogin.setEmployee(doctorEmp);
		
		 nurseLogin.setUsername("nurse");
		 nurseLogin.setPassword("123");
		 nurseLogin.setRole(nurseRole);
		 nurseLogin.setEmployee(nurseEmp);
		
		 labLogin.setUsername("lab");
		 labLogin.setPassword("123");
		 labLogin.setRole(labRole);
		 labLogin.setEmployee(labEmp);
		 //
		 session.save(docRole);
		 session.save(nurseRole);
		 session.save(labRole);
		 session.save(doctorEmp);
		 session.save(nurseEmp);
		 session.save(labEmp);
		 session.save(docLogin);
		 session.save(nurseLogin);
		 session.save(labLogin);

//		for (int i = 0; i < 5; i++) {
//			Drugs drugs = new Drugs();
//			drugs.setDrugId(i);
//			drugs.setDrugName("drug" + i);
//			drugs.getDrugComponents().add("comp " + i);
//			session.save(drugs);
//		}
//
		tx.commit();
		session.close();

		// Patient patient = new Patient();
		// patient.setRefNumber("ref111");
		// Encounter e = new Encounter();
		// e.setChiefComplaint("1st comp");
		// e.setAttDoctor("kusum kumar");
		// Allergies a = new Allergies();
		// a.setName("all1");
		// Medications m = new Medications();
		// m.setName("med1");
		// Symptoms s = new Symptoms();
		// s.setName("sym1");
		// VitalSign sv = new VitalSign();
		// sv.setBmi(1);
		// sv.setBp("123");
		// sv.setGlucoseLevel(4);
		// sv.setPulse(33);
		// sv.setSkinCondition("pale");
		// e.setAllergy(a);
		// e.setMedication(m);
		// e.setSymptom(s);
		// e.setVitalSign(sv);
		// patient.getEncounterList().add(e);
		//
		// ObjectMapper mapper = new ObjectMapper();
		// String jsonInString = mapper.writeValueAsString(patient);
		// System.out.println(jsonInString);

		// NurseController nc = new NurseController();
		// nc.getAllDocs();

	}

}
