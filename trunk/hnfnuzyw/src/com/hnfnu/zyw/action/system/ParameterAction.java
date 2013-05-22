package com.hnfnu.zyw.action.system;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnfnu.zyw.dto.system.ParameterDto;
import com.hnfnu.zyw.service.system.IParameterService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("parameterAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success",type = "json",params = {"root","action"}) })
@Namespace("/system")
public class ParameterAction extends ActionSupport implements ModelDriven<ParameterDto> {

	private static final long serialVersionUID = 361910504650120895L;

	@Autowired
	@Qualifier("parameterService")
	private IParameterService parameterService;
	
	private ParameterDto parameter = new ParameterDto();//获取页面提交参数
	private boolean success;

	@Action(value = "addParameter")
	public String add(){
		success = parameterService.add(parameter);
		return SUCCESS;
	}
	
	@Action(value = "updateParameter", results = { @Result(name = "success", type="json") })
	public String update(){
		success = parameterService.update(parameter);
		return SUCCESS;
	}
	
	@Action(value = "loadParameter", results = { @Result(name = "success", type="json") })
	public String load(){
		parameter = parameterService.load(parameter);
		return SUCCESS;
	}
	
	@Action(value = "deleteParameter", results = { @Result(name = "success", type="json") })
	public String delete(){
		success = parameterService.delete(parameter);
		return SUCCESS;
	}

	/*get set*/
	public IParameterService getParameterService() {
		return parameterService;
	}

	public void setParameterService(IParameterService parameterService) {
		this.parameterService = parameterService;
	}

	public ParameterDto getModel() {
		return parameter;
	}

	public ParameterDto getParameter() {
		return parameter;
	}

	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
