package com.hnfnu.zyw.website.service;

import java.util.Map;

import com.hnfnu.zyw.dao.base.Pager;
import com.hnfnu.zyw.vo.SourceVo;

public interface ISourceListService {

	//public Map<String, Object> getDataModel(int subjectId,int gradeId,int page,int pageSize);
	//public Pager<SourceVo> getPager(int subjectId, int gradeId,String type,String keyWords,int page,int pageSize);
	/**
	 * 学科资源的第一个界面，获取所有的分组，已经分组下面的所有年级
	 * @return
	 */
	public  Map<String, Object> getGroupsAndGrades();
	/**
	 * 根据传来的第几页，取出一页数据
	 * @param pagerIndex
	 * @return
	 */
	public  Pager<SourceVo> indexPage(int pagerIndex);
	
	
	public Map<String, Object> getSubjectByGroupAndGrade(int groupId,int gradeId);
	
	
	public  Pager<SourceVo> indexPage(int pagerIndex,int groupId,int gradeId);
	
	public Map<String, Object> getCourseByGroupAndGradeAndSubject(int groupId,int gradeId,int subjectId);
	
	
	public  Pager<SourceVo> indexPage(int pagerIndex,int groupId,int gradeId,int subjectId);
}
