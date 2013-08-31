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

import com.hnfnu.zyw.dto.system.RoleDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.service.system.IRoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("roleAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success",type = "json",params = {"root","action"}) })
@Namespace("/system")
public class RoleAction extends ActionSupport implements ModelDriven<RoleDto> {

	private static final long serialVersionUID = 361910504650120895L;

	@Autowired
	@Qualifier("roleService")
	private IRoleService roleService;
	
	private RoleDto role = new RoleDto();//获取页面提交参数
	private boolean success;
	private String message;
	private Map<String,Object> roleList;

	@Action(value = "addRole")
	public String add(){
		// 获取当前用户
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		UserDto user = (UserDto) session.get("user");
		role.setCreateUserId(user.getId());
		role.setCreateUserName(user.getName());
		success = roleService.add(role);
		if(success) {
			message = "添加角色成功！";
		} else {
			message = "添加角色失败！";
		}
		return SUCCESS;
	}
	
	@Action(value = "updateRole")
	public String update(){
		success = roleService.update(role);
		if(success) {
			message = "修改角色成功！";
		} else {
			message = "修改角色失败！";
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
			message = "删除角色成功！";
		} else {
			message = "删除角色失败！";
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

	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public RoleDto getRole() {
		return role;
	}

	public Map<String, Object> getRoleList() {
		return roleList;
	}

}
