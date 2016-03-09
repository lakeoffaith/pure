package com.ijoy.common.comutil.Context;

import javax.servlet.http.HttpServletRequest;

import com.ijoy.common.domain.Employee;
public class UserContext {
	public final static String USER_IN_SESSION = "user";
	public static final String MENU_IN_SESSION = "menu_in_session";
	/*
	 * 设置登录用户
	 */
	public static void setUser(Employee emp,HttpServletRequest request) {
		request.getSession().setAttribute(USER_IN_SESSION, emp);
	}
    /*
     * 获得登录用户
     */
	public static Employee getUser(HttpServletRequest request) {
		  Employee employee = new Employee();
		  employee.setId(2l);
		  employee.setName("admin3");
		  return employee;
		/*return (Employee) request.getSession().getAttribute(USER_IN_SESSION);*/
	}
   

	

	
	
}
