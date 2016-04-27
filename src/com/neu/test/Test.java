package com.neu.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.common.HashUtil;
import com.neu.controller.NurseController;
import com.neu.dao.HibernateUtil;
import com.neu.model.Allergies;
import com.neu.model.Diagnosis;
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

		String nursePass = "123";
		String docPass = "123";
		String labPass = "123";

		String nurseHash = HashUtil.generateHash(nursePass, HashUtil.ALGO.MD5);
		String docHash = HashUtil.generateHash(docPass, HashUtil.ALGO.MD5);
		String labHash = HashUtil.generateHash(labPass, HashUtil.ALGO.MD5);

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
		docLogin.setPassword(docHash);
		docLogin.setRole(docRole);
		docLogin.setEmployee(doctorEmp);

		nurseLogin.setUsername("nurse");
		nurseLogin.setPassword(nurseHash);
		nurseLogin.setRole(nurseRole);
		nurseLogin.setEmployee(nurseEmp);

		labLogin.setUsername("lab");
		labLogin.setPassword(labHash);
		labLogin.setRole(labRole);
		labLogin.setEmployee(labEmp);

		session.save(docRole);
		session.save(nurseRole);
		session.save(labRole);
		session.save(doctorEmp);
		session.save(nurseEmp);
		session.save(labEmp);
		session.save(docLogin);
		session.save(nurseLogin);
		session.save(labLogin);

		Drugs drugs = new Drugs();
		Drugs drugs1 = new Drugs();
		Drugs drugs2 = new Drugs();
		drugs.setDrugName("Cipla");
		drugs.getDrugComponents().add("Suphur");
		drugs1.setDrugName("Gipla");
		drugs1.getDrugComponents().add("Cam");
		drugs2.setDrugName("Tipla");
		drugs2.getDrugComponents().add("Jam");
		session.save(drugs);
		session.save(drugs1);
		session.save(drugs2);

		Diagnosis d1 = new Diagnosis();
		Diagnosis d2 = new Diagnosis();
		Diagnosis d3 = new Diagnosis();
		Diagnosis d4 = new Diagnosis();
		Diagnosis d5 = new Diagnosis();

		d1.setDiagnosisName("Cancer");
		d1.setEdulink("https://en.wikipedia.org/wiki/Cancer");
		d2.setDiagnosisName("Asthma");
		d2.setEdulink("https://en.wikipedia.org/wiki/Asthma");
		d3.setDiagnosisName("Ulser");
		d3.setEdulink("https://en.wikipedia.org/wiki/Ulcer");
		d4.setDiagnosisName("Kidney Failure");
		d4.setEdulink("https://en.wikipedia.org/wiki/Kidneyfailure");
		d5.setDiagnosisName("Bronichitis");
		d5.setEdulink("https://en.wikipedia.org/wiki/Bronchitis");
		session.save(d1);
		session.save(d2);
		session.save(d3);
		session.save(d4);
		session.save(d5);

		tx.commit();
		session.close();

		// Patient patient = new Patient();
		// patient.setRefNumber("PA-1");
		// Encounter e = new Encounter();
		// e.setChiefComplaint("1st comp");
		// e.setAttDoctor("kusum kumar");
		// Allergies a = new Allergies();
		// a.setName("Sulphur");
		// a.setName(name);
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
