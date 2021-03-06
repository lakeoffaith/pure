package com.ijoy.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.common.domain.Menu;
import com.ijoy.common.domain.Role;
import com.ijoy.common.mapper.MenuMapper;
import com.ijoy.common.mapper.RoleMapper;
import com.ijoy.common.query.MenuQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.service.IMenuService;
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
	public PageResult<Menu> queryPage(MenuQuery  baseQuery) {
		Long totalCount;
		 List<Menu> rows;
		if(baseQuery.getRoleid()!=null && baseQuery.getRoleid()>0){
				 totalCount=mapper.queryJoinRoleTotalCount(baseQuery);
				if(totalCount>0){
					 rows = mapper.queryJoinRoleRows(baseQuery);
					 return new PageResult<>(totalCount, rows, baseQuery.getPageSize()	, baseQuery.getCurrentPage());
				}
		}else{
			totalCount = mapper.queryTotalCount(baseQuery);
			 if(totalCount>0){
				 rows = mapper.queryRows(baseQuery);
				 return new PageResult<>(totalCount, rows, baseQuery.getPageSize()	, baseQuery.getCurrentPage());
			 }
		}
		return new PageResult<>();
	}
}

