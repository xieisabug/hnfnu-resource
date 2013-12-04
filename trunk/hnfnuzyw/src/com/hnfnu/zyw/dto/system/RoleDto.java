package com.hnfnu.zyw.dto.system;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 通过数据库内表的字段动态生成 RoleDto
**/
@Entity
@Table(name="s_role")
public class RoleDto 
{	
	private Integer id;
	//角色名
	private String name;
	//创建用户id
	private Integer createUserId;
	
	private String createUserName;
	//备注
	private String remark;

	public RoleDto()
	{

	}

	public RoleDto(Integer id, String name, Integer createUserId,
			String createUserName, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
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
	public void setCreateUserId(Integer createUserId)
	{
		this.createUserId = createUserId;
	}
	public Integer getCreateUserId()
	{
		return this.createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
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
		return "RoleDto [id=" + id + ", name=" + name + ", createUserId="
				+ createUserId + ", createUserName="
				+ createUserName + ", remark=" + remark + "]";
	}

}
