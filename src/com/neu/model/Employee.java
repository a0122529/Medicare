package com.neu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.log4j.Logger;

@Entity
@Table(name = "employee")
@AttributeOverrides({ @AttributeOverride(name = "personId", column = @Column(name = "empId")),
		@AttributeOverride(name = "name", column = @Column(name = "name")),
		@AttributeOverride(name = "gender", column = @Column(name = "gender")),
		@AttributeOverride(name = "dob", column = @Column(name = "dob")),
		@AttributeOverride(name = "age", column = @Column(name = "age")) })
public class Employee extends Person {

	final static Logger logger = Logger.getLogger(Employee.class);

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleId")
	private Role role;

	@Transient
	private List<Patient> patientList;

	public List<Patient> getPatientList() {
		return patientList;
	}
	
	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	private String workplace;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

}
