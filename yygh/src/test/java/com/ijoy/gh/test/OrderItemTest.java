package com.ijoy.gh.test;

import java.text.ParseException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.common.query.PageResult;
import com.ijoy.gh.domain.OrderItem;
import com.ijoy.gh.query.OrderItemQuery;
import com.ijoy.gh.service.OrderItemService;

public class OrderItemTest  extends BaseTest{
	@Autowired 
	OrderItemService orderItemService;
	
	/**
	 * @throws ParseException 
	 */
	@Test
	public void queryOrderItems() throws ParseException{
		OrderItemQuery orderItemQuery = new OrderItemQuery();
		orderItemQuery.setUserId(3L);
		PageResult<OrderItem> queryOrderItems = orderItemService.queryOrderItems(orderItemQuery);
		System.out.println(queryOrderItems);
	}
}
