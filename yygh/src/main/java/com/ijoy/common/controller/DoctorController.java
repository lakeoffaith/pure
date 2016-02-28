package com.ijoy.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.common.domain.Doctor;
import com.ijoy.common.query.DoctorQuery;
import com.ijoy.common.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	DoctorService doctorService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult  search(@ModelAttribute DoctorQuery baseQuery) throws Exception{
		List<Doctor> doctors = doctorService.queryDoctor(baseQuery).getRows();
		System.out.println(doctors);
		return new Ajaxresult(true, doctors);
	}

	
	
	
	@RequestMapping(params="type=html",method=RequestMethod.GET)
	public ModelAndView search() throws Exception{
		return new ModelAndView("doctor/doctor-search");
	}

	
	@RequestMapping(value="/{id}",params="type=html",method=RequestMethod.GET)
	public ModelAndView show(@PathVariable Long id) throws Exception{
		ModelAndView mv = new ModelAndView("doctor/show");
		Doctor doctor = doctorService.get(id);
		System.out.println(doctor);
		mv.addObject("doctor", doctor);
		return mv;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult get(@PathVariable Long id) throws Exception{
		return new Ajaxresult(true, doctorService.get(id));
	}
}
