package com.hnfnu.zyw.action.system;

import java.util.List;

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
import com.hnfnu.zyw.dto.system.RoleMenuJoinDto;
import com.hnfnu.zyw.service.system.IRoleMenuJoinService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("roleMemuJoinAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/system")
public class RoleMenuJoinAction extends AopNoSuchMethodErrorSolveBaseAction implements
		ModelDriven<RoleMenuJoinDto> {


	@Autowired
	@Qualifier("roleMenuJoinService")
	private IRoleMenuJoinService roleMenuJoinService;

	private RoleMenuJoinDto roleMenuJoin = new RoleMenuJoinDto();// 获取页面提交参数
	private boolean success;
	private String message;
	List<Object> joinTree;
	private String joinIds;

	@Action(value = "joinTree")
	public String joinTree() {
		joinTree = roleMenuJoinService.roleMenuInit(roleMenuJoin.getRoleId());
		if(joinTree != null){
			success = true;
		}else{
			success = false;
		}
		return SUCCESS;
	}
	
	@Action(value = "addRoleMenuJoins")
	public String addRoleMenuJoins() {
		success= roleMenuJoinService.addRoleMenuJoins(joinIds);
		if(success){
			message = "角色挂接菜单成功";
		}else{
			message = "角色挂接菜单失败";
		}
		return SUCCESS;
	}

	public RoleMenuJoinDto getRoleMenuJoin() {
		return roleMenuJoin;
	}

	public void setRoleMenuJoin(RoleMenuJoinDto roleMenuJoin) {
		this.roleMenuJoin = roleMenuJoin;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public List<Object> getJoinTree() {
		return joinTree;
	}

	public RoleMenuJoinDto getModel() {
		return roleMenuJoin;
	}

	public void setJoinIds(String joinIds) {
		this.joinIds = joinIds;
	}

	
}
