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

import com.hnfnu.zyw.action.base.AopNoSuchMethodErrorSolveBaseAction;
import com.hnfnu.zyw.dto.resources.SubjectDto;
import com.hnfnu.zyw.service.resources.ISubjectService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("subjectAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class SubjectAction extends AopNoSuchMethodErrorSolveBaseAction implements
		ModelDriven<SubjectDto> {

	private SubjectDto subject = new SubjectDto();// ��ȡҳ���ύ����
	private boolean success;
	private String message;
	private Map<String, Object> subjectList;

	@Autowired
	@Qualifier("subjectService")
	private ISubjectService subjectService;

	// ���ѧ��
	@Action(value = "addSubject")
	public String add() {
		success = subjectService.add(subject);
		if (success) {
			message = "��ӹ��ܳɹ���";
		} else {
			message = "��ӹ���ʧ�ܣ�";
		}
		return SUCCESS;
	}

	// �޸�ѧ��
	@Action(value = "updateSubject")
	public String update() {
		success = subjectService.update(subject);
		if (success) {
			message = "�޸Ĺ��ܳɹ���";
		} else {
			message = "�޸Ĺ���ʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * ����ѧ��ID��ѯһ��ѧ��
	 * 
	 * @return
	 */
	@Action(value = "loadSubject")
	public String load() {
		subject = subjectService.load(subject.getId());
		return SUCCESS;
	}

	/**
	 * ����ѧ��idɾ��һ��ѧ��
	 * 
	 * @return
	 */

	@Action(value = "deleteSubject")
	public String delete() {
		success = subjectService.delete(subject.getId());
		if (success) {
			message = "ɾ�����ܳɹ���";
		} else {
			message = "ɾ������ʧ�ܣ�";
		}
		return SUCCESS;
	}

	// ��ȡ�������й��ܣ���Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	@Action(value = "listSubject")
	public String list() {
		subjectList = subjectService.listSub();
		return SUCCESS;
	}

	/* get set */

	public SubjectDto getModel() {
		return subject;
	}

	public SubjectDto getSubject() {
		return subject;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getSubjectList() {
		return subjectList;
	}

}
