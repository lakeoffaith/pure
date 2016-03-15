package com.ijoy.common.domain;

/*
 * 为挂号中的科室  domain
 */
public class Department {
	public static final Long  TYPE_COLLECT = 1l;
	private Long id;
	private String code;
	private String pinyin;
	private String type;   
	private String level;   
	private String pic;
	private String phone;
	private String name;
	private Hospital hospital;
	private String message;   //简介
	private Long ghTotal=0L;    //成功挂号的数量
	private Long ghHighScore=0L;   //好评数量
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getPic() {
		if(pic ==null){
			return "images/gh/dep1.jpg";
		}
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getGhTotal() {
		return ghTotal;
	}
	public void setGhTotal(Long ghTotal) {
		this.ghTotal = ghTotal;
	}
	public Long getGhHighScore() {
		return ghHighScore;
	}
	public void setGhHighScore(Long ghHighScore) {
		this.ghHighScore = ghHighScore;
	}
	
	
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", code=" + code + ", pinyin=" + pinyin + ", type=" + type + ", level=" + level
				+ ", pic=" + pic + ", phone=" + phone + ", name=" + name + ", hospital=" + hospital + ", message="
				+ message + ", ghTotal=" + ghTotal + ", ghHighScore=" + ghHighScore + "]";
	}
	
	
	
	
	
}
