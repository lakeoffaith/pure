package com.ijoy.common.query;

import java.util.ArrayList;
import java.util.List;


/*
 * 科室查询的查询条件
 * 如医院(list),科室,科室分类 内科,国家级别  eg:国家重点   排序  eg:预约人数 ,eg:好评
 */
public class DepartmentQuery extends BaseQuery {
	private List types=new ArrayList<>();
	private List  levels=new ArrayList<>();
	
	private Long hosId;
	/*
	 * 医院list
	 */
	private List<Long> list=new ArrayList<>();
	
	private String orderStr;

	private String name;

	


	public List getTypes() {
		return types;
	}

	public void setTypes(List types) {
		this.types = types;
	}

	public List getLevels() {
		return levels;
	}

	public void setLevels(List levels) {
		this.levels = levels;
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

	public Long getHosId() {
		return hosId;
	}

	public void setHosId(Long hosId) {
		this.hosId = hosId;
	}

	
	
	


    

    
}
