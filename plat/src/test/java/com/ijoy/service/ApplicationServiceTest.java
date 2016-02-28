package com.ijoy.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.plat.domain.Application;
import com.ijoy.plat.service.IApplicationService;


public class ApplicationServiceTest extends BaseTest{
	@Autowired
	private IApplicationService applicationService;

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
