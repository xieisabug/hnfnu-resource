package com.hnfnu.zyw.dto.Resources;

/**
* ͨ�����ݿ��ڱ���ֶζ�̬���� GradeDto
**/
public class GradeDto 
{	
	//id
	private Integer id;
	//�꼶����
	private String name;
	private String remark;

	public GradeDto()
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
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}
}
