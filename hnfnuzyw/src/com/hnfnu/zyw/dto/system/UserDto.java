package com.hnfnu.zyw.dto.system;

import java.sql.Date;

/**
* ͨ�����ݿ��ڱ���ֶζ�̬���� UserDto
**/
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
	private String set;
	//��ע
	private String remark;

	public UserDto()
	{

	}

	public void setId(Integer id)
	{
		this.id = id;
	}
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
	public void setSet(String set)
	{
		this.set = set;
	}
	public String getSet()
	{
		return this.set;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}
}
