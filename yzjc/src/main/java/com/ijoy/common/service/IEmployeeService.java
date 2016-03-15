package com.ijoy.common.service;

import java.util.List;

import com.ijoy.common.domain.Employee;
import com.ijoy.common.query.EmployeeQuery;
import com.ijoy.common.query.PageResult;

public interface IEmployeeService  {
	public Long insert(Employee  t);

	public void delete(Long id);
	public void update(Employee t);

	public Employee get(Long  id);

	public List<Employee> getAll();
	public Employee findEmployeeByLoginInfoID(Long id);

	public PageResult<Employee> queryEmployees(EmployeeQuery  baseQuery);

	public void modifyOwnApplications(Long employeeId, String applicationIds);




}
