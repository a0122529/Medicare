package com.neu.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.neu.dao.DAO;
import com.neu.dao.LoginDAO;
import com.neu.model.Login;

@Component
public class LoginDAOImpl extends DAO implements LoginDAO {
	// User login = null;

	final static Logger logger = Logger.getLogger(LoginDAOImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public Login fetchLoginInfo(Login login) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Login where username =:username and password =:password");
		query.setString("username", login.getUsername());
		query.setString("password", login.getPassword());
		login = (Login) query.uniqueResult();
		if (login.getRole().getRoleName().equalsIgnoreCase("doctor")) {
			Query queryPatients = session.createQuery("from Patient");
			login.getEmployee().setPatientList(queryPatients.list());
		}

		session.close();
		tx.commit();
		return login;

	}

}
