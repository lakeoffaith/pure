package com.ijoy.gh.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.common.domain.Employee;
import com.ijoy.common.domain.Hospital;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.HospitalQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.service.HospitalService;

public class HospitalServiceTest extends BaseTest {
	@Autowired 
	HospitalService hospitalService;
	//获取employee 
	@Test
	public void getTest(){
		Hospital hospital = hospitalService.get(1L);
		logger.debug(hospital);;
	}
	
	/*
	 * 
	根据查询条件 如 省份,城市,区域,级别,类型  排序  eg:预约人数 ,eg:好评
	public PageResult<Hospital> queryHospital(BaseQuery basequery);
	 用户查看自己收藏的医院,浏览过的医院,挂过号的医院
	public PageResult<Hospital> queryUseCollectHospital(Employee employee,Long type,BaseQuery baseQuery);
	 * 
	 */
	@Test
	public void queryHospitalTest(){
		HospitalQuery hospitalQuery = new HospitalQuery();
/*		hospitalQuery.setCity("成都");*/
/*		hospitalQuery.setLevel("9");
		PageResult<Hospital> queryHospital = hospitalService.queryHospital(hospitalQuery);
		logger.debug("queryHospital::"+queryHospital);*/
	}
	
	@Test
	public void queryUseCollectHospital(){
		Employee employee=new Employee();
		employee.setId(1L);
		Long type=1L;
		BaseQuery baseQuery=new HospitalQuery();
		PageResult<Hospital> queryUseCollectHospital = hospitalService.queryUserCollectHospital(employee, type, baseQuery);
		logger.debug("queryUseCollectHospital::"+queryUseCollectHospital);
	}
	
	
}
