package com.ijoy.gh.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.gh.domain.Schedule;
import com.ijoy.gh.query.ScheduleQuery;
import com.ijoy.gh.service.ScheduleService;

public class ScheduleServiceTest  extends BaseTest{
	@Autowired 
	ScheduleService scheduleService;
	
	/**
	 * 查询排班表,条件为doctor,起始时间,可预约的天数
	 * @throws ParseException 
	 */
	@Test
	public void querySchedules() throws ParseException{
		ScheduleQuery scheduleQuery=new ScheduleQuery();
	/*	scheduleQuery.setDoctorId(1L);
		scheduleQuery.setStartDate(new SimpleDateFormat("YYYY/mm/DD").parse("2015/12/12"));
		List<Schedule> querySchedules = scheduleService.querySchedules(scheduleQuery);
		logger.debug("querySchedules::"+querySchedules);*/
	}
	
}
