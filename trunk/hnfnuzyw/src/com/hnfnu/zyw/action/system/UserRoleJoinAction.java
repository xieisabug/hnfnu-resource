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
import com.hnfnu.zyw.dto.system.UserRoleJoinDto;
import com.hnfnu.zyw.service.system.IUserRoleJoinService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userRoleJoinAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/system")
public class UserRoleJoinAction extends AopNoSuchMethodErrorSolveBaseAction implements
		ModelDriven<UserRoleJoinDto> {
	private UserRoleJoinDto userRoleJoin = new UserRoleJoinDto();// »ñÈ¡Ò³ÃæÌá½»²ÎÊý
	private boolean success;
	private String message;
	private Map<String, Object> userRoleJoinList;
	//ÓÃ»§¹Ò½Ó½ÇÉ«£¬ÓÃ£»ºÃ¸ô¿ª¡£
	private String seletedRoleIds;

	@Autowired
	@Qualifier("userRoleJoinService")
	private IUserRoleJoinService userRoleJoinService;

	// private String bir;

	// Ìí¼Ó
	@Action(value = "addUserRoleJoin")
	public String add() {
		success = userRoleJoinService.add(userRoleJoin);
		if (success) {
			message = "ÓÃ»§¹Ò½Ó½ÇÉ«³É¹¦£¡";
		} else {
			message = "ÓÃ»§¹Ò½Ó½ÇÉ«Ê§°Ü£¡";
		}
		return SUCCESS;
	}

	// ÐÞ¸Ä
	@Action(value = "updateUserRoleJoin")
	public String update() {
		success = userRoleJoinService.update(userRoleJoin);
		if (success) {
			message = "ÓÃ»§ÐÞ¸Ä½ÇÉ«³É¹¦£¡";
		} else {
			message = "ÓÃ»§ÐÞ¸Ä½ÇÉ«Ê§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ¸ù¾Ý²Ëµ¥ID²éÑ¯Ò»¸ö¶ÔÏó
	 * 
	 * @return
	 */
	@Action(value = "loadUserRoleJoin")
	public String load() {
		userRoleJoin = userRoleJoinService.load(userRoleJoin.getId());
		return SUCCESS;
	}

	/**
	 * ¸ù¾Ý²Ëµ¥idÉ¾³ýÒ»¸ö²Ëµ¥
	 * 
	 * @return
	 */

	@Action(value = "deleteUserRoleJoin")
	public String delete() {
		success = userRoleJoinService.delete(userRoleJoin.getId());
		if (success) {
			message = "ÓÃ»§ÒÆ³ý½ÇÉ«³É¹¦£¡";
		} else {
			message = "ÓÃ»§ÒÆ³ý½ÇÉ«Ê§°Ü£¡";
		}
		return SUCCESS;
	}
	
	@Action(value = "addUserRoleJoins")
	public String addUserRoleJoins(){
		success = userRoleJoinService.addUserRoleJoins(seletedRoleIds);
		if (success) {
			message = "ÓÃ»§Ìí¼Ó½ÇÉ«³É¹¦£¡";
		} else {
			message = "ÓÃ»§Ìí¼Ó½ÇÉ«Ê§°Ü£¡";
		}
		return SUCCESS;
	}
	
	
	

	/* get set */

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
	
	public void setSeletedRoleIds(String seletedRoleIds) {
		this.seletedRoleIds = seletedRoleIds;
	}


}
