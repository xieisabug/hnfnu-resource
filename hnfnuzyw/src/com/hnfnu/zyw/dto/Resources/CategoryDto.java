package com.hnfnu.zyw.dto.Resources;

/**
* ͨ�����ݿ��ڱ���ֶζ�̬���� CategoryDto
**/
public class CategoryDto 
{	
	//id
	private Integer id;
	//�������
	private String name;
	private String remark;

	public CategoryDto()
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
