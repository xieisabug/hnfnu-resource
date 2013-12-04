package com.hnfnu.zyw.dto.system;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Í¨¹ýÊý¾Ý¿âÄÚ±íµÄ×Ö¶Î¶¯Ì¬Éú³É RoleMenuJoinDto
**/
@Entity
@Table(name="s_role_menu_join")
public class RoleMenuJoinDto 
{	
	private Integer id;
	private Integer roleId;
	private Integer menuId;
	private String functionIdList;

	public RoleMenuJoinDto()
	{

	}
	
	

	public RoleMenuJoinDto(Integer id, Integer roleId, Integer menuId,
			String functionIdList) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.menuId = menuId;
		this.functionIdList = functionIdList;
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
	public void setRoleId(Integer roleId)
	{
		this.roleId = roleId;
	}
	public Integer getRoleId()
	{
		return this.roleId;
	}
	public void setMenuId(Integer menuId)
	{
		this.menuId = menuId;
	}
	public Integer getMenuId()
	{
		return this.menuId;
	}
	public void setFunctionIdList(String functionIdList)
	{
		this.functionIdList = functionIdList;
	}
	public String getFunctionIdList()
	{
		return this.functionIdList;
	}



	@Override
	public String toString() {
		return "RoleMenuJoinDto [functionIdList=" + functionIdList + ", id="
				+ id + ", menuId=" + menuId + ", roleId=" + roleId + "]";
	}
	
	
}
