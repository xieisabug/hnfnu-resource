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

import com.hnfnu.zyw.dto.system.FunctionDto;
import com.hnfnu.zyw.dto.system.ParameterDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.service.system.IFunctionService;
import com.hnfnu.zyw.service.system.IParameterService;
import com.hnfnu.zyw.service.website.IIndexService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("IndexAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/website")
public class IndexAction implements ModelDriven<UserDto> {

	private UserDto user = new UserDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private List<Map<String, Object>> menuList;
	private List<FunctionDto> functionList;
	private List<ParameterDto> parameterList;

	@Autowired
	@Qualifier("indexService")
	private IIndexService indexService;
	
	@Autowired
	@Qualifier("functionService")
	private IFunctionService functionService;
	
	@Autowired
	@Qualifier("parameterService")
	private IParameterService parameterService;


	// 获取登录所需要的东西,menuList,functionList
	@Action(value = "index")
	public String index() {
		Map<String, Object> s = ServletActionContext.getContext().getSession();
		UserDto user = (UserDto) s.get("user");
		if (user != null) {
			int id = user.getId();
			menuList = indexService.getRoleMenusByUserId(id);
			functionList = functionService.list();
			parameterList = parameterService.listAll();
			success = true;
		} else {
			success = false;
			message = "您还没有登录";
		}
		return "success";
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

	public List<Map<String, Object>> getMenuList() {
		return menuList;
	}

	public List<FunctionDto> getFunctionList() {
		return functionList;
	}

	public void setMenuList(List<Map<String, Object>> menuList) {
		this.menuList = menuList;
	}

	public List<ParameterDto> getParameterList() {
		return parameterList;
	}

}
