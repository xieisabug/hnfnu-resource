package com.hnfnu.zyw.dao.resources;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.vo.SubjectGroupVo;

@Repository("subjectGroupVoDao")
public class SubjectGroupVoDaoImpl extends BaseDao<SubjectGroupVo> implements ISubjectGroupVoDao {

	/**
	 * 执行复杂的查询语句
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<SubjectGroupVo> subjectList(String sql) throws Exception {
		List<SubjectGroupVo> l  = this.getHibernateTemplate().find(sql);
		return l;
	}

	
}
