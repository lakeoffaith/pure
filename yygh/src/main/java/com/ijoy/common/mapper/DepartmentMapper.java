package com.ijoy.common.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ijoy.common.domain.Department;
import com.ijoy.common.query.BaseQuery;


public interface DepartmentMapper{
	/*
	 * curd 模块
	 */
	public Long insert(Department department);

	public void delete(Long id);
	@Update("update department set code=#{code},pinyin=#{pinyin},type=#{type},level=#{level},pic=#{pic},phone=#{phone},name=#{name},hospital_id=#{hospital.id},message=#{message},ghTotal=#{ghTotal},ghHighScore=#{ghHighScore} where id=#{id} ")
	public void update(Department department);
	
	@Select("select * from department where id=#{id}")
	public Department get(Long id);
	

	public List<Department> queryRows(BaseQuery basequery);

	public Long queryTotalCount(BaseQuery basequery);

	public Long queryUserCollectDepartmentTotalCount(
			HashMap<String, Object> hashMap);

	public List<Department> queryUserCollectDepartmentRows(
			HashMap<String, Object> hashMap);
	
	@Select("SELECT DISTINCT(type) FROM department d where hospital_id=#{hospitalId}")
	public List<String> findDepartmentTypeListByHospitalId(Long hospitalId);
	
	
	

}
