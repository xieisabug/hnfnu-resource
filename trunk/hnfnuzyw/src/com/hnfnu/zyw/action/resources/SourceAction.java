package com.hnfnu.zyw.action.resources;

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

import com.hnfnu.zyw.dto.resources.SourceDto;
import com.hnfnu.zyw.service.resources.ISourceService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("sourceAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class SourceAction extends ActionSupport implements ModelDriven<SourceDto>{
	private static final long serialVersionUID = -7199971221300636848L;
	private SourceDto source = new SourceDto();// ��ȡҳ���ύ����
	private boolean success;
	private String message;
	private Map<String, Object> sourceList;

	@Autowired
	@Qualifier("sourceService")
	private ISourceService sourceService;

	// �����Դ
	@Action(value = "addSource")
	public String add() {
		success = sourceService.add(source);
		if (success) {
			message = "�����Դ�ɹ���";
		} else {
			message = "�����Դʧ�ܣ�";
		}
		return SUCCESS;
	}

	// �޸���Դ
	@Action(value = "updateSource")
	public String update() {
		success = sourceService.update(source);
		if (success) {
			message = "�޸���Դ�ɹ���";
		} else {
			message = "�޸���Դʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * ������ԴID��ѯһ����Դ
	 * 
	 * @return
	 */
	@Action(value = "loadSource")
	public String load() {
		source = sourceService.load(source.getId());
		return SUCCESS;
	}

	/**
	 * ������Դidɾ��һ����Դ
	 * 
	 * @return
	 */

	@Action(value = "deleteSource")
	public String delete() {
		success = sourceService.delete(source.getId());
		if (success) {
			message = "ɾ����Դ�ɹ���";
		} else {
			message = "ɾ����Դʧ�ܣ�";
		}
		return SUCCESS;
	}

	// ��ȡ����������Դ����Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	@Action(value = "listSource")
	public String list() {
		sourceList = sourceService.listSource();
		return SUCCESS;
	}

	/* get set */
	public ISourceService getSourceService() {
		return sourceService;
	}

	public void setSourceService(ISourceService sourceService) {
		this.sourceService = sourceService;
	}

	public SourceDto getModel() {
		return source;
	}

	public SourceDto getSource() {
		return source;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getSourceList() {
		return sourceList;
	}
}
