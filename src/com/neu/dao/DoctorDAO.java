package com.neu.dao;

import java.util.ArrayList;

import com.neu.model.Employee;
import com.neu.model.Encounter;
import com.neu.model.Patient;
import com.neu.model.WorkRequest;

public interface DoctorDAO {

	public abstract ArrayList<Employee> findAllDoctors(int roleId);

	public abstract ArrayList<Patient> findDoctorsPatients(int docId);

	public abstract ArrayList<Encounter> searchPatientByRefNum(String patRefNum);

	public abstract void updateDiagnosis(Encounter encounter);

	public abstract ArrayList<WorkRequest> createLabRequest(WorkRequest workRequest);

	public abstract ArrayList<WorkRequest> getPatientLabRequest(Encounter encounter);
}
