package com.hnfnu.zyw.dto.system;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* ͨ�����ݿ��ڱ���ֶζ�̬���� RoleDto
**/
@Entity
@Table(name="s_role")
public class RoleDto 
{	
	private Integer id;
	//��ɫ��
	private String name;
	//�����û�id
	private Integer createUserId;
	//��ע
	private String remark;

	public RoleDto()
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
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}

}
