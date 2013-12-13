package com.hnfnu.zyw.dto.system.feedback;

import com.hnfnu.zyw.dto.system.StudentDto;



public class AddManyStudentsFB {
	private String name;
	//年纪
	private String number;
	//系部
	private String department;
	//专业
	private String major;
	//入学年份
	private String entranceTime;
	private String telephone;
	//错误信息
	private String message;
	
	public AddManyStudentsFB() {
		super();
	}
	
	public AddManyStudentsFB(StudentDto student,String message) {
		this.name = student.getName();
		this.number = student.getNumber();
		this.department = student.getDepartment();
		this.major = student.getMajor();
		this.entranceTime = student.getEntranceTime();
		this.telephone = student.getTelephone();
		this.message = message;
	}

	public AddManyStudentsFB(String name, String number, String department,
			String major, String entranceTime, String telephone, String message) {
		super();
		this.name = name;
		this.number = number;
		this.department = department;
		this.major = major;
		this.entranceTime = entranceTime;
		this.telephone = telephone;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEntranceTime() {
		return entranceTime;
	}

	public void setEntranceTime(String entranceTime) {
		this.entranceTime = entranceTime;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AddManyStudentsFB [name=" + name + ", number=" + number
				+ ", department=" + department + ", major=" + major
				+ ", entranceTime=" + entranceTime + ", telephone=" + telephone
				+ ", message=" + message + "]";
	}
}

