package com.ijoy.service;

import java.io.IOException;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.plat.domain.Task;
import com.ijoy.plat.service.ITaskService;


public class TaskServiceTest extends BaseTest{
	@Autowired
	private ITaskService taskService;

	@Test
	public void getAllTest() {
		List<Task> tasks = taskService.getAll();
		System.out.println(tasks);
		
	}
	@Test
	public void deleteTest() {
		
		//删除
		Long id=1L;
		taskService.delete(id);
		
	}
	@Test
	public void encodeTest() throws IOException {
		/*SecureRandom.*/
		
	}
}
