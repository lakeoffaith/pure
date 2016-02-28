package com.ijoy.plat.web.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.plat.domain.Application;
import com.ijoy.plat.domain.TaskItem;
import com.ijoy.plat.service.ITaskItemService;

@Controller
@RequestMapping("/taskItem")
public class TaskItemController {
	@Autowired
	private ITaskItemService service;
	

	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public  Ajaxresult  list(@Param("task_id") Long task_id){
		List<TaskItem> taskItemListByTaskId = service.getTaskItemListByTaskId(task_id);
		return new Ajaxresult(true, taskItemListByTaskId);
	}
	
	//修改单个
	@RequestMapping(value="/{id}",params="type=goUpdate",method=RequestMethod.GET)
	public String goUpdate(@PathVariable Long id){
		TaskItem  taskItem=service.get(id);	
		return "taskItem/input";
	}
	
	//更新单个
	
	@RequestMapping(value="/{id}",params="type=update",method=RequestMethod.GET)
	public Ajaxresult update(@ModelAttribute Application application){
		return null;
	}
	//进入新增单个
	@RequestMapping(params="type=goSave",method=RequestMethod.GET)
	public String goSave(){
		return "application/input";
	}
	
	//保存单个
	@RequestMapping(method=RequestMethod.POST)
	public Ajaxresult save(@ModelAttribute Application application){
		return null;
	}
	//删除单个
	@RequestMapping(value="/{id}",params="type=delete",method=RequestMethod.GET)
	public Ajaxresult delete(@PathVariable Long id){
		try {
			service.delete(id);
			return new Ajaxresult(true, "删除成功");
		} catch (Exception e) {
			return new Ajaxresult(false, "删除失败");
		}
	}
	
	
	
	
	//批量删除
	@RequestMapping(value="/batch/ids",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult deleteBatch(@PathVariable String ids){
		Ajaxresult ajaxResult;
		if(StringUtils.isEmpty(ids)){
			ajaxResult= new Ajaxresult(false, "请选中需要删除的用户");
			return ajaxResult;
		}
		String[] idArray = ids.split(",");
		try {
			for (String id : idArray) {
				if(!StringUtils.isEmpty(id)){
					
					service.delete(Long.getLong(id));
				}
			}
			ajaxResult=new Ajaxresult(true,"删除成功");
		} catch (Exception e) {
			ajaxResult=new Ajaxresult(false,"异常:" + e.getMessage());
		}
		return ajaxResult;
	}
}
