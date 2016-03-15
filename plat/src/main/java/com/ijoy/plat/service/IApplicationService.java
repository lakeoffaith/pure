package com.ijoy.plat.service;

import java.util.List;

import com.ijoy.plat.domain.Application;
import com.ijoy.plat.query.BaseQuery;
import com.ijoy.plat.query.PageResult;

public interface IApplicationService {
	
	public Long insert(Application t);

	public void delete(Long id);
	public void update(Application t);

	public Application get(Long  id);

	public List<Application> getAll();

	
	public PageResult<Application> queryPage(BaseQuery  applicationQuery);
	/**
	 * 通过用户的id去查找已经分配的应用
	 * 通过用户的id去查找未分配给自己的应用
	 * @param applicationQuery
	 * @return
	 */
	public PageResult<Application> queryApplicationJoinEmployeePage(BaseQuery  applicationQuery);
}

