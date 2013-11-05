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

import com.hnfnu.zyw.dto.system.TeacherDto;
import com.hnfnu.zyw.service.system.ITeacherService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("teacherAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/system")
public class TeacherAction  extends ActionSupport implements
ModelDriven<TeacherDto>{
	private static final long serialVersionUID = -7199971221300636848L;
	private TeacherDto teacher = new TeacherDto();// ��ȡҳ���ύ����
	private boolean success;
	private String message;
	private Map<String, Object> teacherList;

	@Autowired
	@Qualifier("teacherService")
	private ITeacherService teacherService;

	/**
	 * ��ӽ�ʦ
	 * @return
	 */
	@Action(value = "addTeacher")
	public String add() {
		success = teacherService.add(teacher);
		if (success) {
			message = "��ӽ�ʦ�ɹ���";
		} else {
			message = "��ӽ�ʦʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * �޸Ľ�ʦ
	 * @return
	 */
	@Action(value = "updateTeacher")
	public String update() {
		success = teacherService.update(teacher);
		if (success) {
			message = "�޸Ľ�ʦ�ɹ���";
		} else {
			message = "�޸Ľ�ʦʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * ���ݽ�ʦID��ѯһ����ʦ
	 * @return
	 */
	@Action(value = "loadTeacher")
	public String load() {
		teacher = teacherService.load(teacher);
		return SUCCESS;
	}

	/**
	 * ���ݽ�ʦidɾ��һ����ʦ
	 * @return
	 */

	@Action(value = "deleteTeacher")
	public String delete() {
		success = teacherService.delete(teacher);
		if (success) {
			message = "ɾ����ʦ�ɹ���";
		} else {
			message = "ɾ����ʦʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 *  ��ȡ�������н�ʦ
	 *  ��Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * @return
	 */
	@Action(value = "listTeacher")
	public String list() {
		teacherList = teacherService.listTeach();
		return SUCCESS;
	}

	
	/* get set */
	public ITeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(ITeacherService teacherService) {
		this.teacherService = teacherService;
	}

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
