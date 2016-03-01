package com.ijoy.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.plat.domain.Feedback;
import com.ijoy.plat.query.BaseQuery;
import com.ijoy.plat.query.FeedbackQuery;
import com.ijoy.plat.query.PageResult;
import com.ijoy.plat.service.IFeedbackService;


public class FeedbackServiceTest extends BaseTest{
	@Autowired
	private IFeedbackService feedbackService;

	@Test
	public void getAllTest() {
		List<Feedback> feedbacks = feedbackService.getAll();
		System.out.println(feedbacks);
		
	}
	@Test
	public void queryTest(){
		BaseQuery baseQuery=new FeedbackQuery();
		PageResult<Feedback> pageResult = feedbackService.queryPage(baseQuery);
		System.out.println(pageResult.getRows().size());
	}
	
	@Test
	public void deleteTest() {
		
		//删除
		Long id=1L;
		feedbackService.delete(id);
		
	}
}
