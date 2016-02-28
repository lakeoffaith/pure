package com.ijoy.plat.mapper;

import java.util.List;

import com.ijoy.plat.domain.Application;
import com.ijoy.plat.domain.Sysloginfo;
import com.ijoy.plat.query.BaseQuery;
import com.ijoy.plat.query.SysloginfoQuery;

public interface SysloginfoMapper {
	public Long insert(Sysloginfo  t);

	public void delete(Long  id);
	public void update(Sysloginfo t);

	public Sysloginfo  get(Long  id);

	public List<Sysloginfo> getAll();
	public Long queryTotalCount(BaseQuery query);
	public List<Application> queryRows(SysloginfoQuery baseQuery);
}
