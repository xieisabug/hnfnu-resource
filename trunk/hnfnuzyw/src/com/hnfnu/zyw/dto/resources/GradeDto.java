package com.hnfnu.zyw.dto.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Í¨¹ýÊý¾Ý¿âÄÚ±íµÄ×Ö¶Î¶¯Ì¬Éú³É GradeDto
**/
@Entity
@Table(name="r_grade")
public class GradeDto 
{	
	//id
	private Integer id;
	//Äê¼¶Ãû³Æ
	private String name;
	private String remark;

	public GradeDto()
	{

	}

	public GradeDto(Integer id, String name, String remark) {
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
}
