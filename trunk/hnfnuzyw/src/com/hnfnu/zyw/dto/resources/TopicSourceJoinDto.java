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
	private Integer subtitleId;
	private Integer sourceId;

	public TopicSourceJoinDto()
	{

	}
	public TopicSourceJoinDto(Integer id, Integer subtitleId, Integer sourceId) {
		super();
		this.id = id;
		this.subtitleId = subtitleId;
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
	
	public Integer getSubtitleId() {
		return subtitleId;
	}
	public void setSubtitleId(Integer subtitleId) {
		this.subtitleId = subtitleId;
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
				+ ", subtitleId=" + subtitleId + "]";
	}
	
	
}
