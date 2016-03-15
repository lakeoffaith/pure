package com.ijoy.common.query;



public class RoleQuery extends BaseQuery {
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RoleQuery [name=" + name + "]";
	}


    
}
