package com.ijoy.common.query;

import java.util.ArrayList;
import java.util.List;


/**
 * 根据查询条件 如医院(list),科室分类 内科   排序  eg:预约人数 ,eg:好评
 */
public class DoctorQuery extends BaseQuery {
	/**
	 * 科室分类，
	 */
	private List types=new ArrayList<>();
	/*
	 * 医院list
	 */
	private List<Long> list=new ArrayList<>();
	/*
	 * 科室的id
	 */
	private Long departmentId;
	private String orderStr;

	private String name;


	public List getTypes() {
		return types;
	}

	public void setTypes(List types) {
		this.types = types;
	}

	public List<Long> getList() {
		return list;
	}

	public void setList(List<Long> list) {
		this.list = list;
	}

	public String getOrderStr() {
		return orderStr;
	}

	public void setOrderStr(String orderStr) {
		this.orderStr = orderStr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	

		

    

    
}
