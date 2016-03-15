package com.ijoy.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.common.query.PageResult;
import com.ijoy.plat.domain.Application;
import com.ijoy.plat.query.ApplicationQuery;
import com.ijoy.plat.service.IApplicationService;


public class ApplicationServiceTest extends BaseTest{
	@Autowired
	private IApplicationService applicationService;

	
	/**
	 * getOwnApplicationByEmployeeId    通过用户的id去查找已经分配的应用；
		通过baseQuery.employeeid    IApplicationService.queryApplicationJoinEmployeePage(BaseQuery)
	 */
@Test
public void getOwnApplicationByEmployeeIdTest(){
	ApplicationQuery applicationQuery = new ApplicationQuery();
	applicationQuery.setEmployee_id(1L);
	PageResult<Application> page = applicationService.queryApplicationJoinEmployeePage(applicationQuery);
	System.out.println(page);
}
	
/**
 * getNotOwnApplicationByEmployeeId  通过用户的id去查找未分配给自己的应用；
					 				通过baseQuery.notEmployeeid IApplicationService.queryApplicationJoinEMployeePage
 */
@Test
public void getNotOwnApplicationByEmployeeId(){
	ApplicationQuery applicationQuery = new ApplicationQuery();
	applicationQuery.setNotEmployee_id(1L);
	PageResult<Application> page = applicationService.queryApplicationJoinEmployeePage(applicationQuery);
	System.out.println(page);
}

	@Test
	public void getAllTest() {
		List<Application> applications = applicationService.getAll();
		System.out.println(applications);
		
	}
	@Test
	public void deleteTest() {
		
		//删除
		Long id=1L;
		applicationService.delete(id);
		
	}
}
