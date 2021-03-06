package com.ijoy.plat.service;

import java.util.List;

import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.plat.domain.TaskItem;


public interface ITaskItemService  {
	public Long insert(TaskItem  t);

	public void delete(Long id);
	public void update(TaskItem  t);

	public TaskItem  get(Long  id);

	public List<TaskItem> getAll();	
	
	List<TaskItem> getTaskItemListByTaskId(Long id);
	
	public PageResult<TaskItem> queryPage(BaseQuery baseQuery);
}

