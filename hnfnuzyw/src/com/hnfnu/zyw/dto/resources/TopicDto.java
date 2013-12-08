package com.hnfnu.zyw.dto.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 通过数据库内表的字段动态生成 TopicDto
**/
@Entity
@Table(name="r_topic")
public class TopicDto 
{	
	//id
	private Integer id;
	//专题名称
	private String name;
	//专题简介
	private String description;
	//专题作者
	private String author;
	//专题图片url
	private String imageUrl;
	//备注
	private String remark;

	public TopicDto()
	{

	}
	
	public TopicDto(Integer id, String name, String description, String author,
			String imageUrl, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.author = author;
		this.imageUrl = imageUrl;
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
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getRemark()
	{
		return this.remark;
	}

	@Override
	public String toString() {
		return "TopicDto [id=" + id + ", name=" + name + ", description="
				+ description + ", author=" + author + ", imageUrl=" + imageUrl
				+ ", remark=" + remark + "]";
	}
	
}
