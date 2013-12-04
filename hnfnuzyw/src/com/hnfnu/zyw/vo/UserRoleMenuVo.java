package com.hnfnu.zyw.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.hnfnu.zyw.dto.system.pk.UserRoleMenuPK;


@Entity
@Table(name = "v_user_role_menu")
@IdClass(UserRoleMenuPK.class)
public class UserRoleMenuVo implements Serializable{
	private static final long serialVersionUID = 3120420659832856367L;
	private Integer userId;
	private Integer roleId;
	private Integer menuId;
	private String functionIdList;
	
	
	
	public UserRoleMenuVo() {
		super();
	}



	public UserRoleMenuVo(Integer userId, Integer roleId, Integer menuId,
			String functionIdList) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.menuId = menuId;
		this.functionIdList = functionIdList;
	}


	@Id
	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	@Id
	public Integer getRoleId() {
		return roleId;
	}



	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	@Id
	public Integer getMenuId() {
		return menuId;
	}



	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}



	public String getFunctionIdList() {
		return functionIdList;
	}



	public void setFunctionIdList(String functionIdList) {
		this.functionIdList = functionIdList;
	}



	@Override
	public String toString() {
		return "UserRoleMenuVo [userId=" + userId + ", roleId=" + roleId
				+ ", menuId=" + menuId + ", functionIdList=" + functionIdList
				+ "]";
	}
	
	
	
	

}
