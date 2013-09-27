package com.hnfnu.zyw.website.action;

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

import com.hnfnu.zyw.website.service.IIndexService;
import com.hnfnu.zyw.website.utils.FreemarkerUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("ftlIndexAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/ftl")
public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = 8211651083165988085L;
	private boolean success;
	private String message;
	@Autowired
	@Qualifier("ftl_indexService")
	private IIndexService indexService;
	
	
	private FreemarkerUtil fu =new FreemarkerUtil();
	private Map<String,Object> root = null;
	
	
	
	
	@Action(value = "makeIndex")
	public String makeIndex() {
		String filePath = null;
		
		filePath = ServletActionContext.getServletContext().getRealPath("/");
		// �������ģ��
		root = indexService.getDataModel();
		
		//��ӡ�����̨���Ա��ڲ���
		//fu.print("index.ftl", root);
		//������ļ�
		success = fu.fprint("index.ftl", root, filePath+"website\\", "index.html");
		if(success){
			message="��ҳ���ɳɹ�";
		}else{
			message="��ҳ����ʧ��";
		}
		return SUCCESS;
	}
	public boolean isSuccess() {
		return success;
	}
	public String getMessage() {
		return message;
	}
}
