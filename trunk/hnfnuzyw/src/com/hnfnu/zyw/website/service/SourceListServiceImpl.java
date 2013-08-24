package com.hnfnu.zyw.website.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.base.Pager;
import com.hnfnu.zyw.dao.resources.IGradeDao;
import com.hnfnu.zyw.dao.resources.ISourceVoDao;
import com.hnfnu.zyw.dao.resources.ISubjectDao;
import com.hnfnu.zyw.dto.resources.GradeDto;
import com.hnfnu.zyw.dto.resources.SubjectDto;
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

	public Map<String, Object> getDataModel(int subjectId, int gradeId,
			int page, int pageSize) {
		String hql = "from SourceVo where subjectId=" + subjectId
				+ " and gardeId=" + gradeId + " order by id desc";

		Pager<SourceVo> sourcePager = null;
		SubjectDto subject = null;
		GradeDto grade = null;

		Map<String, Object> root = new HashMap<String, Object>();
		try {
			int pageOffset = (page - 1) * pageSize;
			sourcePager = sourceVoDao.find(hql, pageOffset, pageSize);
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
		// …Ë÷√∞¥’’idΩµ–Ú≈≈–Ú
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
