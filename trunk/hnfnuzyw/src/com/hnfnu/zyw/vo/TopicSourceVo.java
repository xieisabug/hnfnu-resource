package com.hnfnu.zyw.vo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "v_topic_source")
public class TopicSourceVo {
	// id
	private Integer id;
	
	private Integer sourceId;

	// 资源名称

	private String sourceName;

	// 属于的课程的id

	private Integer courseId;

	// 关键字列表，用"；"分隔

	private String keyWords;

	// 媒体类型，如：文本，ppt，视频等

	private String mediaType;

	// 媒体格式，如：jpg，mp4等

	private String mediaFormat;

	// 播放时间，只有视频拥有这个属性

	private String playTime;

	// 文件大小

	private String fileSize;

	// 作者

	private String sourceAuthor;

	// 出版社

	private String publisher;

	// 描述

	private String sourceDescription;

	// 创建时间

	private Timestamp createDate;

	// 审核状态

	private String approvalStatus;


	// 价格

	private double price;

	// 访问次数

	private Integer viewTimes;

	// 下载或者使用次数

	private Integer useTimes;

	private String url;

	private Integer createUserId;
	
	//id
	private Integer topicId;
	private Integer subtitleId;
	private String subtitle;
	private int isDisplay;
	
	
	//专题名称
	private String topicName;
	//专题简介
	private String topicDescription;
	//专题作者
	private String topicAuthor;
	//备注
	private String remark;
	
	
	
	public TopicSourceVo() {
		super();
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getSourceId() {
		return sourceId;
	}



	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}



	public String getSourceName() {
		return sourceName;
	}



	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}



	public Integer getCourseId() {
		return courseId;
	}



	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}



	public String getKeyWords() {
		return keyWords;
	}



	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}



	public String getMediaType() {
		return mediaType;
	}



	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}



	public String getMediaFormat() {
		return mediaFormat;
	}



	public void setMediaFormat(String mediaFormat) {
		this.mediaFormat = mediaFormat;
	}



	public String getPlayTime() {
		return playTime;
	}



	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}



	public String getFileSize() {
		return fileSize;
	}



	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}



	public String getSourceAuthor() {
		return sourceAuthor;
	}



	public void setSourceAuthor(String sourceAuthor) {
		this.sourceAuthor = sourceAuthor;
	}



	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public String getSourceDescription() {
		return sourceDescription;
	}



	public void setSourceDescription(String sourceDescription) {
		this.sourceDescription = sourceDescription;
	}



	public Timestamp getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}



	public String getApprovalStatus() {
		return approvalStatus;
	}



	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Integer getSubtitleId() {
		return subtitleId;
	}



	public void setSubtitleId(Integer subtitleId) {
		this.subtitleId = subtitleId;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public Integer getViewTimes() {
		return viewTimes;
	}



	public void setViewTimes(Integer viewTimes) {
		this.viewTimes = viewTimes;
	}



	public Integer getUseTimes() {
		return useTimes;
	}



	public void setUseTimes(Integer useTimes) {
		this.useTimes = useTimes;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public Integer getCreateUserId() {
		return createUserId;
	}



	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}



	public Integer getTopicId() {
		return topicId;
	}



	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}



	public String getTopicName() {
		return topicName;
	}



	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}



	public String getTopicDescription() {
		return topicDescription;
	}



	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}



	public String getTopicAuthor() {
		return topicAuthor;
	}



	public void setTopicAuthor(String topicAuthor) {
		this.topicAuthor = topicAuthor;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	}

	@Override
	public String toString() {
		return "TopicSourceVo [approvalStatus=" + approvalStatus
				+ ", courseId=" + courseId + ", createDate=" + createDate
				+ ", createUserId=" + createUserId + ", fileSize=" + fileSize
				+ ", id=" + id + ", keyWords=" + keyWords + ", mediaFormat="
				+ mediaFormat + ", mediaType=" + mediaType + ", playTime="
				+ playTime + ", price=" + price + ", publisher=" + publisher
				+ ", subtitleId=" + subtitleId + ", remark=" + remark
				+ ", sourceAuthor=" + sourceAuthor + ", sourceDescription="
				+ sourceDescription + ", sourceId=" + sourceId
				+ ", sourceName=" + sourceName + ", topicAuthor=" + topicAuthor
				+ ", topicDescription=" + topicDescription + ", topicId="
				+ topicId + ", topicName=" + topicName + ", url=" + url
				+ ", useTimes=" + useTimes + ", viewTimes=" + viewTimes + "]";
	}
	
	

}
