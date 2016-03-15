package com.ijoy.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.type.TypeAliasRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.common.comutil.Context.UserContext;
import com.ijoy.common.domain.Department;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.domain.Hospital;
import com.ijoy.common.query.DepartmentQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(params="for=json", method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult search(@ModelAttribute DepartmentQuery baseQuery) throws Exception{
		System.out.println(baseQuery);
		PageResult<Department> pageResult = departmentService.queryDepartmentPage(baseQuery);
		return new Ajaxresult(true, pageResult);
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView  search() throws Exception{
		return new ModelAndView("department/department-search");
	}
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable Long id) throws Exception{
		
	return "department/show";
	}
	
	@RequestMapping(value="/{id}",params="method=collect",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult collect(@PathVariable Long id,HttpServletRequest request){
		Employee employee = UserContext.getUser(request);
		try{
			departmentService.insertDepartmentJoinEmployee(id,employee.getId(),Department.TYPE_COLLECT);
			return new Ajaxresult(true, "收藏成功");
		}catch(Exception e){
			e.printStackTrace();
			return new Ajaxresult(false, "收藏失败");
		}
	}
	

}
