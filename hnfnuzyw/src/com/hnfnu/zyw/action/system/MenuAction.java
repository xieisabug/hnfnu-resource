package com.hnfnu.zyw.action.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnfnu.zyw.dto.system.FunctionDto;
import com.hnfnu.zyw.dto.system.MenuDto;
import com.hnfnu.zyw.service.system.IFunctionService;
import com.hnfnu.zyw.service.system.IMenuService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("menuAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/system")
public class MenuAction extends ActionSupport implements ModelDriven<MenuDto> {

	private static final long serialVersionUID = -6647461641925967113L;
	private MenuDto menu = new MenuDto();// 获取页面提交参数
	private boolean success;
	private Map<String, Object> menuList;
	
	private String message;
	@Autowired
	@Qualifier("menuService")
	private IMenuService menuService;
	List<FunctionDto> functionList;
	private List<MenuDto> menus;
	
	@Autowired
	@Qualifier("functionService")
	private IFunctionService functionService;

	// 添加菜单
	@Action(value = "addMenu")
	public String add() {
		success = menuService.add(menu);
		if(success){
			message = "菜单添加成功";
		}else{
			message = "菜单添加失败";
		}
		return SUCCESS;
	}

	// 修改菜单
	@Action(value = "updateMenu")
	public String update() {
		success = menuService.update(menu);
		if(success){
			message = "菜单修改成功";
		}else{
			message = "菜单修改失败";
		}
		return SUCCESS;
	}

	/**
	 * 根据菜单ID查询一个菜单
	 * 
	 * @return
	 */
	@Action(value = "loadMenu")
	public String load() {
		menu = menuService.load(menu.getId());
		if(menu != null){
			message = "菜单查询成功";
		}else{
			message = "菜单查询失败";
		}
		return SUCCESS;
	}

	/**
	 * 根据菜单id删除一个菜单
	 * 
	 * @return
	 */

	@Action(value = "deleteMenu")
	public String delete() {
		success = menuService.delete(menu.getId());
		if(success){
			message = "菜单删除成功";
		}else{
			message = "菜单删除失败";
		}
		return SUCCESS;
	}

	//
	@Action(value = "listMenu")
	public String list() {
		menuList = new HashMap<String, Object>();
		List<MenuDto> l = menuService.list();
		menuList.put("Rows", l);
		menuList.put("Total", l.size());
		return SUCCESS;
	}
	
	// 获取表中所有功能和所有一级菜单，是用List装的
		@Action(value = "listFunAndMenu")
		public String listFunAndMenu() {
			functionList = functionService.list();
			menus = menuService.getMenusByParentId(-1);
			return SUCCESS;
		}

	
	public MenuDto getModel() {
		return menu;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public void setMenu(MenuDto menu) {
		this.menu = menu;
	}

	public Map<String, Object> getMenuList() {
		return menuList;
	}

	public String getMessage() {
		return message;
	}

	public List<MenuDto> getMenus() {
		return menus;
	}

	public List<FunctionDto> getFunctionList() {
		return functionList;
	}

}
