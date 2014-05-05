package com.hnfnu.zyw.dao.resources;

import java.util.List;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.vo.GradeGroupVo;

public interface IGradeGroupVoDao extends IBaseDao<GradeGroupVo> {
	/**
	 * 执行复杂的查询语句
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<GradeGroupVo> gradeList(String sql) throws Exception;

}
