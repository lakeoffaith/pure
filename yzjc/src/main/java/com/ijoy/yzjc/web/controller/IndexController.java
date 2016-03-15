package com.ijoy.yzjc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;








/**
 * 登录，注册，首页   
 * @author zhengang
 *
 */
@Controller
@RequestMapping("/")
public class IndexController{
		
	/*
	 * 进入登录界面
	 */
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String login() throws Exception {
		return "index/signin";
	}
	
	
	/*
	 * 进入注册界面
	 */
	@RequestMapping(value="register",method = RequestMethod.GET)
	public String register() throws Exception {
		return "index/signup";
	}
	
	
	/*
	 * 进入首页
	 */
	
	@RequestMapping(value="main",method = RequestMethod.GET)
	public ModelAndView main() throws Exception {
		System.out.println("16");
		ModelAndView modelAndView = new ModelAndView("main");
		return modelAndView;
	}
	
}

