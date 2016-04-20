package com.neu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.log4j.Logger;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "patient")
@AttributeOverrides({ @AttributeOverride(name = "personId", column = @Column(name = "patientId")),
		@AttributeOverride(name = "name", column = @Column(name = "name")),
		@AttributeOverride(name = "gender", column = @Column(name = "gender")),
		@AttributeOverride(name = "dob", column = @Column(name = "dob")),
		@AttributeOverride(name = "age", column = @Column(name = "age")) })
public class Patient extends Person {

	final static Logger logger = Logger.getLogger(Patient.class);

	private String ethnicity;

	private String docName;

	private String smoking;

	private String address;

	private String refNumber;

	private String phone;

	// @OneToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name = "insuranceId")
	// private Insurance insurance;

	// @OneToOne(fetch = FetchType.EAGER)
	// @JoinColumn(name = "empId")
	// private Employee primaryDoc;

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Transient
	@OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
	private List<Encounter> encounterList;

	public List<Encounter> getEncounterList() {
		return encounterList;
	}

	public void setEncounterList(List<Encounter> encounterList) {
		this.encounterList = encounterList;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public String getRefNumber() {
		return refNumber;
	}

	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
