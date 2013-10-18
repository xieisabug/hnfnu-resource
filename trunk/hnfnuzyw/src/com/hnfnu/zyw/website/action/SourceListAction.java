package com.hnfnu.zyw.website.action;

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

import com.hnfnu.zyw.dao.base.Pager;
import com.hnfnu.zyw.dto.resources.GradeDto;
import com.hnfnu.zyw.dto.resources.SubjectDto;
import com.hnfnu.zyw.service.resources.IGradeService;
import com.hnfnu.zyw.service.resources.ISubjectService;
import com.hnfnu.zyw.vo.SourceVo;
import com.hnfnu.zyw.website.service.ISourceListService;
import com.hnfnu.zyw.website.utils.FreemarkerUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("ftlSourceListAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/ftl")
public class SourceListAction extends ActionSupport {
	private static final long serialVersionUID = -6797136426456854163L;
	private boolean success;
	private String message;
	private int subjectId;
	private int gradeId;
	// ��ǰ�ǵڼ�ҳ
	private int page;
	// ��Դ����
	private String type;
	// �ؼ���
	private String keyWords;
	// ���ظ������һҳ������
	private Pager<SourceVo> sourcePager;

	@Autowired
	@Qualifier("ftl_sourceListService")
	private ISourceListService sourceListService;

	@Autowired
	@Qualifier("subjectService")
	private ISubjectService subjectService;

	@Autowired
	@Qualifier("gradeService")
	private IGradeService gradeService;

	private FreemarkerUtil fu = new FreemarkerUtil();
	private Map<String, Object> root = null;

	@Action(value = "makeListFtl")
	public String makeList() {
		String filePath = null;

		filePath = ServletActionContext.getServletContext().getRealPath("/");

		// �������ģ��
		root = sourceListService.getDataModel(subjectId, gradeId, 1, 10);
		// ��ӡ�����̨���Ա��ڲ���
		//fu.print("list.ftl", root);
		// ������ļ�
		success = fu.fprint("list.ftl", root, filePath+"website//","sourceList_" + subjectId + "_" + gradeId
				+ ".html");
		if(success){
			message = "�б�ҳ�����ɳɹ�";
		}else{
			message = "�б�ҳ������ʧ��";
		}
		return SUCCESS;
	}

	@Action(value = "makeAllListFtl")
	public String makeAllList() {
		String filePath = null;
		filePath = ServletActionContext.getServletContext().getRealPath("/");
		List<SubjectDto> subjects = subjectService.list();
		List<GradeDto> grades = gradeService.list();
		
		int i = 0;
		for (i = 0; i < subjects.size(); i++) {
			SubjectDto subject = subjects.get(i);
			for (int j = 0; j < grades.size(); j++) {
				GradeDto grade = grades.get(j);
				// �������ģ��
				root = sourceListService.getDataModel(subject.getId(),
						grade.getId(), 1, 10);
				// ��ӡ�����̨���Ա��ڲ���
				//fu.print("list.ftl", root);
				// ������ļ�
				success = fu.fprint("list.ftl", root,filePath+"website//","sourceList_" + subject.getId()
						+ "_" + grade.getId() + ".html");
				if(success == false)break;
			}
		}
		if(i < subjects.size()){
			success = false;
			message = "�б�ҳ������ʧ��";
			
		}else{
			success = true;
			message = "�����б�ҳ�����ɳɹ�";
		}
		
		
		return SUCCESS;
	}

	@Action(value = "pager")
	public String pager() {
		sourcePager = sourceListService.getPager(subjectId, gradeId, type,
				keyWords, page, 10);
		return SUCCESS;
	}

	// get set
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

	public void setSubjectService(ISubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public void setGradeService(IGradeService gradeService) {
		this.gradeService = gradeService;
	}

}
