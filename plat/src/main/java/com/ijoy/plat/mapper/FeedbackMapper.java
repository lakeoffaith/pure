package com.ijoy.plat.mapper;

import java.util.List;

import com.ijoy.plat.domain.Feedback;
import com.ijoy.plat.query.BaseQuery;

public interface FeedbackMapper {
	public Long insert(Feedback t);

	public void delete(Long id);
	public void update(Feedback t);

	public Feedback get(Long id);

	public List<Feedback> getAll();

	public List<Feedback> queryRows(BaseQuery query);

	public Long queryTotalCount(BaseQuery query);
}
