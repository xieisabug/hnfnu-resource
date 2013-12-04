package com.hnfnu.zyw.dto.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* ͨ�����ݿ��ڱ���ֶζ�̬���� TopicDto
**/
@Entity
@Table(name="r_topic")
public class TopicDto 
{	
	//id
	private Integer id;
	//ר������
	private String name;
	//ר����
	private String description;
	//ר������
	private String author;
	//��ע
	private String remark;

	public TopicDto()
	{

	}
	public TopicDto(Integer id, String name, String description, String author,
			String remark) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.author = author;
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
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getAuthor()
	{
		return this.author;
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
		return "TopicDto [author=" + author + ", description=" + description
				+ ", id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}
}
