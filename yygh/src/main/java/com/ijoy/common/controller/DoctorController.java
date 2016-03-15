package com.ijoy.common.controller;

import java.util.List;

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
import com.ijoy.common.domain.Doctor;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.query.DoctorQuery;
import com.ijoy.common.query.PageResult;
import com.ijoy.common.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	DoctorService doctorService;
	
	
	@RequestMapping(params="for=json",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult  search(@ModelAttribute DoctorQuery baseQuery) throws Exception{
		PageResult<Doctor> pageResult = doctorService.queryDoctor(baseQuery);
		return new Ajaxresult(true, pageResult);
	}

	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView search() throws Exception{
		return new ModelAndView("doctor/doctor-search");
	}

	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ModelAndView show(@PathVariable Long id) throws Exception{
		ModelAndView mv = new ModelAndView("doctor/show");
		Doctor doctor = doctorService.get(id);
		System.out.println(doctor);
		mv.addObject("doctor", doctor);
		return mv;
	}
	
	@RequestMapping(value="/{id}",params="for=json",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult get(@PathVariable Long id) throws Exception{
		return new Ajaxresult(true, doctorService.get(id));
	}
	
	/**
	 * 医生和用户之间的关系保存
	 */
	@RequestMapping(value="/{id}",params="method=collect",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult collect(@PathVariable long id,HttpServletRequest request){
		try {
			Employee employee = UserContext.getUser(request);
			doctorService.insertDoctorJoinEmployee(id,employee.getId(),Doctor.TYPE_COLLECT);
			return new Ajaxresult(true, "确认关系成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Ajaxresult(false, "确认关系失败");
		}
	}
	
}
