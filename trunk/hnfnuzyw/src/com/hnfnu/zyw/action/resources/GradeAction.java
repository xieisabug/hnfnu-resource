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
import com.hnfnu.zyw.dto.resources.GradeDto;
import com.hnfnu.zyw.service.resources.IGradeService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("gradeAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class GradeAction extends AopNoSuchMethodErrorSolveBaseAction implements ModelDriven<GradeDto> {

	private GradeDto grade = new GradeDto();// »ñÈ¡Ò³ÃæÌá½»²ÎÊý
	private boolean success;
	private String message;
	private Map<String, Object> gradeList;

	@Autowired
	@Qualifier("gradeService")
	private IGradeService gradeService;

	// Ìí¼ÓÄê¼¶
	@Action(value = "addGrade")
	public String add() {
		success = gradeService.add(grade);
		if (success) {
			message = "Ìí¼ÓÄê¼¶³É¹¦£¡";
		} else {
			message = "Ìí¼ÓÄê¼¶Ê§°Ü£¡";
		}
		return SUCCESS;
	}

	// ÐÞ¸ÄÄê¼¶
	@Action(value = "updateGrade")
	public String update() {
		success = gradeService.update(grade);
		if (success) {
			message = "ÐÞ¸ÄÄê¼¶³É¹¦£¡";
		} else {
			message = "ÐÞ¸ÄÄê¼¶Ê§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ¸ù¾ÝÄê¼¶ID²éÑ¯Ò»¸öÄê¼¶
	 * 
	 * @return
	 */
	@Action(value = "loadGrade")
	public String load() {
		grade = gradeService.load(grade.getId());
		return SUCCESS;
	}

	/**
	 * ¸ù¾ÝÄê¼¶idÉ¾³ýÒ»¸öÄê¼¶
	 * 
	 * @return
	 */

	@Action(value = "deleteGrade")
	public String delete() {
		success = gradeService.delete(grade.getId());
		if (success) {
			message = "É¾³ýÄê¼¶³É¹¦£¡";
		} else {
			message = "É¾³ýÄê¼¶Ê§°Ü£¡";
		}
		return SUCCESS;
	}

	// »ñÈ¡±íÖÐËùÓÐÄê¼¶£¬ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
	@Action(value = "listGrade")
	public String list() {
		gradeList = gradeService.listGrade();
		return SUCCESS;
	}

	/* get set */
	public GradeDto getModel() {
		return grade;
	}

	public GradeDto getGrade() {
		return grade;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getGradeList() {
		return gradeList;
	}

}
