package com.ijoy.common.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.common.domain.Menu;
import com.ijoy.common.domain.Role;
import com.ijoy.common.service.IMenuService;
import com.ijoy.common.service.IRoleService;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private IRoleService roleService;
	@RequestMapping(value="/load",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult load(@Param("roleid") Long roleid){
	    //加载菜单,其中用户已经拥有的菜单的state对象的selected属性必须要设置为true.
		List<Menu> menulist = new ArrayList<>();
		menulist=menuService.getAll();
		//加载的时候只需要取出第2 层的权限。
		List<Menu> menuListByRole =menuService.getMenuListByRoleANDType(new Role(roleid), Menu.PERMISSIONMENU);
		//选出menulist中包含的menuListByEmployee 的menu.
		for (Menu menu : menulist) {
			//如果用户有这个菜单权限
			if (menuListByRole.contains(menu)) {
				Menu.State state=menu.new State(false, false, true);
				menu.setState(state);
			}
		}
	 return  new Ajaxresult(true, menulist);
 }
	
	@RequestMapping(method=RequestMethod.GET)
		public ModelAndView  list(){
			//加载所有的角色
			List<Role> roles = roleService.getAll();
			return new ModelAndView("common/permission/list", "roles", roles);
		}
	
	@RequestMapping(value="/{roleid}",method=RequestMethod.GET)
	@ResponseBody
	 public Ajaxresult save(@PathVariable Long roleid,@Param("outList") String ouList){
	 	Role role=new Role(roleid);
	 	//查找出正在修改菜单的改用户的原有菜单
	 			List<Menu> menulistOld = menuService.getMenuListByRole(role);
	 			//找出ouList对应的id的所有menu的集合.
	 			List<Menu> menuPageList = new ArrayList<>();
	 			List<String> menuPageIDList = Arrays.asList(ouList.split(","));
	 			
	 			List<Menu> menuall = menuService.getAll();
	 			for (Menu menu : menuall) {
	 				if(menuPageIDList.contains(menu.getId().toString())){
	 					menuPageList.add(menu);
	 				}
	 			}
	 			
	 			//角色和用户相对的。menuPageList中为页面选中的菜单集合， menulistOld为原有的菜单集合。
	 			List<Menu> saveList=new ArrayList<>();
	 			List<Menu> deleteList=new ArrayList<>();
	 			for (Menu menu : menulistOld) {
	 				//如果选中的菜单集合中不包含在原有的菜单中，则为删除
	 				if(!menuPageList.contains(menu)){
	 					deleteList.add(menu);
	 				}
	 			}
	 			for (Menu menu : menuPageList) {
	 				//如果原有集合中不包含在选中的菜单，则为新增
	 				if(!menulistOld.contains(menu)){
	 					saveList.add(menu);
	 				}
	 			}
	 			
	 			menuService.saveRoleMenu(role,saveList);
	 			
	 			menuService.deleteRoleMenu(role,deleteList);
	  return new Ajaxresult(true,"保持菜单成功");
	 }

}
