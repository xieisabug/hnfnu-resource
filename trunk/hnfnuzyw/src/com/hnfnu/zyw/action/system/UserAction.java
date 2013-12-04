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

	private UserDto user = new UserDto();// »ñÈ¡Ò³ÃæÌá½»²ÎÊý
	private boolean success;
	private String message;
	private Map<String, Object> userList;
	private String newPassword;
	@Autowired
	@Qualifier("userService")
	private IUserService userService;

	// private String bir;

	// Ìí¼Ó
	@Action(value = "addUser")
	public String add() {
		success = userService.add(user);
		if (success) {
			message = "Ìí¼Ó¹¦ÄÜ³É¹¦£¡";
		} else {
			message = "Ìí¼Ó¹¦ÄÜÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	// ÐÞ¸Ä
	@Action(value = "updateUser")
	public String update() {
		success = userService.update(user);
		if (success) {
			message = "ÐÞ¸Ä³É¹¦£¡";
		} else {
			message = "ÐÞ¸ÄÊ§°Ü£¡";
		}
		return SUCCESS;
	}
	/**
	 * ÐÞ¸ÄÃÜÂë
	 * @return
	 */
	@Action(value = "updatePwd")
	public String updatePwd() {
		success = userService.updatePwd(user.getId(), newPassword);
		if (success) {
			message = "ÐÞ¸ÄÃÜÂë³É¹¦£¡";
		} else {
			message = "ÐÞ¸ÄÃÜÂëÊ§°Ü£¡";
		}
		return SUCCESS;
	}
	/**
	 * ¸ù¾Ý²Ëµ¥ID²éÑ¯Ò»¸ö¶ÔÏó
	 * 
	 * @return
	 */
	@Action(value = "loadUser")
	public String load() {
		user = userService.load(user.getId());
		return SUCCESS;
	}

	/**
	 * ¸ù¾Ý²Ëµ¥idÉ¾³ýÒ»¸ö²Ëµ¥
	 * 
	 * @return
	 */

	@Action(value = "deleteUser")
	public String delete() {
		success = userService.delete(user.getId());
		if (success) {
			message = "É¾³ý³É¹¦£¡";
		} else {
			message = "É¾³ýÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ÑéÖ¤ÓÃ»§ÃûÊÇ·ñÒÑ¾­´æÔÚ
	 * @return
	 */
	@Action(value = "validateUsername")
	public String validateUsername() {
		success = userService.validateUserName(user.getUsername());
		if (success) {
			message = "ÓÃ»§ÃûÒÑ±»Ê¹ÓÃ£¡";
		} else {
			message = "ÓÃ»§Ãû¿ÉÓÃ£¡";
		}
		return SUCCESS;
	}
	
	
	// »ñÈ¡±íÖÐËùÓÐ¹¦ÄÜ£¬ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
	@Action(value = "listUser")
	public String list() {
		userList = userService.list();
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

	
}
