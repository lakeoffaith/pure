package com.ijoy.common.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.common.comutil.ApiResult;
import com.ijoy.common.comutil.CookieUtil;
import com.ijoy.common.comutil.MD5Util;
import com.ijoy.common.comutil.UserContext;
import com.ijoy.common.domain.Employee;
import com.ijoy.common.domain.LoginInfo;
import com.ijoy.common.domain.Menu;
import com.ijoy.common.domain.Sysloginfo;
import com.ijoy.common.service.IEmployeeService;
import com.ijoy.common.service.ILoginInfoService;
import com.ijoy.common.service.IMenuService;
import com.ijoy.common.service.ISysloginfoService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/loginInfo")
public class LoginInfoController {

		@Autowired
		private ILoginInfoService loginInfoService;
		
		@Autowired
		private IEmployeeService employeeService;
		
		@Autowired
		private IMenuService menuService;
		
		@Autowired
		private ISysloginfoService sysloginfoService;
		
		
		//默认不记住密码
	    private boolean stringRegex(String in,String regex){
	    	return in.matches(regex);
	    }
	    @RequestMapping(value="/check/api",method=RequestMethod.POST)
	    @ResponseBody
	    public ApiResult apiCheck(HttpServletRequest request){
	    	StringBuffer jb=new StringBuffer();
	    	String line=null;
	    	try{
	    		BufferedReader reader = request.getReader();
	    		while((line=reader.readLine())!=null)
	    			jb.append(line);
	    	}catch(Exception e){
	    		System.out.println("error");
	    	}
	    	System.out.println("jb="+jb);
	    	try{
	    		JSONObject jsonObject=JSONObject.fromObject(jb.toString());
	    		System.out.println("jsonObject="+jsonObject);
	    	}catch(Exception e){
	    		System.out.println("error");
	    	}
	    	
	    	System.out.println("request="+request.getHeader("Authorization"));
	    	LoginInfo user=loginInfoService.findByLogin(new LoginInfo("admin1",MD5Util.JM(MD5Util.MD5("admin1"))));
	    	if(user!=null){
	    		//根据（user_id,生产时间，设备类型）
	    		ApiResult result=new ApiResult(true,user);
	    		result.setToken(user.getId()+":"+new Date().getTime()+":"+"android");
	    		return result;
	    	}
	    	return new ApiResult(false,"登录失败");
	    	
	    }
		// 处理登录请求
	    @RequestMapping(value="/check",method=RequestMethod.POST)
		public String check(@ModelAttribute LoginInfo loginInfo,HttpServletRequest request,HttpServletResponse response) throws Exception {
			 /** 后台验证name,password;*/
	    	System.out.println(loginInfo);
			 String name=loginInfo.getName();
			 String password=loginInfo.getPassword();
			if(stringRegex(name,"^[a-zA-Z](?![a-zA-Z]+$)\\w{4,10}$") && stringRegex(password, "^[a-zA-Z](?![a-zA-Z]+$)\\w{4,10}$")){
				/**/
			 loginInfo = loginInfoService.findByLogin(new LoginInfo(name,MD5Util.JM(MD5Util.MD5(password)) ));
				 System.out.println("enter check "+loginInfo);
				if (loginInfo != null) {// 登录成功
					
					 //** 1 将用户登录用户放入session中
					 /*根据LoginInfo来获得Employee相同的id*/
					 
					Employee employee=employeeService.findEmployeeByLoginInfoID(loginInfo.getId());
					UserContext.setUser(employee,request);
					System.out.println(request.getSession().getAttribute("user")+"=================================================");
					/* * 2 将权限放入session中*/
					 
					List<Menu> menulist = menuService.getMenuListByRole(employee.getRole());
					System.out.println(menulist);
					UserContext.setUserMenus(menulist,request);
					System.out.println("----------------------------------------------------");
					System.out.println(request.getSession().getAttribute(UserContext.MENU_IN_SESSION));
					 /* 3 检查存放所有资源路径是否存放服务器端*/					 
					
					 /*4 修改登录日志*/
					 
					//1:获得sysloginfo
					Sysloginfo sysloginfo = sysloginfoService.get(employee.getId());
					sysloginfo.setLastLoginTime(sysloginfo.getCurrentLoginTime());
					sysloginfo.setLastExitTime(sysloginfo.getCurrentExitTime());
					sysloginfo.setCurrentLoginTime(new Date());
					sysloginfo.setIp(request.getRemoteAddr());
					sysloginfoService.update(sysloginfo);
					 /*如果记住密码,将用户放入cookie中,默认保留一天*/
					 System.out.println("======================"+loginInfo.getRememberdays());
					if(loginInfo.getRememberdays()>0){
						//保存cookie
						CookieUtil.saveCookie(loginInfo, request, response);
					}else {
						CookieUtil.clearCookie(response);
					}
					return "/index";// 重定向
				}
			}
			return "common/login";
		}
		
		/*
		 * 进入注册页面
		 */
	    @RequestMapping("/register")
		public String register() throws Exception {
			return "common/register";
		}
		/*
		 * 进入登录页面
		 */
	    @RequestMapping("/login")
		public String login() throws Exception {
			//在记住密码的情况下如果执意访问这个页面也是能行的，换用户登录。
			return "common/login";
		}
		/*
		 * 注册的时候进行已经存在的用户名检查
		 */
	    @RequestMapping("/checkname/{name}")
	    @ResponseBody
		public Ajaxresult checkname(@PathVariable String name ) throws Exception {
			Boolean flag=loginInfoService.checkExistLoginInfoByName(name);//flag为true表示已经存在，为false表示不存在此用户
			Boolean map;
			if(flag){
				//已经存在
				return new Ajaxresult(false, "已经存在");
			}else {
				//不存在
				return new Ajaxresult(true,"可以使用");
			}
		}
		/*
		 * 注册用户  保存
		 */
		@RequestMapping(method=RequestMethod.POST)
		public String save(@ModelAttribute LoginInfo loginInfo,@Param(value = "confirmpassword") String confirmpassword) throws Exception {
			/*
			 * 后台验证name,password;
			 */
			String name=loginInfo.getName();
			String password=loginInfo.getPassword();
			
			if(stringRegex(name,"^[a-zA-Z](?![a-zA-Z]+$)\\w{4,10}$") && stringRegex(password, "^[a-zA-Z](?![a-zA-Z]+$)\\w{4,10}$") && stringRegex(confirmpassword, "^[a-zA-Z](?![a-zA-Z]+$)\\w{4,10}$")){
				if (password.equals(confirmpassword)) {
					/*
					 * 1:先保存logininfo   在sqlmap中保存了新创建的Employee,Sysloginfo
					 */
					loginInfo = new LoginInfo(name, MD5Util.JM(MD5Util.MD5(password)));
					Long loginInfoID = loginInfoService.insert(loginInfo);
					
					return "common/login";
				}
			}
			return "common/register";
		}
	   
		
		/*
		 * 用户注销
		 */
		@RequestMapping("/logout")
		public String logout(HttpServletRequest request,HttpServletResponse response) throws Exception {
			UserContext.setUser(null,request);
			UserContext.setUserMenus(null,request);
			return "common/login";
		}
		
		
		
}
