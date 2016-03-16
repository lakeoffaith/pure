package com.ijoy.yzjc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.yzjc.query.WorkLoadQuery;

@Controller
@RequestMapping("/workload")
public class WorkLoadController {
	
	@RequestMapping(params="for=json",method=RequestMethod.GET)
	@ResponseBody
	public  Ajaxresult getJson(@ModelAttribute WorkLoadQuery  workLoadQuery){
		return new Ajaxresult(false, "收入查询失败");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public  ModelAndView  get(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("workLoad/show");;
		return mv;
	}
	
}
