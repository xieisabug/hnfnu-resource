package com.hnfnu.zyw.action.system;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnfnu.zyw.dto.system.RoleMenuJoinDto;
import com.hnfnu.zyw.service.system.IRoleMenuJoinService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("roleMemuJoinAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/system")
public class RoleMenuJoinAction extends ActionSupport implements
		ModelDriven<RoleMenuJoinDto> {

	private static final long serialVersionUID = 5941060251589671029L;

	@Autowired
	@Qualifier("roleMenuJoinService")
	private IRoleMenuJoinService roleMenuJoinService;

	private RoleMenuJoinDto roleMenuJoin = new RoleMenuJoinDto();// ��ȡҳ���ύ����
	private boolean success;
	private String message;
	List<Object> joinTree;

	@Action(value = "joinTree")
	public String joinTree() {
		joinTree = roleMenuJoinService.roleMenuInit(roleMenuJoin.getRoleId());
		if(joinTree != null){
			success = true;
		}else{
			success = false;
		}
		return SUCCESS;
	}

	public RoleMenuJoinDto getRoleMenuJoin() {
		return roleMenuJoin;
	}

	public void setRoleMenuJoin(RoleMenuJoinDto roleMenuJoin) {
		this.roleMenuJoin = roleMenuJoin;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public List<Object> getJoinTree() {
		return joinTree;
	}

	public void setRoleMenuJoinService(IRoleMenuJoinService roleMenuJoinService) {
		this.roleMenuJoinService = roleMenuJoinService;
	}

	public RoleMenuJoinDto getModel() {
		return roleMenuJoin;
	}

}
