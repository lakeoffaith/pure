package com.ijoy.common.domain;


/*
 * 用于用户的登录
 */
public class LoginInfo {
    private Long id;
	private String name;
	private String password;
	private int state=0; //0 表示正常，1表示已经登录  ,-1表示被禁用
	private int rememberdays=0;//默认为不记住密码
	
	public LoginInfo() {
	}
	public LoginInfo(String name, String password) {
		this.name = name;
		this.password = password;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	public int getRememberdays() {
		return rememberdays;
	}
	public void setRememberdays(int rememberdays) {
		this.rememberdays = rememberdays;
	}
	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", name=" + name + ", password="
				+ password + ", state=" + state + ", rememberdays="
				+ rememberdays + "]";
	}
		
}
