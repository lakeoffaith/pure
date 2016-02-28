package com.ijoy.gh.service;

import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.service.BaseCurdService;
import com.ijoy.gh.domain.Schedule;

public interface ScheduleService extends BaseCurdService<Schedule> {

	/**
	 * 查询排班表,条件为doctor,起始时间,可预约的天数
	 */
	public PageResult<Schedule>  querySchedules(BaseQuery baseQuery);


	


}
