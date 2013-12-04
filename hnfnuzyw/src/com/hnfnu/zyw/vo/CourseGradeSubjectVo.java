package com.hnfnu.zyw.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_course_grade_subject")
public class CourseGradeSubjectVo {
	private int id;
	private String name;
	private int gradeId;
	private String gradeName;
	private int subjectId;
	private String subjectName;
	private String remark; 
	

	public CourseGradeSubjectVo() {
		super();
	}

	public CourseGradeSubjectVo(int id, String name, int gradeId,
			String gradeName, int subjectId, String subjectName) {
		super();
		this.id = id;
		this.name = name;
		this.gradeId = gradeId;
		this.gradeName = gradeName;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
