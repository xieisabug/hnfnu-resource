package com.hnfnu.zyw.dto.Resources;

import java.util.Date;

/**
* ͨ�����ݿ��ڱ���ֶζ�̬���� SourceCommentDto
**/
public class SourceCommentDto 
{	
	//id
	private Integer id;
	//�����۵���Դ��Id
	private Integer sourceId;
	//���۵ĸ�����id��0���ʾ����Ϊ�����
	private Integer parentId;
	//���۵�����
	private String content;
	//���۵�����id����������������Ա����Ϣ
	private Integer authorId;
	//��������
	private Date createDate;

	public SourceCommentDto()
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
	public void setSourceId(Integer sourceId)
	{
		this.sourceId = sourceId;
	}
	public Integer getSourceId()
	{
		return this.sourceId;
	}
	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}
	public Integer getParentId()
	{
		return this.parentId;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}
	public void setAuthorId(Integer authorId)
	{
		this.authorId = authorId;
	}
	public Integer getAuthorId()
	{
		return this.authorId;
	}
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	public Date getCreateDate()
	{
		return this.createDate;
	}
}
