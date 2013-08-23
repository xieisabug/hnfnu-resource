package com.hnfnu.zyw.website.action;

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

import com.hnfnu.zyw.dao.base.SystemContext;
import com.hnfnu.zyw.website.service.ISourceListService;
import com.hnfnu.zyw.website.utils.FreemarkerUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Controller("ftlSourceListAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/ftl")
public class SourceListAction extends ActionSupport implements
ModelDriven<SystemContext>{

	private SystemContext systemContext = new SystemContext();// ��ȡҳ���ύ����
	private boolean success;
	private String message;
	private int subjectId;
	private int gradeId;
	

	@Autowired
	@Qualifier("ftl_sourceListService")
	private ISourceListService sourceListService;

	
	private FreemarkerUtil fu =new FreemarkerUtil();
	private Map<String,Object> root = null;
	
	
	@Action(value = "makeList")
	public String makeList() {
		// �������ģ��
		root = sourceListService.getDataModel(subjectId, gradeId, systemContext);
		
		//��ӡ�����̨���Ա��ڲ���
		fu.print("list.ftl", root);
		//������ļ�
		fu.fprint("index.ftl", root, "sourceList_"+subjectId+"_"+gradeId+".html");
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	//get set
	public SystemContext getModel() {
		return systemContext;
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


	public void setMessage(String message) {
		this.message = message;
	}


	public ISourceListService getSourceListService() {
		return sourceListService;
	}


	public void setSourceListService(ISourceListService sourceListService) {
		this.sourceListService = sourceListService;
	}


	public void setSystemContext(SystemContext systemContext) {
		this.systemContext = systemContext;
	}
	
	
}
