package com.ijoy.plat.service;

import java.util.List;

import com.ijoy.plat.domain.Employee;
import com.ijoy.plat.query.EmployeeQuery;
import com.ijoy.plat.query.PageResult;

public interface IEmployeeService  {
	public Long insert(Employee  t);

	public void delete(Long id);
	public void update(Employee t);

	public Employee get(Long  id);

	public List<Employee> getAll();
	public Employee findEmployeeByLoginInfoID(Long id);

	public PageResult<Employee> queryEmployees(EmployeeQuery  baseQuery);




}
