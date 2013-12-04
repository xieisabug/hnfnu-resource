package com.hnfnu.zyw.dto.system;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "s_student")
public class StudentDto 
{	
	private Integer id;
	private String username;
	private String password;
	//名字
	private String name;
	//年纪
	private String number;
	//系部
	private String department;
	//专业
	private String major;
	//入学年份
	private String entranceTime;
	//充值余额，默认为0
	private Integer balance;
	private String telephone;
	private Date createDate;
	private String remark;

	public StudentDto()
	{

	}
	public StudentDto(Integer id, String username, String password,
			String name, String number, String department, String major,
			String entranceTime, Integer balance, String telephone,
			Date createDate, String remark) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.number = number;
		this.department = department;
		this.major = major;
		this.entranceTime = entranceTime;
		this.balance = balance;
		this.telephone = telephone;
		this.createDate = createDate;
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
	public void setNumber(String number)
	{
		this.number = number;
	}
	public String getNumber()
	{
		return this.number;
	}
	public void setDepartment(String department)
	{
		this.department = department;
	}
	public String getDepartment()
	{
		return this.department;
	}
	public void setMajor(String major)
	{
		this.major = major;
	}
	public String getMajor()
	{
		return this.major;
	}
	public void setEntranceTime(String entranceTime)
	{
		this.entranceTime = entranceTime;
	}
	public String getEntranceTime()
	{
		return this.entranceTime;
	}
	public void setBalance(Integer balance)
	{
		this.balance = balance;
	}
	public Integer getBalance()
	{
		return this.balance;
	}
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}
	public String getTelephone()
	{
		return this.telephone;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	public Date getCreateDate()
	{
		return this.createDate;
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
		return "StudentDto [balance=" + balance + ", createDate=" + createDate
				+ ", department=" + department + ", entranceTime="
				+ entranceTime + ", id=" + id + ", major=" + major + ", name="
				+ name + ", number=" + number + ", password=" + password
				+ ", remark=" + remark + ", telephone=" + telephone
				+ ", username=" + username + "]";
	}
	
	
}
