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
import com.ijoy.plat.domain.Employee;
import com.ijoy.plat.query.EmployeeQuery;
import com.ijoy.plat.query.PageResult;
import com.ijoy.plat.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService   employeeService;
	
	/*
	 * 更新domain的适合，保存信息更新不丢失。
	 */
	@ModelAttribute
	public void getDomain(@RequestParam(value="id",required=false) Long id,Map<String, Object> map){
		if(id!=null){
			Employee employee = employeeService.get(id);
			map.put("employee", employee);
		}
	}
	@RequestMapping(method=RequestMethod.GET )
	public  ModelAndView  list(@ModelAttribute  EmployeeQuery  employeeQuery){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employee/list");
		mv.addObject("employeeQuery", employeeQuery);
		mv.addObject("pageResult", employeeService.queryEmployees(employeeQuery));
		return mv;
	}
  //查看单个
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public  String  get(@PathVariable Long id,Model model){
		Employee  employee=employeeService.get(id);	
		model.addAttribute("employee", employee);
		return "employee/view";
	}
	//修改单个
		@RequestMapping(value="/{id}",params={"method=goUpdate"},method=RequestMethod.GET)
		public  String  goUpdate(@PathVariable Long id,Model model){
			System.out.println("/employee");
			Employee  employee=employeeService.get(id);	
			model.addAttribute("employee", employee);
			return "employee/input";
		}
		
		//更新，保存
		@RequestMapping(method=RequestMethod.POST)
		public String save(@ModelAttribute("employee") Employee employee){
			System.out.println("++++++++++++++++++++==");
			System.out.println(employee);
			if(employee.getId()!=null){
				employeeService.update(employee);
			}
			return  "redirect:employee";
		}
		//进入新增单个
		@RequestMapping(params="type=goSave",method=RequestMethod.GET)
		public String goSave(){
			return  "employee/input";
		}
		
		//删除单个
		@RequestMapping(value="/{id}",params="method=delete",method=RequestMethod.GET)
		@ResponseBody
		public  Ajaxresult delete(@PathVariable Long id){
			System.out.println(id);
			try {
				employeeService.delete(id);
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
				ajaxResult= new Ajaxresult(false, "请选中需要删除的用户");
				return ajaxResult;
			}
			String[] idArray = ids.split(",");
			try {
				for (int i = 0; i < idArray.length; i++) {
					employeeService.delete(Long.valueOf(idArray[i]));
				}
				
				ajaxResult=new Ajaxresult(true,"删除成功");
			} catch (Exception e) {
				ajaxResult=new Ajaxresult(false,"异常:" + e.getMessage());
			}
			return ajaxResult;
		}
	
}
