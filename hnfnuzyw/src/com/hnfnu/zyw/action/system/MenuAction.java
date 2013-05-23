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

import com.hnfnu.zyw.dto.system.MenuDto;
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

	@Autowired
	@Qualifier("menuService")
	private IMenuService menuService;

	// 添加菜单
	@Action(value = "addMenu")
	public String add() {
		success = menuService.add(menu);
		return SUCCESS;
	}

	// 修改菜单
	@Action(value = "updateMenu")
	public String update() {
		success = menuService.update(menu);
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
		return SUCCESS;
	}

	@Action(value = "listMenu")
	public String list() {
		menuList = new HashMap<String, Object>();
		List<MenuDto> l = menuService.list();
		menuList.put("Rows", l);
		menuList.put("Total", l.size());
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

}
