package com.neu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "drugs")
public class Drugs {

	public Drugs() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int drugId;

	private String drugName;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "drugComponents")
	private List<String> drugComponents;

	@ManyToMany(targetEntity=Encounter.class, mappedBy = "drugs")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Encounter> encounters;

	public List<String> getDrugComponents() {
		return drugComponents;
	}

	public void setDrugComponents(List<String> drugComponents) {
		this.drugComponents = drugComponents;
	}

	public int getDrugId() {
		return drugId;
	}

	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

//	public Set<Encounter> getEncounters() {
//		return encounters;
//	}
//
//	public void setEncounters(Set<Encounter> encounters) {
//		this.encounters = encounters;
//	}

	public List<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

}
