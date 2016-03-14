package com.ijoy.common.service;

import java.util.List;

import com.ijoy.common.domain.Menu;
import com.ijoy.common.domain.Role;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.PageResult;


public interface IMenuService{
	
	public Long insert(Menu  t);

	public void delete(Long id);
	public void update(Menu t);

	public Menu get(Long  id);

	public List<Menu> getAll();
	void deleteRoleMenu(Role role, List<Menu> menuList);
	List<Menu> getMenuListByRole(Role role);
	void saveRoleMenu(Role role, List<Menu> menuList);
	List<Menu> getMenuListByRoleANDType(Role role, int type);
	List<Menu> getMenuByMenuUrl(String menuUrl);
	void deleteAll();
	List<Menu> getMenuByMenuName(String string);

	public PageResult<Menu> queryPage(BaseQuery  baseQuery);

}

