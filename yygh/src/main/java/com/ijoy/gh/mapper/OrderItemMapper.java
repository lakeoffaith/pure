package com.ijoy.gh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.ijoy.common.query.BaseQuery;
import com.ijoy.gh.domain.OrderItem;
import com.ijoy.gh.domain.Schedule;



public interface OrderItemMapper{
	/*
	 * curd 模块
	 */
	public Long insert(OrderItem order);

	public void delete(Long id);
	
	public void update(OrderItem order);

	@Select("select * from orderItem  where id=#{id}")
	@ResultMap("orderItemResult")
	public OrderItem get(Long id);
	
	@Select("select * from orderItem")
	public List<OrderItem> getAll();
	public Long queryTotalCount(BaseQuery baseQuery);
	public List<Schedule> queryRows(BaseQuery baseQuery);
	

}
