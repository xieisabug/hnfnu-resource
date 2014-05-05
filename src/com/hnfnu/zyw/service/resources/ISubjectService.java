package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.resources.SubjectDto;
import com.hnfnu.zyw.vo.SubjectGroupVo;

public interface ISubjectService {

	public boolean add(SubjectDto subject);

	public boolean delete(String url,int id);

	public boolean update(SubjectDto subject);

	public SubjectDto load(int id);

	/**
	 * 获取表中所有功能，是用List装的
	 * 
	 * @return
	 */
	public List<SubjectDto> list();

	/**
	 *获取表中所有功能，用Map装，为了分页的需要加上Rows和Total
	 * 
	 * @return
	 */
	public Map<String, Object> listSub();
	
	/**
	 * 根据分组id获得该组下所有科目
	 * 
	 * @return
	 */
	public List<SubjectGroupVo> listSubjectByGroupId(int groupId);
	
	/**
	 * 获取已有资源的科目
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<SubjectGroupVo> haveSubjectList();
	
	/**
	 * 清楚冗余的课程图片
	 * @return
	 */
	public boolean clearImage();

}
