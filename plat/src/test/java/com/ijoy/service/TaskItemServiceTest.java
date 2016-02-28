package com.ijoy.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.plat.domain.Employee;
import com.ijoy.plat.domain.TaskItem;
import com.ijoy.plat.service.ITaskItemService;


public class TaskItemServiceTest extends BaseTest{
	@Autowired
	private ITaskItemService taskItemService;

	@Test
	public void getAllTest() {
		List<TaskItem> taskItems = taskItemService.getAll();
		System.out.println(taskItems);
		
	}
	@Test
	public void deleteTest() {
		
		//删除
		Long id=1L;
		taskItemService.delete(id);
		
	}
	@Test
	public void saveTest() {
		TaskItem taskItem = new TaskItem();
		Employee employee = new Employee();
		employee.setId(38L);
		taskItem.setEmployee(employee);
		taskItem.setState(1);
		Long save = taskItemService.insert(taskItem);
		System.out.println(save);
		
	}
	
	//根据任务id，来查对应的任务的子项的id
	
	@Test
	public void getTaskItemListByTaskId(){
		Long id=1L;
		List<TaskItem> taskItems=taskItemService.getTaskItemListByTaskId(id);
	}
}
