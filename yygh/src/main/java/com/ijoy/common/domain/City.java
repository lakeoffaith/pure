package com.ijoy.common.domain;

public class City {
	/**
	 * HOT_LEVEL_ONE 表示最热门
	 */
	public static final Long HOT_LEVEL_ONE=1L;
	private Long id;
	private Long province_id;
	private String name;
	private String pinyin;
	private String zip;
	private Long  level;     //level  为1表示热门
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProvince_id() {
		return province_id;
	}
	public void setProvince_id(Long province_id) {
		this.province_id = province_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
	
	public Long getLevel() {
		return level;
	}
	public void setLevel(Long level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", province_id=" + province_id + ", name=" + name + ", pinyin=" + pinyin + ", zip="
				+ zip + "]";
	}
	
}
