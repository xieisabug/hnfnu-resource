package com.hnfnu.zyw.website.service;

import java.util.Map;

import com.hnfnu.zyw.dao.base.Pager;
import com.hnfnu.zyw.vo.SourceVo;

public interface ISourceListService {

	//public Map<String, Object> getDataModel(int subjectId,int gradeId,int page,int pageSize);
	//public Pager<SourceVo> getPager(int subjectId, int gradeId,String type,String keyWords,int page,int pageSize);

	public  Map<String, Object> getGroupsAndGrades();

	public  Pager<SourceVo> indexPage(int pagerIndex);
	
	public Map<String, Object> getSubjectByGroupAndGrade(int groupId,int gradeId);

	public  Pager<SourceVo> indexPage(int pagerIndex,int groupId,int gradeId);
	
	public Map<String, Object> getCourseByGroupAndGradeAndSubject(int groupId,int gradeId,int subjectId);

    public  Pager<SourceVo> indexPage(int pagerIndex,int groupId,int gradeId,int subjectId);

    public Map<String, Object> getFinalByGroupAndGradeAndSubjectAndCourse(int groupId,int gradeId, int subjectId, int courseId);

    public  Pager<SourceVo> indexPage(int pagerIndex,int groupId,int gradeId,int subjectId,int courseId);
}
