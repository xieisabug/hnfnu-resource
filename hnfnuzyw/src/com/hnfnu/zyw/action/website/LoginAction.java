package com.hnfnu.zyw.action.website;

import org.apache.struts2.ServletActionContext;
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
import com.hnfnu.zyw.dto.system.ValidateMessege;
import com.hnfnu.zyw.service.website.ILoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("loginAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/website")
public class LoginAction extends ActionSupport implements ModelDriven<UserDto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7199971221300636848L;
	private UserDto user = new UserDto();// 获取页面提交参数
	private boolean success;
	private String message;

	@Autowired
	@Qualifier("loginService")
	private ILoginService loginService;


	// 登陆验证用户是否存在
	@Action(value = "validateUser")
	public String validateUser() {
		ValidateMessege vm = loginService.validateUser(user);
		if (vm.isResult()) {
			message = vm.getMessege();
			user = (UserDto) vm.getO();
			ServletActionContext.getContext().getSession().put("user", user);
			success = true;
		} else {
			message = vm.getMessege();
			success = false;
		}
		return SUCCESS;
	}

	/* get set */

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
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

}
