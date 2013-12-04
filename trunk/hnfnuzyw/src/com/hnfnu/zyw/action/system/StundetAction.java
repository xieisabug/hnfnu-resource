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
	private StudentDto student = new StudentDto();// »ñÈ¡Ò³ÃæÌá½»²ÎÊý
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
	 * ÅúÁ¿¸øÑ§Éú³äÖµ×ÊÔ´±Ò
	 * @return
	 */
	@Action(value = "addStudentBalanceCount")
	public String addStudentBalanceCount() {
		int i = studentService.addStudnetBalance(balanceCount, studentIds);
		if (i == 1) {
			success = true;
			message = "¸øÑ§ÉúÃÇ³äÖµ³É¹¦£¡";
		} else {
			success=false;
			if(i==0){
				message = "¸øÑ§ÉúÃÇ³äÖµÊ§°Ü£¡";	
			}
			if(i == -1){
				message = "¸øÑ§ÉúÃÇ³äÖµÊ§°Ü,ÒòÎªÔÚÄúÑ¡ÔñµÄÑ§Éúµ±ÖÐÓÐÑ§ÉúµÄ×ÊÔ´±ÒÉÙÓÚÄúÒª¼õÈ¥µÄ×ÊÔ´±Ò£¡";
			}
			if( i == -2){
				message = "¸øÑ§ÉúÃÇ³äÖµÊ§°Ü,ÒòÎªÃ¿Î»Ñ§ÉúµÄ×ÜÓà¶îÊý²»ÄÜ³¬¹ý1000000000£¡";
			}
			
		}
		return SUCCESS;
	}

	/**
	 * ÅúÁ¿×¢²áÑ§Éú
	 * @return
	 */
	@Action(value = "addManyStudent")
	public String addManyStudent() {
		success = studentService.addStudnets(url);
		if (success) {
			message = "¸øÑ§ÉúÃÇ×¢²á³É¹¦£¡";
		} else {
			message = "¸øÑ§ÉúÃÇ×¢²áÊ§°Ü£¡";
		}
		return SUCCESS;
	}
	
	
	/**
	 * Ìí¼ÓÑ§Éú
	 * @return
	 */
	@Action(value = "addStudent")
	public String add() {
		success = studentService.add(student);
		if (success) {
			message = "Ìí¼ÓÑ§Éú³É¹¦£¡";
		} else {
			message = "Ìí¼ÓÑ§ÉúÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ÐÞ¸ÄÑ§Éú
	 * @return
	 */
	@Action(value = "updateStudent")
	public String update() {
		success = studentService.update(student);
		if (success) {
			message = "ÐÞ¸ÄÑ§Éú³É¹¦£¡";
		} else {
			message = "ÐÞ¸ÄÑ§ÉúÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ¸ù¾ÝÑ§ÉúID²éÑ¯Ò»¸öÑ§Éú
	 * @return
	 */
	@Action(value = "loadStudent")
	public String load() {
		student = studentService.load(student);
		return SUCCESS;
	}

	/**
	 * ¸ù¾ÝÑ§ÉúidÉ¾³ýÒ»¸öÑ§Éú
	 * @return
	 */

	@Action(value = "deleteStudent")
	public String delete() {
		success = studentService.delete(student);
		if (success) {
			message = "É¾³ýÑ§Éú³É¹¦£¡";
		} else {
			message = "É¾³ýÑ§ÉúÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 *  »ñÈ¡±íÖÐËùÓÐÑ§Éú
	 *  ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
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
			message = "¸ÃÑ§ÉúÓÃ»§ÃûÒÑ±»Ê¹ÓÃ";
		} else {
			message = "»¹Ñ§ÉúÓÃ»§Ãû¿ÉÒÔÊ¹ÓÃ";
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
