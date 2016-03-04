package com.ijoy.common.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.common.domain.Employee;
import com.ijoy.common.domain.Hospital;
import com.ijoy.common.mapper.HospitalMapper;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.HospitalQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.service.HospitalService;

@Service
public class HospitalServiceImpl  implements HospitalService {
	@Autowired
	private HospitalMapper hospitalMapper;

	@Override
	public PageResult<Hospital> queryPage(HospitalQuery  basequery) {
		Long totalCount=hospitalMapper.queryTotalCount(basequery);
		if(totalCount>0){
			List<Hospital> rows= hospitalMapper.queryRows(basequery);
			
			return new PageResult<>(totalCount, rows, basequery.getPageSize(), basequery.getCurrentPage());
		}
		
		return new PageResult<>();
	}

	@Override
	public PageResult<Hospital> queryUserCollectHospital(Employee employee,
			Long type, BaseQuery baseQuery) {
		if(employee==null || employee.getId()==0)return null;
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("type", type);
		hashMap.put("employeeId", employee.getId());
		hashMap.put("baseQuery", baseQuery);
		
		Long totalCount=hospitalMapper.queryUserCollectHospitalTotalCount(hashMap);
		LOGGER.debug("totalCount::"+totalCount);
		if(totalCount>0){
			List<Hospital> rows=hospitalMapper.queryUserCollectHospitalRows(hashMap);
			return new PageResult<>(totalCount, rows, baseQuery.getPageSize(), baseQuery.getCurrentPage());
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void save(Hospital hospital) {
		/*hospitalMapper.save(hospital);*/
	}

	@Override
	public void delete(Long id) {
		hospitalMapper.delete(id);
	}

	@Override
	public void update(Hospital hospital) {
		hospitalMapper.update(hospital);
	}

	@Override
	public Hospital get(Long id) {
		return hospitalMapper.get(id);
	}


	
}
