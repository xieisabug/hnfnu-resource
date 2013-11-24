package com.hnfnu.zyw.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.hnfnu.zyw.dto.system.pk.RoleMenuPK;

@Entity
@Table(name = "v_role_menu")
@IdClass(RoleMenuPK.class)
public class RoleMenuVo implements Serializable{
	private static final long serialVersionUID = -7845996932250565865L;
	// ��ɫ��
	private String roleName;
	// �����û�id
	//private RoleMenuPK id;
	private Integer roleId;
	private Integer menuId;
	// ���˵���id�������-1�����ʾ��ǰΪ��߼��˵�
	private Integer parentId;
	// ���˵�������
	private String  parentName;
	// �˵�������
	private String menuName;
	// �˵��������õ�����
	private String url;
	// �˵���ӵ�еĹ��ܵ�id�б����á������ָ�
	private String functionIdList;
	// �˵���ͼ��
	private String icon;

	public RoleMenuVo() {
		super();
	}

	public RoleMenuVo(Integer roleId, String roleName, Integer menuId,
			Integer parentId, String menuName, String url,
			String functionIdList, String icon) {
		super();
		this.roleName = roleName;
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
	@Id
	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}