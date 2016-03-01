package com.ijoy.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.plat.domain.Task;
import com.ijoy.plat.mapper.TaskMapper;
import com.ijoy.plat.query.PageResult;
import com.ijoy.plat.query.TaskQuery;
import com.ijoy.plat.service.ITaskService;

@Service
public class TaskServiceImpl  implements ITaskService {
	@Autowired
	private TaskMapper mapper;
	@Override
	public Long insert(Task t) {
		return mapper.insert(t);
	}

	@Override
	public void delete(Long id) {
		mapper.delete(id);
	}
	@Override
	public void update(Task t) {
		mapper.update(t);
	}
	@Override
	public Task get(Long id) {
		return mapper.get(id);
	}
	@Override
	public List<Task> getAll() {
		return mapper.getAll();
	}
	@Override
	public PageResult<Task> queryPage(TaskQuery baseQuery) {
		Long totalCount = mapper.queryTotalCount(baseQuery);
		if(totalCount>0){
			List<Task> rows = mapper.queryRows(baseQuery);
			return new PageResult<>(totalCount, rows, baseQuery.getPageSize()	, baseQuery.getCurrentPage());
		}
		return new PageResult<>();
	}
	
}

