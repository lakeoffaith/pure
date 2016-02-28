package com.ijoy.plat.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	//调整index页面
	@RequestMapping("index")
	public String execute(){
		return "index";
	}
	//首页的主页面
	@RequestMapping("main")
	public String main(){
		return "main";
	}
	
}
