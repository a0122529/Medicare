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
@Table(name = "allergies")
public class Allergies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int allergyId;
	
	private String name;
	

	public int getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(int allergyId) {
		this.allergyId = allergyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
