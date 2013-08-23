package com.hnfnu.zyw.website.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.IGradeDao;
import com.hnfnu.zyw.dao.resources.ISubjectDao;
import com.hnfnu.zyw.dao.resources.ITopicDao;
import com.hnfnu.zyw.dto.resources.GradeDto;
import com.hnfnu.zyw.dto.resources.SubjectDto;
import com.hnfnu.zyw.dto.resources.TopicDto;

@Service("ftl_indexService")
public class IndexServiceImpl implements IIndexService {

	@Autowired
	@Qualifier("topicDao")
	public ITopicDao topicDao;

	@Autowired
	@Qualifier("subjectDao")
	public ISubjectDao subjectDao;

	@Autowired
	@Qualifier("gradeDao")
	public IGradeDao gradeDao;

	public Map<String, Object> getDataModel() {
		Map<String, Object> root = new HashMap<String, Object>();
		String hql1 = "from TopicDto order by id desc";
		String hql2 = "from SubjectDto";
		String hql3 = "from GradeDto";
		List<SubjectDto> subjectList = null;
		List<TopicDto> topicList = null;
		List<GradeDto> gradeList = null;
		int topicNum = 10;//默认的专题显示10个
		int sourceLine = 4;//默认显示四行资源
		try {
			topicList = topicDao.list(hql1);
			subjectList = subjectDao.list(hql2);
			gradeList = gradeDao.list(hql3);
			
			if(subjectList.size() >= 5){
				topicNum = subjectList.size() * 2;
				sourceLine = sourceLine + (subjectList.size() - 5)/2;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		root.put("subjectList", subjectList);
		root.put("topicList", topicList);
		root.put("gradeList", gradeList);
		root.put("topicNum", topicNum);
		root.put("sourceLine", sourceLine);
		return root;
	}

}
