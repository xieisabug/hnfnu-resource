package com.hnfnu.zyw.dao.resources;

import java.util.List;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.resources.SubjectDto;

public interface ISubjectDao extends IBaseDao<SubjectDto>{
	/**
	 * 获取已有资源的科目
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<SubjectDto> subjectList(String sql) throws Exception;

}
