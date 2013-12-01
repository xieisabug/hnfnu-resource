package com.hnfnu.zyw.dto.website.chart;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_chart_top_user_source")
public class TopUserSource {
	private String name;
	private int num;
	
	@Id
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
