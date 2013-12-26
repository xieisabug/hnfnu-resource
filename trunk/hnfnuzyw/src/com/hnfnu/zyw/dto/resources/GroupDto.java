package com.hnfnu.zyw.dto.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="r_group")
public class GroupDto {
	private int id;
	private String name;
	private int style;
	private int isDisplay;
	private String remark;
	
	public GroupDto() {
		super();
	}
	public GroupDto(int id, String name, int style, int isDisplay, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.style = style;
		this.isDisplay = isDisplay;
		this.remark = remark;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStyle() {
		return style;
	}
	public void setStyle(int style) {
		this.style = style;
	}
	public int getIsDisplay() {
		return isDisplay;
	}
	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "GroupDto [id=" + id + ", name=" + name + ", style=" + style
				+ ", isDisplay=" + isDisplay + ", remark=" + remark + "]";
	} 
}
