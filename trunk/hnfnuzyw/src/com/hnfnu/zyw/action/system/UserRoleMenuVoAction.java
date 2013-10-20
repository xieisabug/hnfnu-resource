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
import com.hnfnu.zyw.service.system.IUserRoleMenuVoService;
import com.hnfnu.zyw.vo.UserRoleMenuVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userRoleMenuAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/system")
public class UserRoleMenuVoAction extends ActionSupport implements
ModelDriven<UserRoleMenuVo>{
	
	private static final long serialVersionUID = -7199971221300636848L;
	private UserRoleMenuVo userRoleMenuVo = new UserRoleMenuVo();// ��ȡҳ���ύ����
	private boolean success;
	private String message;
	private String functionIdList;
	

	@Autowired
	@Qualifier("userRoleMenuVoService")
	private IUserRoleMenuVoService userRoleMenuVoService;

	
	@Action(value = "listFunctionIdList")
	public String listFunctionIdList() {
		// ��ȡ��ǰ�û�
				ActionContext context = ActionContext.getContext();
				Map<String, Object> session = context.getSession();
				UserDto user = (UserDto) session.get("user");
		functionIdList = userRoleMenuVoService.getListByUserIdMenuId(user.getId(), userRoleMenuVo.getMenuId());
		return SUCCESS;
	}
	
	
	
	public UserRoleMenuVo getModel() {
		return userRoleMenuVo;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public String getFunctionIdList() {
		return functionIdList;
	}

	public void setUserRoleMenuVo(UserRoleMenuVo userRoleMenuVo) {
		this.userRoleMenuVo = userRoleMenuVo;
	}

	public void setUserRoleMenuVoService(
			IUserRoleMenuVoService userRoleMenuVoService) {
		this.userRoleMenuVoService = userRoleMenuVoService;
	}
	
}