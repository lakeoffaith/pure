package com.ijoy.plat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Application {
	private Long id;
	private String name;
	private String brief="";
	private Date starttime=new Date();
	private Date endtime=new Date();
	private int state;
	private String docpath="";
	private String url="";
	private List<PlatEmployee> employeeList=new ArrayList();
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
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getDocpath() {
		return docpath;
	}
	public void setDocpath(String docpath) {
		this.docpath = docpath;
	}
	
	public List<PlatEmployee> getPlatEmployeeList() {
		return employeeList;
	}
	public void setPlatEmployeeList(List<PlatEmployee> employeeList) {
		this.employeeList = employeeList;
	}
	
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Application [id=" + id + ", name=" + name + ", brief=" + brief
				+ ", starttime=" + starttime + ", endtime=" + endtime
				+ ", state=" + state + ", docpath=" + docpath
				+ ", employeeList=" +employeeList.size() + "]";
	}
	
}
