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

import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.service.system.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/system")
public class UserAction extends ActionSupport implements ModelDriven<UserDto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7199971221300636848L;
	private UserDto user = new UserDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> userList;
	private String newPassword;
	@Autowired
	@Qualifier("userService")
	private IUserService userService;

	// private String bir;

	// 添加
	@Action(value = "addUser")
	public String add() {
		//老师默认资源币为0
		user.setBalance(0);
		success = userService.add(user);
		if (success) {
			message = "添加功能成功！";
		} else {
			message = "添加功能失败！";
		}
		return SUCCESS;
	}

	// 修改
	@Action(value = "updateUser")
	public String update() {
		success = userService.update(user);
		if (success) {
			message = "修改成功！";
		} else {
			message = "修改失败！";
		}
		return SUCCESS;
	}
	/**
	 * 修改密码
	 * @return
	 */
	@Action(value = "updatePwd")
	public String updatePwd() {
		success = userService.updatePwd(user.getId(), newPassword);
		if (success) {
			message = "修改密码成功！";
		} else {
			message = "修改密码失败！";
		}
		return SUCCESS;
	}
	/**
	 * 根据菜单ID查询一个对象
	 * 
	 * @return
	 */
	@Action(value = "loadUser")
	public String load() {
		user = userService.load(user.getId());
		return SUCCESS;
	}

	/**
	 * 根据菜单id删除一个菜单
	 * 
	 * @return
	 */

	@Action(value = "deleteUser")
	public String delete() {
		success = userService.delete(user.getId());
		if (success) {
			message = "删除成功！";
		} else {
			message = "删除失败！";
		}
		return SUCCESS;
	}

	/**
	 * 验证用户名是否已经存在
	 * @return
	 */
	@Action(value = "validateUsername")
	public String validateUsername() {
		success = userService.validateUserName(user.getUsername());
		if (success) {
			message = "用户名已被使用！";
		} else {
			message = "用户名可用！";
		}
		return SUCCESS;
	}
	
	
	// 获取表中所有功能，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "listUser")
	public String list() {
		userList = userService.list();
		return SUCCESS;
	}

	/* get set */
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public UserDto getModel() {
		return user;
	}

	public UserDto getUser() {
		return user;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getUserList() {
		return userList;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	
}
