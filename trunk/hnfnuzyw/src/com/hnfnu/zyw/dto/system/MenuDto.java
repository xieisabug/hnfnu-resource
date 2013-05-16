package com.hnfnu.zyw.dto.system;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* ͨ�����ݿ��ڱ���ֶζ�̬���� MenuDto
**/

@Entity
@Table(name="s_menu")
public class MenuDto 
{	
	private Integer id;
	//���˵���id�������-1�����ʾ��ǰΪ��߼��˵�
	private Integer parentId;
	//�˵�������
	private String name;
	//�˵��������õ�����
	private String url;
	//�˵���ӵ�еĹ��ܵ�id�б��á������ָ�
	private String functionIdList;
	//�˵���ͼ��
	private String icon;

	public MenuDto()
	{

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
}
