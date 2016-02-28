package com.ijoy.plat.service;

import java.util.List;

import com.ijoy.plat.domain.Role;
import com.ijoy.plat.query.BaseQuery;
import com.ijoy.plat.query.PageResult;

public interface IRoleService{
	public Long insert(Role  t);

	public void delete(Long id);
	public void update(Role  t);

	public Role get(Long  id);

	public List<Role> getAll();
	Role getByName(String string);

	public PageResult<Role> queryPage(BaseQuery baseQuery);
}

