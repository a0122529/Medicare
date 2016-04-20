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
@Table(name = "symptoms")
public class Symptoms {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int symId;

	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "encounterId")
	private Encounter encounter;

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public int getSymId() {
		return symId;
	}

	public void setSymId(int symId) {
		this.symId = symId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
