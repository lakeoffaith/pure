package com.ijoy.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.plat.domain.Application;
import com.ijoy.plat.domain.Sysloginfo;
import com.ijoy.plat.mapper.SysloginfoMapper;
import com.ijoy.plat.query.PageResult;
import com.ijoy.plat.query.SysloginfoQuery;
import com.ijoy.plat.service.ISysloginfoService;

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

