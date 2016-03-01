package com.ijoy.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.plat.domain.Employee;
import com.ijoy.plat.mapper.EmployeeMapper;
import com.ijoy.plat.mapper.LoginInfoMapper;
import com.ijoy.plat.query.EmployeeQuery;
import com.ijoy.plat.query.PageResult;
import com.ijoy.plat.service.IEmployeeService;

@Service
public class EmployeeServiceImpl  implements IEmployeeService {
	@Autowired
	private EmployeeMapper  mapper;
	@Autowired
	private LoginInfoMapper   loginInfoMapper;
	@Override
	public Employee findEmployeeByLoginInfoID(Long id) {
		return mapper.get(id);
	}
	@Override
	public Long insert(Employee t) {
		return mapper.insert(t);
	}
	@Override
	public void delete(Long id) {
			mapper.delete(id);
	}
	@Override
	public void update(Employee t) {
		mapper.update(t);
	}
	@Override
	public Employee get(Long id) {
		return mapper.get(id);
	}
	@Override
	public List<Employee> getAll() {
		return mapper.getAll();
	}
	@Override
	public PageResult<Employee> queryEmployees(EmployeeQuery baseQuery) {
		Long totalCount = mapper.queryTotalCount(baseQuery);
		if(totalCount>0){
			List<Employee> rows = mapper.queryRows(baseQuery);
			return new PageResult<>(totalCount, rows, baseQuery.getPageSize()	, baseQuery.getCurrentPage());
		}
		return new PageResult<>();
	}
	
	
}
