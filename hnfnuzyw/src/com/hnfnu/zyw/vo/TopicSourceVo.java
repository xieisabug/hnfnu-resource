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

	// ��Դ����

	private String sourceName;

	// ���ڵĿγ̵�id

	private Integer courseId;

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

	private String sourceAuthor;

	// ������

	private String publisher;

	// ����

	private String sourceDescription;

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
	
	//id
	private Integer topicId;
	//ר������
	private String topicName;
	//ר����
	private String topicDescription;
	//ר������
	private String topicAuthor;
	//��ע
	private String remark;
	
	
	
	public TopicSourceVo() {
		super();
	}



	public TopicSourceVo(Integer id, Integer sourceId, String sourceName,
			Integer courseId, String keyWords, String mediaType,
			String mediaFormat, String playTime, String fileSize,
			String sourceAuthor, String publisher, String sourceDescription,
			Timestamp createDate, String approvalStatus, String quality,
			double price, Integer viewTimes, Integer useTimes, String url,
			Integer createUserId, Integer topicId, String topicName,
			String topicDescription, String topicAuthor, String remark) {
		super();
		this.id = id;
		this.sourceId = sourceId;
		this.sourceName = sourceName;
		this.courseId = courseId;
		this.keyWords = keyWords;
		this.mediaType = mediaType;
		this.mediaFormat = mediaFormat;
		this.playTime = playTime;
		this.fileSize = fileSize;
		this.sourceAuthor = sourceAuthor;
		this.publisher = publisher;
		this.sourceDescription = sourceDescription;
		this.createDate = createDate;
		this.approvalStatus = approvalStatus;
		this.quality = quality;
		this.price = price;
		this.viewTimes = viewTimes;
		this.useTimes = useTimes;
		this.url = url;
		this.createUserId = createUserId;
		this.topicId = topicId;
		this.topicName = topicName;
		this.topicDescription = topicDescription;
		this.topicAuthor = topicAuthor;
		this.remark = remark;
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



	@Override
	public String toString() {
		return "TopicSourceVo [approvalStatus=" + approvalStatus
				+ ", courseId=" + courseId + ", createDate=" + createDate
				+ ", createUserId=" + createUserId + ", fileSize=" + fileSize
				+ ", id=" + id + ", keyWords=" + keyWords + ", mediaFormat="
				+ mediaFormat + ", mediaType=" + mediaType + ", playTime="
				+ playTime + ", price=" + price + ", publisher=" + publisher
				+ ", quality=" + quality + ", remark=" + remark
				+ ", sourceAuthor=" + sourceAuthor + ", sourceDescription="
				+ sourceDescription + ", sourceId=" + sourceId
				+ ", sourceName=" + sourceName + ", topicAuthor=" + topicAuthor
				+ ", topicDescription=" + topicDescription + ", topicId="
				+ topicId + ", topicName=" + topicName + ", url=" + url
				+ ", useTimes=" + useTimes + ", viewTimes=" + viewTimes + "]";
	}
	
	

}
