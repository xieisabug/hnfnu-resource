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

import com.hnfnu.zyw.service.resources.ICourseGradeSubjectService;
import com.hnfnu.zyw.vo.CourseGradeSubjectVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("courseGradeSubjectAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class CourseGradeSubjectAction extends ActionSupport implements
		ModelDriven<CourseGradeSubjectVo> {
	private static final long serialVersionUID = -7199971221300636848L;
	private CourseGradeSubjectVo courseGradeSubject = new CourseGradeSubjectVo();// ��ȡҳ���ύ����
	private boolean success;
	private String message;
	private Map<String, Object> courseGradeSubjectList;

	@Autowired
	@Qualifier("courseGradeSubjectService")
	private ICourseGradeSubjectService courseGradeSubjectService;

	// ��ȡ�������пγ̣���Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	@Action(value = "listCourseGradeSubject")
	public String list() {
		courseGradeSubjectList = courseGradeSubjectService
				.listAllCourseGradeSubject();
		return SUCCESS;
	}

	public CourseGradeSubjectVo getModel() {
		return courseGradeSubject;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getCourseGradeSubjectList() {
		return courseGradeSubjectList;
	}

	public void setCourseGradeSubject(CourseGradeSubjectVo courseGradeSubject) {
		this.courseGradeSubject = courseGradeSubject;
	}

	public void setCourseGradeSubjectService(
			ICourseGradeSubjectService courseGradeSubjectService) {
		this.courseGradeSubjectService = courseGradeSubjectService;
	}
}