package com.ijoy.plat.service;

import java.util.List;

import com.ijoy.common.query.BaseQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.plat.domain.Feedback;

public interface IFeedbackService  {
	public Long insert(Feedback  t);
	public void delete(Long id);
	public void update(Feedback t);
	public Feedback  get(Long  id);
	public List<Feedback> getAll();
	public PageResult<Feedback> queryPage(BaseQuery baseQuery);

}

