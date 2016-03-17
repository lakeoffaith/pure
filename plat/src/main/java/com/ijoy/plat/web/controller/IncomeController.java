package com.ijoy.plat.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.plat.query.IncomeQuery;
import com.ijoy.plat.service.IncomeService;

@Controller
@RequestMapping("/income")
public class IncomeController {	
	@Autowired
		private IncomeService service;
		@RequestMapping(params="for=json",method=RequestMethod.GET)
		@ResponseBody
		public Ajaxresult get(@ModelAttribute IncomeQuery incomeQuery){
			try {
				List income = service.queryIncome(incomeQuery);
				return new Ajaxresult(true, income);
			} catch (Exception e) {
				
				e.printStackTrace();
				return new Ajaxresult(false, "查询数据失败");
			}
		}
}
