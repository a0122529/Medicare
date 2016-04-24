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
@Table(name = "medication")
public class Medications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medId;

	private String name;


	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
