package com.ijoy.common.service;

import java.util.List;

import com.ijoy.common.domain.Role;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.PageResult;

public interface IRoleService{
	public Long insert(Role  t);

	public void delete(Long id);
	public void update(Role  t);

	public Role get(Long  id);

	public List<Role> getAll();
	Role getByName(String string);

	public PageResult<Role> queryPage(BaseQuery baseQuery);
}

