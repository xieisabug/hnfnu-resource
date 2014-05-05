package com.hnfnu.zyw.dto.system;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 通过数据库内表的字段动态生成 ParameterDto
**/
@Entity
@Table(name="s_parameter")
public class ParameterDto 
{	
	private Integer id;
	//参数的名称
	private String name;
	//参数的值
	private String value;
	//参数的类型
	private String type;
	//参数备注
	private String remark;

	public ParameterDto()
	{

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
	@Override
	public String toString() {
		return "ParameterDto [id=" + id + ", name=" + name + ", value=" + value
				+ ", type=" + type + ", remark=" + remark + "]";
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setValue(String value)
	{
		this.value = value;
	}
	public String getValue()
	{
		return this.value;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getType()
	{
		return this.type;
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
