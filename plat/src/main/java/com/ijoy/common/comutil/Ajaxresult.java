package com.ijoy.common.comutil;

import java.util.List;

public class Ajaxresult {
	public static int codeUrl=2;
	public Boolean success;
	public String msg;
	public int code;   //2表示msg返回为url
	public List results;
	public Object obj;
	
	
	public Ajaxresult(Boolean success, Object obj) {
		super();
		this.success = success;
		this.obj = obj;
	}
	public Ajaxresult(Boolean success, List results) {
		super();
		this.success = success;
		this.results = results;
	}
	public Ajaxresult() {
	}
	public Ajaxresult(Boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}

	public Ajaxresult(Boolean success, String msg, int code) {
		super();
		this.success = success;
		this.msg = msg;
		this.code = code;
	}
	
	
	
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public static int getCodeUrl() {
		return codeUrl;
	}
	public static void setCodeUrl(int codeUrl) {
		Ajaxresult.codeUrl = codeUrl;
	}
	public List getResults() {
		return results;
	}
	public void setResults(List results) {
		this.results = results;
	}
	
	
}
