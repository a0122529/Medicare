package com.neu.dao.impl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.neu.dao.DAO;
import com.neu.model.Drugs;


@Component
public class DrugAndAllergyCheckImpl extends DAO {

	public boolean drugDrugInteraction(Drugs drug1, Drugs drug2) {

		return false;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Drugs> getAllDrugs() {
		ArrayList<Drugs> drugList = null;
		Session session = getSession();
		try {
			Query query = session.createQuery("from Drugs");
			drugList = (ArrayList<Drugs>) query.list();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return drugList;
	}
	
	public boolean drugAllergyCheck(){
		
		
		return false;
	}

}
