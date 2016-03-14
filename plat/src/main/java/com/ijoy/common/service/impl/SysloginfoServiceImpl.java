package com.ijoy.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.common.domain.Sysloginfo;
import com.ijoy.common.mapper.SysloginfoMapper;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.query.SysloginfoQuery;
import com.ijoy.common.service.ISysloginfoService;
import com.ijoy.plat.domain.Application;

@Service
public class SysloginfoServiceImpl   implements ISysloginfoService {
	@Autowired
	private SysloginfoMapper mapper;

	@Override
	public Long insert(Sysloginfo t) {
		return mapper.insert(t);
	}

	@Override
	public void delete(Long id) {
		mapper.delete(id);
	}

	@Override
	public void update(Sysloginfo t) {
		mapper.update(t);
	}

	@Override
	public Sysloginfo get(Long id) {
		return mapper.get(id);
	}

	@Override
	public List<Sysloginfo> getAll() {
		return mapper.getAll();
	}

	@Override
	public PageResult<Sysloginfo> queryPage(SysloginfoQuery baseQuery) {
		Long totalCount = mapper.queryTotalCount(baseQuery);
		if(totalCount>0){
			List<Application> rows = mapper.queryRows(baseQuery);
			return new PageResult<>(totalCount, rows, baseQuery.getPageSize()	, baseQuery.getCurrentPage());
		}
		return new PageResult<>();
	}
	
}

