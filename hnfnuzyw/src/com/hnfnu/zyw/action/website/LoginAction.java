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
	private Map<String, Object> info;

	@Autowired
	@Qualifier("loginService")
	private ILoginService loginService;

	// 验证用户是否存在
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

	// 根据登陆的身份登陆
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

	// 判断前台是否登陆，不管是学生还是老师
	@Action(value = "validateLogin")
	public String validateLogin() {
		// 获取当前用户
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
			message = "用户已经登陆";
		} else {
			message = "下载资源前请您先登陆";
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
			message = "退出系统失败，session清除不成功";
		} else {
			success = true;
			message = "退出系统成功";
		}
		return SUCCESS;
	}

	// 获取主页的图表
	@Action(value = "welcomeChart")
	public String welcomeChart() {
		int id = ((UserDto) ServletActionContext.getContext().getSession()
				.get("user")).getId();
		data = loginService.welcomeChart(id);
		if (data != null) {
			success = true;
			message = "获取图表成功";
		} else {
			success = false;
			message = "获取图表失败";
		}
		return SUCCESS;
	}
	
	//获取用户登录信息
	@Action(value = "welcomeInfo")
	public String welcomeInfo() {
		info = loginService.welcomeInfo();
		System.out.println(info.get("habit"));
		if (info != null) {
			success = true;
			message = "获取用户信息成功";
		} else {
			success = false;
			message = "用户信息获取失败，请与管理员联系";
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

	public Map<String, Object> getInfo() {
		return info;
	}

}
