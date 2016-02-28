package com.ijoy.plat.mapper;

import java.util.List;

import com.ijoy.plat.domain.Employee;
import com.ijoy.plat.query.BaseQuery;

public interface EmployeeMapper {
	public Long insert(Employee t);

	public void delete(Long id);
	public void update(Employee t);

	
	public Employee get(Long id);

	public List<Employee> getAll();

	public List<Employee> queryRows(BaseQuery query);

	public Long queryTotalCount(BaseQuery query);

}
