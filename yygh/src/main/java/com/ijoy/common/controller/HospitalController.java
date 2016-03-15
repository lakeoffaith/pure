package com.ijoy.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.common.comutil.Context.UserContext;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.domain.Hospital;
import com.ijoy.common.query.HospitalQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.service.HospitalService;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
	@Autowired
	HospitalService hospitalService;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 * index/main.jsp   根据城市id来获得医院的json
	 */
	@RequestMapping(params={"for=json"},method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult search(@ModelAttribute HospitalQuery baseQuery) throws Exception{
		try {
			PageResult<Hospital> pageResult = hospitalService.queryPage(baseQuery);
			return new Ajaxresult(true, pageResult);
		} catch (Exception e) {
			return new Ajaxresult(false, "查询医院列表出错");
		}
		
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView  show() throws Exception{
		ModelAndView mv = new ModelAndView("hospital/hospital-search");
		
	return mv;
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView show(@PathVariable Long id) throws Exception{
		ModelAndView mv=new ModelAndView("hospital/show");
		Hospital hospital = hospitalService.get(id);
		mv.addObject("hospital",hospital );
		System.out.println("====================="+hospital);
		return mv;
	}
	
	@RequestMapping(value="/{id}",params="method=collect",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult collect(@PathVariable Long id,HttpServletRequest request){
		Employee employee = UserContext.getUser(request);
		try {
			hospitalService.insertHospitalJoinEmployee(id,employee.getId(),Hospital.TYPE_COLLECT);
			return new Ajaxresult(true,"收藏成功");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Ajaxresult(false, "收藏失败");
		}
		
	}

}
