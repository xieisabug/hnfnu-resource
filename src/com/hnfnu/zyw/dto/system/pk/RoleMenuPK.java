package com.hnfnu.zyw.dto.system.pk;

import java.io.Serializable;


public class RoleMenuPK implements Serializable {

	private static final long serialVersionUID = -5261507671667300800L;
	private Integer menuId;
	private Integer roleId;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RoleMenuPK) {
			RoleMenuPK roleMenu = (RoleMenuPK) obj;
			if (this.roleId == roleMenu.roleId
					&& this.menuId == roleMenu.menuId)
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.menuId.hashCode();
	}

}
