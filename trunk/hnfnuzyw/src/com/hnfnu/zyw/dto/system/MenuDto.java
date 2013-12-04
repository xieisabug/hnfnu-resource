package com.hnfnu.zyw.dto.system;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Í¨¹ýÊý¾Ý¿âÄÚ±íµÄ×Ö¶Î¶¯Ì¬Éú³É MenuDto
**/

@Entity
@Table(name="s_menu")
public class MenuDto 
{	
	private Integer id;
	//¸¸²Ëµ¥µÄid£¬Èç¹ûÊÇ-1£¬Ôò±íÊ¾µ±Ç°Îª×î¸ß¼¶²Ëµ¥
	private Integer parentId;
	
	//²Ëµ¥µÄÃû×Ö
	private String name;
	//²Ëµ¥µã»÷ºóµ÷ÓÃµÄÁ´½Ó
	private String url;
	//²Ëµ¥ËùÓµÓÐµÄ¹¦ÄÜµÄidÁÐ±í£¬ÓÃ¡®£¬¡¯·Ö¸î
	private String functionIdList;
	//²Ëµ¥µÄÍ¼±ê
	private String icon;

	public MenuDto()
	{

	}

	public MenuDto(Integer id, Integer parentId, String parentName,
			String name, String url, String functionIdList, String icon) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.url = url;
		this.functionIdList = functionIdList;
		this.icon = icon;
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

	@Override
	public String toString() {
		return "MenuDto [id=" + id + ", parentId=" + parentId + ", name="
				+ name + ", url=" + url + ", functionIdList=" + functionIdList
				+ ", icon=" + icon + "]";
	}

}
