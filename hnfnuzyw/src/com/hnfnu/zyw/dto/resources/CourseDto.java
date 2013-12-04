package com.hnfnu.zyw.dto.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Í¨¹ýÊý¾Ý¿âÄÚ±íµÄ×Ö¶Î¶¯Ì¬Éú³É CourseDto
**/
@Entity
@Table(name="r_course")
public class CourseDto 
{	
	//id
	private Integer id;
	//¿Î³ÌÃû³Æ
	private String name;
	//¿Î³ÌËùÔÚÄê¼¶µÄid
	private Integer gradeId;
	//¿Î³ÌËùÔÚ¿ÆÄ¿µÄid
	private Integer subjectId;
	private String remark;

	public CourseDto()
	{

	}

	public CourseDto(Integer id, String name, Integer gradeId,
			Integer subjectId, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.gradeId = gradeId;
		this.subjectId = subjectId;
		this.remark = remark;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
	@Id
	@GeneratedValue
	public Integer getId()
	{
		return this.id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setGradeId(Integer gradeId)
	{
		this.gradeId = gradeId;
	}
	public Integer getGradeId()
	{
		return this.gradeId;
	}
	public void setSubjectId(Integer subjectId)
	{
		this.subjectId = subjectId;
	}
	public Integer getSubjectId()
	{
		return this.subjectId;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}
}
