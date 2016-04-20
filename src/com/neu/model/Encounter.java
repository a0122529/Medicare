package com.neu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "encounter")
public class Encounter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int encounterId;

	private String chiefComplaint;

	private String diagnosis;

	private String attDoctor;

	public List<Allergies> getAllergiyList() {
		return allergiyList;
	}

	public void setAllergiyList(List<Allergies> allergiyList) {
		this.allergiyList = allergiyList;
	}

	public List<Symptoms> getSymptomsList() {
		return symptomsList;
	}

	public void setSymptomsList(List<Symptoms> symptomsList) {
		this.symptomsList = symptomsList;
	}

	public List<Medications> getMedList() {
		return medList;
	}

	public void setMedList(List<Medications> medList) {
		this.medList = medList;
	}

	@Transient
	private VitalSign vitalSign;

	public VitalSign getVitalSign() {
		return vitalSign;
	}

	public void setVitalSign(VitalSign vitalSign) {
		this.vitalSign = vitalSign;
	}

	@Transient
	@OneToMany(mappedBy = "encounter", fetch = FetchType.EAGER)
	private List<Allergies> allergiyList = new ArrayList<>();

	@Transient
	@OneToMany(mappedBy = "encounter", fetch = FetchType.EAGER)
	private List<Symptoms> symptomsList = new ArrayList<>();

	@Transient
	@OneToMany(mappedBy = "encounter", fetch = FetchType.EAGER)
	private List<Medications> medList = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientId")
	private Patient patient;

	public Encounter() {

	}

	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getAttDoctor() {
		return attDoctor;
	}

	public void setAttDoctor(String attDoctor) {
		this.attDoctor = attDoctor;
	}

	public int getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(int encounterId) {
		this.encounterId = encounterId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
