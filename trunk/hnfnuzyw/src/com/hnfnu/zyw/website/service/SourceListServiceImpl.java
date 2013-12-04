package com.hnfnu.zyw.website.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.base.Pager;
import com.hnfnu.zyw.dao.resources.IGradeDao;
import com.hnfnu.zyw.dao.resources.ISourceVoDao;
import com.hnfnu.zyw.dao.resources.ISubjectDao;
import com.hnfnu.zyw.dao.resources.ITopicDao;
import com.hnfnu.zyw.dto.resources.GradeDto;
import com.hnfnu.zyw.dto.resources.SubjectDto;
import com.hnfnu.zyw.dto.resources.TopicDto;
import com.hnfnu.zyw.vo.SourceVo;

@Service("ftl_sourceListService")
public class SourceListServiceImpl implements ISourceListService{

	@Autowired
	@Qualifier("sourceVoDao")
	public ISourceVoDao sourceVoDao;

	@Autowired
	@Qualifier("subjectDao")
	public ISubjectDao subjectDao;

	@Autowired
	@Qualifier("gradeDao")
	public IGradeDao gradeDao;
	
	@Autowired
	@Qualifier("topicDao")
	public ITopicDao topicDao;

	public Map<String, Object> getDataModel(int subjectId, int gradeId,
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
	}

}
