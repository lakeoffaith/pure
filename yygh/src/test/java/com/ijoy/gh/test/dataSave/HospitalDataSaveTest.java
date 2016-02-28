package com.ijoy.gh.test.dataSave;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.common.comutil.dataCollection.HospitalDataCollection;
import com.ijoy.common.domain.Hospital;
import com.ijoy.common.service.HospitalService;
import com.ijoy.gh.test.BaseTest;


public class HospitalDataSaveTest extends BaseTest {
	@Autowired 
	HospitalService  hospitalService;
	/**
	 * 调用远程的接口插入数据到数据库中
	 */
	@Test
	public void saveHospitalListTest(){
			List<Hospital> hospitalRemoteList = HospitalDataCollection.getHospitalRemoteList();
			for (int i = 0; i < hospitalRemoteList.size(); i++) {
				hospitalService.save(hospitalRemoteList.get(i));
			}
	}
}
