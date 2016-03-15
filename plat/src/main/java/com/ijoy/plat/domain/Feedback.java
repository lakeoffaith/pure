package com.ijoy.plat.domain;

import java.util.Date;

public class Feedback {
	private Long id;
	private String content="";
	private Date time=new Date();
	private PlatEmployee employee;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public PlatEmployee getPlatEmployee() {
		return employee;
	}
	public void setPlatEmployee(PlatEmployee employee) {
		this.employee = employee;
	}
	
}
