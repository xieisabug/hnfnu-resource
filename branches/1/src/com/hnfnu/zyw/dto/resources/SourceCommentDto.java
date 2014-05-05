package com.hnfnu.zyw.dto.resources;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 通过数据库内表的字段动态生成 SourceCommentDto
**/
@Entity
@Table(name="r_source_comment")
public class SourceCommentDto 
{	
	//id
	private Integer id;
	//所评价的资源的Id
	private Integer sourceId;
	//评价的父评价id，0则表示此条为最顶评论
	private Integer parentId;
	//评论的内容
	private String content;
	//评论的作者id，用于链接评论人员的信息
	private Integer createId;
	//创建日期
	private Date createDate;

	public SourceCommentDto()
	{

	}

	
	public SourceCommentDto(Integer id, Integer sourceId, Integer parentId,
			String content, Integer createId, Date createDate) {
		super();
		this.id = id;
		this.sourceId = sourceId;
		this.parentId = parentId;
		this.content = content;
		this.createId = createId;
		this.createDate = createDate;
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
	public void setSourceId(Integer sourceId)
	{
		this.sourceId = sourceId;
	}
	public Integer getSourceId()
	{
		return this.sourceId;
	}
	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}
	public Integer getParentId()
	{
		return this.parentId;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}
	public void setCreateId(Integer createId)
	{
		this.createId = createId;
	}
	public Integer getCreateId()
	{
		return this.createId;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	public Date getCreateDate()
	{
		return this.createDate;
	}
	@Override
	public String toString() {
		return "SourceCommentDto [id=" + id + ", sourceId=" + sourceId
				+ ", parentId=" + parentId + ", content=" + content
				+ ", createId=" + createId + ", createDate=" + createDate + "]";
	}
}
