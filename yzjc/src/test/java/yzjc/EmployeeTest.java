package yzjc;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.common.domain.Employee;
import com.ijoy.common.service.IEmployeeService;

public class EmployeeTest  extends BaseTest{
	@Autowired
	private IEmployeeService employeeService;
	@Test
	public void getAll(){
		List<Employee> all = employeeService.getAll();
		System.out.println(all);
	}
}
