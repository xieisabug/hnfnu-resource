package com.hnfnu.zyw.dto.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Í¨¹ýÊý¾Ý¿âÄÚ±íµÄ×Ö¶Î¶¯Ì¬Éú³É TopicSourceJoinDto
**/
@Entity
@Table(name="r_topic_source_join")
public class TopicSourceJoinDto 
{	
	private Integer id;
	private Integer topicId;
	private Integer sourceId;

	public TopicSourceJoinDto()
	{

	}
	public TopicSourceJoinDto(Integer id, Integer topicId, Integer sourceId) {
		super();
		this.id = id;
		this.topicId = topicId;
		this.sourceId = sourceId;
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
	public void setTopicId(Integer topicId)
	{
		this.topicId = topicId;
	}
	public Integer getTopicId()
	{
		return this.topicId;
	}
	public void setsourceId(Integer sourceId)
	{
		this.sourceId = sourceId;
	}
	public Integer getsourceId()
	{
		return this.sourceId;
	}
	@Override
	public String toString() {
		return "TopicSourceJoinDto [id=" + id + ", sourceId=" + sourceId
				+ ", topicId=" + topicId + "]";
	}
	
	
}
