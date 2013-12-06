package com.hnfnu.zyw.dto.system;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "s_teacher")
public class TeacherDto 
{	
	private Integer id;
	//用户登录名字
	private String username;
	//登录密码
	private String password;
	//姓名
	private String name;
	//身份证
	private String idcard;
	private String qq;
	//手机号码
	private String telephone;
	//系部或部门
	private String department;
	//创建日期
	private Date createDate;
	//创建人id
	private Integer createUserId;
	//备注
	private String remark;

	public TeacherDto()
	{

	}
	public TeacherDto(Integer id, String username, String password,
			String name, String idcard, String qq, String telephone,
			String department, Date createDate, Integer createUserId,
			String remark) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.idcard = idcard;
		this.qq = qq;
		this.telephone = telephone;
		this.department = department;
		this.createDate = createDate;
		this.createUserId = createUserId;
		this.remark = remark;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	@Id
	@GeneratedValue
	public Integer getId()
	{
		return this.id;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return this.username;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setIdcard(String idcard)
	{
		this.idcard = idcard;
	}
	public String getIdcard()
	{
		return this.idcard;
	}
	public void setQq(String qq)
	{
		this.qq = qq;
	}
	public String getQq()
	{
		return this.qq;
	}
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}
	public String getTelephone()
	{
		return this.telephone;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
	public String getDepartment()
	{
		return this.department;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	public Date getCreateDate()
	{
		return this.createDate;
	}
	public void setCreateUserId(Integer createUserId)
	{
		this.createUserId = createUserId;
	}
	public Integer getCreateUserId()
	{
		return this.createUserId;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}
	@Override
	public String toString() {
		return "TeacherDto [createDate=" + createDate + ", createUserId="
				+ createUserId + ", department=" + department + ", id=" + id
				+ ", idcard=" + idcard + ", name=" + name + ", password="
				+ password + ", qq=" + qq + ", remark=" + remark
				+ ", telephone=" + telephone + ", username=" + username + "]";
	}
}
