package com.ijoy.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.plat.domain.Application;
import com.ijoy.plat.mapper.ApplicationMapper;
import com.ijoy.plat.query.BaseQuery;
import com.ijoy.plat.query.PageResult;
import com.ijoy.plat.service.IApplicationService;
@Service
public class ApplicationServiceImpl  implements IApplicationService {
		@Autowired
		private ApplicationMapper mapper;
	@Override
	public Long insert(Application t) {
		
		return mapper.insert(t);
	}

	@Override
	public void delete(Long id) {
		mapper.delete(id);
	}

	@Override
	public void update(Application t) {
		mapper.update(t);
	}

	@Override
	public Application get(Long id) {
		return mapper.get(id);
	}

	@Override
	public List<Application> getAll() {
		return mapper.getAll();
	}
	@Override
	public PageResult<Application> queryPage(BaseQuery applicationQuery) {
		Long totalCount = mapper.queryTotalCount(applicationQuery);
		if(totalCount>0){
			List<Application> rows = mapper.queryRows(applicationQuery);
			return new PageResult<>(totalCount, rows, applicationQuery.getPageSize()	, applicationQuery.getCurrentPage());
		}
		    return new PageResult<>();
	}

	@Override
	public PageResult<Application> queryApplicationJoinEmployeePage(BaseQuery applicationQuery) {
		Long totalCount = mapper.queryApplicationJoinEmployeeTotalCount(applicationQuery);
		System.out.println(totalCount);
		if(totalCount>0){
			List<Application> rows = mapper.queryApplicationJoinEmployeeRows(applicationQuery);
			System.out.println(rows.size());
			return new PageResult<>(totalCount, rows, applicationQuery.getPageSize()	, applicationQuery.getCurrentPage());
		}
		    return new PageResult<>();
	}
}

