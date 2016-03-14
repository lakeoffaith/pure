package com.ijoy.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.common.domain.Role;
import com.ijoy.common.mapper.RoleMapper;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.service.IRoleService;
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
		return mapper.insert(t);
	}
	@Override
	public void delete(Long id) {
		mapper.delete(id);
		
	}
	@Override
	public void update(Role t) {
		mapper.update(t);
		
	}
	@Override
	public Role get(Long id) {
		
		return mapper.get(id);
	}
	@Override
	public List<Role> getAll() {
		return mapper.getAll();
	}
	@Override
	public PageResult<Role> queryPage(BaseQuery baseQuery) {
		Long totalCount = mapper.queryTotalCount(baseQuery);
		if(totalCount>0){
			List<Role> rows = mapper.queryRows(baseQuery);
			return new PageResult<>(totalCount, rows, baseQuery.getPageSize(), baseQuery.getCurrentPage());
		}
		return new PageResult<>();
	}


	
}

