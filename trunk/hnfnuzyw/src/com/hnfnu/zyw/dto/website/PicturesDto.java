package com.hnfnu.zyw.dto.website;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="f_pictures")
public class PicturesDto 
{	
	private Integer id;
	private String src;
	private String link;
	//是否显示，1是0否
	private int display;
	private Date createDate;
	private Integer createUserId;
	private String createUserName;
	private String remark;

	public PicturesDto()
	{

	}
	public PicturesDto(Integer id, String src, String link, int display,
			Date createDate, Integer createUserId, String createUserName,
			String remark) {
		super();
		this.id = id;
		this.src = src;
		this.link = link;
		this.display = display;
		this.createDate = createDate;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.remark = remark;
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
	public void setSrc(String src)
	{
		this.src = src;
	}
	public String getSrc()
	{
		return this.src;
	}
	public void setLink(String link)
	{
		this.link = link;
	}
	public String getLink()
	{
		return this.link;
	}
	
	public int getDisplay() {
		return display;
	}
	public void setDisplay(int display) {
		this.display = display;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	public Date getCreateDate()
	{
		return this.createDate;
	}
	public void setCreateUserId(Integer createUserId)
	{
		this.createUserId = createUserId;
	}
	public Integer getCreateUserId()
	{
		return this.createUserId;
	}
	public void setCreateUserName(String createUserName)
	{
		this.createUserName = createUserName;
	}
	public String getCreateUserName()
	{
		return this.createUserName;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}

	@Override
	public String toString() {
		return "PictruesDto [id=" + id + ", src=" + src + ", link=" + link
				+ ", display=" + display + ", createDate=" + createDate
				+ ", createUserId=" + createUserId + ", createUserName="
				+ createUserName + ", remark=" + remark + "]";
	}
}
