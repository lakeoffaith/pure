package com.ijoy.common.domain;

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

	
	
	public Employee() {
		super();
	}
	public Employee(long id) {
		this.id=id;
	}
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
	
	
	

	
}
