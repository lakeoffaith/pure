package com.ijoy.plat.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value="/load",method=RequestMethod.GET)
	@ResponseBody
		 public Ajaxresult loadMenu(HttpServletRequest request){
		System.out.println("menu    load");
					
					//只查询menu.type ==1即为菜单的menu
					List<Menu> menuList = service.getMenuListByRoleANDType(UserContext.getUser(request).getRole(),Menu.INDEXMENU);
					return new Ajaxresult(true, menuList);
			 }
@RequestMapping(method=RequestMethod.GET,params="for=json")	
@ResponseBody
     public  Ajaxresult queryList(@ModelAttribute MenuQuery baseQuery){
    	 List<Menu> results=service.queryPage(baseQuery).getRows();
    	 return new Ajaxresult(true, results);
     }
	
	  
	  /*
		 * 更新domain的适合，保存信息更新不丢失。
		 */
		@ModelAttribute
		public void getDomain(@RequestParam(value="id",required=false) Long id,Map<String, Object> map){
			if(id!=null){
				Menu menu=service.get(id);
				map.put("menu", menu);
			}
		}
		
	@RequestMapping(method=RequestMethod.GET)
	public  ModelAndView  list(@ModelAttribute MenuQuery menuQuery){
		System.out.println("list    "+menuQuery);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menu/list");
		mv.addObject("menuQuery", menuQuery);
		mv.addObject("pageResult", service.queryPage(menuQuery));
		return mv;
	}
	//查看单个
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		public  String  get(@PathVariable Long id,Model model){
			Menu  menu=service.get(id);	
			model.addAttribute("menu", menu);
			return "menu/view";
		}
		//修改单个
		@RequestMapping(value="/{id}",params={"method=goUpdate"},method=RequestMethod.GET)
		public  String  goUpdate(@PathVariable Long id,Model model){
			Menu  menu=service.get(id);	
			model.addAttribute("menu", menu);
			return "menu/input";
		}
		
	
	//更新单个
		//更新，保存
		@RequestMapping(method=RequestMethod.POST)
		public String save(@ModelAttribute("menu") Menu menu){
			System.out.println(menu);
			if(menu.getId()!=null){
				service.update(menu);
			}else {
				service.insert(menu);
			}
			return  "redirect:menu";
		}
		
	//进入新增单个
	@RequestMapping(params="method=goSave",method=RequestMethod.GET)
	public String goSave(){
		return "menu/input";
	}
	
	//删除单个
	@RequestMapping(value="/{id}",params="method=delete",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult delete(@PathVariable Long id){
		try {
			service.delete(id);
			return new Ajaxresult(true, "删除成功");
		} catch (Exception e) {
			return new Ajaxresult(false, "删除失败");
		}
	}
	//批量删除
	@RequestMapping(params="method=batchDelete",method=RequestMethod.GET)
	@ResponseBody
	public Ajaxresult deleteBatch(@RequestParam(value="ids",required=true) String ids){
		Ajaxresult ajaxResult;
		if(ids==null){
			ajaxResult= new Ajaxresult(false, "请选中需要删除的用户");
			return ajaxResult;
		}
		String[] idArray = ids.split(",");
		try {
			for (int i = 0; i < idArray.length; i++) {
				service.delete(Long.valueOf(idArray[i]));
			}
			
			ajaxResult=new Ajaxresult(true,"删除成功");
		} catch (Exception e) {
			ajaxResult=new Ajaxresult(false,"异常:" + e.getMessage());
		}
		return ajaxResult;
	}


	  
	
}
