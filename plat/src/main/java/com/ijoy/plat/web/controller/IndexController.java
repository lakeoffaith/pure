package com.ijoy.plat.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ijoy.common.comutil.UserContext;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.service.IEmployeeService;
import com.ijoy.plat.query.TaskItemQuery;
import com.ijoy.plat.service.ITaskItemService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private ITaskItemService  taskItemService;
	//调整index页面
	@RequestMapping("index")
	public String execute(){
		return "index";
	}
	//首页的主页面
	@RequestMapping("main")
	public ModelAndView  main(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("allEmployeeCount",employeeService.getAll().size());
		Employee user = UserContext.getUser(request);
		TaskItemQuery taskItemQuery = new TaskItemQuery();
		taskItemQuery.setEmployee_id(user.getId());
		mv.addObject("ownTaskItemCount", taskItemService.queryPage(taskItemQuery).getRows().size());
		return mv;
	}
	
}
