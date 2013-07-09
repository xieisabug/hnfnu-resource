package com.hnfnu.zyw.dto.resources;

import java.util.Date;

/**
* 通过数据库内表的字段动态生成 SourceDto
**/
public class SourceDto 
{	
	//id
	private Integer id;
	//资源名称
	private String name;
	//属于的课程的id
	private Integer courseId;
	//属于的类别的id,一个资源有多个类别，以；隔开
	private Integer categoryIdList;
	//关键字列表，用"；"分隔
	private String keyWords;
	//媒体类型，如：文本，ppt，视频等
	private String mediaType;
	//媒体格式，如：jpg，mp4等
	private String mediaFormat;
	//播放时间，只有视频拥有这个属性
	private String playTime;
	//文件大小
	private String fileSize;
	//作者
	private String author;
	//出版社
	private String publisher;
	//描述
	private String description;
	//创建时间
	private Date createDate;
	//审核状态
	private String approvalStatus;
	//质量等级
	private String quality;
	//价格
	private  double price;
	//访问次数
	private Integer viewTimes;
	//下载或者使用次数
	private Integer useTimes;

	public SourceDto()
	{

	}

	public void setId(Integer id)
	{
		this.id = id;
	}
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
	public void setCategoryIdList(Integer categoryIdList)
	{
		this.categoryIdList = categoryIdList;
	}
	public Integer getCategoryIdList()
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
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
}
