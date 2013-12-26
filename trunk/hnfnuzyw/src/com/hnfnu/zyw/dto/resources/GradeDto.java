package com.hnfnu.zyw.dto.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 通过数据库内表的字段动态生成 GradeDto
**/
@Entity
@Table(name="r_grade")
public class GradeDto 
{	
	//id
	private Integer id;
	//年级名称
	private String name;
	private int groupId;
	private String remark;

	public GradeDto()
	{

	}
	public GradeDto(Integer id, String name, int groupId, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.groupId = groupId;
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
	@Override
	public String toString() {
		return "GradeDto [id=" + id + ", name=" + name + ", groupId=" + groupId
				+ ", remark=" + remark + "]";
	}
	
}
