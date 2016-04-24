package com.neu.dao;

import com.neu.model.Drugs;

public interface DrugAndAllergyCheckDAO {

	public abstract boolean drugDrugInteraction(Drugs drug1, Drugs drug2);
	
}
