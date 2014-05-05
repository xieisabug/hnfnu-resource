package com.hnfnu.zyw.dao.resources;

import java.util.List;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.vo.SubjectGroupVo;

public interface ISubjectGroupVoDao extends IBaseDao<SubjectGroupVo> {

	/**
	 * 执行复杂的查询语句
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<SubjectGroupVo> subjectList(String sql) throws Exception;
}
