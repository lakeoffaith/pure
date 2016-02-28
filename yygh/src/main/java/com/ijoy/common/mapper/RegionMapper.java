package com.ijoy.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ijoy.common.domain.Region;

public interface RegionMapper {
        
	  @Insert("insert into region(id,name) values(#{id},#{name})")
		public void insert(Region region);
     @Select("select id,name from region")
	 public List<Region> getAll();
}
