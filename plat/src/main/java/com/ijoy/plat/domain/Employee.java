package com.ijoy.plat.domain;

import java.util.List;


public class Employee {
	private Long id;
	private String name;
	private String email;
	private String realName;
	private String cellphone;
	private String department;
	private String homePath;
	private String workPath;
	private Role role;
	private List<Application> applicationList;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getHomePath() {
	
		return homePath;
	}
	public void setHomePath(String homePath) {
		
		this.homePath = homePath;
	}
	public String getWorkPath() {
		return workPath;
	}
	public void setWorkPath(String workPath) {
		this.workPath = workPath;
	}
	
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	public List<Application> getApplicationList() {
		return applicationList;
	}
	public void setApplicationList(List<Application> applicationList) {
		this.applicationList = applicationList;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email
				+ ", realName=" + realName + ", cellphone=" + cellphone
				+ ", department=" + department + ", homePath=" + homePath
				+ ", workPath=" + workPath + ", role=" + (role==null?null:role.getId())
				+ ", applicationList=" + applicationList + "]";
	}

	
}
