package com.ijoy.common.domain;

public class Doctor {
	private Long id;
	private String name;
	private String pic;
	private Department department;
	private Hospital hospital;
	private String introduce;
	private Long ghTotal;    //成功挂号的数量
	private Long ghHighScore;   //好评数量
	
	
	
	
	public Doctor() {
		super();
	}
	public Doctor(Long id, String name, String pic ,Department department, String introduce,
			Long ghTotal, Long ghHighScore) {
		super();
		this.id = id;
		this.name = name;
		this.pic = pic;
		this.department = department;
		this.introduce = introduce;
		this.ghTotal = ghTotal;
		this.ghHighScore = ghHighScore;
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
	public String getPic() {
		return "images/gh/doc1.jpg";
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
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
	
	
	
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", pic=" + pic + ", department=" + department + ", hospital="
				+ hospital + ", introduce=" + introduce + ", ghTotal=" + ghTotal + ", ghHighScore=" + ghHighScore + "]";
	}
	
}
