package com.ijoy.plat.query;

/**
 * 
 */
public class EmployeeQuery extends BaseQuery {
	private String name;
	private String email;
	private Long deptId;

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

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "EmployeeQuery [name=" + name + ", email=" + email + ", deptId=" + deptId + ", getEndNum()="
				+ getEndNum() + ", getStartNum()=" + getStartNum() + "]";
	}

	
	
}
