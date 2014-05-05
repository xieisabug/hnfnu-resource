package com.hnfnu.zyw.dto.system;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 通过数据库内表的字段动态生成 FunctionDto
**/

@Entity
@Table(name="s_function")
public class FunctionDto 
{	
	private Integer id;
	
	//功能的缩写字母，要大写
	private String name;
	
	//功能的中文名称
	private String remark;
	

	public FunctionDto()
	{

	}
	
	

	public FunctionDto(Integer id, String name, String remark) {
		super();
		this.id = id;
		this.name = name;
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
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}

	@Override
	public String toString() {
		return "FunctionDto [id=" + id + ", name=" + name + ", remark="
				+ remark + "]";
	}
	
	
	
}
