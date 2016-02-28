package com.ijoy.gh.domain;

import java.util.Date;

import com.ijoy.common.domain.Department;
import com.ijoy.common.domain.Doctor;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.domain.Hospital;


/**
 * 
 * @author zhengang
 *  预约单
 */
public class OrderItem {
	public final static int ORDER_STATE_CANCLE=4;//预约用户取消
	public final static int ORDER_STATE_SUCCESS=3;  //预约成功
	public final static int ORDER_STATE_SURE=2;;  //确定预约
	public final static int ORDER_STATE_CREATE=1;  //创建预约
	public final static int ORDER_SCORE_NOT=-1;  //没有评分
	private Long id;
	private Hospital hospital;
	private Department department;
	private Doctor doctor;
	private Schedule schedule;   //医生排班中的号源
	private Date date;
	private int orderNum;    //当天的序号
	private int state;        //预约状态
	private String takePassword;  //取号密码
	private Employee employee;
	private int score;     //这条预约的评分
	private String message;  //这条预约的评价
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getTakePassword() {
		return takePassword;
	}
	public void setTakePassword(String takePassword) {
		this.takePassword = takePassword;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	
}
