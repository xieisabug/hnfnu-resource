package com.hnfnu.zyw.dto.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 通过数据库内表的字段动态生成 CategoryDto
**/
@Entity
@Table(name="r_category")
public class CategoryDto 
{	
	//id
	private Integer id;
	//类别名称
	private String name;
	private int groupId;
	private int ord;
	private String remark;

	public CategoryDto()
	{

	}
	public CategoryDto(Integer id, String name,int groupId, int ord, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.groupId = groupId;
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
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
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
		return "CategoryDto [id=" + id + ", name=" + name + ", groupId="
				+ groupId + ", ord=" + ord + ", remark=" + remark + "]";
	}

}
