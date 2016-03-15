package com.ijoy.common.service;

import java.util.List;

import com.ijoy.common.domain.Sysloginfo;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.query.SysloginfoQuery;

public interface ISysloginfoService  {
	
	public Long insert(Sysloginfo  t);

	public void delete(Long id);
	public void update(Sysloginfo t);

	public Sysloginfo  get(Long  id);

	public List<Sysloginfo> getAll();

	public  PageResult<Sysloginfo>  queryPage(SysloginfoQuery baseQuery);
}

