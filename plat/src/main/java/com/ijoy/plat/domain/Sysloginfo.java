package com.ijoy.plat.domain;

import java.util.Date;

public class Sysloginfo {
	private Long id;
	private int type=0;
	private String content;
	private Date lastLoginTime;
	private Date lastExitTime;
	private Date currentLoginTime;
	private Date currentExitTime;
	private String ip;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Date getLastExitTime() {
		return lastExitTime;
	}
	public void setLastExitTime(Date lastExitTime) {
		this.lastExitTime = lastExitTime;
	}
	public Date getCurrentLoginTime() {
		if(currentLoginTime==null){
			return new Date();
		}
		return currentLoginTime;
	}
	public void setCurrentLoginTime(Date currentLoginTime) {
		this.currentLoginTime = currentLoginTime;
	}
	public Date getCurrentExitTime() {
		if(currentExitTime==null){
			return new Date();
		}
		return currentExitTime;
	}
	public void setCurrentExitTime(Date currentExitTime) {
		this.currentExitTime = currentExitTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	@Override
	public String toString() {
		return "Sysloginfo [id=" + id + ", type=" + type + ", content="
				+ content + ", lastLoginTime=" + lastLoginTime
				+ ", lastExitTime=" + lastExitTime + ", currentLoginTime="
				+ currentLoginTime + ", currentExitTime=" + currentExitTime
				+ ", ip=" + ip + "]";
	}
	
}
