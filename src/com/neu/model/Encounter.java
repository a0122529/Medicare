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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "encounter")
public class Encounter {

	public Encounter() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int encounterId;

	public List<WorkRequest> getLabTestList() {
		return labTestList;
	}

	public void setLabTestList(List<WorkRequest> labTestList) {
		this.labTestList = labTestList;
	}

	private String chiefComplaint;

	private String diagnosis;

	@Transient
	private String encStatus;

	private String attDoctor;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vitalId")
	private VitalSign vitalSign;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "allergyId")
	private Allergies allergy;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "symId")
	private Symptoms symptom;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medId")
	private Medications medication;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientId")
	private Patient patient;

	@Transient
	@OneToMany(mappedBy = "encounter", fetch = FetchType.EAGER)
	private List<WorkRequest> labTestList = new ArrayList<>();

	public Allergies getAllergy() {
		return allergy;
	}

	public void setAllergy(Allergies allergy) {
		this.allergy = allergy;
	}

	public Symptoms getSymptom() {
		return symptom;
	}

	public void setSymptom(Symptoms symptom) {
		this.symptom = symptom;
	}

	public Medications getMedication() {
		return medication;
	}

	public void setMedication(Medications medication) {
		this.medication = medication;
	}

	public VitalSign getVitalSign() {
		return vitalSign;
	}

	public void setVitalSign(VitalSign vitalSign) {
		this.vitalSign = vitalSign;
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
