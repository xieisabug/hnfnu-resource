package com.hnfnu.zyw.website.service;

import java.util.Map;

import com.hnfnu.zyw.dao.base.Pager;
import com.hnfnu.zyw.vo.SourceVo;

public interface ISourceListService {

	public Map<String, Object> getDataModel(int subjectId,int gradeId,int page,int pageSize);
	public Pager<SourceVo> getPager(int subjectId, int gradeId,String type,String keyWords,int page,int pageSize);
}
