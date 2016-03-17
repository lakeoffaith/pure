package com.ijoy.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.plat.query.IncomeQuery;
import com.ijoy.plat.service.IncomeService;

public class IcomeServiceTest extends BaseTest {
		@Autowired
	private IncomeService service;
	/**
	 * 获得104医院，科室为11092,月份为2月份的每天的收入的map list集合
	 */
	@Test
	public void getIncomeTest(){
			IncomeQuery incomeQuery=new IncomeQuery();
			incomeQuery.setHospital_id(104L);
			incomeQuery.setMonth(3L);
			
			List<Map<String,Object>> income = service.queryIncome(incomeQuery);
			System.out.println("----------------------");
			System.out.println(income);
			for (Map<String, Object> map : income) {
				System.out.println(map.get("VALUE"));
			}
	}

}
