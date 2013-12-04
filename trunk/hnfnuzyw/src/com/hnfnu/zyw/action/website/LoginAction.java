package com.hnfnu.zyw.action.website;

import java.util.List;
import java.util.Map;

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

import com.hnfnu.zyw.action.base.AopNoSuchMethodErrorSolveBaseAction;
import com.hnfnu.zyw.dto.system.StudentDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.dto.system.ValidateMessege;
import com.hnfnu.zyw.service.website.ILoginService;
import com.opensymphony.xwork2.ActionContext;

@Controller("loginAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/website")
public class LoginAction extends AopNoSuchMethodErrorSolveBaseAction{
	
	private final int USER = 1;
	private final int STUDENT = 0;
	private int loginType;
	private String username;
	private String password;
	private boolean success;
	private String message;
	private List<Map<String, Object>> data;

	@Autowired
	@Qualifier("loginService")
	private ILoginService loginService;

	// ÑéÖ¤ÓÃ»§ÊÇ·ñ´æÔÚ
	@Action(value = "loginUser")
	public String loginUser() {
		UserDto user = new UserDto();
		user.setUsername(username);
		user.setPassword(password);
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

	@Action(value = "loginStudent")
	public String loginStudent() {
		StudentDto student = new StudentDto();
		student.setUsername(username);
		student.setPassword(password);
		ValidateMessege vm = loginService.validateStudent(student);
		if (vm.isResult()) {
			message = vm.getMessege();
			student = (StudentDto) vm.getO();
			ServletActionContext.getContext().getSession()
					.put("student", student);
			success = true;
		} else {
			message = vm.getMessege();
			success = false;
		}
		return SUCCESS;
	}

	// ¸ù¾ÝµÇÂ½µÄÉí·ÝµÇÂ½
	@Action(value = "login")
	public String login() {
		if (loginType == STUDENT) {
			return loginStudent();
		}

		if (loginType == USER) {
			return loginUser();
		}
		return SUCCESS;
	}

	// ÅÐ¶ÏÇ°Ì¨ÊÇ·ñµÇÂ½£¬²»¹ÜÊÇÑ§Éú»¹ÊÇÀÏÊ¦
	@Action(value = "validateLogin")
	public String validateLogin() {
		// »ñÈ¡µ±Ç°ÓÃ»§
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		UserDto user = (UserDto) session.get("user");
		StudentDto student = (StudentDto) session.get("student");
		success = false;
		if (user != null) {
			success = true;
		}
		if (student != null) {
			success = true;
		}

		if (success) {
			message = "ÓÃ»§ÒÑ¾­µÇÂ½";
		} else {
			message = "ÏÂÔØ×ÊÔ´Ç°ÇëÄúÏÈµÇÂ½";
		}
		return SUCCESS;
	}

	@Action(value = "exit")
	public String exit() {
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();
		session.clear();
		if (session.containsKey("user") || session.containsKey("student")) {
			success = false;
			message = "ÍË³öÏµÍ³Ê§°Ü£¬sessionÇå³ý²»³É¹¦";
		} else {
			success = true;
			message = "ÍË³öÏµÍ³³É¹¦";
		}
		return SUCCESS;
	}

	// »ñÈ¡Ö÷Ò³µÄÍ¼±í
	@Action(value = "welcomeChart")
	public String welcomeChart() {
		int id = ((UserDto) ServletActionContext.getContext().getSession()
				.get("user")).getId();
		data = loginService.welcomeChart(id);
		if (data != null) {
			success = true;
			message = "»ñÈ¡Í¼±í³É¹¦";
		} else {
			success = false;
			message = "»ñÈ¡Í¼±íÊ§°Ü";
		}
		return SUCCESS;
	}

	/* get set */
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

	public List<Map<String, Object>> getData() {
		return data;
	}

}
