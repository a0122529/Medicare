package com.neu.dao.impl;

import java.util.ArrayList;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.neu.dao.DAO;
import com.neu.dao.LabDAO;
import com.neu.model.Employee;
import com.neu.model.WorkRequest;

@Component
public class LabDAOImpl extends DAO implements LabDAO {

	@Override
	public ArrayList<WorkRequest> fetchLabRequest() {
		// TODO Auto-generated method stub
		ArrayList<WorkRequest> wr = new ArrayList<>();
		Session session = getSession();
		try {
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("from WorkRequest");
			wr = (ArrayList<WorkRequest>) query.list();
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		finally {
			session.close();
		}
		return wr;
	}
	
	
	@Override
	public ArrayList<WorkRequest> updateWorkReq(WorkRequest wr) {
		ArrayList<WorkRequest> wrList = new ArrayList<WorkRequest>();
		Session session = getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.merge(wr);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		
		return wrList;
	}

}
