package com.ijoy.common.domain;


public class Employee {
	private Long id;
	private String name;
	private String password;
	private String email;
	private String realName;
	private String cellphone;
	private String homePath;
	private String idCardNo;  //身份证号
	private String  healthInsuranceCardType;   //医保卡类型
	private String  healthInsuranceCardNo;
	
	
	
	
	public Employee() {
		super();
	}
	
	
	
	
	public Employee(String name, String password, String email, String realName, String cellphone, String homePath,
			String idCardNo, String healthInsuranceCardType, String healthInsuranceCardNo) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.realName = realName;
		this.cellphone = cellphone;
		this.homePath = homePath;
		this.idCardNo = idCardNo;
		this.healthInsuranceCardType = healthInsuranceCardType;
		this.healthInsuranceCardNo = healthInsuranceCardNo;
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
	public String getHealthInsuranceCardType() {
		return healthInsuranceCardType;
	}
	public void setHealthInsuranceCardType(String healthInsuranceCardType) {
		this.healthInsuranceCardType = healthInsuranceCardType;
	}
	public String getHealthInsuranceCardNo() {
		return healthInsuranceCardNo;
	}
	public void setHealthInsuranceCardNo(String healthInsuranceCardNo) {
		this.healthInsuranceCardNo = healthInsuranceCardNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getHomePath() {
		return homePath;
	}
	public void setHomePath(String homePath) {
		this.homePath = homePath;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", password="
				+ password + ", email=" + email + ", realName=" + realName
				+ ", cellphone=" + cellphone + ", homePath=" + homePath
				+ ", idCardNo=" + idCardNo + ", healthInsuranceCardType="
				+ healthInsuranceCardType + ", healthInsuranceCardNo="
				+ healthInsuranceCardNo + "]";
	}
	
	
}
