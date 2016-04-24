package com.neu.dao.impl;

import com.neu.dao.DrugAndAllergyCheckDAO;
import com.neu.model.Drugs;

public class DrugAndAllergyCheckImpl implements DrugAndAllergyCheckDAO {

	@Override
	public boolean drugDrugInteraction(Drugs drug1, Drugs drug2) {
		
		return false;
	}

}
