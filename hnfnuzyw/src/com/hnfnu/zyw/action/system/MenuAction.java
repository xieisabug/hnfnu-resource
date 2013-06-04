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
	private MenuDto menu = new MenuDto();// ��ȡҳ���ύ����
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

	// ��Ӳ˵�
	@Action(value = "addMenu")
	public String add() {
		success = menuService.add(menu);
		if(success){
			message = "�˵���ӳɹ�";
		}else{
			message = "�˵����ʧ��";
		}
		return SUCCESS;
	}

	// �޸Ĳ˵�
	@Action(value = "updateMenu")
	public String update() {
		success = menuService.update(menu);
		if(success){
			message = "�˵��޸ĳɹ�";
		}else{
			message = "�˵��޸�ʧ��";
		}
		return SUCCESS;
	}

	/**
	 * ���ݲ˵�ID��ѯһ���˵�
	 * 
	 * @return
	 */
	@Action(value = "loadMenu")
	public String load() {
		menu = menuService.load(menu.getId());
		if(menu != null){
			message = "�˵���ѯ�ɹ�";
		}else{
			message = "�˵���ѯʧ��";
		}
		return SUCCESS;
	}

	/**
	 * ���ݲ˵�idɾ��һ���˵�
	 * 
	 * @return
	 */

	@Action(value = "deleteMenu")
	public String delete() {
		success = menuService.delete(menu.getId());
		if(success){
			message = "�˵�ɾ���ɹ�";
		}else{
			message = "�˵�ɾ��ʧ��";
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
	
	// ��ȡ�������й��ܺ�����һ���˵�������Listװ��
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
