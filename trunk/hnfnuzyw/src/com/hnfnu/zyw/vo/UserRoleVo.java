package com.hnfnu.zyw.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.hnfnu.zyw.dto.system.pk.UserRolePK;

@Entity
@Table(name = "v_user_role")
@IdClass(UserRolePK.class)
public class UserRoleVo {
	private Integer userId;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 姓名
	private String realname;
	// 身份证
	private String idcard;
	// 性别
	private String sex;
	// QQ
	private String qq;
	// 电话
	private String telephone;
	// 生日
	private Date birth;
	// 部门
	private String department;
	private Integer roleId;
	// 角色名
	private String rolename;

	public UserRoleVo() {
		super();
	}

	public UserRoleVo(Integer userId, String username, String password,
			String realname, String idcard, String sex, String qq,
			String telephone, Date birth, String department, Integer roleId,
			String rolename) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.idcard = idcard;
		this.sex = sex;
		this.qq = qq;
		this.telephone = telephone;
		this.birth = birth;
		this.department = department;
		this.roleId = roleId;
		this.rolename = rolename;
	}

	@Id
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Id
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
