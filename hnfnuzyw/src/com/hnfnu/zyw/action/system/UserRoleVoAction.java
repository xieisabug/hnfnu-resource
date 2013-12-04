﻿package com.hnfnu.zyw.action.system;

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
import com.hnfnu.zyw.service.system.IUserRoleVoService;
import com.hnfnu.zyw.vo.UserRoleVo;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userRoleVoAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/system")
public class UserRoleVoAction extends AopNoSuchMethodErrorSolveBaseAction implements
		ModelDriven<UserRoleVo> {
	private UserRoleVo userRoleVo = new UserRoleVo();// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> roleByUser;
	/**
	 * 通过用户id，得到该用户已经添加的角色和未添加的角色
	 */
	@Autowired
	@Qualifier("userRoleVoService")
	private IUserRoleVoService userRoleVoService;

	@Action(value = "roleByUser")
	public String selected() {
		roleByUser = userRoleVoService.roleByUser(userRoleVo.getUserId());
		return SUCCESS;
	}
	public UserRoleVo getUserRoleVo() {
		return userRoleVo;
	}

	public void setUserRoleVo(UserRoleVo userRoleVo) {
		this.userRoleVo = userRoleVo;
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

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getRoleByUser() {
		return roleByUser;
	}

	public UserRoleVo getModel() {
		return userRoleVo;
	}
}
