package com.ijoy.common.web.controller;

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
import com.ijoy.common.domain.Sysloginfo;
import com.ijoy.common.query.SysloginfoQuery;
import com.ijoy.common.service.ISysloginfoService;


@Controller
@RequestMapping("/sysloginfo")
public class SysloginfoController {
	@Autowired
	private ISysloginfoService service;
	
	/*
	 * 更新domain的适合，保存信息更新不丢失。
	 */
	@ModelAttribute
	public void getDomain(@RequestParam(value="id",required=false) Long id,Map<String, Object> map){
		if(id!=null){
			Sysloginfo sysloginfo=service.get(id);
			map.put("sysloginfo", sysloginfo);
		}
	}
	
@RequestMapping(method=RequestMethod.GET)
public  ModelAndView  list(@ModelAttribute SysloginfoQuery sysloginfoQuery){
	System.out.println("list    "+sysloginfoQuery);
	ModelAndView mv = new ModelAndView();
	mv.setViewName("common/sysloginfo/list");
	mv.addObject("sysloginfoQuery", sysloginfoQuery);
	mv.addObject("pageResult", service.queryPage(sysloginfoQuery));
	return mv;
}
//查看单个
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public  String  get(@PathVariable Long id,Model model){
		Sysloginfo  sysloginfo=service.get(id);	
		model.addAttribute("sysloginfo", sysloginfo);
		return "common/sysloginfo/view";
	}
	//修改单个
	@RequestMapping(value="/{id}",params={"method=goUpdate"},method=RequestMethod.GET)
	public  String  goUpdate(@PathVariable Long id,Model model){
		Sysloginfo  sysloginfo=service.get(id);	
		model.addAttribute("sysloginfo", sysloginfo);
		return "common/sysloginfo/input";
	}
	

//更新单个
	//更新，保存
	@RequestMapping(method=RequestMethod.POST)
	public String save(@ModelAttribute("sysloginfo") Sysloginfo sysloginfo){
		System.out.println(sysloginfo);
		if(sysloginfo.getId()!=null){
			service.update(sysloginfo);
		}else {
			service.insert(sysloginfo);
		}
		return  "redirect:sysloginfo";
	}
	
//进入新增单个
@RequestMapping(params="method=goSave",method=RequestMethod.GET)
public String goSave(){
	return "common/sysloginfo/input";
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
		ajaxResult= new Ajaxresult(false, "请选中需要删除的对象");
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
