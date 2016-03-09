package com.ijoy.plat.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.ijoy.common.comutil.CookieUtil;
import com.ijoy.common.comutil.UserContext;
import com.ijoy.plat.domain.Employee;

public class AutoLogonFilter implements Filter{

	@Override
	public void destroy() {
		
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("AutoLogonFilter");
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		
		//查看用户是否登录
		Employee user = (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
		if(user!=null){
			chain.doFilter(request, response);
			return;
		}
		//用户没有登录   则开始查看cookie
		Cookie[] cookies = request.getCookies();
		String cookieValue="";
		if(cookies!=null){
			for (int i = 0; i < cookies.length; i++) {
				if(CookieUtil.LOGINCOOKIE.equals(cookies[i].getName())){
					cookieValue=cookies[i].getValue();
					break;
				}
			}
		}
		//如果cookieValue为空，则让别interceptor去处理
		if(StringUtils.isBlank(cookieValue)){
			chain.doFilter(request, response);
			return;
		}
		//cookieValue不为空
		CookieUtil.readCookieAndLogon(chain, request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
