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
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.service.system.IUserService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/system")
public class UserAction extends AopNoSuchMethodErrorSolveBaseAction implements ModelDriven<UserDto> {

	private UserDto user = new UserDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> userList;
	private String newPassword;
	private String userIds; 
	private int balanceCount;
	private String url;
	private Map<String,Object> failUsers;
	@Autowired
	@Qualifier("userService")
	private IUserService userService;

	// private String bir;
	
	/**
	 * 批量注册用户
	 * @return
	 */
	@Action(value = "addManyUser")
	public String addManyUser() {
		failUsers = userService.addUsers(url);
		if(failUsers != null){
			success = true;	
		}else{
			success = false;
		}
		if (success) {
			message = "给用户们注册成功！";
		} else {
			message = "给所有用户们注册失败！";
		}
		return SUCCESS;
	}

	/**
	 * 批量给用户充值资源币
	 * @return
	 */
	@Action(value = "addUserBalanceCount")
	public String addUserBalanceCount() {
		int i = userService.addUserBalance(balanceCount, userIds);
		if (i == 1) {
			success = true;
			message = "给用户们充值成功！";
		} else {
			success=false;
			if(i==0){
				message = "给用户们充值失败！";	
			}
			if(i == -1){
				message = "给用户们充值失败,因为在您选择的学生当中有学生的资源币少于您要减去的资源币！";
			}
			if( i == -2){
				message = "给用户们充值失败,因为每位学生的总余额数不能超过1000000000！";
			}
			
		}
		return SUCCESS;
	}
	
	
	/**
	 * 批量给用户修改密码
	 * @return
	 */
	@Action(value = "editManyUserPassword")
	public String editManyPassword() {
	success = userService.editManyPassword(userIds, newPassword);
	if(success){
		message = "批量修改密码成功";
	}else{
		message = "批量修改密码失败";
	}
		return SUCCESS;
	}
	
	/**
	 * 批量给用户重置资源币
	 * @return
	 */
	@Action(value = "changeUserBalance")
	public String changeUserBalance() {
		int i = userService.setUserBalance(balanceCount, userIds);
		if (i == 1) {
			success = true;
			message = "给用户们重置成功！";
		} else {
			success=false;
			if(i==0){
				message = "给用户们重置失败！";	
			}
			if(i == -1){
				message = "给用户们充值失败,重置后的资源币不能为负数！";
			}
			if( i == -2){
				message = "给用户们重置失败,因为每位用户的总余额数不能超过1000000000！";
			}
			
		}
		return SUCCESS;
	}
	

	/**
	 * 批量删除用户
	 * @return
	 */
	@Action(value = "deleteUsers")
	public String deleteUsers() {
		int i = userService.deleteUsers(userIds);
		if (i == 1) {
			success = true;
			message = "删除用户们成功！";
		} else {
			success=false;
			if(i==0){
				message = "删除用户们失败！";	
			}
		}
		return SUCCESS;
	}
	

	// 添加
	@Action(value = "addUser")
	public String add() {
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
		if(user != null){
			success = true;
		}else {
			success = false;
		}
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
	
	
	// 获取表中所有用户，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "listUser")
	public String list() {
		userList = userService.list();
		if(userList != null){
			success = true;
		}else {
			success = false;
		}
		return SUCCESS;
	}

	/* get set */

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

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public void setBalanceCount(int balanceCount) {
		this.balanceCount = balanceCount;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, Object> getFailUsers() {
		return failUsers;
	}
}
