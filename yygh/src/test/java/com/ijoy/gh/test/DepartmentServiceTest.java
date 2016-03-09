package com.ijoy.gh.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.common.domain.Department;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.DepartmentQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.service.DepartmentService;


public class DepartmentServiceTest extends BaseTest {
	@Autowired 
	DepartmentService departmentService;
	/**
	 * 
	 * 根据查询条件 如 医院id list,科室,科室分类 内科,国家级别  eg:国家重点   排序  eg:预约人数 ,eg:好评
	 *
	 */
	/*
	 * 
	 */
	@Test
	public void queryDepartmentTest(){
		DepartmentQuery departmentQuery = new DepartmentQuery();
		
		/*departmentQuery.setType("DT1");*/
		departmentQuery.setOrderStr("ghtotal");
		List<Long> hospitalIdList=new ArrayList<>();
		/*hospitalIdList.add(1L);*/
		/*hospitalIdList.add(2L);*/
/*		departmentQuery.setList(hospitalIdList);*/
		PageResult<Department> queryDepartment = departmentService.queryDepartmentPage(departmentQuery);
		System.out.println(queryDepartment);
	}
	
	/**
	 * 用户查看自己收藏的科室,浏览过的科室,挂过号的科室
	 */
	@Test
	public void queryUseCollectDepartmentTest(){
		Employee employee=new Employee();
		employee.setId(1L);
		Long type=1L;
		BaseQuery baseQuery=new DepartmentQuery();
		PageResult<Department> queryUseCollectDepartment = departmentService.queryUserCollectDepartment(employee, type, baseQuery);
		System.out.println(queryUseCollectDepartment);
	}
	
	/**
	 * 当用户点击医院的时候，得到科室有多少个分类，再调用queryDepartment 得知每个分类下面有多少科室
	 */
	@Test
	public void findDepartmentTypeListByHospitalIdTest(){
		List<String> findDepartmentTypeListByHospitalId = departmentService.findDepartmentTypeListByHospitalId(1L);
		logger.debug("findDepartmentTypeListByHospitalId::"+findDepartmentTypeListByHospitalId);
	}
	
}
