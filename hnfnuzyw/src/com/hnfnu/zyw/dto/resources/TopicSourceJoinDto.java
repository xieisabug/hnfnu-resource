package com.hnfnu.zyw.dto.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 通过数据库内表的字段动态生成 TopicSourceJoinDto
**/
@Entity
@Table(name="r_topic_source_join")
public class TopicSourceJoinDto 
{	
	private Integer id;
	private Integer topicId;
	private Integer sourceID;

	public TopicSourceJoinDto()
	{

	}
	public TopicSourceJoinDto(Integer id, Integer topicId, Integer sourceID) {
		super();
		this.id = id;
		this.topicId = topicId;
		this.sourceID = sourceID;
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
	public void setSourceID(Integer sourceID)
	{
		this.sourceID = sourceID;
	}
	public Integer getSourceID()
	{
		return this.sourceID;
	}
	@Override
	public String toString() {
		return "TopicSourceJoinDto [id=" + id + ", sourceID=" + sourceID
				+ ", topicId=" + topicId + "]";
	}
	
	
}
