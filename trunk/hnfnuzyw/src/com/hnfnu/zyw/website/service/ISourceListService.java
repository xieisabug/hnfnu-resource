package com.hnfnu.zyw.website.service;

import java.util.Map;

import com.hnfnu.zyw.dao.base.SystemContext;

public interface ISourceListService {

	public Map<String, Object> getDataModel(int subjectId,int gradeId,SystemContext systemContext);
}
