package com.hnfnu.zyw.dto.website;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="f_news")
public class NewsDto 
{	
	//主键
	private Integer id;
	//标题
	private String title;
	//正文
	private String content;
	//日期
	private Date date;
	//创建者用户id
	private int createUserId;
	//优先级，默认为0
	private Integer priority;

	public NewsDto()
	{
	}
	
	public NewsDto(Integer id, String title, String content, Date date,
			int createUserId, Integer priority) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.createUserId = createUserId;
		this.priority = priority;
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
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	public Date getDate()
	{
		return this.date;
	}
	
	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public void setPriority(Integer priority)
	{
		this.priority = priority;
	}
	public Integer getPriority()
	{
		return this.priority;
	}
	@Override
	public String toString() {
		return "NewsDto [id=" + id + ", title=" + title + ", content="
				+ content + ", date=" + date + ", createUserId=" + createUserId
				+ ", priority=" + priority + "]";
	}
}
