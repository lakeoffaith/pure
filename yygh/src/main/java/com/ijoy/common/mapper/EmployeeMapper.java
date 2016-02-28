package com.ijoy.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ijoy.common.domain.Employee;


public interface EmployeeMapper{
	/*
	 * curd 模块
	 */
	@Insert("insert into employee(name,password,email,realName,cellphone,homePath,idCardNo,healthInsuranceCardType,healthInsuranceCardNo) values(#{name},#{password},#{email},#{realName},#{cellphone},#{homePath},#{idCardNo},#{healthInsuranceCardType},#{healthInsuranceCardNo})")
	public Long insert(Employee employee);

	public void delete(Long id);
	
	public void update(Employee employee);

	@Select("select * from employee where id=#{id}")
	public Employee get(Long id);
	
	@Select("select * from employee")
	public List<Employee> getAll();
	

}
