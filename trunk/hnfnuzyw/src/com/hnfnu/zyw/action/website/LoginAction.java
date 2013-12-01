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

import com.hnfnu.zyw.dto.system.StudentDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.dto.system.ValidateMessege;
import com.hnfnu.zyw.service.website.ILoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("loginAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/website")
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -7199971221300636848L;
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

	// ��֤�û��Ƿ����
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

	// ���ݵ�½����ݵ�½
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

	// �ж�ǰ̨�Ƿ��½��������ѧ��������ʦ
	@Action(value = "validateLogin")
	public String validateLogin() {
		// ��ȡ��ǰ�û�
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
			message = "�û��Ѿ���½";
		} else {
			message = "������Դǰ�����ȵ�½";
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
			message = "�˳�ϵͳʧ�ܣ�session������ɹ�";
		} else {
			success = true;
			message = "�˳�ϵͳ�ɹ�";
		}
		return SUCCESS;
	}

	// ��ȡ��ҳ��ͼ��
	@Action(value = "welcomeChart")
	public String welcomeChart() {
		int id = ((UserDto) ServletActionContext.getContext().getSession()
				.get("user")).getId();
		data = loginService.welcomeChart(id);
		if (data != null) {
			success = true;
			message = "��ȡͼ��ɹ�";
		} else {
			success = false;
			message = "��ȡͼ��ʧ��";
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
