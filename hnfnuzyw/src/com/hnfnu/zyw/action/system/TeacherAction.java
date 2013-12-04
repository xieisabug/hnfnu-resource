package com.hnfnu.zyw.action.system;

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
import com.hnfnu.zyw.dto.system.TeacherDto;
import com.hnfnu.zyw.service.system.ITeacherService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("teacherAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/system")
public class TeacherAction  extends AopNoSuchMethodErrorSolveBaseAction implements
ModelDriven<TeacherDto>{
	private TeacherDto teacher = new TeacherDto();// »ñÈ¡Ò³ÃæÌá½»²ÎÊý
	private boolean success;
	private String message;
	private Map<String, Object> teacherList;

	@Autowired
	@Qualifier("teacherService")
	private ITeacherService teacherService;

	/**
	 * Ìí¼Ó½ÌÊ¦
	 * @return
	 */
	@Action(value = "addTeacher")
	public String add() {
		success = teacherService.add(teacher);
		if (success) {
			message = "Ìí¼Ó½ÌÊ¦³É¹¦£¡";
		} else {
			message = "Ìí¼Ó½ÌÊ¦Ê§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ÐÞ¸Ä½ÌÊ¦
	 * @return
	 */
	@Action(value = "updateTeacher")
	public String update() {
		success = teacherService.update(teacher);
		if (success) {
			message = "ÐÞ¸Ä½ÌÊ¦³É¹¦£¡";
		} else {
			message = "ÐÞ¸Ä½ÌÊ¦Ê§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ¸ù¾Ý½ÌÊ¦ID²éÑ¯Ò»¸ö½ÌÊ¦
	 * @return
	 */
	@Action(value = "loadTeacher")
	public String load() {
		teacher = teacherService.load(teacher);
		return SUCCESS;
	}

	/**
	 * ¸ù¾Ý½ÌÊ¦idÉ¾³ýÒ»¸ö½ÌÊ¦
	 * @return
	 */

	@Action(value = "deleteTeacher")
	public String delete() {
		success = teacherService.delete(teacher);
		if (success) {
			message = "É¾³ý½ÌÊ¦³É¹¦£¡";
		} else {
			message = "É¾³ý½ÌÊ¦Ê§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 *  »ñÈ¡±íÖÐËùÓÐ½ÌÊ¦
	 *  ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
	 * @return
	 */
	@Action(value = "listTeacher")
	public String list() {
		teacherList = teacherService.listTeach();
		return SUCCESS;
	}

	
	/* get set */

	public TeacherDto getModel() {
		return teacher;
	}

	public TeacherDto getTeacher() {
		return teacher;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getTeacherList() {
		return teacherList;
	}

}
