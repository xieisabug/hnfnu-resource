package com.hnfnu.zyw.dto.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="r_source_category_join")
public class SourceCategoryJoinDto {

	
	private int id;
	private int sourceId;
	private int categoryId;
	
	
	public SourceCategoryJoinDto() {
		super();
	}


	public SourceCategoryJoinDto(int id, int sourceId, int categoryId) {
		super();
		this.id = id;
		this.sourceId = sourceId;
		this.categoryId = categoryId;
	}


	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getSourceId() {
		return sourceId;
	}


	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	@Override
	public String toString() {
		return "SourceCategoryJoinDto [categoryId=" + categoryId + ", id=" + id
				+ ", sourceId=" + sourceId + "]";
	}
	
	
}
