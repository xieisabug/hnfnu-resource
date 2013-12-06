package com.hnfnu.zyw.dto.system.pk;

import java.io.Serializable;

public class UserRoleMenuPK implements Serializable{
	private static final long serialVersionUID = 2949818698059467589L;
	private Integer userId;
	private Integer roleId;
	private Integer menuId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UserRoleMenuPK) {
			UserRoleMenuPK userRoleMenu = (UserRoleMenuPK) obj;
			if (this.userId == userRoleMenu.userId
					&&this.roleId == userRoleMenu.roleId
					&& this.menuId == userRoleMenu.menuId)
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.menuId.hashCode();
	}

}
