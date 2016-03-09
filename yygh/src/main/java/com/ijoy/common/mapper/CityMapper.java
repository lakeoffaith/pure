package com.ijoy.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ijoy.common.domain.City;
import com.ijoy.common.query.CityQuery;

public interface CityMapper {
	
	@Insert("insert into city(id,province_id,p_level,name,pinyin,zip) values (#{id},#{province_id},#{level},#{name},#{pinyin},#{zip})")
	public void insert (City city);
  
	@Select("select * from city where id=#{id}")
	public City get(Long id);
	@Select("select * from city")
	public List<City> getAll();
   @Select("select * from city where name=#{name}")
	public City getByName(String name);
    @Update("update city set province_id=#{province_id},level=#{level},name=#{name},pinyin=#{pinyin},zip=#{zip}  where id=#{id}")
     public void update(City oldCity);

    
	public List<City> queryRows(CityQuery cityQuery);

	 public Long queryTotalCount(CityQuery cityQuery);
	
}
