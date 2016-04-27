package com.neu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int diagId;

	private String diagnosisName;
	
	private String edulink;

	public Diagnosis() {

	}

	public int getDiagId() {
		return diagId;
	}

	public void setDiagId(int diagId) {
		this.diagId = diagId;
	}

	public String getDiagnosisName() {
		return diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	public String getEdulink() {
		return edulink;
	}

	public void setEdulink(String edulink) {
		this.edulink = edulink;
	}

}
