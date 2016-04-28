package com.neu.dao.impl;

import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.neu.dao.DAO;
import com.neu.dao.DoctorDAO;
import com.neu.model.Diagnosis;
import com.neu.model.Employee;
import com.neu.model.Encounter;
import com.neu.model.Patient;
import com.neu.model.WorkRequest;

@Component
public class DoctorDAOImpl extends DAO implements DoctorDAO {

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Employee> findAllDoctors(int roleId) {
		// TODO Auto-generated method stub
		ArrayList<Employee> allDoctors = new ArrayList<>();
		Session session = getSession();
		try {
			Transaction tx = session.beginTransaction();

			Query query = session.createQuery("from Employee");
			// query.setInteger("roleId", roleId);
			allDoctors = (ArrayList<Employee>) query.list();
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return allDoctors;
	}

	@Override
	public ArrayList<Patient> findDoctorsPatients(int docId) {
		// TODO Auto-generated method stub
		ArrayList<Patient> allPatients = new ArrayList<>();
		Session session = getSession();
		Employee emp = new Employee();
		try {
			Transaction tx = session.beginTransaction();
			Query docQ = session.createQuery("from Employee where empId =:empId");
			docQ.setInteger("empId", docId);
			emp = (Employee) docQ.uniqueResult();
			Query query = session.createQuery("from Patient where docName =:docName");
			query.setString("docName", emp.getName());
			allPatients = (ArrayList<Patient>) query.list();
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();

		}
		return allPatients;
	}

	@Override
	public ArrayList<Encounter> searchPatientByRefNum(String patRefNum) {
		// TODO Auto-generated method stub
		Patient patient = new Patient();
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Patient where refNumber=:refNumber");
		query.setString("refNumber", patRefNum);
		patient = (Patient) query.uniqueResult();
		Query encountersListQuery = session.createQuery("from Encounter where patientId=:patientId");
		encountersListQuery.setString("patientId", String.valueOf(patient.getPersonId()));
		ArrayList<Encounter> encList = (ArrayList<Encounter>) encountersListQuery.list();
		tx.commit();
		session.close();
		return encList;
	}

	@Override
	public void updateDiagnosis(Encounter encounter) {

		Session session = getSession();
		try {
			Transaction tx = session.beginTransaction();
			encounter.setEncStatus("Closed");
			session.update(encounter);
			tx.commit();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<WorkRequest> createLabRequest(WorkRequest workRequest) {
		// TODO Auto-generated method stub
		System.out.println(workRequest.getPatientRefNum());
		ArrayList<WorkRequest> wr = new ArrayList<>();
		Session session = getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(workRequest);

			Query query = session.createQuery("from WorkRequest where encounterId =:encounterId");
			query.setInteger("encounterId", workRequest.getEncounter().getEncounterId());
			wr = (ArrayList<WorkRequest>) query.list();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			session.close();
		}
		return wr;
	}

	@Override
	public ArrayList<WorkRequest> getPatientLabRequest(Encounter encounter) {
		// TODO Auto-generated method stub
		ArrayList<WorkRequest> wr = new ArrayList<>();
		Session session = getSession();
		try {
			Query query = session.createQuery("from WorkRequest where encounterId =:encounterId");
			query.setInteger("encounterId", encounter.getEncounterId());
			wr = (ArrayList<WorkRequest>) query.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			session.close();
		}
		return wr;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Diagnosis> allDiagnosis() {
		ArrayList<Diagnosis> diagnosisList = new ArrayList<>();
		try {
			Query query = getSession().createQuery("from Diagnosis");
			diagnosisList = (ArrayList<Diagnosis>) query.list();
		} catch (Exception e) {

		} finally {
			getSession().close();
		}
		return diagnosisList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Encounter> findPatientEncUsingDiagnosis(Diagnosis diagnosis) {
		ArrayList<Encounter> patEncList = new ArrayList<>();
		try {
			Query query = getSession().createQuery("from Encounter where diagnosis =:diagnosis group by patientId");
			query.setString("diagnosis", diagnosis.getDiagnosisName());
			patEncList = (ArrayList<Encounter>) query.list();
		} catch (Exception e) {

		} finally {
			getSession().close();
		}
		return patEncList;
	}

	public Diagnosis findDiabObj(String diag) {
		Diagnosis diagnosis = new Diagnosis();
		try {
			Query query = getSession().createQuery("from Diagnosis where diagnosisName =:diagnosisName");
			query.setString("diagnosisName", diag);
			diagnosis = (Diagnosis) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			getSession().close();
		}
		return diagnosis;
	}

}
