package com.hnfnu.zyw.dto.Resources;

/**
* ͨ�����ݿ��ڱ���ֶζ�̬���� CourseDto
**/
public class CourseDto 
{	
	//id
	private Integer id;
	//�γ�����
	private String name;
	//�γ������꼶��id
	private Integer gradeId;
	//�γ����ڿ�Ŀ��id
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
