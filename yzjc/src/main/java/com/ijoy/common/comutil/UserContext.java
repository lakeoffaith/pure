package com.ijoy.common.comutil;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ijoy.common.domain.Employee;
import com.ijoy.common.domain.Menu;
import com.ijoy.common.service.IMenuService;
public class UserContext {
	public final static String USER_IN_SESSION = "user";
	public static final String MENU_IN_SESSION = "menu_in_session";
	public static Employee employee;
	private static IMenuService menuService;
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
		return (Employee) request.getSession().getAttribute(USER_IN_SESSION);
	}
   


	/*
	 * 从session中获取权限 name字段的list
	 */
	public static  List<String> getUserMenu(HttpServletRequest request) {
		return  (List<String>) request.getSession().getAttribute(
				MENU_IN_SESSION);
	}
	public static void setUserMenus(List<Menu> menulist,HttpServletRequest request) {
		/*
		 * 只把menu的name属性存入session中
		 */
		if(menulist==null || menulist.size()==0){
			request.getSession().removeAttribute(MENU_IN_SESSION);
			return ;
		}
		List<String> menunameList = new ArrayList<>();
		for (Menu menu : menulist) {
			menunameList.add(menu.getName());
		}
		request.getSession().setAttribute(MENU_IN_SESSION, menunameList);
	}
	public static Boolean checkAuthMenuUrl(String menuUrl, HttpServletRequest request) {
		//通过menuUrl去Menu中去找对应的name，如果没有对应的记录，则放行，，
				//如果有则，查找用户SESSION中的MENUNamelist中是否有这个name,没有返回权限。
		//1:如果session中没有MENU_IN_SESSION,返回false
		List<String> userMenu = getUserMenu(request);
		if(userMenu.size()==0)return false;
		//2:menuUrl对应的menuName
		List<Menu> menu=menuService.getMenuByMenuUrl(menuUrl);
		//代表这个url没有被权限管理，则放行。
		if (menu==null || menu.size()==0) {
			return true;
		}
		//url被权限管理
		//改用户有这个权限。放行。
		for (Menu m : menu) {
			if(userMenu.contains(m.getName())){
				return true;
			}
		}
		//该用户没有这个权限;
		return false;
	}
	public IMenuService getMenuService() {
		return menuService;
	}
	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}
	
	

	
	
}
