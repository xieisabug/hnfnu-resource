package com.hnfnu.zyw.vo;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "v_topic_subtitle_source")
public class TopicSubtiltleSourceVo {
	// id
	private Integer id;

	// 资源名称

	private String sourceName;

	// 属于的课程的id

	//private Integer courseId;

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
	private String subtitleName;
	
	
	//专题名称
	private String topicName;
	private int isDisplay;
	//专题简介
	private String topicDescription;
	private int topicCreateUserId;
	private String topicKeyWords;
	private Date lastUpdateDate;
	private int topicViewTimes;
	private Date topicCreateDate;
	//备注
	private String remark;
	public TopicSubtiltleSourceVo() {
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



	



	public String getSourceName() {
		return sourceName;
	}



	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
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


	public int getTopicCreateUserId() {
		return topicCreateUserId;
	}

	public void setTopicCreateUserId(int topicCreateUserId) {
		this.topicCreateUserId = topicCreateUserId;
	}

	public String getTopicKeyWords() {
		return topicKeyWords;
	}

	public void setTopicKeyWords(String topicKeyWords) {
		this.topicKeyWords = topicKeyWords;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public int getTopicViewTimes() {
		return topicViewTimes;
	}

	public void setTopicViewTimes(int topicViewTimes) {
		this.topicViewTimes = topicViewTimes;
	}

	public Date getTopicCreateDate() {
		return topicCreateDate;
	}

	public void setTopicCreateDate(Date topicCreateDate) {
		this.topicCreateDate = topicCreateDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getSubtitleName() {
		return subtitleName;
	}





	public void setSubtitleName(String subtitleName) {
		this.subtitleName = subtitleName;
	}





	public int getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	}

}
