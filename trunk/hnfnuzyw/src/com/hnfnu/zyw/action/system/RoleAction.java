package com.hnfnu.zyw.action.system;

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
import com.hnfnu.zyw.dto.system.RoleDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.service.system.IRoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller("roleAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success",type = "json",params = {"root","action"}) })
@Namespace("/system")
public class RoleAction extends AopNoSuchMethodErrorSolveBaseAction implements ModelDriven<RoleDto> {


	@Autowired
	@Qualifier("roleService")
	private IRoleService roleService;
	
	private RoleDto role = new RoleDto();//»ñÈ¡Ò³ÃæÌá½»²ÎÊý
	private boolean success;
	private String message;
	private Map<String,Object> roleList;

	@Action(value = "addRole")
	public String add(){
		// »ñÈ¡µ±Ç°ÓÃ»§
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		UserDto user = (UserDto) session.get("user");
		role.setCreateUserId(user.getId());
		role.setCreateUserName(user.getName());
		success = roleService.add(role);
		if(success) {
			message = "Ìí¼Ó½ÇÉ«³É¹¦£¡";
		} else {
			message = "Ìí¼Ó½ÇÉ«Ê§°Ü£¡";
		}
		return SUCCESS;
	}
	
	@Action(value = "updateRole")
	public String update(){
		success = roleService.update(role);
		if(success) {
			message = "ÐÞ¸Ä½ÇÉ«³É¹¦£¡";
		} else {
			message = "ÐÞ¸Ä½ÇÉ«Ê§°Ü£¡";
		}
		return SUCCESS;
	}
	
	@Action(value = "loadRole")
	public String load(){
		role = roleService.load(role);
		return SUCCESS;
	}
	
	@Action(value = "deleteRole")
	public String delete(){
		success = roleService.delete(role);
		if(success) {
			message = "É¾³ý½ÇÉ«³É¹¦£¡";
		} else {
			message = "É¾³ý½ÇÉ«Ê§°Ü£¡";
		}
		return SUCCESS;
	}
	
	@Action(value = "listRole")
	public String list(){
		roleList = roleService.list();
		return SUCCESS;
	}

	public boolean isSuccess() {
		return success;
	}
	
	public String getMessage() {
		return message;
	}

	public RoleDto getModel() {
		return role;
	}

	public RoleDto getRole() {
		return role;
	}

	public Map<String, Object> getRoleList() {
		return roleList;
	}

}
