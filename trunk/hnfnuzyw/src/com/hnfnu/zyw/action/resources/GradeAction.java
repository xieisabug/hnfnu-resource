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
import com.hnfnu.zyw.dto.resources.GradeDto;
import com.hnfnu.zyw.service.resources.IGradeService;
import com.hnfnu.zyw.vo.GradeGroupVo;
import com.hnfnu.zyw.website.service.IIndexService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("gradeAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class GradeAction extends AopNoSuchMethodErrorSolveBaseAction implements ModelDriven<GradeDto> {

	private GradeDto grade = new GradeDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> gradeList;
	private List<GradeGroupVo> grades;
 
	@Autowired
	@Qualifier("gradeService")
	private IGradeService gradeService;
	
	@Autowired
	@Qualifier("ftl_indexService")
	private IIndexService indexService;

	// 添加年级
	@Action(value = "addGrade")
	public String add() {
		success = gradeService.add(grade);
		if (success) {
			message = "添加年级成功！";
		} else {
			message = "添加年级失败！";
		}
		return SUCCESS;
	}

	// 修改年级
	@Action(value = "updateGrade")
	public String update() {
		success = gradeService.update(grade);
		if (success) {
			indexService.makeTabGroups();
			message = "修改年级成功！";
		} else {
			message = "修改年级失败！";
		}
		return SUCCESS;
	}

	/**
	 * 根据年级ID查询一个年级
	 * 
	 * @return
	 */
	@Action(value = "loadGrade")
	public String load() {
		grade = gradeService.load(grade.getId());
		return SUCCESS;
	}

	/**
	 * 根据年级id删除一个年级
	 * 
	 * @return
	 */

	@Action(value = "deleteGrade")
	public String delete() {
		success = gradeService.delete(grade.getId());
		indexService.makeTabGroups();
		if (success) {
			message = "删除年级成功！";
		} else {
			message = "删除年级失败！";
		}
		return SUCCESS;
	}

	// 获取表中所有年级，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "listGrade")
	public String list() {
		gradeList = gradeService.listGrade();
		return SUCCESS;
	}
	

	// 根据分组Id获得该组下所有的年級
	@Action(value = "listGradesByGroupId")
	public String listGradesByGroupId() {
		grades= gradeService.listGradeByGroupId(grade.getGroupId());
		if(grades != null){
			success = true;
		}else {
			success = false;
		}
		if (success) {
			message = "获取成功";
		} else {
			message = "获取失败！";
		}
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

	public List<GradeGroupVo> getGrades() {
		return grades;
	}

}
