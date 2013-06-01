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

import com.hnfnu.zyw.dto.system.UserRoleJoinDto;
import com.hnfnu.zyw.service.system.IUserRoleJoinService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userRoleJoinAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/system")
public class UserRoleJoinAction extends ActionSupport implements
		ModelDriven<UserRoleJoinDto> {
	private static final long serialVersionUID = -5962640394246361991L;
	private UserRoleJoinDto userRoleJoin = new UserRoleJoinDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> userRoleJoinList;

	@Autowired
	@Qualifier("userRoleJoinService")
	private IUserRoleJoinService userRoleJoinService;

	// private String bir;

	// 添加
	@Action(value = "addUserRoleJoin")
	public String add() {
		success = userRoleJoinService.add(userRoleJoin);
		if (success) {
			message = "用户挂接角色成功！";
		} else {
			message = "用户挂接角色失败！";
		}
		return SUCCESS;
	}

	// 修改
	@Action(value = "updateUserRoleJoin")
	public String update() {
		success = userRoleJoinService.update(userRoleJoin);
		if (success) {
			message = "用户修改角色成功！";
		} else {
			message = "用户修改角色失败！";
		}
		return SUCCESS;
	}

	/**
	 * 根据菜单ID查询一个对象
	 * 
	 * @return
	 */
	@Action(value = "loadUserRoleJoin")
	public String load() {
		userRoleJoin = userRoleJoinService.load(userRoleJoin.getId());
		return SUCCESS;
	}

	/**
	 * 根据菜单id删除一个菜单
	 * 
	 * @return
	 */

	@Action(value = "deleteUserRoleJoin")
	public String delete() {
		success = userRoleJoinService.delete(userRoleJoin.getId());
		if (success) {
			message = "用户移除角色成功！";
		} else {
			message = "用户移除角色失败！";
		}
		return SUCCESS;
	}
/*
	// 获取表中所有功能，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "listUser")
	public String list() {
		userRoleJoinList = userRoleJoinService.list();
		return SUCCESS;
	}*/

	/* get set */
	public IUserRoleJoinService getUserRoleJoinService() {
		return userRoleJoinService;
	}

	public void setUserRoleJoinService(IUserRoleJoinService userRoleJoinService) {
		this.userRoleJoinService = userRoleJoinService;
	}

	public UserRoleJoinDto getModel() {
		return userRoleJoin;
	}

	public UserRoleJoinDto getUser() {
		return userRoleJoin;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getUserList() {
		return userRoleJoinList;
	}

}
