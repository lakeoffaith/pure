package com.ijoy.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.plat.domain.TaskItem;
import com.ijoy.plat.mapper.TaskItemMapper;
import com.ijoy.plat.service.ITaskItemService;

@Service
public class TaskItemServiceImpl   implements ITaskItemService {
	@Autowired
	private TaskItemMapper mapper;

	@Override
	public List<TaskItem> getTaskItemListByTaskId(Long id) {
		return mapper.getTaskItemListByTaskId(id);
	}

	@Override
	public Long insert(TaskItem t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TaskItem t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TaskItem get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskItem> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

