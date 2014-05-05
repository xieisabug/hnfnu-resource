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
import com.hnfnu.zyw.dto.resources.CourseDto;
import com.hnfnu.zyw.service.resources.ICourseService;
import com.hnfnu.zyw.service.resources.IGradeService;
import com.hnfnu.zyw.service.resources.ISubjectService;
import com.hnfnu.zyw.vo.GradeGroupVo;
import com.hnfnu.zyw.vo.SubjectGroupVo;
import com.hnfnu.zyw.website.service.IIndexService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("courseAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class CourseAction extends AopNoSuchMethodErrorSolveBaseAction implements
		ModelDriven<CourseDto> {

	private CourseDto course = new CourseDto();// 获取页面提交参数
	private List<GradeGroupVo> gradeList;
	private List<SubjectGroupVo> subjectList;
	private boolean success;
	private String message;
	private Map<String, Object> courseList;
	private int groupId;

	@Autowired
	@Qualifier("courseService")
	private ICourseService courseService;

	@Autowired
	@Qualifier("gradeService")
	private IGradeService gradeService;

	@Autowired
	@Qualifier("subjectService")
	private ISubjectService subjectService;
	
	@Autowired
	@Qualifier("ftl_indexService")
	private IIndexService indexService;

	// 添加课程
	@Action(value = "addCourse")
	public String add() {
		success = courseService.add(course);
		if (success) {
			message = "添加课程成功，请到资源界面为该课程添加资源！";
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
			indexService.makeTabGroups();
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
		gradeList = gradeService.listGradeByGroupId(groupId);
		subjectList = subjectService.listSubjectByGroupId(groupId);
		return SUCCESS;
	}

	/* get set */
	public CourseDto getModel() {
		return course;
	}

	public List<GradeGroupVo> getGradeList() {
		return gradeList;
	}

	public List<SubjectGroupVo> getSubjectList() {
		return subjectList;
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

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

}
