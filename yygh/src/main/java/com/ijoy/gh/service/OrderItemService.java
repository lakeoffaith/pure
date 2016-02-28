package com.ijoy.gh.service;

import com.ijoy.common.domain.Employee;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.service.BaseCurdService;
import com.ijoy.gh.domain.OrderItem;
import com.ijoy.gh.domain.Schedule;

public interface OrderItemService extends BaseCurdService<OrderItem> {

	/**
	 * 点击预约，弹出预约的信息
	 */
	public PageResult<OrderItem> queryOrderItems(BaseQuery baseQuery);
	
	/**
	 * 点击确认预约：
	 * 	1：验证码是否需要验证
	 *  2: 调用预约接口  生成取号码
	 *  3: 保存Order 信息单
	 */
	public OrderItem  saveOrderItem(Employee employee,Schedule schedule);

	/**
	 * 
	 *点击取消预约
	 *	1：验证码是否需要验证
	 *	2：调用预约取消接口
	 *  3：修改Order 状态
	 */
	 public Boolean cancleOrderItem(OrderItem order);

	public Boolean cancleOrderItem(Long orderItem_id);


	
	 


}
