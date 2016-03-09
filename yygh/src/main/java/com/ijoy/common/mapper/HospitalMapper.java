package com.ijoy.common.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.ijoy.common.domain.Hospital;
import com.ijoy.common.query.BaseQuery;

@Component(value="hospitalMapper")
public interface HospitalMapper{
	/*
	 * curd 模块
	 */
	public Long  insert(Hospital hospital);

	public void delete(Long id);
	
	public void update(Hospital hospital);

	@Select("select * from hospital where id=#{id}")
	@ResultMap("hospitalResult")
	public Hospital get(Long id);
	
	@Select("select * from hospital order by id")
	public List<Hospital> getAll();

	public Long queryTotalCount(BaseQuery basequery);

	public List<Hospital> queryRows(BaseQuery basequery);

	public Long queryUserCollectHospitalTotalCount(
			HashMap<String, Object> hashMap);

	public List<Hospital> queryUserCollectHospitalRows(
			HashMap<String, Object> hashMap);

	@Insert("insert into hospital_employee(hospital_id,employee_id,type)  values  (#{0},#{1},#{2})")
	public void insertHospitalJoinEmployee(Long hospital_id, Long employee_id, Long type);
	

}
