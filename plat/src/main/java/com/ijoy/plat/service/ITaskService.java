package com.ijoy.plat.service;

import java.util.List;

import com.ijoy.common.query.PageResult;
import com.ijoy.plat.domain.Task;
import com.ijoy.plat.query.TaskQuery;

public interface ITaskService {
	
	public Long insert(Task  t);

	public void delete(Long id);
	public void update(Task t);

	public Task get(Long  id);

	public List<Task> getAll();

	public PageResult<Task> queryPage(TaskQuery baseQuery);
}

