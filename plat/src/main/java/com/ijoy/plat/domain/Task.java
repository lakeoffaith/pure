package com.ijoy.plat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {
	private Long id;
	private int month;
	private String name="";
	private int taskcycle;
	private String describe="";
	private int type;
	private int state;
	private Date starttime=new Date();
	private Date endtime=new Date();
	private PlatEmployee employee=new PlatEmployee(1L);
	private List<TaskItem> taskItems=new ArrayList();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTaskcycle() {
		return taskcycle;
	}
	public void setTaskcycle(int taskcycle) {
		this.taskcycle = taskcycle;
	}
	public String getDesc() {
		return describe;
	}
	public void setDesc(String describe) {
		this.describe = describe;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public PlatEmployee getPlatEmployee() {
		return employee;
	}
	public void setPlatEmployee(PlatEmployee employee) {
		this.employee = employee;
	}
	
	
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public List<TaskItem> getTaskItems() {
		return taskItems;
	}
	public void setTaskItems(List<TaskItem> taskItems) {
		this.taskItems = taskItems;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", month=" + month + ", name=" + name
				+ ", taskcycle=" + taskcycle + ", describe=" + describe
				+ ", type=" + type + ", state=" + state + ", starttime="
				+ starttime + ", endtime=" + endtime + ", employee=" + employee
				+ ", taskItems=" + taskItems.size() + "]";
	}
	
	
}
