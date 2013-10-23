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

import com.hnfnu.zyw.dto.resources.CourseDto;
import com.hnfnu.zyw.dto.resources.GradeDto;
import com.hnfnu.zyw.dto.resources.SubjectDto;
import com.hnfnu.zyw.service.resources.ICourseService;
import com.hnfnu.zyw.service.resources.IGradeService;
import com.hnfnu.zyw.service.resources.ISubjectService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("courseAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class CourseAction extends ActionSupport implements
		ModelDriven<CourseDto> {

	private static final long serialVersionUID = -7199971221300636848L;
	private CourseDto course = new CourseDto();// 获取页面提交参数
	private List<GradeDto> gradeList;
	private List<SubjectDto> subjectList;
	private boolean success;
	private String message;
	private Map<String, Object> courseList;

	@Autowired
	@Qualifier("courseService")
	private ICourseService courseService;

	@Autowired
	@Qualifier("gradeService")
	private IGradeService gradeService;

	@Autowired
	@Qualifier("subjectService")
	private ISubjectService subjectService;

	// 添加课程
	@Action(value = "addCourse")
	public String add() {
		success = courseService.add(course);
		if (success) {
			message = "添加课程成功！";
		} else {
			message = "添加课程失败！";
		}
		return SUCCESS;
	}

	// 修改课程
	@Action(value = "updateCourse")
	public String update() {
		success = courseService.update(course);
		if (success) {
			message = "修改课程成功！";
		} else {
			message = "修改课程失败！";
		}
		return SUCCESS;
	}

	/**
	 * 根据课程ID查询一个课程
	 * 
	 * @return
	 */
	@Action(value = "loadCourse")
	public String load() {
		course = courseService.load(course.getId());
		return SUCCESS;
	}

	/**
	 * 根据课程id删除一个课程
	 * 
	 * @return
	 */

	@Action(value = "deleteCourse")
	public String delete() {
		success = courseService.delete(course.getId());
		if (success) {
			message = "删除课程成功，资源界面请刷新或者重新打开资源界面！";
		} else {
			message = "删除课程失败！";
		}
		return SUCCESS;
	}

	// 获取表中所有课程，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "listCourse")
	public String list() {
		courseList = courseService.listCourse();
		return SUCCESS;
	}
	
	@Action(value = "listGradesAndSubjects")
	public String listGradesAndSubjects() {
		gradeList = gradeService.list();
		subjectList = subjectService.list(); 
		return SUCCESS;
	}

	/* get set */
	
	
	public ICourseService getCourseService() {
		return courseService;
	}

	public List<GradeDto> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<GradeDto> gradeList) {
		this.gradeList = gradeList;
	}

	public List<SubjectDto> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<SubjectDto> subjectList) {
		this.subjectList = subjectList;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}
	

	public IGradeService getGradeService() {
		return gradeService;
	}

	public void setGradeService(IGradeService gradeService) {
		this.gradeService = gradeService;
	}

	public ISubjectService getSubjectService() {
		return subjectService;
	}

	public void setSubjectService(ISubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public CourseDto getModel() {
		return course;
	}

	public CourseDto getCourse() {
		return course;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getCourseList() {
		return courseList;
	}

}
