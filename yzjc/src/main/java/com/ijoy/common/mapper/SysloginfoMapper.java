package com.ijoy.common.mapper;

import java.util.List;

import com.ijoy.common.domain.Sysloginfo;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.SysloginfoQuery;

public interface SysloginfoMapper {
	public Long insert(Sysloginfo  t);

	public void delete(Long  id);
	public void update(Sysloginfo t);

	public Sysloginfo  get(Long  id);

	public List<Sysloginfo> getAll();
	public Long queryTotalCount(BaseQuery query);
	public List<Sysloginfo> queryRows(SysloginfoQuery baseQuery);
}
