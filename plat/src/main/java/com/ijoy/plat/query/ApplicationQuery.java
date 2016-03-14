package com.ijoy.plat.query;

import com.ijoy.common.query.BaseQuery;

public class ApplicationQuery extends BaseQuery {
	private String name;
    private Long employee_id;  //分配此应用的用户id。
    private Long notEmployee_id ; //未分配此应用的用户id:
    
    
	public Long getNotEmployee_id() {
		return notEmployee_id;
	}

	public void setNotEmployee_id(Long notEmployee_id) {
		this.notEmployee_id = notEmployee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}



    
}
