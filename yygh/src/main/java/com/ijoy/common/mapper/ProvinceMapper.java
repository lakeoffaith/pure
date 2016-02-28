package com.ijoy.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ijoy.common.domain.Province;

public interface ProvinceMapper {

	@Insert("insert into province(name,region_id,id) values(#{name},#{region_id},#{id})")
	 public void insert(Province province);
    
	@Select("select * from province")
	public List<Province> getAll();
}
