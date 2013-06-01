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
	private UserRoleJoinDto userRoleJoin = new UserRoleJoinDto();// ��ȡҳ���ύ����
	private boolean success;
	private String message;
	private Map<String, Object> userRoleJoinList;
	//�û��ҽӽ�ɫ���ã��ø�����
	private String seletedRoleIds;

	@Autowired
	@Qualifier("userRoleJoinService")
	private IUserRoleJoinService userRoleJoinService;

	// private String bir;

	// ���
	@Action(value = "addUserRoleJoin")
	public String add() {
		success = userRoleJoinService.add(userRoleJoin);
		if (success) {
			message = "�û��ҽӽ�ɫ�ɹ���";
		} else {
			message = "�û��ҽӽ�ɫʧ�ܣ�";
		}
		return SUCCESS;
	}

	// �޸�
	@Action(value = "updateUserRoleJoin")
	public String update() {
		success = userRoleJoinService.update(userRoleJoin);
		if (success) {
			message = "�û��޸Ľ�ɫ�ɹ���";
		} else {
			message = "�û��޸Ľ�ɫʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * ���ݲ˵�ID��ѯһ������
	 * 
	 * @return
	 */
	@Action(value = "loadUserRoleJoin")
	public String load() {
		userRoleJoin = userRoleJoinService.load(userRoleJoin.getId());
		return SUCCESS;
	}

	/**
	 * ���ݲ˵�idɾ��һ���˵�
	 * 
	 * @return
	 */

	@Action(value = "deleteUserRoleJoin")
	public String delete() {
		success = userRoleJoinService.delete(userRoleJoin.getId());
		if (success) {
			message = "�û��Ƴ���ɫ�ɹ���";
		} else {
			message = "�û��Ƴ���ɫʧ�ܣ�";
		}
		return SUCCESS;
	}
	
	@Action(value = "addUserRoleJoins")
	public String addUserRoleJoins(){
		success = userRoleJoinService.addUserRoleJoins(seletedRoleIds);
		if (success) {
			message = "�û���ӽ�ɫ�ɹ���";
		} else {
			message = "�û���ӽ�ɫʧ�ܣ�";
		}
		return SUCCESS;
	}
	
	
	

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
	
	public void setSeletedRoleIds(String seletedRoleIds) {
		this.seletedRoleIds = seletedRoleIds;
	}


}
