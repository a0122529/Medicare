package com.neu.dao;

import org.apache.log4j.Logger;

import com.neu.model.Login;

public interface LoginDAO {

	final static Logger logger = Logger.getLogger(LoginDAO.class);

	public Login fetchLoginInfo(Login login);

}
