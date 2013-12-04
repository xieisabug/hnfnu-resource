package com.hnfnu.zyw.dto.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Í¨¹ýÊý¾Ý¿âÄÚ±íµÄ×Ö¶Î¶¯Ì¬Éú³É CategoryDto
**/
@Entity
@Table(name="r_category")
public class CategoryDto 
{	
	//id
	private Integer id;
	//Àà±ðÃû³Æ
	private String name;
	private int ord;
	private String remark;

	public CategoryDto()
	{

	}
	public CategoryDto(Integer id, String name, int ord, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.ord = ord;
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

	public int getOrd() {
		return ord;
	}

	public void setOrd(int ord) {
		this.ord = ord;
	}

	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", name=" + name + ", remark="
				+ remark + "]";
	}
	
}
