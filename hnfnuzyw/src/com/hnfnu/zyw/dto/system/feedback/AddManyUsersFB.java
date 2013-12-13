package com.hnfnu.zyw.dto.system.feedback;

import com.hnfnu.zyw.dto.system.UserDto;


public class AddManyUsersFB {
	// 姓名
	private String name;
	// 身份证
	private String idcard;
	// 性别
	private String sex;
	// QQ
	private String qq;
	// 电话
	private String telephone;
	//邮箱
	private String email;
	// 部门
	private String department;
	//错误信息
	private String message;
	
	public AddManyUsersFB() {
		super();
	}
	
	public AddManyUsersFB(UserDto user,String message) {
		this.name = user.getName();
		this.idcard = user.getIdcard();
		this.sex = user.getSex();
		this.qq = user.getQq();
		this.telephone = user.getTelephone();
		this.email = user.getEmail();
		this.department = user.getDepartment();
		this.message = message;
	}

	public AddManyUsersFB(String name, String idcard, String sex, String qq,
			String telephone, String email, String department, String message) {
		super();
		this.name = name;
		this.idcard = idcard;
		this.sex = sex;
		this.qq = qq;
		this.telephone = telephone;
		this.email = email;
		this.department = department;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AddManyUsersFB [name=" + name + ", idcard=" + idcard + ", sex="
				+ sex + ", qq=" + qq + ", telephone=" + telephone + ", email="
				+ email + ", department=" + department + ", message=" + message
				+ "]";
	}

	
}

