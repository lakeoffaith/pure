package com.ijoy.yzjc.query;

import java.util.Date;

/**
 * 收入查询
 * 	 条件起止时间段
 * 	 section 范围 全院，科室，门诊，急诊，住院收入
 * @author ijoy
 *
 */
public class WorkLoadQuery {

	private Date startTime;
	private Date endTime;
	private String section;
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}

}
