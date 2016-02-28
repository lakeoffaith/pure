package com.ijoy.common.query;

import java.util.ArrayList;
import java.util.List;

/*
 * 科室查询的查询条件
 * 根据查询条件 如 省份,城市,区域,级别,类型  排序  eg:预约人数 ,eg:好评
 */
public class HospitalQuery extends BaseQuery {
	private String province ;   //省份
	private Long  cityId;     //城市ID
	private String district;  //区域
	private List  types=new ArrayList<>();   //类型
	private List  levels=new ArrayList<>();  //级别
	
	private String orderStr;//排序   ghTotal,ghHighScore,count
	private String name;
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}

	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	

	

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
	@Override
	public String toString() {
		return "HospitalQuery [province=" + province + ", cityId=" + cityId + ", district=" + district + ", types="
				+ types + ", levels=" + levels + ", orderStr=" + orderStr + ", name=" + name + "]";
	}
	
	


    

    
}
