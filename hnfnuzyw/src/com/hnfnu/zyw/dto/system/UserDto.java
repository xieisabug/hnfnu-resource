package com.hnfnu.zyw.dto.system;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 通过数据库内表的字段动态生成 UserDto
 **/
@Entity
@Table(name = "s_user")
public class UserDto {
	private Integer id;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 姓名
	private String name;
	// 身份证
	private String idcard;
	// 性别
	private String sex;
	// QQ
	private String qq;
	// 电话
	private String telephone;
	//邮箱
	private String email;
	// 生日
	private Date birth;
	// 部门
	private String department;
	//资源币余额
	private int balance;
	// 创建日期
	private Date createDate;
	// 最后登录时间
	private Date latestLoginDate;
	// 设置（用于涉及用户个人的设置）
	private String setting;
	// 备注
	private String remark;

	public UserDto() {

	}
	
	public UserDto(Integer id, String username, String password, String name,
			String idcard, String sex, String qq, String telephone,
			String email, Date birth, String department, int balance,
			Date createDate, Date latestLoginDate, String setting, String remark) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.idcard = idcard;
		this.sex = sex;
		this.qq = qq;
		this.telephone = telephone;
		this.email = email;
		this.birth = birth;
		this.department = department;
		this.balance = balance;
		this.createDate = createDate;
		this.latestLoginDate = latestLoginDate;
		this.setting = setting;
		this.remark = remark;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return this.id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return this.sex;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getQq() {
		return this.qq;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setLatestLoginDate(Date latestLoginDate) {
		this.latestLoginDate = latestLoginDate;
	}

	public Date getLatestLoginDate() {
		return this.latestLoginDate;
	}

	public void setSetting(String setting) {
		this.setting = setting;
	}

	public String getSetting() {
		return this.setting;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", password="
				+ password + ", name=" + name + ", idcard=" + idcard + ", sex="
				+ sex + ", qq=" + qq + ", telephone=" + telephone + ", birth="
				+ birth + ", department=" + department + ", createDate="
				+ createDate + ", latestLoginDate=" + latestLoginDate
				+ ", setting=" + setting + ", remark=" + remark + "]";
	}

}
