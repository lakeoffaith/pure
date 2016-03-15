package com.ijoy.common.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.common.domain.Employee;
import com.ijoy.common.mapper.EmployeeMapper;
import com.ijoy.common.mapper.LoginInfoMapper;
import com.ijoy.common.query.EmployeeQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.service.IEmployeeService;

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
	@Override
	public void modifyOwnApplications(Long employeeId,String applicationIds) {
				
				//删除employee_application 中间表的关联数据，
		mapper.deleteJoinApplication(employeeId);
		    System.out.println(employeeId+"-----------------------------------");
			  //增加需要新增的数据到employee_application;
		String[] str = applicationIds.split(",");
		for (int i = 0; i < str.length; i++) {
			if (StringUtils.isNotBlank(str[i])) {
				Long applicationId=Long.valueOf(str[i]);
				System.out.println(employeeId+"=======================");
				mapper.insertJoinApplication(employeeId,applicationId);
			}
			
		}
	}
	
	
}
