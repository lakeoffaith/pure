package com.ijoy.common.service.impl;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.common.domain.Department;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.mapper.DepartmentMapper;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.service.DepartmentService;

@Service
public class DepartmentServiceImpl  implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public List<String> findDepartmentTypeListByHospitalId(Long hospitalId) {
		return departmentMapper.findDepartmentTypeListByHospitalId(hospitalId);
	}
	
	@Override
	public PageResult<Department> queryDepartmentPage(BaseQuery basequery) {
		
		
		Long totalCount=departmentMapper.queryTotalCount(basequery);
		if( totalCount>0){
			List<Department> rows=departmentMapper.queryRows(basequery);
			return new PageResult<Department>(totalCount, rows, basequery.getPageSize(), basequery.getCurrentPage());
		}
		return new PageResult<Department>();
		
	}
	
	
	@Override
	public PageResult<Department> queryUserCollectDepartment(Employee employee,
			Long type,BaseQuery baseQuery) {
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("employeeId", employee.getId());
		hashMap.put("type", type);
		hashMap.put("baseQuery", baseQuery);
		Long totalCount=departmentMapper.queryUserCollectDepartmentTotalCount(hashMap);
		LOGGER.debug("totalCount::"+totalCount);
		if(totalCount!=null && totalCount>0){
			List<Department> rows=departmentMapper.queryUserCollectDepartmentRows(hashMap);
			return new PageResult<Department>(totalCount, rows, baseQuery.getPageSize(), baseQuery.getCurrentPage());
		}
		
		return new PageResult<>();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void save(Department department) {
	departmentMapper.insert(department);
	}

	@Override
	public void delete(Long id) {
		departmentMapper.delete(id);
	}

	@Override
	public void update(Department department) {
		departmentMapper.update(department);
	}

	@Override
	public Department get(Long id) {
		return departmentMapper.get(id);
	}

	@Override
	public void insertDepartmentJoinEmployee(Long department_id, Long employee_id, Long type) {
			departmentMapper.insertDepartmentJoinEmployee(department_id,employee_id,type);
	}


	





























	

	
	
}
