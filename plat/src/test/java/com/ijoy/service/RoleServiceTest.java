package com.ijoy.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.plat.domain.Employee;
import com.ijoy.plat.domain.Role;
import com.ijoy.plat.service.IEmployeeService;
import com.ijoy.plat.service.IRoleService;


public class RoleServiceTest extends BaseTest{
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IEmployeeService employeeService;

	@Test
	public void getAllTest() {
		List<Role> roles = roleService.getAll();
		System.out.println(roles);
		
	}
	@Test
	public void deleteTest() {
		
		//删除
		Long id=1L;
		roleService.delete(id);
		
	}
	/*
	 * 通过用户来找角色
	 */
	@Test
	public void ttTest(){
		Employee employee = employeeService.get(1L);
		System.out.println(employee.getRole());
	}
}
