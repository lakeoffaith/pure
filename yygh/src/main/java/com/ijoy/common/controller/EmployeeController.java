package com.ijoy.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@RequestMapping(params="tip=insession",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult get(HttpServletRequest request){
		Employee employee=(Employee) request.getSession().getAttribute("USE_IN_SESSION");
		if(employee==null){
			employee=employeeService.get(2L);
		}
		return new Ajaxresult(true, employee);
	}
}
