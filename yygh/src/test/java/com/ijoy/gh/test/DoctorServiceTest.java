package com.ijoy.gh.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.common.domain.Doctor;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.query.DoctorQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.service.DoctorService;

public class DoctorServiceTest extends BaseTest {
	@Autowired 
	DoctorService doctorService;
	
	/*
	 * 
	根据查询条件 如医院(list),科室,科室分类 内科   排序  eg:预约人数 ,eg:好评
	 * 
	 */
	@Test
	public void queryDoctorTest(){
		DoctorQuery doctorQuery = new DoctorQuery();
		/*doctorQuery.setType("DT1");*/
		/*doctorQuery.setDepartmentId(1L);*/
	   PageResult<Doctor> queryDoctor = doctorService.queryDoctor(doctorQuery);
	   logger.debug("queryDoctor::"+queryDoctor);
	}
	/*
	 * 用户查看自己收藏的医生,浏览过的医生,挂过号的医生
	 */
	@Test
	public void queryUseCollectDoctorTest(){
		Employee employee=new Employee();
		employee.setId(1L);
		Long type=1L;
		DoctorQuery doctorQuery = new DoctorQuery();
		 PageResult<Doctor> queryUserCollectDoctor = doctorService.queryUserCollectDoctor(employee, type, doctorQuery);
		 logger.debug("queryUserCollectDoctor::"+queryUserCollectDoctor);
	}
	
	
}
