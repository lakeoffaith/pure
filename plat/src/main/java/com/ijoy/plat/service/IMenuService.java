package com.ijoy.plat.service;

import java.util.List;

import com.ijoy.plat.domain.Menu;
import com.ijoy.plat.domain.Role;
import com.ijoy.plat.query.BaseQuery;
import com.ijoy.plat.query.PageResult;


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

