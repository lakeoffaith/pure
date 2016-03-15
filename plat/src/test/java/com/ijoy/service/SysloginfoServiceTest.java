package com.ijoy.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.common.domain.Sysloginfo;
import com.ijoy.common.service.ISysloginfoService;


public class SysloginfoServiceTest extends BaseTest{
	@Autowired
	private ISysloginfoService sysloginfoService;

	@Test
	public void getAllTest() {
		List<Sysloginfo> sysloginfos = sysloginfoService.getAll();
		System.out.println(sysloginfos);
		
	}
	@Test
	public void deleteTest() {
		
		//删除
		Long id=1L;
		sysloginfoService.delete(id);
		
	}
	@Test
	public void getTest() {
		Sysloginfo sysloginfo = sysloginfoService.get(23L);
		System.out.println(sysloginfo);
		
	}
	/*
	 * 更新
	 */
	@Test
	public void updateTest() {
		Sysloginfo sysloginfo = sysloginfoService.get(1L);
		sysloginfo.setIp("192.168.0.1");
		 sysloginfoService.update(sysloginfo);
		
	}
}
