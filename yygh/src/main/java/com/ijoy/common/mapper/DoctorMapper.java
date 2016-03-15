package com.ijoy.common.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ijoy.common.domain.Doctor;
import com.ijoy.common.query.BaseQuery;



public interface DoctorMapper{
	/*
	 * curd 模块
	 */
	@Insert("insert into doctor(id,name,department_id,hospital_id,introduce) values(doctor_seq.nextval,#{name},#{department.id},#{hospital_id},#{introduce})")
	public Long insert(Doctor doctor);
	public void delete(Long id);
	@Update("update doctor set name=#{name},pic=#{pic},department_id=#{department.id},hospital_id=#{hospital.id},introduce=#{introduce},ghTotal=#{ghTotal},ghHighScore=#{ghHighScore} where id=#{id}")
	public void update(Doctor doctor);
	@Select("select * from doctor where id=#{id}")
	@ResultMap("doctorResult")
	public Doctor get(Long id);
	@Select("select * from doctor")
	public List<Doctor> getAll();
	public Long queryTotalCount(BaseQuery basequery);
	public List<Doctor> queryRows(BaseQuery basequery);
	public Long queryUserCollectDoctorTotalCount(HashMap<String, Object> hashMap);
	public List<Doctor> queryUserCollectDoctorRows(
			HashMap<String, Object> hashMap);
	@Insert("insert into doctor_employee(doctor_id,employee_id,type) values(#{0},#{1},#{2})")
	public void insertDoctorJoinEmployee(long doctor_id, Long employee_id, long type);
	

}
