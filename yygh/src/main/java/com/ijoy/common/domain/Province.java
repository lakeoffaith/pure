package com.ijoy.common.domain;

public class Province {
	private String name;
	private Long region_id;
	private Long id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getRegion_id() {
		return region_id;
	}
	public void setRegion_id(Long region_id) {
		this.region_id = region_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Province [name=" + name + ", region_id=" + region_id + ", id=" + id + "]";
	}
	
	
}
