package com.neu.dao.impl;

import java.util.ArrayList;
import java.util.LinkedList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.neu.dao.DAO;
import com.neu.dao.PatientDAO;
import com.neu.model.Allergies;
import com.neu.model.Employee;
import com.neu.model.Encounter;
import com.neu.model.Medications;
import com.neu.model.Patient;
import com.neu.model.Person;
import com.neu.model.Symptoms;
import com.neu.model.VitalSign;

@Component
public class PatientDAOImpl extends DAO implements PatientDAO {

	@Override
	public void addPatient(Patient patient) {

		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.save(patient);
		tx.commit();
		session.close();
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
		tx.commit();
		session.close();
		return patient;
	}

	@SuppressWarnings("unchecked")
	@Override
	public LinkedList<Patient> searchPatientByPrimDocId(int docId) {
		// TODO Auto-generated method stub
		LinkedList<Patient> patientList = new LinkedList<>();
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Patient where empId =:docId");
		query.setInteger("empId", docId);
		patientList = (LinkedList<Patient>) query.list();
		tx.commit();
		session.close();
		return patientList;

	}

	@Override
	public void addPatientEncounter(Patient patient) {
		System.out.println("Atleast reached here");
		Encounter encounter = patient.getEncounterList().get(0);
		Allergies allergy = encounter.getAllergy();
		Medications med = encounter.getMedication();
		Symptoms sym = encounter.getSymptom();
		VitalSign vitalSign = encounter.getVitalSign();
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Query findPatient = session.createQuery("from Patient where refNumber=:refNumber");
		findPatient.setString("refNumber", patient.getRefNumber());
		Patient foundPatient = (Patient) findPatient.uniqueResult();
		session.save(allergy);
		session.save(med);
		session.save(sym);
		session.save(vitalSign);
		encounter.setEncStatus("Open");
		encounter.setAllergy(allergy);
		encounter.setSymptom(sym);
		encounter.setMedication(med);
		encounter.setVitalSign(vitalSign);
		encounter.setPatient(foundPatient);
		session.save(encounter);
		if (!tx.wasCommitted()) {
			tx.commit();
		}
		session.close();

	}

}
