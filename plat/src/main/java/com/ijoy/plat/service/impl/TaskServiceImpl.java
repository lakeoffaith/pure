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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Task t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Task get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageResult<Task> queryPage(TaskQuery baseQuery) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

