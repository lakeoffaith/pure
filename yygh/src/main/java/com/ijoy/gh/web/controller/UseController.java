package com.ijoy.gh.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.gh.query.OrderItemQuery;
import com.ijoy.gh.service.OrderItemService;

@Controller
@RequestMapping("/use/")
public class UseController {
	@Autowired
	private OrderItemService orderItemService;
	
	@RequestMapping(value="center/{useId}",params="type=html",method=RequestMethod.GET)
	public String centerHtml(@PathVariable Long useId)throws Exception{
		return "use/center";
	}
	@RequestMapping(value="center/{useId}",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult centerJson(@PathVariable Long useId)throws Exception{
		OrderItemQuery orderItemQuery = new OrderItemQuery();
		orderItemQuery.setUserId(useId);
		return new Ajaxresult(true, orderItemService.queryOrderItems(orderItemQuery).getRows());
	}
	@RequestMapping(value="center",method=RequestMethod.GET)
	public String center()throws Exception{
		return "use/center";
	}
	
}
