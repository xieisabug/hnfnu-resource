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

import com.hnfnu.zyw.action.base.AopNoSuchMethodErrorSolveBaseAction;
import com.hnfnu.zyw.dto.system.FunctionDto;
import com.hnfnu.zyw.dto.system.MenuDto;
import com.hnfnu.zyw.service.system.IFunctionService;
import com.hnfnu.zyw.service.system.IMenuService;
import com.hnfnu.zyw.vo.MenuVo;
import com.opensymphony.xwork2.ModelDriven;

@Controller("menuAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/system")
public class MenuAction extends AopNoSuchMethodErrorSolveBaseAction implements ModelDriven<MenuDto> {

	private MenuDto menu = new MenuDto();// »ñÈ¡Ò³ÃæÌá½»²ÎÊý
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

	// Ìí¼Ó²Ëµ¥
	@Action(value = "addMenu")
	public String add() {
		success = menuService.add(menu);
		if(success){
			message = "²Ëµ¥Ìí¼Ó³É¹¦";
		}else{
			message = "²Ëµ¥Ìí¼ÓÊ§°Ü";
		}
		return SUCCESS;
	}

	// ÐÞ¸Ä²Ëµ¥
	@Action(value = "updateMenu")
	public String update() {
		success = menuService.update(menu);
		if(success){
			message = "²Ëµ¥ÐÞ¸Ä³É¹¦";
		}else{
			message = "²Ëµ¥ÐÞ¸ÄÊ§°Ü";
		}
		return SUCCESS;
	}

	/**
	 * ¸ù¾Ý²Ëµ¥ID²éÑ¯Ò»¸ö²Ëµ¥
	 * 
	 * @return
	 */
	@Action(value = "loadMenu")
	public String load() {
		menu = menuService.load(menu.getId());
		if(menu != null){
			message = "²Ëµ¥²éÑ¯³É¹¦";
		}else{
			message = "²Ëµ¥²éÑ¯Ê§°Ü";
		}
		return SUCCESS;
	}

	/**
	 * ¸ù¾Ý²Ëµ¥idÉ¾³ýÒ»¸ö²Ëµ¥
	 * 
	 * @return
	 */

	@Action(value = "deleteMenu")
	public String delete() {
		success = menuService.delete(menu.getId());
		if(success){
			message = "²Ëµ¥É¾³ý³É¹¦";
		}else{
			message = "²Ëµ¥É¾³ýÊ§°Ü";
		}
		return SUCCESS;
	}

	//
	@Action(value = "listMenu")
	public String list() {
		menuList = new HashMap<String, Object>();
		List<MenuVo> l = menuService.list();
		menuList.put("Rows", l);
		menuList.put("Total", l.size());
		return SUCCESS;
	}
	
	// »ñÈ¡±íÖÐËùÓÐ¹¦ÄÜºÍËùÓÐÒ»¼¶²Ëµ¥£¬ÊÇÓÃList×°µÄ
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
