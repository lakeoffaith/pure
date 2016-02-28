package com.ijoy.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.common.domain.Employee;
import com.ijoy.common.mapper.EmployeeMapper;
import com.ijoy.common.service.EmployeeService;

@Service
public class EmployeeServiceImpl  implements EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public void save(Employee employee) {
 employeeMapper.insert(employee);
	}

	@Override
	public void delete(Long id) {
		employeeMapper.delete(id);
	}

	@Override
	public void update(Employee employee) {
		employeeMapper.update(employee);
	}

	@Override
	public Employee get(Long id) {
		return employeeMapper.get(id);
	}
	
}
