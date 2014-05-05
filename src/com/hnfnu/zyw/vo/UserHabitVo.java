package com.hnfnu.zyw.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_user_habit")
public class UserHabitVo {
	// 用户id
	private int id;
	//菜单id
	private int menuId;
	// 菜单名
	private String name;
	// 菜单链接
	private String url;

	public UserHabitVo() {
	}

	public UserHabitVo(int menuId,String name, String url) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.url = url;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Id
	@GeneratedValue
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "UserHabitVo [id=" + id + ", menuId=" + menuId + ", name="
				+ name + ", url=" + url + "]";
	}

}
