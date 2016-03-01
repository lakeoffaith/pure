package com.ijoy.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ijoy.common.comutil.ListUtil;
import com.ijoy.plat.domain.Menu;
import com.ijoy.plat.domain.Role;
import com.ijoy.plat.query.MenuQuery;
import com.ijoy.plat.query.PageResult;
import com.ijoy.plat.service.IMenuService;


public class MenuServiceTest extends BaseTest{
	@Autowired
	private IMenuService menuService;

	@Test
	public void getAllTest() {
		List<Menu> menus = menuService.getAll();
		System.out.println(menus);
		
	}
	/*
	 * 通过 baseQuery查询菜单
	 */
	@Test
	public void queryTest(){
		MenuQuery menuQuery = new MenuQuery();
		menuQuery.setParent_id(1L);
		PageResult<Menu> query = menuService.queryforPage(menuQuery);
		int size = query.getRows().size();
		System.out.println(size);
		
		
		
	}
	/*
	 * 通过角色 来获取加载菜单
	 */
	@Test
	public void getMenuListByRoleIDAndTypeTest() {
/*		Role role=new Role();
		role.setId(1L);
		List<Menu> menus= menuService.getMenuListByRoleANDType(role,1);
		System.out.println("menus:"+menus);
		List<Menu> menujson = Menu.formatJson(menus);
		System.out.println(menujson);*/
	}
	
	//分页测试
	@Test
	public void getAllPageTest() {
		MenuQuery query=new MenuQuery();;
		query.setCurrentPage(2L);
		query.setPageSize(10L);
		System.out.println(query);
		 PageResult<Menu> queryforPage = menuService.queryforPage(query);
		System.out.println(queryforPage);
		
	}
	@Test
	public void deleteTest() {
		
		//删除
		Long id=1L;
		menuService.delete(id);
		
	}
	
	/*
	 * 通过url来获取菜单MenuList
	 */
	@Test
	public void getMenuListByrurl() {
		String url="menu\\list.action";
		List<Menu> menus= menuService.getMenuByMenuUrl(url);
		System.out.println(menus);
	}
	/*
	 * 通过角色 list来获取菜单MenuList
	 */
	@Test
	public void getMenuListByRole() {/*
		Role role=new Role();
		role.setId(1L);
		List<Menu> menus= menuService.getMenuListByRole(role);
		Map<Long, Menu> menuMap = new HashMap<>();
		for (Menu menu : menus) {
			menuMap.put(menu.getId(), menu);
		}
		System.out.println("menuMap初始="+menuMap);
		int type=2;  //最多有多少层
		Set<Entry<Long, Menu>> entrySet;
		//先循环最低层
		while(type>0){
			entrySet = menuMap.entrySet();
			for (Iterator<Map.Entry<Long, Menu>> iterator =entrySet.iterator();iterator.hasNext();) {
				Entry<Long, Menu> nEntry = iterator.next();
				Menu nMenu = nEntry.getValue();
				
				//如果有父类，且为当前层的
				if(nMenu!=null && type==nMenu.getType() && null!=nMenu.getParent_id()){
					menuMap.get(nMenu.getParent_id()).getChildren().add(nMenu);
					iterator.remove();
				}
			}
			type--;
		}
		
		System.out.println("menuMap结束="+menuMap.size());
		System.out.println(menuMap);
		System.out.println(menus.size());
	*/}
	
	
	/*
	 * 通过角色 来获取权限配置
	 */
	@Test
	public void getMenuListByRoleIDTest() {/*
		Role role=new Role();
		role.setId(1L);
		List<Menu> menus= menuService.getMenuListByRole(role);
		System.out.println("menus:"+menus);
		List<Menu> menujson = Menu.formatJson(menus);
		System.out.println(menujson);
	*/}
	/*
	 * 全部菜单测试
	 */
	
	@Test
	public void getTreeJsonByAll() {/*
		List<Menu> menulist = new ArrayList<>();
		Role role = new Role();
		role.setId(11L);
		menulist=menuService.getAll();
		List<Menu> menuListByRole = menuService.getMenuListByRole(role);
		//选出menulist中包含的menuListByEmployee 的menu.
		for (Menu menu : menuListByRole) {
			Menu.State state=menu.new State(false, false, true);
			menu.setState(state);
		}
		//根据hashcode,equals,得知两个menu比较与state无关。
		//移除相同的
		System.out.println("menulist====="+menulist);
		System.out.println("menuListByRole====="+menuListByRole);
		ListUtil.dereplication(menulist, menuListByRole);
		List<Menu> menujson = Menu.formatJson(menulist);
		System.out.println(menujson);
		
	*/}
	
	@Test
	public void saveRoleMenu(){
		String ouList="2,3,4,6";
		Long roleid=11L;
		Role role=new Role();
		role.setId(roleid);
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
		
		
		
	}
}
