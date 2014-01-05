package com.hnfnu.zyw.website.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.base.Pager;
import com.hnfnu.zyw.dao.resources.ICourseGradeSubjectDao;
import com.hnfnu.zyw.dao.resources.IGradeDao;
import com.hnfnu.zyw.dao.resources.IGroupDao;
import com.hnfnu.zyw.dao.resources.ISourceVoDao;
import com.hnfnu.zyw.dao.resources.ISubjectDao;
import com.hnfnu.zyw.dao.resources.ITopicDao;
import com.hnfnu.zyw.dto.resources.GradeDto;
import com.hnfnu.zyw.dto.resources.GroupDto;
import com.hnfnu.zyw.vo.CourseGradeSubjectVo;
import com.hnfnu.zyw.vo.SourceVo;

@Service("ftl_sourceListService")
public class SourceListServiceImpl implements ISourceListService{
	public static final int PAGE_SIXE = 8;
	@Autowired
	@Qualifier("sourceVoDao")
	public ISourceVoDao sourceVoDao;

	@Autowired
	@Qualifier("subjectDao")
	public ISubjectDao subjectDao;

	@Autowired
	@Qualifier("groupDao")
	public IGroupDao groupDao;
	
	@Autowired
	@Qualifier("gradeDao")
	public IGradeDao gradeDao;
	
	@Autowired
	@Qualifier("topicDao")
	public ITopicDao topicDao;
	@Autowired
	@Qualifier("courseGradeSubjectDao")
	public ICourseGradeSubjectDao courseGradeSubjectDao;

	public Map<String, Object> getGroupsAndGrades() {
		Map<String, Object> root = new HashMap<String, Object>();
		List<Map<String, Object>> list =new ArrayList<Map<String,Object>>();
		Map<String, Object> groupMap = null;
		//GroupDto group = null;
		List<GradeDto> grades  = null;
		try {
			List<GroupDto> groups = groupDao.list("from GroupDto");
			for(int i=0;i<groups.size();i++){
				groupMap = new HashMap<String, Object>();
				GroupDto t = groups.get(i); 
				groupMap.put("group", t);
				grades = gradeDao.list("from GradeDto where groupId="+t.getId());
				groupMap.put("gradeList", grades);
				list.add(groupMap);
			}
			Pager<SourceVo> sourcePager = sourceVoDao.find("from SourceVo order by id desc", 0, PAGE_SIXE);
			root.put("groupList", list);
			root.put("sourcePager", sourcePager);
			return root;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Pager<SourceVo> indexPage(int pagerIndex) {
		int pageOffset = (pagerIndex -1)*PAGE_SIXE;
		try {
			Pager<SourceVo> sourcePager = sourceVoDao.find("from SourceVo order by id desc", pageOffset, PAGE_SIXE);
			return sourcePager;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, Object> getSubjectByGroupAndGrade(int groupId,
			int gradeId) {
		Map<String, Object> root = new HashMap<String, Object>();
		String hql = "FROM CourseGradeSubjectVo  where groupId="+groupId+" and gradeId="+gradeId+" group by subjectId";
		try {
			List<CourseGradeSubjectVo> courseGradeSubjectList =courseGradeSubjectDao.list(hql);
			root.put("courseGradeSubjectList", courseGradeSubjectList);
			Pager<SourceVo> sourcePager = sourceVoDao.find("from SourceVo where groupId="+groupId+" and gradeId="+gradeId+" order by id desc", 0, PAGE_SIXE);
			root.put("sourcePager", sourcePager);
			return root;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Pager<SourceVo> indexPage(int pagerIndex, int groupId, int gradeId) {
		int pageOffset = (pagerIndex -1)*PAGE_SIXE;
		try {
			Pager<SourceVo> sourcePager = sourceVoDao.find("from SourceVo where groupId="+groupId+" and gradeId="+gradeId+" order by id desc", pageOffset, PAGE_SIXE);
			return sourcePager;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, Object> getCourseByGroupAndGradeAndSubject(int groupId,
			int gradeId, int subjectId) {
		Map<String, Object> root = new HashMap<String, Object>();
		String hql = "FROM CourseGradeSubjectVo where groupId="+groupId+" and gradeId="+gradeId+" and subjectId="+subjectId;
		try {
			List<CourseGradeSubjectVo> courseGradeSubjectList =courseGradeSubjectDao.list(hql);
			root.put("courseGradeSubjectList", courseGradeSubjectList);
			Pager<SourceVo> sourcePager = sourceVoDao.find("from SourceVo where groupId="+groupId+" and gradeId="+gradeId+" and subjectId="+subjectId+"  order by id desc", 0, PAGE_SIXE);
			root.put("sourcePager", sourcePager);
			return root;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Pager<SourceVo> indexPage(int pagerIndex, int groupId, int gradeId,
			int subjectId) {
		int pageOffset = (pagerIndex -1)*PAGE_SIXE;
		try {
			Pager<SourceVo> sourcePager = sourceVoDao.find("from SourceVo where groupId="+groupId+" and gradeId="+gradeId+" and subjectId="+subjectId+"  order by id desc", pageOffset, PAGE_SIXE);
			return sourcePager;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*public Map<String, Object> getDataModel(int subjectId, int gradeId,
			int page, int pageSize) {
		String hql = "from SourceVo where subjectId=" + subjectId
				+ " and gradeId=" + gradeId + " order by id desc";
		String hql1 = "from TopicDto order by id desc";
		Pager<SourceVo> sourcePager = null;
		List<TopicDto> topicList = new ArrayList<TopicDto>();
		SubjectDto subject = null;
		GradeDto grade = null;

		Map<String, Object> root = new HashMap<String, Object>();
		try {
			int pageOffset = (page - 1) * pageSize;
			sourcePager = sourceVoDao.find(hql, pageOffset, pageSize);
			subject = subjectDao.get(subjectId);
			grade = gradeDao.get(gradeId);
			topicList = topicDao.list(hql1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		root.put("sourcePager", sourcePager);
		root.put("subject", subject);
		root.put("grade", grade);
		root.put("topicList", topicList);
		return root;
	}

	public Pager<SourceVo> getPager(int subjectId, int gradeId, String type,
			String keyWords, int page, int pageSize) {

		String hql = "from SourceVo where subjectId=" + subjectId
				+ " and gradeId=" + gradeId;
		if (type != null && !"".equals(type)) {
			hql += " and mediaType= '" + type + "'";
		}
		if (keyWords != null && !"".equals(keyWords)) {
			hql += " and keyWords like '%" + keyWords + "%'";
		}
		hql += " order by id desc";

		Pager<SourceVo> sourcePager = null;

		try {
			int pageOffset = (page - 1) * pageSize;
			sourcePager = sourceVoDao.find(hql, pageOffset, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sourcePager;
	}*/

}
