package com.ijoy.gh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ijoy.gh.domain.Dictionary;
import com.ijoy.gh.query.DictionaryQuery;



public interface DictionaryMapper{
	/*
	 * curd 模块
	 */
	@Insert("insert into dictionary(id,name,type) values (dictionary_seq.nextval,#{name},#{type})")
	public Long insert(Dictionary dictionary);

	public void delete(Long id);
	
	public void update(Dictionary dictionary);

	@Select("select * from dictionary where id=#{id}")
	public Dictionary get(Long id);
	
	@Select("select * from dictionary")
	public List<Dictionary> getAll();

	public List<Dictionary> queryRows(DictionaryQuery baseQuery);

	public Long queryTotalCount(DictionaryQuery baseQuery);
	

}
