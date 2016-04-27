package com.neu.model;

import java.util.ArrayList;

public class DrugFailure {

	private String dName;
	private ArrayList<String> failedComponents = new ArrayList<>();
	private boolean failure;

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public ArrayList<String> getFailedComponents() {
		return failedComponents;
	}

	public void setFailedComponents(ArrayList<String> failedComponents) {
		this.failedComponents = failedComponents;
	}

	public boolean isFailure() {
		return failure;
	}

	public void setFailure(boolean failure) {
		this.failure = failure;
	}

}
