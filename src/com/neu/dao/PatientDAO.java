package com.neu.dao;

import java.util.LinkedList;

import com.neu.model.Allergies;
import com.neu.model.Employee;
import com.neu.model.Encounter;
import com.neu.model.Medications;
import com.neu.model.Patient;
import com.neu.model.Person;
import com.neu.model.Symptoms;
import com.neu.model.VitalSign;

public interface PatientDAO {

	public void addPatient(Patient patient);

	public void addPatientEncounter(Patient patient);

	public Patient searchPatientByRefNum(String patRefNum);

	public LinkedList<Patient> searchPatientByPrimDocId(int DocId);

}
