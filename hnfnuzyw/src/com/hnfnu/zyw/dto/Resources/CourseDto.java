package com.hnfnu.zyw.dto.Resources;

/**
* 通过数据库内表的字段动态生成 CourseDto
**/
public class CourseDto 
{	
	//id
	private Integer id;
	//课程名称
	private String name;
	//课程所在年级的id
	private Integer gradeId;
	//课程所在科目的id
	private Integer subjectId;
	private String remark;

	public CourseDto()
	{

	}

	public void setId(Integer id)
	{
		this.id = id;
	}
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
