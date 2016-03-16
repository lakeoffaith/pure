package com.ijoy.yzjc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.abel533.echarts.Option;
import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.yzjc.query.IncomeQuery;
import com.ijoy.yzjc.service.IncomeService;

@Controller
@RequestMapping("/income")
public class IncomeController {
	@Autowired
	private IncomeService service;
	@RequestMapping(params="for=json",method=RequestMethod.GET)
	@ResponseBody
	public  Ajaxresult getJson(@ModelAttribute IncomeQuery incomeQuery){
		try {
			Option option = service.getAll();
			return new Ajaxresult(true, option);
		} catch (Exception e) {
			return new Ajaxresult(false, "收入查询失败");
		}
		
		
	}
	@RequestMapping(method=RequestMethod.GET)
	public  ModelAndView  get(){
		System.out.println("--------------------------");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("income/show");;
		return mv;
	}
	
}
