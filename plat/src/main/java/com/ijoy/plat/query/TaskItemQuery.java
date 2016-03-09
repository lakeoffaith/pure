package com.ijoy.plat.query;



public class TaskItemQuery extends BaseQuery {
	private String name;

	//这个任务子项对应的责任人
	private Long employee_id;
	public Long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


    
}
