package com.hnfnu.zyw.dto.system;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 通过数据库内表的字段动态生成 UserRoleJoinDto
**/
@Entity
@Table(name="s_user_role_join")
public class UserRoleJoinDto 
{	
	private Integer id;
	private Integer userId;
	private Integer roleId;

	public UserRoleJoinDto()
	{

	}

	
	public UserRoleJoinDto(Integer id, Integer userId, Integer roleId) {
		super();
		this.id = id;
		this.userId = userId;
		this.roleId = roleId;
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
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	public Integer getUserId()
	{
		return this.userId;
	}
	public void setRoleId(Integer roleId)
	{
		this.roleId = roleId;
	}
	public Integer getRoleId()
	{
		return this.roleId;
	}

	@Override
	public String toString() {
		return "UserRoleJoinDto [id=" + id + ", userId=" + userId + ", roleId="
				+ roleId + "]";
	}
	
}
