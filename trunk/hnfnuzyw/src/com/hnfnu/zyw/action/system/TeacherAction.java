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
	private TeacherDto teacher = new TeacherDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> teacherList;

	@Autowired
	@Qualifier("teacherService")
	private ITeacherService teacherService;

	/**
	 * 添加教师
	 * @return
	 */
	@Action(value = "addTeacher")
	public String add() {
		success = teacherService.add(teacher);
		if (success) {
			message = "添加教师成功！";
		} else {
			message = "添加教师失败！";
		}
		return SUCCESS;
	}

	/**
	 * 修改教师
	 * @return
	 */
	@Action(value = "updateTeacher")
	public String update() {
		success = teacherService.update(teacher);
		if (success) {
			message = "修改教师成功！";
		} else {
			message = "修改教师失败！";
		}
		return SUCCESS;
	}

	/**
	 * 根据教师ID查询一个教师
	 * @return
	 */
	@Action(value = "loadTeacher")
	public String load() {
		teacher = teacherService.load(teacher);
		return SUCCESS;
	}

	/**
	 * 根据教师id删除一个教师
	 * @return
	 */

	@Action(value = "deleteTeacher")
	public String delete() {
		success = teacherService.delete(teacher);
		if (success) {
			message = "删除教师成功！";
		} else {
			message = "删除教师失败！";
		}
		return SUCCESS;
	}

	/**
	 *  获取表中所有教师
	 *  用Map装，为了分页的需要加上Rows和Total
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
