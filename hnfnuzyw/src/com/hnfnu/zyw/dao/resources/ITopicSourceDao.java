package com.hnfnu.zyw.dao.resources;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.resources.TopicSourceDto;

public interface ITopicSourceDao extends IBaseDao<TopicSourceDto> {
	public int getTotalCount(String hql);
	public Float getTotalCapacity(String hql);
}
