package com.ijoy.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.PageResult;
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
		return mapper.insert(t);
	}

	@Override
	public void delete(Long id) {
		mapper.delete(id);
	}

	@Override
	public void update(TaskItem t) {
		mapper.update(t);
	}

	@Override
	public TaskItem get(Long id) {
		return mapper.get(id);
	}

	@Override
	public List<TaskItem> getAll() {
		return mapper.getAll();
	}

	@Override
	public PageResult<TaskItem> queryPage(BaseQuery baseQuery) {
		Long count = mapper.queryTotalCount(baseQuery);
		if(count>0){
			List<TaskItem> rows = mapper.queryRows(baseQuery);
			return new PageResult<>(count, rows, baseQuery.getPageSize(), baseQuery.getCurrentPage());
		}
		return new PageResult<>();
	}
	
}

