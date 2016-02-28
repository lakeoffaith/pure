package com.ijoy.common.query;

public class CityQuery  extends BaseQuery{
	//热门等级
	private Long  level;
    private String conditionStr;
    
    
    
	public Long getLevel() {
		return level;
	}
	public void setLevel(Long level) {
		this.level = level;
	}
	public String getConditionStr() {
		return conditionStr;
	}
	public void setConditionStr(String conditionStr) {
		this.conditionStr = conditionStr;
	}
	
	
}
