package com.ijoy.plat.mapper;

import java.util.List;

import com.ijoy.plat.domain.Menu;
import com.ijoy.plat.query.BaseQuery;

public interface MenuMapper {
	
	public Long insert(Menu  t);

	public void delete(Long  id);
	public void update(Menu  t);

	public Menu  get(Long  id);
	public List<Menu> getAll();

	public void insertRoleMenu(Long roleid, Long menuid);
	public void deleteRoleMenu(Long roleid, Long menuid);
	public List<Menu> getMenuListByRoleID(Long id);
	public List<Menu> getMenuListByRoleIDANDType(Long id, int type);
	public List<Menu> getMenuByMenuUrl(String menuUrl);
	public void deleteAll();
	public List<Menu> getMenuByMenuName(String menuName);

	public Long queryTotalCount(BaseQuery baseQuery);

	public List<Menu> queryRows(BaseQuery baseQuery);
}
