package com.ijoy.common.comutil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ijoy.common.domain.Employee;
import com.ijoy.common.domain.LoginInfo;
import com.ijoy.common.domain.Menu;
import com.ijoy.common.domain.Sysloginfo;
import com.ijoy.common.service.IEmployeeService;
import com.ijoy.common.service.ILoginInfoService;
import com.ijoy.common.service.IMenuService;
import com.ijoy.common.service.ISysloginfoService;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
@Component
public class CookieUtil {
	 //保存cookie时的cookieName
    public final static String LOGINCOOKIE = "logincookie";
 // 登录用户的key
    private final static String webKey ="ijoy";
    //设置cookie有效期是两个星期，根据需要自定义
    private final static int cookieMaxAge = 60 * 60 * 24;
    //保存Cookie到客户端-------------------------------------------------------------------------
    //在CheckLogonServlet.java中被调用
    //传递进来的user对象中封装了在登陆时填写的用户名与密码
    @Autowired
    private  ILoginInfoService loginInfoService;
    @Autowired
    private  IEmployeeService employeeService;
    @Autowired
    private IMenuService menuService;	
    @Autowired
    private ISysloginfoService sysloginfoService;
    
    private static  CookieUtil cookieUtil;
    
    @PostConstruct
    public void init(){
    	cookieUtil=this;
    	cookieUtil.loginInfoService=this.loginInfoService;
    }
    
	public static void saveCookie(LoginInfo loginInfo,HttpServletRequest request,HttpServletResponse response) {
    		//cookie的有效期
    		long validTime = System.currentTimeMillis() +cookieMaxAge*loginInfo.getRememberdays();
           //MD5加密用户详细信息   //
           String cookieValueWithMd5 =MD5Util.MD5(loginInfo.getName()+ ":" + MD5Util.JM(loginInfo.getPassword())

                         + ":" + request.getRemoteAddr() +":"+validTime+ ":" + webKey);
           //将要被保存的完整的Cookie值
           String cookieValue = loginInfo.getName() + ":"+request.getRemoteAddr() +":" + validTime + ":" + cookieValueWithMd5;
           //再一次对Cookie的值进行BASE64编码

           String cookieValueBase64 = new String(Base64.encode(cookieValue.getBytes()));
           //开始保存Cookie
           Cookie cookie = new Cookie(LOGINCOOKIE, cookieValueBase64);
           //存登录信息保存的cookie天数(这个值应该大于或等于validTime)
           cookie.setMaxAge(cookieMaxAge*loginInfo.getRememberdays());
           //向客户端写入
           cookie.setPath("/plat");
           response.addCookie(cookie);
    }
    //读取Cookie,自动完成登陆操作----------------------------------------------------------------

    //在Filter程序中调用该方法,见AutoLogonFilter.java

    public static void readCookieAndLogon(FilterChain chain,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException,UnsupportedEncodingException{
    //根据cookieName取cookieValue
    Cookie cookies[] = request.getCookies();
                  String cookieValue = null;
                  if(cookies!=null){
                         for (int i = 0; i < cookies.length; i++) {
                        	 if (LOGINCOOKIE.equals(cookies[i].getName())) {
                                 cookieValue = cookies[i].getValue();
                                 break;
                          }
						}
                  }
                  //如果cookieValue为空,返回,
                  if(cookieValue==null){
                	  chain.doFilter(request, response);
                         return;
                  }
           //如果cookieValue不为空,才执行下面的代码
           //先得到的CookieValue进行Base64解码
           String cookieValueAfterDecode = new String (Base64.decode(cookieValue),"utf-8");
           System.out.println("cookieValueAfterDecode===="+cookieValueAfterDecode);
           //对解码后的值进行分拆,得到一个数组,如果数组长度不为3,就是非法登陆
           String cookieValues[] = cookieValueAfterDecode.split(":");
           for (int i = 0; i < cookieValues.length; i++) {
        	   System.out.println(i+"   :");
			System.out.println(cookieValues[i]);
		}
           if(cookieValues.length!=4){
        	   clearCookie(response);
               chain.doFilter(request, response);
               return;
           }
           //判断是否在内网的同一ip登录
           //判断是否在有效期内,过期就删除Cookie
           String validid=cookieValues[1];
		if(!request.getRemoteAddr().equals(validid)){
                  //删除Cookie
                  clearCookie(response);
                  chain.doFilter(request, response);
                  return;
           }
           //判断是否在有效期内,过期就删除Cookie
           long validTimeInCookie=Long.parseLong(cookieValues[2]);
		if(validTimeInCookie < System.currentTimeMillis()){
                  //删除Cookie
                  clearCookie(response);
                  chain.doFilter(request, response);
                  return;
           }
           //取出cookie中的用户名,并到数据库中检查这个用户名,
           String username = cookieValues[0];
           LoginInfo existLoginInfo = cookieUtil.getLoginInfoService().findExistLoginInfoByName(username);
           
           //如果user返回不为空,就取出密码,使用用户名+密码+有效时间+ webSiteKey进行MD5加密
           if(existLoginInfo!=null){
                  String md5ValueInCookie = cookieValues[3];
                  String md5ValueFromUser =MD5Util.MD5(existLoginInfo.getName()+ ":" + MD5Util.JM(existLoginInfo.getPassword())+":"+request.getRemoteAddr()
                                + ":" + validTimeInCookie + ":" + webKey);
                  //将结果与Cookie中的MD5码相比较,如果相同,写入Session,自动登陆成功,并继续用户请求
                  if(md5ValueFromUser.equals(md5ValueInCookie)){
                	  /** 1 将用户登录用户放入session中
      				 * 根据LoginInfo来获得Employee相同的id*/
      				 
      				Employee employee=cookieUtil.getEmployeeService().findEmployeeByLoginInfoID(existLoginInfo.getId());
      				UserContext.setUser(employee,request);
      				
      				/* * 2 将权限放入session中*/
      				 
      				List<Menu> menulist = cookieUtil.getMenuService().getMenuListByRole(employee.getRole());
      				UserContext.setUserMenus(menulist,request);
      				
      				 
      				
      				 /** 4 修改登录日志*/
      				 
      				//1:获得sysloginfo
      				Sysloginfo sysloginfo = cookieUtil.getSysloginfoService().get(employee.getId());
      				sysloginfo.setLastLoginTime(sysloginfo.getCurrentLoginTime());
      				sysloginfo.setLastExitTime(sysloginfo.getCurrentExitTime());
      				sysloginfo.setCurrentLoginTime(new Date());
      				cookieUtil.getSysloginfoService().update(sysloginfo);
      				
      				chain.doFilter(request, response);
      				return;
                  }

           }
           //最后都继续请求，后面用拦截器控制
           chain.doFilter(request, response);    
    }

    

    //用户注销时,清除Cookie,在需要时可随时调用-----------------------------------------------------
    public static void clearCookie( HttpServletResponse response){
           Cookie cookie = new Cookie(LOGINCOOKIE, null);
           cookie.setMaxAge(0);
           cookie.setPath("/");
           response.addCookie(cookie);
    }



		public ILoginInfoService getLoginInfoService() {
			return loginInfoService;
		}



		public void setLoginInfoService(ILoginInfoService loginInfoService) {
			this.loginInfoService = loginInfoService;
		}



		public IEmployeeService getEmployeeService() {
			return employeeService;
		}



		public void setEmployeeService(IEmployeeService employeeService) {
			this.employeeService = employeeService;
		}



		public IMenuService getMenuService() {
			return menuService;
		}



		public void setMenuService(IMenuService menuService) {
			this.menuService = menuService;
		}



		public ISysloginfoService getSysloginfoService() {
			return sysloginfoService;
		}



		public void setSysloginfoService(ISysloginfoService sysloginfoService) {
			this.sysloginfoService = sysloginfoService;
		}
		
           
}
