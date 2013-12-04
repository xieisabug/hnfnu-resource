﻿package com.hnfnu.zyw.action.system;

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
import com.hnfnu.zyw.dto.system.StudentDto;
import com.hnfnu.zyw.service.system.IStudentService;
import com.opensymphony.xwork2.ModelDriven;


@Controller("studentAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/system")
public class StundetAction extends AopNoSuchMethodErrorSolveBaseAction implements
ModelDriven<StudentDto>{
	private StudentDto student = new StudentDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> studentList;
	private String studentIds; 
	private int balanceCount;
	private String url;
	@Autowired
	@Qualifier("studentService")
	private IStudentService studentService;

	

	/**
	 * 批量给学生充值资源币
	 * @return
	 */
	@Action(value = "addStudentBalanceCount")
	public String addStudentBalanceCount() {
		int i = studentService.addStudnetBalance(balanceCount, studentIds);
		if (i == 1) {
			success = true;
			message = "给学生们充值成功！";
		} else {
			success=false;
			if(i==0){
				message = "给学生们充值失败！";	
			}
			if(i == -1){
				message = "给学生们充值失败,因为在您选择的学生当中有学生的资源币少于您要减去的资源币！";
			}
			if( i == -2){
				message = "给学生们充值失败,因为每位学生的总余额数不能超过1000000000！";
			}
			
		}
		return SUCCESS;
	}

	/**
	 * 批量注册学生
	 * @return
	 */
	@Action(value = "addManyStudent")
	public String addManyStudent() {
		success = studentService.addStudnets(url);
		if (success) {
			message = "给学生们注册成功！";
		} else {
			message = "给学生们注册失败！";
		}
		return SUCCESS;
	}
	
	
	/**
	 * 添加学生
	 * @return
	 */
	@Action(value = "addStudent")
	public String add() {
		success = studentService.add(student);
		if (success) {
			message = "添加学生成功！";
		} else {
			message = "添加学生失败！";
		}
		return SUCCESS;
	}

	/**
	 * 修改学生
	 * @return
	 */
	@Action(value = "updateStudent")
	public String update() {
		success = studentService.update(student);
		if (success) {
			message = "修改学生成功！";
		} else {
			message = "修改学生失败！";
		}
		return SUCCESS;
	}

	/**
	 * 根据学生ID查询一个学生
	 * @return
	 */
	@Action(value = "loadStudent")
	public String load() {
		student = studentService.load(student);
		return SUCCESS;
	}

	/**
	 * 根据学生id删除一个学生
	 * @return
	 */

	@Action(value = "deleteStudent")
	public String delete() {
		success = studentService.delete(student);
		if (success) {
			message = "删除学生成功！";
		} else {
			message = "删除学生失败！";
		}
		return SUCCESS;
	}

	/**
	 *  获取表中所有学生
	 *  用Map装，为了分页的需要加上Rows和Total
	 * @return
	 */
	@Action(value = "listStudent")
	public String list() {
		studentList = studentService.listStu();
		return SUCCESS;
	}

	@Action(value = "validateStudentUsername")
	public String validateStudent() {
		success = studentService.validateStudent(student.getUsername());
		if (success) {
			message = "该学生用户名已被使用";
		} else {
			message = "还学生用户名可以使用";
		}
		return SUCCESS;
	}
	
	/* get set */

	public StudentDto getModel() {
		return student;
	}

	public StudentDto getStudent() {
		return student;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getStudentList() {
		return studentList;
	}
	
	public void setBalanceCount(int balanceCount) {
		this.balanceCount = balanceCount;
	}


	public void setStudentIds(String studentIds) {
		this.studentIds = studentIds;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	
	
	
}
