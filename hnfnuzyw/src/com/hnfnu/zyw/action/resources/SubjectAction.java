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

	private SubjectDto subject = new SubjectDto();// »ñÈ¡Ò³ÃæÌá½»²ÎÊý
	private boolean success;
	private String message;
	private Map<String, Object> subjectList;

	@Autowired
	@Qualifier("subjectService")
	private ISubjectService subjectService;

	// Ìí¼ÓÑ§¿Æ
	@Action(value = "addSubject")
	public String add() {
		success = subjectService.add(subject);
		if (success) {
			message = "Ìí¼Ó¹¦ÄÜ³É¹¦£¡";
		} else {
			message = "Ìí¼Ó¹¦ÄÜÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	// ÐÞ¸ÄÑ§¿Æ
	@Action(value = "updateSubject")
	public String update() {
		success = subjectService.update(subject);
		if (success) {
			message = "ÐÞ¸Ä¹¦ÄÜ³É¹¦£¡";
		} else {
			message = "ÐÞ¸Ä¹¦ÄÜÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ¸ù¾ÝÑ§¿ÆID²éÑ¯Ò»¸öÑ§¿Æ
	 * 
	 * @return
	 */
	@Action(value = "loadSubject")
	public String load() {
		subject = subjectService.load(subject.getId());
		return SUCCESS;
	}

	/**
	 * ¸ù¾ÝÑ§¿ÆidÉ¾³ýÒ»¸öÑ§¿Æ
	 * 
	 * @return
	 */

	@Action(value = "deleteSubject")
	public String delete() {
		success = subjectService.delete(subject.getId());
		if (success) {
			message = "É¾³ý¹¦ÄÜ³É¹¦£¡";
		} else {
			message = "É¾³ý¹¦ÄÜÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	// »ñÈ¡±íÖÐËùÓÐ¹¦ÄÜ£¬ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
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
