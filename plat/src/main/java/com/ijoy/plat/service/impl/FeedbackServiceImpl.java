package com.ijoy.plat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijoy.plat.domain.Feedback;
import com.ijoy.plat.mapper.FeedbackMapper;
import com.ijoy.plat.query.BaseQuery;
import com.ijoy.plat.query.FeedbackQuery;
import com.ijoy.plat.query.PageResult;
import com.ijoy.plat.service.IFeedbackService;

@Service
public class FeedbackServiceImpl   implements IFeedbackService {
	@Autowired
	private FeedbackMapper mapper;
	@Override
	public Long insert(Feedback t) {
		return mapper.insert(t);
	}

	@Override
	public void delete(Long id) {
		mapper.delete(id);
	}

	@Override
	public void update(Feedback t) {
		mapper.update(t);
	}

	@Override
	public Feedback get(Long id) {
		return mapper.get(id);
	}

	@Override
	public List<Feedback> getAll() {
		return mapper.getAll();
	}

	@Override
	public PageResult<Feedback> queryFeedbacks(BaseQuery baseQuery) {
		Long totalCount = mapper.queryTotalCount(baseQuery);
		if(totalCount>0){
			List<Feedback> rows = mapper.queryRows(baseQuery);
			return new PageResult<>(totalCount, rows, baseQuery.getPageSize()	, baseQuery.getCurrentPage());
		}
		return null;
	}
	
}

