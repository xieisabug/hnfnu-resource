package com.hnfnu.zyw.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.hnfnu.zyw.dto.system.pk.RoleMenuPK;

@Entity
@Table(name = "v_role_menu")
@IdClass(RoleMenuPK.class)
public class RoleMenuVo {
	private Integer roleId;
	// 角色名
	private String roleName;
	// 创建用户id

	private Integer menuId;
	// 父菜单的id，如果是-1，则表示当前为最高级菜单
	private Integer parentId;
	// 菜单的名字
	private String menuName;
	// 菜单点击后调用的链接
	private String url;
	// 菜单所拥有的功能的id列表，用‘，’分割
	private String functionIdList;
	// 菜单的图标
	private String icon;

	public RoleMenuVo() {
		super();
	}

	public RoleMenuVo(Integer roleId, String roleName, Integer menuId,
			Integer parentId, String menuName, String url,
			String functionIdList, String icon) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.menuId = menuId;
		this.parentId = parentId;
		this.menuName = menuName;
		this.url = url;
		this.functionIdList = functionIdList;
		this.icon = icon;
	}

	@Id
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Id
	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFunctionIdList() {
		return functionIdList;
	}

	public void setFunctionIdList(String functionIdList) {
		this.functionIdList = functionIdList;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "RoleMenuVo [roleId=" + roleId + ", roleName=" + roleName
				+ ", menuId=" + menuId + ", parentId=" + parentId
				+ ", menuName=" + menuName + ", url=" + url
				+ ", functionIdList=" + functionIdList + ", icon=" + icon + "]";
	}
	
	

}
