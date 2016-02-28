package com.ijoy.gh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.gh.domain.Schedule;
import com.ijoy.gh.query.ScheduleQuery;
import com.ijoy.gh.service.ScheduleService;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
 @Autowired
 ScheduleService scheduleService;
 @RequestMapping(value="/{id}",method=RequestMethod.GET)
 @ResponseBody
 public Ajaxresult  get(@PathVariable Long id){
	 Schedule schedule = scheduleService.get(id);
	 System.out.println(schedule);
	 return  new Ajaxresult(true,schedule );
 }
 
 @RequestMapping(method=RequestMethod.GET)
 @ResponseBody
 public Ajaxresult search(@ModelAttribute ScheduleQuery scheduleQuery){
	 List rows = scheduleService.querySchedules(scheduleQuery).getRows();
	 return new Ajaxresult(true,rows );
 }
 
}
