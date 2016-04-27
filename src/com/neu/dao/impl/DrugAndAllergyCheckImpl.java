package com.neu.dao.impl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.neu.dao.DAO;
import com.neu.model.DrugFailure;
import com.neu.model.Drugs;
import com.neu.model.Encounter;

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

	public ArrayList<DrugFailure> drugAllergyCheck(Encounter encounter) {
		boolean fail = false;
		ArrayList<DrugFailure> dfList = new ArrayList<>();
		String[] allergy = encounter.getAllergy().getName().split(",");
		for (Drugs drug : encounter.getDrugs()) {
			DrugFailure df = new DrugFailure();
			for (String comp : drug.getDrugComponents()) {
				for (String all : allergy) {
					if (comp.equalsIgnoreCase(all)) {
						df.setdName(drug.getDrugName());
						df.getFailedComponents().add(comp);
						fail = true;
					}
				}
			}
			if (fail == true) {
				dfList.add(df);
				fail = false;
			}
		}
		Session session = getSession();
		try {
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from Encounter where encounterId =:encounterId");
		
			query.setInteger("encounterId", encounter.getEncounterId());
			Encounter enc = (Encounter) query.uniqueResult();
			// enc.setDrugs(encounter.getDrugs());
			if (dfList.isEmpty()) {
				session.merge(enc);
				tx.commit();
			} else {
				for (Drugs drug : encounter.getDrugs()) {
					for (DrugFailure df : dfList) {
						if (!drug.getDrugName().equalsIgnoreCase(df.getdName())) {
						}
					}
				}
				session.merge(enc);
				tx.commit();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return dfList;
	}

	// public void drugAllergyCheck() {
	// try {
	// Transaction tx = getSession().beginTransaction();
	// Query q = getSession().createQuery("from Encounter where encounterId
	// =:encounterId");
	// q.setInteger("encounterID", 1);
	// Encounter enc = (Encounter) q.uniqueResult();
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// finally {
	// getSession().close();
	// }
	// }
}
