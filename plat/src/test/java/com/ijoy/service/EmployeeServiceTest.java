package com.ijoy.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ijoy.plat.domain.Employee;
import com.ijoy.plat.domain.Role;
import com.ijoy.plat.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceTest {
	@Autowired
	private IEmployeeService employeeService;

	
	
	//查询所有的用户
	@Test
	public void serviceTest() {
		List<Employee> employees = employeeService.getAll();
		System.out.println(employees);
	}
	
	
	//查询指定id用户
		@Test
		public void getTest() {
			 Employee employee = employeeService.get(2L);
			System.out.println(employee);
			Role role = employee.getRole();
			System.out.println(role);
		}
		
		//保持用户
		@Test
		public void saveTest() {
			Employee e=new Employee();
			e.setId(24L);
			e.setName("nihao");
			employeeService.insert(e);
		}
		
		//删除用户
}
