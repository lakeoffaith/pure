package com.ijoy.gh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.gh.domain.Schedule;
import com.ijoy.gh.mapper.ScheduleMapper;
import com.ijoy.gh.service.ScheduleService;

@Service
public class ScheduleServiceImpl  implements ScheduleService {
	@Autowired
	private ScheduleMapper scheduleMapper;
	@Override
	public void save(Schedule schedule) {
		 scheduleMapper.insert(schedule);
	}

	@Override
	public void delete(Long id) {
		scheduleMapper.delete(id);
	}

	@Override
	public void update(Schedule schedule) {
		scheduleMapper.update(schedule);
	}

	@Override
	public Schedule get(Long id) {
		return scheduleMapper.get(id);
	}

	@Override
	public PageResult<Schedule> querySchedules(BaseQuery baseQuery) {
		Long totalCount=scheduleMapper.queryTotalCount(baseQuery);
		if(totalCount>0){
			List<Schedule>  rows=scheduleMapper.queryRows(baseQuery);
			return new PageResult<>(totalCount, rows, baseQuery.getPageSize(), baseQuery.getCurrentPage());
		}
		return new PageResult<>();
	}

	
	
}
