package com.hnfnu.zyw.website.vo;

import java.util.List;

import com.hnfnu.zyw.dto.resources.GradeDto;


public class Subject{
	//id
	private Integer id;
	//¿ÆÄ¿Ãû³Æ
	private String name;
	private String remark;
	
	private List<GradeDto> gradeList;

	public Subject() {
		super();
	}

	

	public Subject(Integer id, String name, String remark,
			List<GradeDto> gradeList) {
		super();
		this.id = id;
		this.name = name;
		this.remark = remark;
		this.gradeList = gradeList;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}



	public List<GradeDto> getGradeList() {
		return gradeList;
	}



	public void setGradeList(List<GradeDto> gradeList) {
		this.gradeList = gradeList;
	}

	
}
