package com.ijoy.plat.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.common.query.PageResult;
import com.ijoy.plat.domain.Application;
import com.ijoy.plat.query.ApplicationQuery;
import com.ijoy.plat.service.IApplicationService;

@Controller
@RequestMapping("/application")
public class ApplicationController {
	@Autowired
	private IApplicationService service;
	
	/*
	 * 更新domain的适合，保存信息更新不丢失。
	 */
	@ModelAttribute
	public void getDomain(@RequestParam(value="id",required=false) Long id,Map<String, Object> map){
		if(id!=null){
			Application application=service.get(id);
			map.put("application", application);
		}
	}
	//返回json
	@RequestMapping(params={"for=json"},method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult listJson(@ModelAttribute ApplicationQuery applicationQuery){
		System.out.println(applicationQuery);
		try {
			PageResult<Application> page;
			if (applicationQuery.getNotEmployee_id()!=null || applicationQuery.getEmployee_id()!=null) {
				page= service.queryApplicationJoinEmployeePage(applicationQuery);
			}else {
				page=service.queryPage(applicationQuery);
			}
			
			return new Ajaxresult(true, page.getRows());
		} catch (Exception e) {
			return new Ajaxresult(false, "用户获取没绑定的应用报错");
		}
	}
	
	//返回页面
@RequestMapping(method=RequestMethod.GET)
public  ModelAndView  list(@ModelAttribute ApplicationQuery applicationQuery){
	System.out.println("list    "+applicationQuery);
	ModelAndView mv = new ModelAndView();
	mv.setViewName("application/list");
	mv.addObject("applicationQuery", applicationQuery);
	mv.addObject("pageResult", service.queryPage(applicationQuery));
	return mv;
}
//查看单个
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public  String  get(@PathVariable Long id,Model model){
		Application  application=service.get(id);	
		model.addAttribute("application", application);
		return "application/view";
	}
	//修改单个
	@RequestMapping(value="/{id}",params={"method=goUpdate"},method=RequestMethod.GET)
	public  String  goUpdate(@PathVariable Long id,Model model){
		Application  application=service.get(id);	
		model.addAttribute("application", application);
		return "application/input";
	}
	

//更新单个
	//更新，保存
	@RequestMapping(method=RequestMethod.POST)
	public String save(@ModelAttribute("application") Application application){
		System.out.println(application);
		if(application.getId()!=null){
			service.update(application);
		}else {
			service.insert(application);
		}
		return  "redirect:application";
	}
	
//进入新增单个
@RequestMapping(params="method=goSave",method=RequestMethod.GET)
public String goSave(){
	return "application/input";
}

//删除单个
@RequestMapping(value="/{id}",params="method=delete",method=RequestMethod.GET)
@ResponseBody
public Ajaxresult delete(@PathVariable Long id){
	try {
		service.delete(id);
		return new Ajaxresult(true, "删除成功");
	} catch (Exception e) {
		return new Ajaxresult(false, "删除失败");
	}
}
//批量删除
@RequestMapping(params="method=batchDelete",method=RequestMethod.GET)
@ResponseBody
public Ajaxresult deleteBatch(@RequestParam(value="ids",required=true) String ids){
	Ajaxresult ajaxResult;
	if(ids==null){
		ajaxResult= new Ajaxresult(false, "请选中需要删除的应用");
		return ajaxResult;
	}
	String[] idArray = ids.split(",");
	try {
		for (int i = 0; i < idArray.length; i++) {
			service.delete(Long.valueOf(idArray[i]));
		}
		
		ajaxResult=new Ajaxresult(true,"删除成功");
	} catch (Exception e) {
		ajaxResult=new Ajaxresult(false,"异常:" + e.getMessage());
	}
	return ajaxResult;
}

}
