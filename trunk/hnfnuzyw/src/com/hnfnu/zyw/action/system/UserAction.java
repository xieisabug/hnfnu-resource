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
import com.hnfnu.zyw.dto.system.ValidateMessege;
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
	private UserDto user = new UserDto();// ��ȡҳ���ύ����
	private boolean success;
	private String message;
	private Map<String, Object> userList;

	@Autowired
	@Qualifier("userService")
	private IUserService userService;

	// private String bir;

	// ����
	@Action(value = "addUser")
	public String add() {
		success = userService.add(user);
		if (success) {
			message = "���ӹ��ܳɹ���";
		} else {
			message = "���ӹ���ʧ�ܣ�";
		}
		return SUCCESS;
	}

	// �޸�
	@Action(value = "updateUser")
	public String update() {
		success = userService.update(user);
		if (success) {
			message = "�޸ĳɹ���";
		} else {
			message = "�޸�ʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * ���ݲ˵�ID��ѯһ������
	 * 
	 * @return
	 */
	@Action(value = "loadUser")
	public String load() {
		user = userService.load(user.getId());
		return SUCCESS;
	}

	/**
	 * ���ݲ˵�idɾ��һ���˵�
	 * 
	 * @return
	 */

	@Action(value = "deleteUser")
	public String delete() {
		success = userService.delete(user.getId());
		if (success) {
			message = "ɾ���ɹ���";
		} else {
			message = "ɾ��ʧ�ܣ�";
		}
		return SUCCESS;
	}

	// ��ȡ�������й��ܣ���Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	@Action(value = "listUser")
	public String list() {
		userList = userService.list();
		return SUCCESS;
	}

	// ��½��֤�û��Ƿ����
	@Action(value = "validateUser")
	public String validateUser() {
		ValidateMessege vm = userService.validateUser(user);
		if (vm.isResult()) {
			message = vm.getMessege();
			user = (UserDto) vm.getO();
		} else {
			message = vm.getMessege();
		}
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

	// public void setBir(String bir) {
	// this.bir = bir;
	// }

}