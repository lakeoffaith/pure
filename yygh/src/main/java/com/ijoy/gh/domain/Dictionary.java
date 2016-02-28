package com.ijoy.gh.domain;
/**
 * 词典
 * @author zhengang
 *
 */
public class Dictionary {
	private Long id;
	private String name;
	private String type;
	
	
	public Dictionary() {
	}
	public Dictionary(String name, String type) {
		super();
		this.name = name;
		this.type = type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
