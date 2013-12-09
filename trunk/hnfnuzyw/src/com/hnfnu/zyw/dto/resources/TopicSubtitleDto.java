package com.hnfnu.zyw.dto.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="r_topic_subtitle")
public class TopicSubtitleDto 
{	
	private Integer id;
	//专题id
	private Integer topicId;
	//二级标题
	private String subtitle;
	//是否为系统自动添加，0否1是
	private Integer isAuto;
	//备注
	private String remark;

	public TopicSubtitleDto()
	{
	}
	
	

	public TopicSubtitleDto(Integer id, Integer topicId, String subtitle,
			Integer isAuto, String remark) {
		super();
		this.id = id;
		this.topicId = topicId;
		this.subtitle = subtitle;
		this.isAuto = isAuto;
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
	public void setTopicId(Integer topicId)
	{
		this.topicId = topicId;
	}
	public Integer getTopicId()
	{
		return this.topicId;
	}
	public void setSubtitle(String subtitle)
	{
		this.subtitle = subtitle;
	}
	public String getSubtitle()
	{
		return this.subtitle;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}
	public Integer getIsAuto() {
		return isAuto;
	}
	public void setIsAuto(Integer isAuto) {
		this.isAuto = isAuto;
	}



	@Override
	public String toString() {
		return "TopicSubtitleDto [id=" + id + ", topicId=" + topicId
				+ ", subtitle=" + subtitle + ", isAuto=" + isAuto + ", remark="
				+ remark + "]";
	}


	
	
}
