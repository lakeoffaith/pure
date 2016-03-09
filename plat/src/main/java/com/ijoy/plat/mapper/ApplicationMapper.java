package com.ijoy.plat.mapper;

import java.util.List;

import com.ijoy.plat.domain.Application;
import com.ijoy.plat.query.BaseQuery;

public interface ApplicationMapper {
	public Long insert(Application t);

	public void delete(Long id);
	public void update(Application t);

	public Application get(Long  id);

	public List<Application> getAll();

	public List<Application> queryRows(BaseQuery query);

	public Long queryTotalCount(BaseQuery query);
	

	public Long queryApplicationJoinEmployeeTotalCount(BaseQuery applicationQuery);

	public List<Application> queryApplicationJoinEmployeeRows(BaseQuery applicationQuery);
}
