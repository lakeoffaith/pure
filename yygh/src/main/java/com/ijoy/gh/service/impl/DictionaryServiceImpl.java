package com.ijoy.gh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.common.query.PageResult;
import com.ijoy.gh.domain.Dictionary;
import com.ijoy.gh.mapper.DictionaryMapper;
import com.ijoy.gh.query.DictionaryQuery;
import com.ijoy.gh.service.DictionaryService;

@Service
public class DictionaryServiceImpl  implements DictionaryService {
	@Autowired
	private DictionaryMapper dictionaryMapper;

	@Override
	public void save(Dictionary dictionary) {
		 dictionaryMapper.insert(dictionary);
	}

	@Override
	public void delete(Long id) {
		dictionaryMapper.delete(id);
	}

	@Override
	public void update(Dictionary dictionary) {
		dictionaryMapper.update(dictionary);
	}

	@Override
	public Dictionary get(Long id) {
		return dictionaryMapper.get(id);
	}

	@Override
	public PageResult<Dictionary> queryDictionary(DictionaryQuery baseQuery) {
		Long totalCount=dictionaryMapper.queryTotalCount(baseQuery);
		if( totalCount>0){
			List<Dictionary> rows=dictionaryMapper.queryRows(baseQuery);
			return new PageResult<Dictionary>(totalCount, rows, baseQuery.getPageSize(), baseQuery.getCurrentPage());
		}
		return null;
	}
	
}
