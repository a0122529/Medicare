package com.neu.dao;

import java.util.ArrayList;

import com.neu.model.Employee;

public interface NurseDAO {

	
	public abstract ArrayList<Employee> findSpecificEmployees(int roleId);
}
