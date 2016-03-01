package com.ijoy.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.plat.domain.Menu;
import com.ijoy.plat.domain.Role;
import com.ijoy.plat.mapper.MenuMapper;
import com.ijoy.plat.mapper.RoleMapper;
import com.ijoy.plat.query.BaseQuery;
import com.ijoy.plat.query.PageResult;
import com.ijoy.plat.service.IMenuService;
@Service
public class MenuServiceImpl  implements IMenuService {
	@Autowired
	private MenuMapper mapper;
	@Autowired
	private RoleMapper  roleMapper;
	

	@Override
	public List<Menu> getMenuListByRole(Role role) {
		return  mapper.getMenuListByRoleID(role.getId());
	}




	@Override
	public void saveRoleMenu(Role role,
			List<Menu> menuPageList) {
		for (Menu menu : menuPageList) {
			mapper.insertRoleMenu(role.getId(),menu.getId());
		}	
	}

	@Override
	public void deleteRoleMenu(Role role,
			List<Menu> menuList) {
		for (Menu menu : menuList) {
			mapper.deleteRoleMenu(role.getId(),menu.getId());
		}
	}

	@Override
	public List<Menu> getMenuListByRoleANDType(Role role,int type) {
		return mapper.getMenuListByRoleIDANDType(role.getId(), type);
	}

	public List<Menu> getMenuByMenuUrl(String menuUrl) {
		return mapper.getMenuByMenuUrl(menuUrl);
	}

	@Override
	public void deleteAll() {
		mapper.deleteAll();
		
	}

	@Override
	public List<Menu> getMenuByMenuName(String menuName) {
		return mapper.getMenuByMenuName(menuName);
	}




	@Override
	public Long insert(Menu t) {
		return mapper.insert(t);
	}




	@Override
	public void delete(Long id) {
		mapper.delete(id);
	}




	@Override
	public void update(Menu t) {
		mapper.update(t);
	}




	@Override
	public Menu get(Long id) {
		return mapper.get(id);
	}




	@Override
	public List<Menu> getAll() {
		return mapper.getAll();
	}




	@Override
	public PageResult<Menu> queryPage(BaseQuery baseQuery) {
		 Long totalCount = mapper.queryTotalCount(baseQuery);
		 if(totalCount>0){
			 List<Menu> rows = mapper.queryRows(baseQuery);
			 return new PageResult<>(totalCount, rows, baseQuery.getPageSize()	, baseQuery.getCurrentPage());
		 }
		return new PageResult<>();
	}
}

