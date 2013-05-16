package com.hnfnu.zyw.dto.system;

/**
* 通过数据库内表的字段动态生成 FunctionDto
**/
public class FunctionDto 
{	
	private Integer id;
	//功能的名字
	private String name;
	//备注
	private String remark;

	public FunctionDto()
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
