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

import com.hnfnu.zyw.dto.system.StudentDto;
import com.hnfnu.zyw.service.system.IStudentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Controller("studentAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/system")
public class StundetAction extends ActionSupport implements
ModelDriven<StudentDto>{
	private static final long serialVersionUID = -7199971221300636848L;
	private StudentDto student = new StudentDto();// ��ȡҳ���ύ����
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
	 * ������ѧ����ֵ��Դ��
	 * @return
	 */
	@Action(value = "addStudentBalanceCount")
	public String addStudentBalanceCount() {
		success = studentService.addStudnetBalance(balanceCount, studentIds);
		if (success) {
			message = "��ѧ���ǳ�ֵ�ɹ���";
		} else {
			message = "��ѧ���ǳ�ֵʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * ����ע��ѧ��
	 * @return
	 */
	@Action(value = "addManyStudent")
	public String addManyStudent() {
		System.out.println("fileUrl"+url);
		success = studentService.addStudnets(url);
		if (success) {
			message = "��ѧ����ע��ɹ���";
		} else {
			message = "��ѧ����ע��ʧ�ܣ�";
		}
		return SUCCESS;
	}
	
	
	/**
	 * ���ѧ��
	 * @return
	 */
	@Action(value = "addStudent")
	public String add() {
		//�½��û�Ĭ����Դ��Ϊ100
		student.setBalance(100);
		success = studentService.add(student);
		if (success) {
			message = "���ѧ���ɹ���";
		} else {
			message = "���ѧ��ʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * �޸�ѧ��
	 * @return
	 */
	@Action(value = "updateStudent")
	public String update() {
		success = studentService.update(student);
		if (success) {
			message = "�޸�ѧ���ɹ���";
		} else {
			message = "�޸�ѧ��ʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * ����ѧ��ID��ѯһ��ѧ��
	 * @return
	 */
	@Action(value = "loadStudent")
	public String load() {
		student = studentService.load(student);
		return SUCCESS;
	}

	/**
	 * ����ѧ��idɾ��һ��ѧ��
	 * @return
	 */

	@Action(value = "deleteStudent")
	public String delete() {
		success = studentService.delete(student);
		if (success) {
			message = "ɾ��ѧ���ɹ���";
		} else {
			message = "ɾ��ѧ��ʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 *  ��ȡ��������ѧ��
	 *  ��Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * @return
	 */
	@Action(value = "listStudent")
	public String list() {
		studentList = studentService.listStu();
		return SUCCESS;
	}

	
	/* get set */
	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

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
