package com.ijoy.gh.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.gh.service.OrderItemService;

@Controller
@RequestMapping("/orderItem")
public class OrderItemController {
	
	@Autowired
	OrderItemService orderItemService;
	
	@RequestMapping(value="/{orderItem_id}",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult get(@PathVariable Long orderItem_id) throws Exception{
			return new Ajaxresult(true, orderItemService.get(orderItem_id));
	}
	
	
	@RequestMapping(value="/{orderItem_id}",params="type=cancle",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult cancle(@PathVariable Long orderItem_id) throws Exception{
		if(orderItemService.cancleOrderItem(orderItem_id)){
			return new Ajaxresult(true,"use/center",Ajaxresult.codeUrl);
		}else {
			return new Ajaxresult(false, "取消失败");
		}
		
	}
}
