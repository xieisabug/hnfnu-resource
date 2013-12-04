package com.hnfnu.zyw.dto.website.chart;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_chart_user_count")
public class UserCount {
	private int num;
	private int month;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Id
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
}
