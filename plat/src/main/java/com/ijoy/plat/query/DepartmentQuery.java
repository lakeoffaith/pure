package com.ijoy.plat.query;

import com.ijoy.common.query.BaseQuery;

public class DepartmentQuery extends BaseQuery {
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DepartmentQuery [name=" + name + ", getPageSize()="
				+ getPageSize() + ", getCurrentPage()=" + getCurrentPage()
				+ "]";
	}
    

    
}
