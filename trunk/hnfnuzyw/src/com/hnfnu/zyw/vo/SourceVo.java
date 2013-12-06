package com.hnfnu.zyw.vo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_source")
public class SourceVo {

	// id

	private Integer id;

	// 资源名称

	private String name;

	// 属于的课程的id

	private Integer courseId;
	private String courseName;
	private Integer gradeId;
	private String gradeName;
	private Integer subjectId;
	private String subjectName;

	// 属于的类别的id,一个资源有多个类别，以；隔开

	private String categoryIdList;
	
	private String categoryNameList;

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
	private String createUserName;

	public SourceVo() {
		super();
	}

	

	

	public SourceVo(Integer id, String name, Integer courseId,
			String courseName, Integer gradeId, String gradeName,
			Integer subjectId, String subjectName, String categoryIdList,
			String categoryNameList, String keyWords, String mediaType,
			String mediaFormat, String playTime, String fileSize,
			String author, String publisher, String description,
			Timestamp createDate, String approvalStatus, String quality,
			double price, Integer viewTimes, Integer useTimes, String url,
			Integer createUserId, String createUserName) {
		super();
		this.id = id;
		this.name = name;
		this.courseId = courseId;
		this.courseName = courseName;
		this.gradeId = gradeId;
		this.gradeName = gradeName;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.categoryIdList = categoryIdList;
		this.categoryNameList = categoryNameList;
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
		this.createUserName = createUserName;
	}

	public Integer getCourseId() {
		return courseId;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getCategoryIdList() {
		return categoryIdList;
	}

	public void setCategoryIdList(String categoryIdList) {
		this.categoryIdList = categoryIdList;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCategoryNameList() {
		return categoryNameList;
	}



	public void setCategoryNameList(String categoryNameList) {
		this.categoryNameList = categoryNameList;
	}

	@Override
	public String toString() {
		return "SourceVo [approvalStatus=" + approvalStatus + ", author="
				+ author + ", categoryIdList=" + categoryIdList
				+ ", categoryNameList=" + categoryNameList + ", courseId="
				+ courseId + ", courseName=" + courseName + ", createDate="
				+ createDate + ", createUserId=" + createUserId
				+ ", createUserName=" + createUserName + ", description="
				+ description + ", fileSize=" + fileSize + ", gradeId="
				+ gradeId + ", gradeName=" + gradeName + ", id=" + id
				+ ", keyWords=" + keyWords + ", mediaFormat=" + mediaFormat
				+ ", mediaType=" + mediaType + ", name=" + name + ", playTime="
				+ playTime + ", price=" + price + ", publisher=" + publisher
				+ ", subjectId=" + subjectId
				+ ", subjectName=" + subjectName + ", url=" + url
				+ ", useTimes=" + useTimes + ", viewTimes=" + viewTimes + "]";
	}

	
	
}
