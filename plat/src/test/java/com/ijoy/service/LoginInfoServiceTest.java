package com.ijoy.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.common.comutil.MD5Util;
import com.ijoy.plat.domain.LoginInfo;
import com.ijoy.plat.service.ILoginInfoService;


public class LoginInfoServiceTest extends BaseTest{
	@Autowired
	private ILoginInfoService loginInfoService;
	
	/*
	 * 测试返回所有
	 */
	@Test
	public void getAll(){
		List<LoginInfo> all = loginInfoService.getAll();
		System.out.println(all);
	}
	
	/*
	 * 测试登陆验证
	 */
	@Test
	public void checkLogin(){
		LoginInfo loginInfo=new LoginInfo("admin3", "admin3");
		LoginInfo findByLogin = loginInfoService.findByLogin(loginInfo);
		System.out.println(findByLogin);
	}
	
	/*
	 * 测试已经存在用户名
	 */
	@Test
	public void existNameTest(){
		System.out.println(loginInfoService.checkExistLoginInfoByName("admin"));
	}
	
	/*
	 * 测试登录
	 */
	@Test
	public void pageTest(){
		LoginInfo loginMessage=new LoginInfo();
		loginMessage.setName("admin1");
		loginMessage.setPassword(MD5Util.JM(MD5Util.MD5("admin1")));
		LoginInfo loginInfo = loginInfoService.findByLogin(loginMessage);
		System.out.println(loginInfo);
	}
	
	/*
	 * 验证码测试
	 */
	@Test
	public void regexTest(){
		String regex="^[a-zA-Z](?![a-zA-Z]+$)\\w{4,10}$";
		String name="admin1";
		System.out.println(name.matches(regex));
	}
	
	/*
	 * 测试注册 返回id  
	 */
	@Test
	public void registerTest(){
		LoginInfo loginInfo = new LoginInfo("admin5", "admin5");
		Long saveid = loginInfoService.insert(loginInfo);
		System.out.println(saveid);
		
	}
	

	/*
	 * 测试注册 返回id  +md5
	 * 测试返回id 为24
	 */
	@Test
	public void registerMd5Test(){
		LoginInfo loginInfo = new LoginInfo("admin3", MD5Util.MD5("admin3"));
		Long saveid = loginInfoService.insert(loginInfo);
		System.out.println(saveid);
	}
	
	/*
	 * 测试 get   +md5
	 */
	@Test
	public void getmd5Test(){
		LoginInfo loginInfo = loginInfoService.get(24L);
		System.out.println(loginInfo);
	}
	
	/*
	 * 测试 md5 加密
	 */
	@Test
	public void md5jmTest(){
		String password="admin3";
		String jm = MD5Util.JM(MD5Util.MD5(password));
		System.out.println(jm);
	}
}
