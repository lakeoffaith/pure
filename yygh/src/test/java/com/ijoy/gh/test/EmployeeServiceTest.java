package com.ijoy.gh.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.common.domain.Employee;
import com.ijoy.common.service.EmployeeService;


public class EmployeeServiceTest extends BaseTest {
	@Autowired 
	EmployeeService employeeService;
	//获取employee 
	@Test
	public void getTest(){
		Employee employee = employeeService.get(1L);
		logger.debug(employee);;
	}
}
