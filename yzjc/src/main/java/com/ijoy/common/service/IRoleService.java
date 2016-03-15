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

	/**
	 * 修改角色和菜单的关系的时候，先删除角色对应的原有关系，再重新添加角色对应的关系。
	 * @param id						角色id
	 * @param menuIds    以逗号分割的菜单id字符串
	 */
	public void insertJoinMenuAfterDelete(Long id, String menuIds);
}

