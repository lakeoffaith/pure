package com.ijoy.common.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.common.domain.Doctor;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.mapper.DoctorMapper;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.service.DoctorService;

@Service
public class DoctorServiceImpl  implements DoctorService {
	@Autowired
	private DoctorMapper doctorMapper;

	@Override
	public PageResult<Doctor> queryDoctor(BaseQuery basequery) {
		Long totalCount=doctorMapper.queryDoctorTotalCount(basequery);
		LOGGER.debug("totalCount::"+totalCount);
		if(totalCount>0){
			List<Doctor> rows= doctorMapper.queryDoctorRows(basequery);
			return new PageResult<>(totalCount, rows, basequery.getPageSize(), basequery.getCurrentPage());
		}
		return new PageResult<>();
	}

	@Override
	public PageResult<Doctor> queryUserCollectDoctor(Employee employee,
			Long type, BaseQuery baseQuery) {
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("employeeId", employee.getId());
		hashMap.put("type", type);
		hashMap.put("baseQuery", baseQuery);
		Long totalCount=doctorMapper.queryUserCollectDoctorTotalCount(hashMap);
		LOGGER.debug("totalCount::"+totalCount);
		if(totalCount>0){
			List<Doctor> rows=doctorMapper.queryUserCollectDoctorRows(hashMap);
			return new PageResult<>(totalCount, rows, baseQuery.getPageSize(), baseQuery.getCurrentPage());
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void save(Doctor doctor) {
		 doctorMapper.insert(doctor);
	}

	@Override
	public void delete(Long id) {
		doctorMapper.delete(id);
	}

	@Override
	public void update(Doctor doctor) {
		doctorMapper.update(doctor);
	}

	@Override
	public Doctor get(Long id) {
		return doctorMapper.get(id);
	}

	
	
}
