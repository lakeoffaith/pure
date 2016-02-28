package com.ijoy.gh.query;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.ijoy.common.query.BaseQuery;


public class ScheduleQuery extends BaseQuery {
	private   final static Long DAYS_DEAFAULT=7L;    //默认七天
	
	private Long doctor_id;  //医生
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date startDate; //起始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date endDate; //起始时间
	private Long days;
	
	
	public ScheduleQuery() {
		super();
	}
	public ScheduleQuery(Long doctor_id, Date startDate, Date endDate, Long days) {
		this.doctor_id=doctor_id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.days = days;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		if(this.endDate==null)return DateUtils.addDays(this.startDate, this.DAYS_DEAFAULT.intValue());
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Long getDays() {
		if(days==null)return this.DAYS_DEAFAULT;
		
		return days;
	}
	public void setDays(Long days) {
		this.days = days;
	}
	public Long getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Long doctor_id) {
		this.doctor_id = doctor_id;
	}
	
}
