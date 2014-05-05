package com.hnfnu.zyw.dao.resources;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.resources.SourceDto;

public interface ISourceDao extends IBaseDao<SourceDto> {
	
	public int getTotalCount(String hql);
	public Float getTotalCapacity(String hql);
}
