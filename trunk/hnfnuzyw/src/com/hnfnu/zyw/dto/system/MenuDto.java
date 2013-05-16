package com.hnfnu.zyw.dto.system;

/**
* 通过数据库内表的字段动态生成 MenuDto
**/
public class MenuDto 
{	
	private Integer id;
	//父菜单的id，如果是-1，则表示当前为最高级菜单
	private Integer parentId;
	//菜单的名字
	private String name;
	//菜单点击后调用的链接
	private String url;
	//菜单所拥有的功能的id列表，用‘，’分割
	private String functionIdList;
	//菜单的图标
	private String icon;

	public MenuDto()
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
	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}
	public Integer getParentId()
	{
		return this.parentId;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getUrl()
	{
		return this.url;
	}
	public void setFunctionIdList(String functionIdList)
	{
		this.functionIdList = functionIdList;
	}
	public String getFunctionIdList()
	{
		return this.functionIdList;
	}
	public void setIcon(String icon)
	{
		this.icon = icon;
	}
	public String getIcon()
	{
		return this.icon;
	}
}
