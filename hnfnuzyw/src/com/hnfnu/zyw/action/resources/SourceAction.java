package com.hnfnu.zyw.action.resources;

import java.util.Date;
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
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.service.resources.ISourceService;
import com.hnfnu.zyw.service.resources.ISourceVoService;
import com.hnfnu.zyw.vo.SourceVo;
import com.opensymphony.xwork2.ActionContext;
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
	private SourceVo sourceVo;// ��ȡҳ���ύ����
	private boolean success;
	private String message;
	private Map<String, Object> sourceVoList;
	private UserDto user;

	@Autowired
	@Qualifier("sourceService")
	private ISourceService sourceService;
	
	@Autowired
	@Qualifier("sourceVoService")
	private ISourceVoService sourceVoService;
	

	// �����Դ
	@Action(value = "addSource")
	public String add() {
		//��ȡ��ǰʱ��
		source.setCreateDate(new Date());
		//��ȡ��ǰ�û�
		 ActionContext context = ActionContext.getContext();  
		 Map session = context.getSession();
		 user = (UserDto) session.get("user");
		 source.setCreateUserId(user.getId());
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
	@Action(value = "loadSourceVo")
	public String load() {
		sourceVo = sourceVoService.load(source.getId());
		return SUCCESS;
	}

	/**
	 * ������Դidɾ��һ����Դ�ļ��Լ������ݿ��������Ϣ,
	 * 
	 * @return
	 */

	@Action(value = "deleteSourceMessege")
	public String deleteMessege() {
		success = sourceService.deleteMessege(source.getId());
		if (success) {
			message = "ɾ����Դ��Ϣ�ɹ���";
		} else {
			message = "ɾ����Դ��Ϣʧ�ܣ�";
		}
		return SUCCESS;
	}
	
	@Action(value = "deleteSource")
	public String delete() {
		int i = sourceService.delete(source.getUrl());
		if (i == 1) {
			success = true;
			message = "ɾ����Դ�ļ��ɹ���";
		} else if (i == -1){
			success = false;
			message = "ɾ����Դ�ļ�ʧ�ܣ���Ϊ���ļ������ڣ�";
		}else if(i == -1){
			success = false;
			message = "ɾ����Դ�ļ�ʧ��,��Ϊ�����ļ���";
		}
		return SUCCESS;
	}
	

	// ��ȡ����������Դ����Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	@Action(value = "listSourceVo")
	public String list() {
		sourceVoList = sourceVoService.listSourceVo();
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
		return sourceVoList;
	}

	public SourceVo getSourceVo() {
		return sourceVo;
	}

	public void setSourceVo(SourceVo sourceVo) {
		this.sourceVo = sourceVo;
	}
	
}
