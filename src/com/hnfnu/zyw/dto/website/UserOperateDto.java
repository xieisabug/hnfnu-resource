package com.hnfnu.zyw.dto.website;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="l_user_operate")
public class UserOperateDto 
{	
	//主键
	private Integer id;
	//用户id
	private Integer userId;
	//操作的菜单id
	private Integer menuId;

	public UserOperateDto()
	{
	}
	

	public UserOperateDto(Integer userId, Integer menuId) {
		super();
		this.userId = userId;
		this.menuId = menuId;
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


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getMenuId() {
		return menuId;
	}


	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}


	@Override
	public String toString() {
		return "UserOperateDto [id=" + id + ", userId=" + userId + ", menuId="
				+ menuId + "]";
	}
	
}
