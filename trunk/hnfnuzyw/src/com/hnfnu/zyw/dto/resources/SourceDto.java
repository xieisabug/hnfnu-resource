package com.hnfnu.zyw.dto.resources;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 通过数据库内表的字段动态生成 SourceDto
 **/
@Entity
@Table(name = "r_source")
public class SourceDto {
	// id

	private Integer id;

	// 资源名称

	private String name;

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

	private String author;

	// 出版社

	private String publisher;

	// 描述

	private String description;

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

	public SourceDto() {

	}

	public SourceDto(Integer id, String name, Integer courseId,
			String keyWords, String mediaType, String mediaFormat,
			String playTime, String fileSize, String author, String publisher,
			String description, Timestamp createDate, String approvalStatus,
			String quality, double price, Integer viewTimes, Integer useTimes,
			String url, Integer createUserId) {
		super();
		this.id = id;
		this.name = name;
		this.courseId = courseId;
		this.keyWords = keyWords;
		this.mediaType = mediaType;
		this.mediaFormat = mediaFormat;
		this.playTime = playTime;
		this.fileSize = fileSize;
		this.author = author;
		this.publisher = publisher;
		this.description = description;
		this.createDate = createDate;
		this.approvalStatus = approvalStatus;
		this.price = price;
		this.viewTimes = viewTimes;
		this.useTimes = useTimes;
		this.url = url;
		this.createUserId = createUserId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getCourseId() {
		return this.courseId;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getKeyWords() {
		return this.keyWords;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getMediaType() {
		return this.mediaType;
	}

	public void setMediaFormat(String mediaFormat) {
		this.mediaFormat = mediaFormat;
	}

	public String getMediaFormat() {
		return this.mediaFormat;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getPlayTime() {
		return this.playTime;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileSize() {
		return this.fileSize;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}

	public void setViewTimes(Integer viewTimes) {
		this.viewTimes = viewTimes;
	}

	public Integer getViewTimes() {
		return this.viewTimes;
	}

	public void setUseTimes(Integer useTimes) {
		this.useTimes = useTimes;
	}

	public Integer getUseTimes() {
		return this.useTimes;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getCreateUserId() {
		return this.createUserId;
	}

	@Override
	public String toString() {
		return "SourceDto [approvalStatus=" + approvalStatus + ", author="
				+ author + ", courseId=" + courseId + ", createDate="
				+ createDate + ", createUserId=" + createUserId
				+ ", description=" + description + ", fileSize=" + fileSize
				+ ", id=" + id + ", keyWords=" + keyWords + ", mediaFormat="
				+ mediaFormat + ", mediaType=" + mediaType + ", name=" + name
				+ ", playTime=" + playTime + ", price=" + price
				+ ", publisher=" + publisher 
				+ ", url=" + url + ", useTimes=" + useTimes + ", viewTimes="
				+ viewTimes + "]";
	}
}
