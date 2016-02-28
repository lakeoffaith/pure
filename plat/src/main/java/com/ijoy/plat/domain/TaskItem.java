package com.ijoy.plat.domain;


public class TaskItem {
	private Long id;
	private int itemCycle;
	private int itemtype;
	private String itemdescribe;
	private String department;
	private int state=0;  //0 创建状态  1 认领状态  2  完成状态     -1非正常关闭状态
	private Employee employee;
	private Long task_id;    //归属于的任务id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getItemCycle() {
		return itemCycle;
	}
	public void setItemCycle(int itemCycle) {
		this.itemCycle = itemCycle;
	}
	public int getItemtype() {
		return itemtype;
	}
	public void setItemtype(int itemtype) {
		this.itemtype = itemtype;
	}
	public String getItemdescribe() {
		return itemdescribe;
	}
	public void setItemdescribe(String itemdescribe) {
		this.itemdescribe = itemdescribe;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Long getTask_id() {
		return task_id;
	}
	public void setTask_id(Long task_id) {
		this.task_id = task_id;
	}
	@Override
	public String toString() {
		return "TaskItem [id=" + id + ", itemCycle=" + itemCycle
				+ ", itemtype=" + itemtype + ", itemdescribe=" + itemdescribe
				+ ", department=" + department + ", state=" + state
				+ ", employee=" + employee + ", task_id=" + task_id + "]";
	}
	
		
	
	
}
