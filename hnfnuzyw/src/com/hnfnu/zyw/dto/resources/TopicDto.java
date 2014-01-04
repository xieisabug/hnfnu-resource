package com.hnfnu.zyw.dto.resources;

import java.sql.Timestamp;

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
	//是否显示
	private int isDisplay;
	//专题简介
	private String description;
	
	private int createUserId;
	private String keyWords;
	private Timestamp lastUpdateDate;
	private int viewTimes;
	private Timestamp createDate;
	//专题图片url
	private String imageUrl;
	//外部链接地址
	private  String outlink;
	//是否为外部链接，0否1是
	private String isOutlink;
	//样式模板id
	private int templateId;
 	
	//备注
	private String remark;

	public TopicDto()
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
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getDescription()
	{
		return this.description;
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
	public String getOutlink() {
		return outlink;
	}
	public void setOutlink(String outlink) {
		this.outlink = outlink;
	}
	public String getIsOutlink() {
		return isOutlink;
	}
	public void setIsOutlink(String isOutlink) {
		this.isOutlink = isOutlink;
	}
	public int getTemplateId() {
		return templateId;
	}
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	public int getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	}

	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}


	public int getViewTimes() {
		return viewTimes;
	}

	public void setViewTimes(int viewTimes) {
		this.viewTimes = viewTimes;
	}

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "TopicDto [id=" + id + ", name=" + name + ", isDisplay="
				+ isDisplay + ", description=" + description
				+ ", createUserId=" + createUserId + ", keyWords=" + keyWords
				+ ", lastUpdateDate=" + lastUpdateDate + ", viewTimes="
				+ viewTimes + ", createDate=" + createDate + ", imageUrl="
				+ imageUrl + ", outlink=" + outlink + ", isOutlink="
				+ isOutlink + ", templateId=" + templateId + ", remark="
				+ remark + "]";
	}
}
