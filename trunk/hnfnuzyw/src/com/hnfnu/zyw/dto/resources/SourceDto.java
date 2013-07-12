package com.hnfnu.zyw.dto.resources;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ͨ�����ݿ��ڱ���ֶζ�̬���� SourceDto
 **/
@Entity
@Table(name = "r_source")
public class SourceDto {
	//id

	private Integer id;

	//��Դ����

	private String name;

	//���ڵĿγ̵�id

	private Integer courseId;

	//���ڵ�����id,һ����Դ�ж������ԣ�����

	private String categoryIdList;

	//�ؼ����б���"��"�ָ�

	private String keyWords;

	//ý�����ͣ��磺�ı���ppt����Ƶ��

	private String mediaType;

	//ý���ʽ���磺jpg��mp4��

	private String mediaFormat;

	//����ʱ�䣬ֻ����Ƶӵ���������

	private String playTime;

	//�ļ���С

	private String fileSize;

	//����

	private String author;

	//������

	private String publisher;

	//����

	private String description;

	//����ʱ��

	private Date createDate;

	//���״̬

	private String approvalStatus;

	//�����ȼ�

	private String quality;

	//�۸�

	private double price;

	//���ʴ���

	private Integer viewTimes;

	//���ػ���ʹ�ô���

	private Integer useTimes;

	private String url;

	private Integer createUserId;


	public SourceDto()
	{

	}
	public SourceDto(Integer id, String name, Integer courseId,
			String categoryIdList, String keyWords, String mediaType,
			String mediaFormat, String playTime, String fileSize,
			String author, String publisher, String description,
			Date createDate, String approvalStatus, String quality,
			double price, Integer viewTimes, Integer useTimes, String url,
			Integer createUserId) {
		super();
		this.id = id;
		this.name = name;
		this.courseId = courseId;
		this.categoryIdList = categoryIdList;
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

	public void setCourseId(Integer courseId)
	{
		this.courseId = courseId;
	}

	public Integer getCourseId()
	{
		return this.courseId;
	}

	public void setCategoryIdList(String categoryIdList)
	{
		this.categoryIdList = categoryIdList;
	}

	public String getCategoryIdList()
	{
		return this.categoryIdList;
	}

	public void setKeyWords(String keyWords)
	{
		this.keyWords = keyWords;
	}

	public String getKeyWords()
	{
		return this.keyWords;
	}

	public void setMediaType(String mediaType)
	{
		this.mediaType = mediaType;
	}

	public String getMediaType()
	{
		return this.mediaType;
	}

	public void setMediaFormat(String mediaFormat)
	{
		this.mediaFormat = mediaFormat;
	}

	public String getMediaFormat()
	{
		return this.mediaFormat;
	}

	public void setPlayTime(String playTime)
	{
		this.playTime = playTime;
	}

	public String getPlayTime()
	{
		return this.playTime;
	}

	public void setFileSize(String fileSize)
	{
		this.fileSize = fileSize;
	}

	public String getFileSize()
	{
		return this.fileSize;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getAuthor()
	{
		return this.author;
	}

	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}

	public String getPublisher()
	{
		return this.publisher;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public Date getCreateDate()
	{
		return this.createDate;
	}

	public void setApprovalStatus(String approvalStatus)
	{
		this.approvalStatus = approvalStatus;
	}

	public String getApprovalStatus()
	{
		return this.approvalStatus;
	}

	public void setQuality(String quality)
	{
		this.quality = quality;
	}

	public String getQuality()
	{
		return this.quality;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public double getPrice()
	{
		return this.price;
	}

	public void setViewTimes(Integer viewTimes)
	{
		this.viewTimes = viewTimes;
	}

	public Integer getViewTimes()
	{
		return this.viewTimes;
	}

	public void setUseTimes(Integer useTimes)
	{
		this.useTimes = useTimes;
	}

	public Integer getUseTimes()
	{
		return this.useTimes;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getUrl()
	{
		return this.url;
	}

	public void setCreateUserId(Integer createUserId)
	{
		this.createUserId = createUserId;
	}

	public Integer getCreateUserId()
	{
		return this.createUserId;
	}
	
	@Override
	public String toString() {
		return "SourceDto [approvalStatus=" + approvalStatus + ", author="
				+ author + ", categoryIdList=" + categoryIdList + ", courseId="
				+ courseId + ", createDate=" + createDate + ", createUserId="
				+ createUserId + ", description=" + description + ", fileSize="
				+ fileSize + ", id=" + id + ", keyWords=" + keyWords
				+ ", mediaFormat=" + mediaFormat + ", mediaType=" + mediaType
				+ ", name=" + name + ", playTime=" + playTime + ", price="
				+ price + ", publisher=" + publisher + ", quality=" + quality
				+ ", url=" + url + ", useTimes=" + useTimes + ", viewTimes="
				+ viewTimes + "]";
	}
}
