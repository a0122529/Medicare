package com.neu.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "workRequest")
public class WorkRequest {

	public WorkRequest() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empId")
	private Employee employee;

	private String patientRefNum;

	private String attDoctor;

	private String testName;

	private String testResult;

	private String additionalInfo;

	private String date;

	private String status;

	private String testInstructions;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "encounterId")
	private Encounter encounter;

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public String getPatientRefNum() {
		return patientRefNum;
	}

	public void setPatientRefNum(String patientRefNum) {
		this.patientRefNum = patientRefNum;
	}

	public String getAttDoctor() {
		return attDoctor;
	}

	public void setAttDoctor(String attDoctor) {
		this.attDoctor = attDoctor;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getTestInstructions() {
		return testInstructions;
	}

	public void setTestInstructions(String testInstructions) {
		this.testInstructions = testInstructions;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
