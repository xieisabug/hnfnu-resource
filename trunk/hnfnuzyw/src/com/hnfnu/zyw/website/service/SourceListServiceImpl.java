package com.hnfnu.zyw.website.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.base.Pager;
import com.hnfnu.zyw.dao.base.SystemContext;
import com.hnfnu.zyw.dao.resources.IGradeDao;
import com.hnfnu.zyw.dao.resources.ISourceVoDao;
import com.hnfnu.zyw.dao.resources.ISubjectDao;
import com.hnfnu.zyw.dto.resources.GradeDto;
import com.hnfnu.zyw.dto.resources.SubjectDto;
import com.hnfnu.zyw.vo.SourceVo;


@Service("ftl_sourceListService")
public class SourceListServiceImpl {

	@Autowired
	@Qualifier("sourceVoDao")
	public ISourceVoDao sourceVoDao;

	@Autowired
	@Qualifier("subjectDao")
	public ISubjectDao subjectDao;
	
	@Autowired
	@Qualifier("gradeDao")
	public IGradeDao gradeDao;

	public Map<String, Object> getDataModel(int subjectId, int gradeId,SystemContext systemContext) {
		String hql = "from SourceVo where subjectId=" + subjectId
				+ " and gardeId=" + gradeId + " order by id desc";
		
		Pager<SourceVo> sourcePager = null;
		SubjectDto subject = null;
		GradeDto grade = null;
		
		Map<String, Object> root = new HashMap<String, Object>();
		try {
			sourcePager = sourceVoDao.find(hql, systemContext);
			subject = subjectDao.load(subjectId);
			grade = gradeDao.load(gradeId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		root.put("sourcePager", sourcePager);
		root.put("subject", subject);
		root.put("grade", grade);
		return root;
	}

}
