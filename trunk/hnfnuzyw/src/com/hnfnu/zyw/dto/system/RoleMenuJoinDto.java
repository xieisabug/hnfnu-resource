package com.hnfnu.zyw.dto.system;

/**
* 通过数据库内表的字段动态生成 RoleMenuJoinDto
**/
public class RoleMenuJoinDto 
{	
	private Integer id;
	private Integer roleId;
	private Integer menuId;
	private String functionIdList;

	public RoleMenuJoinDto()
	{

	}

	public void setId(Integer id)
	{
		this.id = id;
	}
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
}
