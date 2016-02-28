package com.ijoy.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.plat.domain.Role;
import com.ijoy.plat.mapper.RoleMapper;
import com.ijoy.plat.query.BaseQuery;
import com.ijoy.plat.query.PageResult;
import com.ijoy.plat.service.IRoleService;
@Service
public class RoleServiceImpl  implements IRoleService {
	
	@Autowired
	private RoleMapper mapper;
	@Override
	public Role getByName(String string) {
		return mapper.getRoleByName(string);
	}
	@Override
	public Long insert(Role t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Role t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Role get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PageResult<Role> queryPage(BaseQuery baseQuery) {
		// TODO Auto-generated method stub
		return null;
	}


	
}

