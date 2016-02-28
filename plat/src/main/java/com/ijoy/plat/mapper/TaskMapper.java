package com.ijoy.plat.mapper;

import java.util.List;

import com.ijoy.plat.domain.Task;
import com.ijoy.plat.query.TaskQuery;

public interface TaskMapper {
	public Long insert(Task  t);
 
	public void delete(Long  id);
	public void update(Task t);

	public Task get(Long  id);

	public List<Task> getAll();

	public Long queryTotalCount(TaskQuery baseQuery);

	public List<Task> queryRows(TaskQuery baseQuery);
}
