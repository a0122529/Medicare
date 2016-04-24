package com.neu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drugs")
public class Drugs {

	public Drugs() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String drugName;

	@ElementCollection
	@CollectionTable(name = "drugComponents")
	private List<String> drugComponents = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public List<String> getDrugComponents() {
		return drugComponents;
	}

	public void setDrugComponents(List<String> drugComponents) {
		this.drugComponents = drugComponents;
	}

}
