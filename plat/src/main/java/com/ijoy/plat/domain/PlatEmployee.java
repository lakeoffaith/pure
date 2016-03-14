package com.ijoy.plat.domain;

import java.util.List;

import com.ijoy.common.domain.Employee;

public class PlatEmployee  extends Employee {
	
	
	public PlatEmployee() {
		super();
	}

	public PlatEmployee(long id) {
		super(id);
	}

	private List<Application> applicationList;

	public List<Application> getApplicationList() {
		return applicationList;
	}

	public void setApplicationList(List<Application> applicationList) {
		this.applicationList = applicationList;
	}
}
