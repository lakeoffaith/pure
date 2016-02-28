package com.ijoy.gh.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.service.EmployeeService;
import com.ijoy.gh.domain.OrderItem;
import com.ijoy.gh.domain.Schedule;
import com.ijoy.gh.service.OrderItemService;
import com.ijoy.gh.service.ScheduleService;

@Controller
@RequestMapping("/yuyue")
public class YuyueController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	ScheduleService  scheduleService;
	
	@Autowired
	OrderItemService orderItemService;
	
	@RequestMapping(value="/sure/{yyItemId}",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult make(@PathVariable Long yyItemId) throws Exception{
			return new Ajaxresult(true, "use/center/1", Ajaxresult.codeUrl);
	}
	
	@RequestMapping(value="/{use_id}/{schedule_id}",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult make(@PathVariable Long use_id,@PathVariable Long schedule_id) throws Exception{
		Schedule schedule=scheduleService.get(schedule_id);
		Employee employee=employeeService.get(use_id);
		OrderItem order =orderItemService.saveOrderItem(employee, schedule);
		if(order!=null){
			return new Ajaxresult(true, order);
		}
			return new Ajaxresult(false,"预约失败");
	}
}
