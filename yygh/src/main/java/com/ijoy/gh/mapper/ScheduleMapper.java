package com.ijoy.gh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ijoy.common.query.BaseQuery;
import com.ijoy.gh.domain.Schedule;



public interface ScheduleMapper{
	/*
	 * curd 模块
	 */
	@Insert("insert into schedule(id,doctor_id,p_date,numbers,cost,residueNumbers,noonType) values(schedule_seq.nextval,#{doctor.id},#{date},#{numbers},#{cost},#{residueNumbers},#{noonType})")
	public Long insert(Schedule schedule);

	public void delete(Long id);
    @Update("update schedule set doctor_id=#{doctor.id},date=#{date},numbers=#{numbers},cost=#{cost},residueNumbers=#{residueNumbers},noonType=#{noonType} where id=#{id}")	
	public void update(Schedule schedule);

	@Select("select * from schedule where id=#{id}")
	@ResultMap("scheduleResult")
	public Schedule get(Long id);
	@Select("select * from schedule")
	public List<Schedule> getAll();
	

	public Long queryTotalCount(BaseQuery baseQuery);

	public List<Schedule> queryRows(BaseQuery baseQuery);
	

}
