package com.ijoy.plat.web.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ijoy.common.comutil.UserContext;
import com.ijoy.plat.web.exception.AuthException;

public class AuthInterceptor implements  HandlerInterceptor {
	private List<String> excludedUrls;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("enter authInterceptor");
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		System.out.println(excludedUrls);
		for (String url : excludedUrls) {
			if(url.endsWith(requestURI)){
				return true;
			}
		}
		HttpSession session = request.getSession();
		if(session.getAttribute(UserContext.USER_IN_SESSION)==null){
			throw new  AuthException();
		}else{
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<String> getExcludedUrls() {
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}
	
	
	
	
	
}
