package com.neu.dao;

import java.util.ArrayList;

import com.neu.model.Employee;
import com.neu.model.WorkRequest;

public interface LabDAO {

	
	public abstract ArrayList<WorkRequest> fetchLabRequest();

	public abstract ArrayList<WorkRequest> updateWorkReq(WorkRequest wr);
	
	

	
}
