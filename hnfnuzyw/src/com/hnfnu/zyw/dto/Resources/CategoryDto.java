package com.hnfnu.zyw.dto.Resources;

/**
* 通过数据库内表的字段动态生成 CategoryDto
**/
public class CategoryDto 
{	
	//id
	private Integer id;
	//类别名称
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
