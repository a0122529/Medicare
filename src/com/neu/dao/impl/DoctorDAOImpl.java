package com.neu.dao.impl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.neu.dao.DAO;
import com.neu.dao.DoctorDAO;
import com.neu.model.Employee;
import com.neu.model.Encounter;
import com.neu.model.Patient;

@Component
public class DoctorDAOImpl extends DAO implements DoctorDAO {

	@Override
	public ArrayList<Employee> findAllDoctors(int roleId) {
		// TODO Auto-generated method stub
		ArrayList<Employee> allDoctors = new ArrayList<>();
		Session session = getSession();
		Transaction tx = session.getTransaction();
		Query query = session.createQuery("from Employee where roleId:=roleId");
		query.setInteger("roleId", roleId);
		allDoctors = (ArrayList<Employee>) query.list();
		tx.commit();
		session.close();
		return allDoctors;
	}

	@Override
	public ArrayList<Patient> findDoctorsPatients(int docId) {
		// TODO Auto-generated method stub
		ArrayList<Patient> allPatients = new ArrayList<>();
		Session session = getSession();
		Transaction tx = session.getTransaction();
		Query query = session.createQuery("from Patient");
		// query.setInteger("roleId", roleId);
		allPatients = (ArrayList<Patient>) query.list();
		tx.commit();
		session.close();
		return allPatients;
	}

	@Override
	public Patient searchPatientByRefNum(String patRefNum) {
		// TODO Auto-generated method stub
		Patient patient = new Patient();
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Patient where refNumber=:refNumber");
		query.setString("refNumber", patRefNum);
		patient = (Patient) query.uniqueResult();
		System.out.println(patient.getEncounterList().size());
		Query encountersListQuery = session.createQuery("from Encounter where patientId=:patientId");
		encountersListQuery.setString("patientId", String.valueOf(patient.getPersonId()));
		ArrayList<Encounter> encList = (ArrayList<Encounter>) encountersListQuery.list();
		patient.setEncounterList(encList);
		tx.commit();
		session.close();
		return patient;
	}

}
