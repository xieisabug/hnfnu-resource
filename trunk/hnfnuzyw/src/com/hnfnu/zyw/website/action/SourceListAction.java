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

import com.hnfnu.zyw.dao.base.Pager;
import com.hnfnu.zyw.vo.SourceVo;
import com.hnfnu.zyw.website.service.ISourceListService;
import com.hnfnu.zyw.website.utils.FreemarkerUtil;
import com.opensymphony.xwork2.ActionSupport;


@Controller("ftlSourceListAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/ftl")
public class SourceListAction extends ActionSupport{
	private static final long serialVersionUID = -6797136426456854163L;
	private boolean success;
	private String message;
	private int subjectId;
	private int gradeId;
	//��ǰ�ǵڼ�ҳ
	private int page;
	//��Դ����
	private String type;
	//�ؼ���
	private String keyWords;
	//���ظ������һҳ������
	private Pager<SourceVo> sourcePager;
	

	@Autowired
	@Qualifier("ftl_sourceListService")
	private ISourceListService sourceListService;

	
	private FreemarkerUtil fu =new FreemarkerUtil();
	private Map<String,Object> root = null;
	
	
	@Action(value = "makeListFtl")
	public String makeList() {
		// �������ģ��
		root = sourceListService.getDataModel(subjectId, gradeId, page,10);
		
		//��ӡ�����̨���Ա��ڲ���
		fu.print("list.ftl", root);
		//������ļ�
		fu.fprint("index.ftl", root, "sourceList_"+subjectId+"_"+gradeId+".html");
		return SUCCESS;
	}
	
	
	
	@Action(value = "pager")
	public String pager() {
		sourcePager = sourceListService.getPager(subjectId, gradeId, type, keyWords, page, 1);
		return SUCCESS;
	}
	
	
	
	//get set
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

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}



	public Pager<SourceVo> getSourcePager() {
		return sourcePager;
	}

	
	
	
}
