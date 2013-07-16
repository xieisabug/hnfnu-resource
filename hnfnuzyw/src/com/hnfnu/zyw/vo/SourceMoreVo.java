package com.hnfnu.zyw.vo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_source_more")
public class SourceMoreVo {

	// id

	private Integer sourceId;

	// ��Դ����

	private String sourceName;

	// ���ڵĿγ̵�id

	private Integer courseId;
	private String courseName;
	private Integer gradeId;
	private String gradeName;
	private Integer subjectId;
	private String subjectName;

	// ���ڵ�����id,һ����Դ�ж������ԣ�����

	private String categoryId;
	
	private String categoryName;

	// �ؼ����б���"��"�ָ�

	private String keyWords;

	// ý�����ͣ��磺�ı���ppt����Ƶ��

	private String mediaType;

	// ý���ʽ���磺jpg��mp4��

	private String mediaFormat;

	// ����ʱ�䣬ֻ����Ƶӵ���������

	private String playTime;

	// �ļ���С

	private String fileSize;

	// ����

	private String author;

	// ������

	private String publisher;

	// ����

	private String description;

	// ����ʱ��

	private Timestamp createDate;

	// ���״̬

	private String approvalStatus;

	// �����ȼ�

	private String quality;

	// �۸�

	private double price;

	// ���ʴ���

	private Integer viewTimes;

	// ���ػ���ʹ�ô���

	private Integer useTimes;

	private String url;

	private Integer createUserId;
	private String createUserName;

	public SourceMoreVo() {
		super();
	}

	public SourceMoreVo(Integer sourceId, String sourceName, Integer courseId,
			String courseName, Integer gradeId, String gradeName,
			Integer subjectId, String subjectName, String categoryId,
			String categoryName, String keyWords, String mediaType,
			String mediaFormat, String playTime, String fileSize,
			String author, String publisher, String description,
			Timestamp createDate, String approvalStatus, String quality,
			double price, Integer viewTimes, Integer useTimes, String url,
			Integer createUserId, String createUserName) {
		super();
		this.sourceId = sourceId;
		this.sourceName = sourceName;
		this.courseId = courseId;
		this.courseName = courseName;
		this.gradeId = gradeId;
		this.gradeName = gradeName;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
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
		this.quality = quality;
		this.price = price;
		this.viewTimes = viewTimes;
		this.useTimes = useTimes;
		this.url = url;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
	}
	@Id
	@GeneratedValue
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

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
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

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "SourceMoreVo [approvalStatus=" + approvalStatus + ", author="
				+ author + ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", courseId=" + courseId + ", courseName="
				+ courseName + ", createDate=" + createDate + ", createUserId="
				+ createUserId + ", createUserName=" + createUserName
				+ ", description=" + description + ", fileSize=" + fileSize
				+ ", gradeId=" + gradeId + ", gradeName=" + gradeName
				+ ", keyWords=" + keyWords + ", mediaFormat=" + mediaFormat
				+ ", mediaType=" + mediaType + ", playTime=" + playTime
				+ ", price=" + price + ", publisher=" + publisher
				+ ", quality=" + quality + ", sourceId=" + sourceId
				+ ", sourceName=" + sourceName + ", subjectId=" + subjectId
				+ ", subjectName=" + subjectName + ", url=" + url
				+ ", useTimes=" + useTimes + ", viewTimes=" + viewTimes + "]";
	}
}
