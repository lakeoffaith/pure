package com.ijoy.plat.mapper;

import java.io.Serializable;
import java.util.List;

import com.ijoy.plat.domain.Role;
import com.ijoy.plat.query.BaseQuery;

public interface RoleMapper {
	
	public Long insert(Role  t);

	public void delete(Long  id);
	public void update(Role  t);

	public Role get(Serializable id);

	public List<Role> getAll();
	public Long queryTotalCount(BaseQuery baseQuery);
	public List<Role> queryRows(BaseQuery baseQuery);

	public List<Role> getRoleListByEmployeeID(Long  id);

	public Role getRoleByName(String string);


}
