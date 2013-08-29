package com.hnfnu.zyw.dto.system;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* ͨ�����ݿ��ڱ���ֶζ�̬���� UserDto
**/
@Entity
@Table(name="s_user")
public class UserDto 
{	
	private Integer id;
	//�û���
	private String username;
	//����
	private String password;
	//����
	private String name;
	//���֤
	private String idcard;
	//�Ա�
	private String sex;
	//QQ
	private String qq;
	//�绰
	private String telephone;
	//����
	private Date birth;
	//����
	private String department;
	//��������
	private Date createDate;
	//����¼ʱ��
	private Date latestLoginDate;
	//���ã������漰�û����˵����ã�
	private String setting;
	//��ע
	private String remark;

	public UserDto()
	{

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
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getSex()
	{
		return this.sex;
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
	public void setBirth(Date birth)
	{
		this.birth = birth;
	}
	public Date getBirth()
	{
		return this.birth;
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
	public void setLatestLoginDate(Date latestLoginDate)
	{
		this.latestLoginDate = latestLoginDate;
	}
	public Date getLatestLoginDate()
	{
		return this.latestLoginDate;
	}
	public void setSetting(String setting)
	{
		this.setting = setting;
	}
	public String getSetting()
	{
		return this.setting;
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
		return "UserDto [id=" + id + ", username=" + username + ", password="
				+ password + ", name=" + name + ", idcard=" + idcard + ", sex="
				+ sex + ", qq=" + qq + ", telephone=" + telephone + ", birth="
				+ birth + ", department=" + department + ", createDate="
				+ createDate + ", latestLoginDate=" + latestLoginDate
				+ ", setting=" + setting + ", remark=" + remark + "]";
	}
	
	
}
