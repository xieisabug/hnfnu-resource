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

import com.hnfnu.zyw.action.base.AopNoSuchMethodErrorSolveBaseAction;
import com.hnfnu.zyw.dto.system.ParameterDto;
import com.hnfnu.zyw.service.system.IParameterService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("parameterAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success",type = "json",params = {"root","action"}) })
@Namespace("/system")
public class ParameterAction extends AopNoSuchMethodErrorSolveBaseAction implements ModelDriven<ParameterDto> {


	@Autowired
	@Qualifier("parameterService")
	private IParameterService parameterService;
	
	private ParameterDto parameter = new ParameterDto();//��ȡҳ���ύ����
	private boolean success;
	private String message;
	private Map<String,Object> parameterList;

	/**
	 * ��Ӳ���
	 * @return
	 */
	@Action(value = "addParameter")
	public String add(){
		success = parameterService.add(parameter);
		if(success) {
			message = "��Ӳ����ɹ���";
		} else {
			message = "��Ӳ���ʧ�ܣ�";
		}
		return SUCCESS;
	}
	
	/**
	 * �޸Ĳ���
	 * @return
	 */
	@Action(value = "updateParameter")
	public String update(){
		success = parameterService.update(parameter);
		if(success) {
			message = "�޸Ĳ����ɹ���";
		} else {
			message = "�޸Ĳ���ʧ�ܣ�";
		}
		return SUCCESS;
	}
	
	/**
	 * ��ȡ����
	 * @return
	 */
	@Action(value = "loadParameter")
	public String load(){
		parameter = parameterService.load(parameter);
		return SUCCESS;
	}
	
	/**
	 * ɾ������
	 * @return
	 */
	@Action(value = "deleteParameter")
	public String delete(){
		success = parameterService.delete(parameter);
		if(success) {
			message = "ɾ�������ɹ���";
		} else {
			message = "ɾ������ʧ�ܣ�";
		}
		return SUCCESS;
	}
	
	/**
	 * ��ȡ�����б�
	 * @return
	 */
	@Action(value = "listParameter")
	public String list(){
		parameterList = parameterService.list();
		return SUCCESS;
	}

	/*get set*/

	public ParameterDto getModel() {
		return parameter;
	}

	public ParameterDto getParameter() {
		return parameter;
	}

	public boolean isSuccess() {
		return success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Map<String, Object> getParameterList() {
		return parameterList;
	}
}
