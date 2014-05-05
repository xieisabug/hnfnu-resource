package com.hnfnu.zyw.dao.resources;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.vo.GradeGroupVo;
import com.hnfnu.zyw.vo.SubjectGroupVo;

@Repository("gradeGroupVoDao")
public class GradeGroupVoDaoImpl extends BaseDao<GradeGroupVo> implements IGradeGroupVoDao {

	/**
	 * 执行复杂的查询语句
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<GradeGroupVo> gradeList(String sql) throws Exception {
		List<GradeGroupVo> l  = this.getHibernateTemplate().find(sql);
		return l;
	}
}
