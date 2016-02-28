package com.ijoy.gh.service.impl;


import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.common.comutil.HttpYY;
import com.ijoy.common.domain.Department;
import com.ijoy.common.domain.Doctor;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.domain.Hospital;
import com.ijoy.common.mapper.DepartmentMapper;
import com.ijoy.common.mapper.DoctorMapper;
import com.ijoy.common.mapper.HospitalMapper;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.gh.domain.OrderItem;
import com.ijoy.gh.domain.Schedule;
import com.ijoy.gh.mapper.OrderItemMapper;
import com.ijoy.gh.service.OrderItemService;

@Service
public class OrderItemServiceImpl  implements OrderItemService {
	@Autowired
	private OrderItemMapper orderItemMapper;
	
	@Autowired
	private HospitalMapper hospitalMapper;
	
	@Autowired
	private DepartmentMapper departmentMapper;

	@Autowired
	private DoctorMapper doctorMapper;
	
	@Override
	public OrderItem saveOrderItem(Employee employee, Schedule schedule) {
		Boolean securitycodeFlag=true;
		Boolean orderFlag=false;
		//1:验证码是否正确
		if(!securitycodeFlag)return null;
		//2:调用预约接口
		String takePassword = HttpYY.sendData(employee,schedule);
		int orderNum=2;
		if(StringUtils.isNotBlank(takePassword)){
				orderFlag=true;
		}
		
		OrderItem order=null;
	
		//3:保存order  ,返回true
		if(orderFlag){
			synchronized (this) {
				order=initOrderItem(employee,schedule,orderNum,takePassword);
				orderItemMapper.insert(order);
				//1)医院挂号的总数，科室挂号的总数，医生挂号的总数加1？
		/*		Hospital hospital = schedule.getDoctor().getDepartment().getHospital();
				hospital.setGhTotal(hospital.getGhTotal()+1);
				hospitalMapper.update(hospital);
				
				Department department = schedule.getDoctor().getDepartment();
				department.setGhTotal(hospital.getGhTotal()+1);
				departmentMapper.update(department);
				
				Doctor doctor = schedule.getDoctor();
				doctor.setGhTotal(doctor.getGhTotal()+1);
				doctorMapper.update(doctor);*/
			}
			return order;
			
			
		}
		
		
		
		
		return null;
	}
	@Override
	public Boolean cancleOrderItem(Long orderItem_id) {
		OrderItem orderItem = orderItemMapper.get(orderItem_id);
		return cancleOrderItem(orderItem);
	}
	//点击取消预约
	@Override
	public Boolean cancleOrderItem(OrderItem order) {
		Boolean securitycodeFlag=true;
		//1:验证码是否正确
		if(!securitycodeFlag)return false;
		//2:调用预约接口
		
		
		Boolean orderFlag=true;
		//3:保存order  ,返回true
		if(orderFlag){
			
			synchronized (this) {
				order.setState(OrderItem.ORDER_STATE_CANCLE);
				orderItemMapper.update(order);
				//1)医院挂号的总数，科室挂号的总数，医生挂号的总数加1？
				/*Hospital hospital = order.getHospital();
				hospital.setGhTotal(hospital.getGhTotal()-1);
				hospitalMapper.update(hospital);
				
				Department department = order.getDepartment();
				department.setGhTotal(hospital.getGhTotal()-1);
				departmentMapper.update(department);
				
				Doctor doctor = order.getDoctor();
				doctor.setGhTotal(doctor.getGhTotal()-1);
				doctorMapper.update(doctor);*/
			}
			return true;
			
			
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private OrderItem  initOrderItem(Employee employee, Schedule schedule, int orderNum, String takePassword) {
		OrderItem order = new OrderItem();
		order.setHospital(schedule.getDoctor().getDepartment().getHospital());
		order.setDepartment(schedule.getDoctor().getDepartment());
		order.setDoctor(schedule.getDoctor());
		order.setSchedule(schedule);
		order.setDate(new Date());
		order.setOrderNum(orderNum);
		order.setState(OrderItem.ORDER_STATE_SUCCESS);
		order.setTakePassword(takePassword);
		order.setEmployee(employee);
		order.setScore(OrderItem.ORDER_SCORE_NOT);
		return order;
	}
























	@Override
	public void save(OrderItem t) {
	 orderItemMapper.insert(t);
	}

	@Override
	public void update(OrderItem t) {
		orderItemMapper.update(t);
	}

	@Override
	public OrderItem get(Long id) {
		return orderItemMapper.get(id);
	}

	@Override
	public void delete(Long id) {
		orderItemMapper.delete(id);
	}

	@Override
	public PageResult<OrderItem> queryOrderItems(BaseQuery baseQuery) {
		Long totalCount=orderItemMapper.queryTotalCount(baseQuery);
		if(totalCount>0){
			List<Schedule>  rows=orderItemMapper.queryRows(baseQuery);
			return new PageResult<>(totalCount, rows, baseQuery.getPageSize(), baseQuery.getCurrentPage());
		}
		return new PageResult<>();
		
	}



	
	
}
