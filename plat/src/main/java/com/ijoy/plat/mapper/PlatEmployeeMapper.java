package com.ijoy.plat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import com.ijoy.common.domain.Employee;
import com.ijoy.common.query.BaseQuery;
import com.ijoy.plat.domain.PlatEmployee;

public interface PlatEmployeeMapper {
	public Long insert(Employee t);

	public void delete(Long id);
	public void update(Employee t);

	
	public PlatEmployee  get(Long id);

	public List<PlatEmployee> getAll();

	public List<PlatEmployee> queryRows(BaseQuery query);

	public Long queryTotalCount(BaseQuery query);
	/**
	 * 删除employee_application表中的employee_id为employeeId的全部数据
	 * @param employeeId
	 */
	@Delete("delete from employee_application where employee_id=#{employeeId}")
	public void deleteJoinApplication(Long employeeId);

	/**
	 * 增加需要新增的数据到employee_application;
	 * @param employeeId
	 * @param valueOf
	 */
	@Insert("insert into employee_application(employee_id,application_id) values(#{param1},#{param2})")
	public void insertJoinApplication(Long employeeId, Long applicationId);

}
