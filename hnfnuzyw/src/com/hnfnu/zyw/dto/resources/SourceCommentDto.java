package com.hnfnu.zyw.dto.resources;

import java.util.Date;

/**
* Í¨¹ýÊý¾Ý¿âÄÚ±íµÄ×Ö¶Î¶¯Ì¬Éú³É SourceCommentDto
**/
public class SourceCommentDto 
{	
	//id
	private Integer id;
	//ËùÆÀ¼ÛµÄ×ÊÔ´µÄId
	private Integer sourceId;
	//ÆÀ¼ÛµÄ¸¸ÆÀ¼Ûid£¬0Ôò±íÊ¾´ËÌõÎª×î¶¥ÆÀÂÛ
	private Integer parentId;
	//ÆÀÂÛµÄÄÚÈÝ
	private String content;
	//ÆÀÂÛµÄ×÷Õßid£¬ÓÃÓÚÁ´½ÓÆÀÂÛÈËÔ±µÄÐÅÏ¢
	private Integer authorId;
	//´´½¨ÈÕÆÚ
	private Date createDate;

	public SourceCommentDto()
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
	public void setAuthorId(Integer authorId)
	{
		this.authorId = authorId;
	}
	public Integer getAuthorId()
	{
		return this.authorId;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	public Date getCreateDate()
	{
		return this.createDate;
	}
}
