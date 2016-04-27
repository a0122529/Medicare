package com.neu.dao.impl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.neu.dao.DAO;
import com.neu.dao.NurseDAO;
import com.neu.model.Employee;
import com.neu.model.Encounter;
import com.neu.model.Patient;

@Component
public class NurseDAOImpl extends DAO implements NurseDAO {

	@Override
	public ArrayList<Employee> findSpecificEmployees(int roleId) {
		ArrayList<Employee> allDocs = new ArrayList<>();
		Session session = getSession();
		try {
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from Employee where roleId =:roleId");
			query.setInteger("roleId", roleId);
			allDocs.addAll(query.list());
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}

		return allDocs;
	}

	public Patient sendEmailToPatient(Patient patient) {
		Session session = getSession();
		Patient foundPatient = null;
		try {

			Query query = session.createQuery("from Patient where refNumber =:refNumber");
			query.setString("refNumber", patient.getRefNumber());
			foundPatient = (Patient) query.uniqueResult();
			Query encQuery = session.createQuery("from Encounter where patientId =:patId order by encounterId DESC");
			encQuery.setInteger("patId", foundPatient.getPersonId());
			Encounter encounter = (Encounter) encQuery.list().get(0);
			
			patient.getEncounterList().add(encounter);
			patient.setName(foundPatient.getName());
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return patient;
	}

}
