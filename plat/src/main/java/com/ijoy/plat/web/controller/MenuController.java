package com.ijoy.plat.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ijoy.common.comutil.Ajaxresult;
import com.ijoy.common.comutil.UserContext;
import com.ijoy.plat.domain.Menu;
import com.ijoy.plat.query.MenuQuery;
import com.ijoy.plat.service.IMenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private IMenuService service;
	
	//加载菜单
	@RequestMapping("/load")
	@ResponseBody
		 public Ajaxresult loadMenu(HttpServletRequest request){
		System.out.println("menu    load");
					
					//只查询role.type ==1即为菜单的menu
					List<Menu> menuList = service.getMenuListByRoleANDType(UserContext.getUser(request).getRole(),Menu.INDEXMENU);
					return new Ajaxresult(true, menuList);
			 }
@RequestMapping(method=RequestMethod.GET,params="for=json")	
@ResponseBody
     public  Ajaxresult queryList(@ModelAttribute MenuQuery baseQuery){
    	 List<Menu> results=service.queryforPage(baseQuery).getRows();
    	 return new Ajaxresult(true, results);
     }
	
	  @RequestMapping(method=RequestMethod.GET)
		public ModelAndView  list(@ModelAttribute MenuQuery menuQuery) {
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("menu/list");
		  mv.addObject("menuPage", service.queryforPage(menuQuery));
		  return mv;
		}
	//去修改单个
	  	@RequestMapping(value="/{id}",params="type=goUpdate",method=RequestMethod.GET)
		public String goUpdate(@PathVariable Long id) throws Exception {
			// 添加角色列表
			return "/menu/input";
		}

	  	//修改单个
	  	@RequestMapping(value="/{id}",params="type=update",method=RequestMethod.GET)
		public String update(@ModelAttribute Menu menu) throws Exception {
		    
			return null;
		}
		//删除单个
		@RequestMapping(value="/{id}",params="type=delete",method=RequestMethod.GET)
		public Ajaxresult delete(@PathVariable Long id){
			try {
				service.delete(id);
				return new Ajaxresult(true, "删除成功");
			} catch (Exception e) {
				return new Ajaxresult(false, "删除失败");
			}
		}
		//批量删除
		@RequestMapping(value="/batch/ids",method=RequestMethod.GET)
		@ResponseBody
		public Ajaxresult deleteBatch(@PathVariable String ids){
			Ajaxresult ajaxResult;
			if(StringUtils.isEmpty(ids)){
				ajaxResult= new Ajaxresult(false, "请选中需要删除的用户");
				return ajaxResult;
			}
			String[] idArray = ids.split(",");
			try {
				for (String id : idArray) {
					if(!StringUtils.isEmpty(id)){
						
						service.delete(Long.getLong(id));
					}
				}
				ajaxResult=new Ajaxresult(true,"删除成功");
			} catch (Exception e) {
				ajaxResult=new Ajaxresult(false,"异常:" + e.getMessage());
			}
			return ajaxResult;
		}
		
}
