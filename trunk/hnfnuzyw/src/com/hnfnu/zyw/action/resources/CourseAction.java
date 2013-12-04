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
import com.hnfnu.zyw.dto.resources.GradeDto;
import com.hnfnu.zyw.dto.resources.SubjectDto;
import com.hnfnu.zyw.service.resources.ICourseService;
import com.hnfnu.zyw.service.resources.IGradeService;
import com.hnfnu.zyw.service.resources.ISubjectService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("courseAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class CourseAction extends AopNoSuchMethodErrorSolveBaseAction implements
		ModelDriven<CourseDto> {

	private CourseDto course = new CourseDto();// »ñÈ¡Ò³ÃæÌá½»²ÎÊý
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

	// Ìí¼Ó¿Î³Ì
	@Action(value = "addCourse")
	public String add() {
		success = courseService.add(course);
		if (success) {
			message = "Ìí¼Ó¿Î³Ì³É¹¦£¬Çëµ½×ÊÔ´½çÃæÎª¸Ã¿Î³ÌÌí¼Ó×ÊÔ´£¡";
		} else {
			message = "Ìí¼Ó¿Î³ÌÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	// ÐÞ¸Ä¿Î³Ì
	@Action(value = "updateCourse")
	public String update() {
		success = courseService.update(course);
		if (success) {
			message = "ÐÞ¸Ä¿Î³Ì³É¹¦£¡";
		} else {
			message = "ÐÞ¸Ä¿Î³ÌÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ¸ù¾Ý¿Î³ÌID²éÑ¯Ò»¸ö¿Î³Ì
	 * 
	 * @return
	 */
	@Action(value = "loadCourse")
	public String load() {
		course = courseService.load(course.getId());
		return SUCCESS;
	}

	/**
	 * ¸ù¾Ý¿Î³ÌidÉ¾³ýÒ»¸ö¿Î³Ì
	 * 
	 * @return
	 */

	@Action(value = "deleteCourse")
	public String delete() {
		success = courseService.delete(course.getId());
		if (success) {
			message = "É¾³ý¿Î³Ì³É¹¦£¬×ÊÔ´½çÃæÇëË¢ÐÂ»òÕßÖØÐÂ´ò¿ª×ÊÔ´½çÃæ£¡";
		} else {
			message = "É¾³ý¿Î³ÌÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	// »ñÈ¡±íÖÐËùÓÐ¿Î³Ì£¬ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
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
