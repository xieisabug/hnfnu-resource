package com.hnfnu.zyw.action.resources;

import java.util.List;
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
import com.hnfnu.zyw.vo.SubjectGroupVo;
import com.hnfnu.zyw.website.service.IIndexService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("subjectAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/resources")
public class SubjectAction extends AopNoSuchMethodErrorSolveBaseAction
		implements ModelDriven<SubjectDto> {

	private SubjectDto subject = new SubjectDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> subjectList;
	private List<SubjectGroupVo> subjects;

	@Autowired
	@Qualifier("subjectService")
	private ISubjectService subjectService;
	
	@Autowired
	@Qualifier("ftl_indexService")
	private IIndexService indexService;

	// 添加学科
	@Action(value = "addSubject")
	public String add() {
		String[] s = subject.getImageUrl().split("\\\\");
		subject.setImageUrl(s[s.length-1]);
		success = subjectService.add(subject);
		if (success) {
			message = "添加功能成功！";
		} else {
			message = "添加功能失败！";
		}
		return SUCCESS;
	}


	// 改变图片
	@Action(value = "changeSubjectImage")
	public String changeSubjectImage() {
		String[] s = subject.getImageUrl().split("\\\\");
		subject.setImageUrl(s[s.length-1]);
		success = subjectService.update(subject);
		if (success) {
			message = "图片修改成功！";
		} else {
			message = "图片修改失败！";
		}
		return SUCCESS;
	}
	// 修改学科
	@Action(value = "updateSubject")
	public String update() {
		success = subjectService.update(subject);
		indexService.makeTabGroups();
		if (success) {
			message = "修改功能成功！";
		} else {
			message = "修改功能失败！";
		}
		return SUCCESS;
	}

	/**
	 * 根据学科ID查询一个学科
	 * 
	 * @return
	 */
	@Action(value = "loadSubject")
	public String load() {
		subject = subjectService.load(subject.getId());
		return SUCCESS;
	}

	/**
	 * 根据学科id删除一个学科
	 * 
	 * @return
	 */

	@Action(value = "deleteSubject")
	public String delete() {
		//System.out.println("subject.getImageUrl()"+subject.getImageUrl());
		success = subjectService.delete(subject.getImageUrl(),subject.getId());
		indexService.makeTabGroups();
		if (success) {
			message = "删除功能成功！";
		} else {
			message = "删除功能失败！";
		}
		return SUCCESS;
	}

	// 获取表中所有功能，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "listSubject")
	public String list() {
		subjectList = subjectService.listSub();
		return SUCCESS;
	}

	// 根据分组Id获得该组下所有的类别
	@Action(value = "listSubjectsByGroupId")
	public String listSubjectsByGroupId() {
		subjects = subjectService.listSubjectByGroupId(subject.getGroupId());
		if (subjects != null) {
			success = true;
		} else {
			success = false;
		}
		if (success) {
			message = "获取成功";
		} else {
			message = "获取失败！";
		}
		return SUCCESS;
	}
	@Action(value = "clearSubjectImage")
	public String clearImage() {
		success = subjectService.clearImage();
		if (success) {
			message = "冗余图片清除成功！";
		} else {
			message = "冗余图片清除失败！";
		}
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

	public List<SubjectGroupVo> getSubjects() {
		return subjects;
	}

}
