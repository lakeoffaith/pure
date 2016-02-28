package com.ijoy.gh.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ijoy.common.domain.Doctor;

/**
 * 
 * @author zhengang
 * 预约挂号中，每个医生的排班
 */
public class Schedule {
	public static final int FORENOON=0;
	public static final int AFTERNOON=1;
	private Long id;
	private Doctor doctor;
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date date;
	private int numbers;//每次排班的号源个数
	private BigDecimal cost;
	private int residueNumbers;   //每次排班剩余多少个号
	private int noonType;  //上午下午
	
	
	
	
	
	public Schedule(Doctor doctor, Date date, int numbers, BigDecimal cost, int noonType) {
		super();
		this.doctor = doctor;
		this.date = date;
		this.numbers = numbers;
		this.cost = cost;
		this.noonType = noonType;
	}
	public Schedule() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public int getResidueNumbers() {
		return residueNumbers;
	}
	public void setResidueNumbers(int residueNumbers) {
		this.residueNumbers = residueNumbers;
	}
	public int getNoonType() {
		return noonType;
	}
	public void setNoonType(int noonType) {
		this.noonType = noonType;
	}
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", date=" + date + ", numbers=" + numbers
				+ ", cost=" + cost + ", residueNumbers=" + residueNumbers
				+ ", noonType=" + noonType + "]";
	}
	
	
	
}
