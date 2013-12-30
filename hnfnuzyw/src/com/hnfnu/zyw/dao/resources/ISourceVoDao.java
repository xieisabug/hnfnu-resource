package com.hnfnu.zyw.dao.resources;

import java.util.List;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.vo.SourceVo;

public interface ISourceVoDao extends IBaseDao<SourceVo> {
	
	public List<SourceVo> sourceVoList(String sql) throws Exception;
	public int getViewTimesBySubjectId(int subjectId,int groupId,int gradeId);

}
