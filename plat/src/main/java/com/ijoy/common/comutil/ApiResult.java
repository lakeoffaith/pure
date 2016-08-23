package com.ijoy.common.comutil;

import java.util.ArrayList;

public class ApiResult {
	private Boolean status;
	private String msg;
	private Object	ijoy;
	private String token;
	
	
	
	public ApiResult(Boolean status, Object ijoy) {
		super();
		this.status = status;
		this.ijoy = ijoy;
	}
	public ApiResult( String msg) {
		super();
		this.status = false;
		this.msg = msg;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getIjoy() {
		return ijoy;
	}
	public void setIjoy(Object ijoy) {
		this.ijoy = ijoy;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	
	
	
}
