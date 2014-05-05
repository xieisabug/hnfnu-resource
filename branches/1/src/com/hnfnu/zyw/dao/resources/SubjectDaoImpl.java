package com.hnfnu.zyw.dao.resources;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.SubjectDto;

@Repository("subjectDao")
public class SubjectDaoImpl extends BaseDao<SubjectDto> implements ISubjectDao {

	public List<SubjectDto> subjectList(String sql) throws Exception {
		List<SubjectDto> l  = this.getHibernateTemplate().find(sql);
		return l;
	}

	
}
