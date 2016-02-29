package com.ijoy.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.plat.domain.Menu;
import com.ijoy.plat.domain.Role;
import com.ijoy.plat.service.IMenuService;
import com.ijoy.plat.service.IRoleService;

public class ResourceSaveTest extends BaseTest{/*
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IRoleService roleService;
	
	
	//添加插入菜单脚本
	@Test
	public void insertMenuTest(){
		//清空数据Menu数据表
		menuService.deleteAll();
		//插入管理系统
		int id, String name, String url, Long parent_id, int orderid,int type,String iconname
		menuService.insert(new Menu(1,"管理系统","",null,1,1,"icon-cogs"));
		menuService.insert(new Menu(2,"应用管理","",null,2,1,"icon-tablet"));
		menuService.insert(new Menu(3,"个人办公","",null,3,1,"icon-user"));
		menuService.insert(new Menu(4,"项目管理","task\\list.action",null,4,1,"icon-paste"));
		menuService.insert(new Menu(5,"统计分析","application\\list.action",null,5,1,"icon-bar-chart"));
		menuService.insert(new Menu(6,"日志管理","sysloginfo\\list.action",null,6,1,"icon-book"));
		menuService.insert(new Menu(7,"在线咨询","",null,7,1,"icon-comment"));
		menuService.insert(new Menu(8,"角色管理","role\\list.action",1L,1,1,""));
		menuService.insert(new Menu(9,"角色显示","role\\list.action",8L,1,2,""));
		menuService.insert(new Menu(10,"角色编辑","role\\input.action",8L,1,2,""));
		menuService.insert(new Menu(11,"角色增加","role\\save.action",8L,2,2,""));
		menuService.insert(new Menu(12,"角色删除","role\\delete.action",8L,3,2,""));
		menuService.insert(new Menu(13,"员工管理","employee\\list.action",1L,2,1,""));
		menuService.insert(new Menu(14,"员工显示","employee\\list.action",13L,1,2,""));
		menuService.insert(new Menu(15,"员工编辑","employee\\input.action",13L,2,2,""));
		menuService.insert(new Menu(16,"员工增加","employee\\save.action",13L,3,2,""));
		menuService.insert(new Menu(17,"员工删除","employee\\delete.action",13L,4,2,""));
		menuService.insert(new Menu(18,"菜单管理","menu\\list.action",1L,3,1,""));
		menuService.insert(new Menu(19,"菜单显示","menu\\list.action",18L,1,2,""));
		menuService.insert(new Menu(20,"菜单编辑","menu\\input.action",18L,2,2,""));
		menuService.insert(new Menu(21,"菜单增加","menu\\save.action",18L,3,2,""));
		menuService.insert(new Menu(22,"菜单删除","menu\\delete.action",18L,4,2,""));
		menuService.insert(new Menu(23,"权限配置","permission\\list.action",1L,4,1,""));
		menuService.insert(new Menu(24,"权限显示","permission\\list.action",23L,1,2,""));
		menuService.insert(new Menu(25,"权限保存","permission\\save.action",23L,2,2,""));
		menuService.insert(new Menu(26,"应用配置","application\\list.action",2L,1,1,""));
		menuService.insert(new Menu(27,"应用显示","application\\list.action",26L,2,2,""));
		menuService.insert(new Menu(28,"应用编辑","application\\input.action",26L,3,2,""));
		menuService.insert(new Menu(29,"应用增加","application\\save.action",26L,2,4,""));
		menuService.insert(new Menu(30,"应用删除","application\\delete.action",26L,3,2,""));
		menuService.insert(new Menu(31,"应用查询","application\\list.action",2L,2,1,""));
		menuService.insert(new Menu(32,"应用显示","application\\list.action",31L,1,2,""));
		menuService.insert(new Menu(33,"应用编辑","application\\input.action",31L,2,2,""));
		menuService.insert(new Menu(34,"应用增加","application\\save.action",31L,3,2,""));
		menuService.insert(new Menu(35,"应用删除","application\\delete.action",31L,4,2,""));
		menuService.insert(new Menu(36,"我的应用","application\\list.action",3L,1,1,""));
		menuService.insert(new Menu(37,"应用显示","application\\list.action",36L,1,2,""));
		menuService.insert(new Menu(38,"应用编辑","application\\input.action",36L,2,2,""));
		menuService.insert(new Menu(39,"应用增加","application\\save.action",36L,3,2,""));
		menuService.insert(new Menu(40,"应用删除","application\\delete.action",36L,4,2,""));
		menuService.insert(new Menu(41,"我的任务","task\\list.action",3L,2,1,""));
		menuService.insert(new Menu(42,"任务显示","task\\list.action",41L,1,2,""));
		menuService.insert(new Menu(43,"任务编辑","task\\input.action",41L,2,2,""));
		menuService.insert(new Menu(44,"任务增加","task\\save.action",41L,3,2,""));
		menuService.insert(new Menu(45,"任务删除","task\\delete.action",41L,4,2,""));
		menuService.insert(new Menu(46,"任务显示","task\\list.action",4L,1,2,""));
		menuService.insert(new Menu(47,"任务编辑","task\\input.action",4L,2,2,""));
		menuService.insert(new Menu(48,"任务增加","task\\save.action",4L,3,2,""));
		menuService.insert(new Menu(49,"任务删除","task\\delete.action",4L,4,2,""));
		menuService.insert(new Menu(50,"应用显示","application\\list.action",5L,1,2,""));
		menuService.insert(new Menu(51,"应用编辑","application\\input.action",5L,2,2,""));
		menuService.insert(new Menu(52,"应用增加","application\\save.action",5L,3,2,""));
		menuService.insert(new Menu(53,"应用删除","application\\delete.action",5L,4,2,""));
		menuService.insert(new Menu(54,"日志显示","sysloginfo\\list.action",6L,1,2,""));
		menuService.insert(new Menu(55,"日志编辑","sysloginfo\\input.action",6L,2,2,""));
		menuService.insert(new Menu(56,"日志增加","sysloginfo\\save.action",6L,3,2,""));
		menuService.insert(new Menu(57,"日志删除","sysloginfo\\delete.action",6L,4,2,""));
		menuService.insert(new Menu(58,"用户反馈","feedback\\list.action",7L,1,1,""));
		menuService.insert(new Menu(59,"反馈显示","feedback\\list.action",58L,1,2,""));
		menuService.insert(new Menu(60,"反馈编辑","feedback\\input.action",58L,2,2,""));
		menuService.insert(new Menu(61,"反馈增加","feedback\\save.action",58L,3,2,""));
		menuService.insert(new Menu(62,"反馈删除","feedback\\delete.action",58L,4,2,""));
		menuService.insert(new Menu(63,"反馈管理","feedback\\list.action",7L,2,1,""));
		menuService.insert(new Menu(64,"反馈显示","feedback\\list.action",63L,1,2,""));
		menuService.insert(new Menu(65,"反馈编辑","feedback\\input.action",63L,2,2,""));
		menuService.insert(new Menu(66,"反馈增加","feedback\\save.action",63L,3,2,""));
		menuService.insert(new Menu(67,"反馈删除","feedback\\delete.action",63L,4,2,""));
		
		
		
		
		
	}
	
	//更新中间表
	@Test
	public void rolemenuTest(){
		//给系统管理员设置所有权限。
				Role role=roleService.getByName("系统管理员");
				List<Menu> menuList=menuService.getAll();
				menuService.saveRoleMenu(role, menuList);
				
				
		//给普通用户设置个		个人办公
				Role r=roleService.getByName("普通用户");
				List<Menu> menuList1=menuService.getMenuByMenuName("个人办公");
				menuService.saveRoleMenu(r, menuList1);
	}

	
*/}
