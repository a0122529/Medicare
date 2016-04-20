package com.neu.dao;

import java.util.ArrayList;

import com.neu.model.Employee;
import com.neu.model.Patient;

public interface DoctorDAO {

	public abstract ArrayList<Employee> findAllDoctors(int roleId);

	public abstract ArrayList<Patient> findDoctorsPatients(int docId);

	public Patient searchPatientByRefNum(String patRefNum);

}
