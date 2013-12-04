package com.hnfnu.zyw.dto.system;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Í¨¹ýÊý¾Ý¿âÄÚ±íµÄ×Ö¶Î¶¯Ì¬Éú³É ParameterDto
**/
@Entity
@Table(name="s_parameter")
public class ParameterDto 
{	
	private Integer id;
	//²ÎÊýµÄÃû³Æ
	private String name;
	//²ÎÊýµÄÖµ
	private String value;
	//²ÎÊýµÄÀàÐÍ
	private String type;
	//²ÎÊý±¸×¢
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
