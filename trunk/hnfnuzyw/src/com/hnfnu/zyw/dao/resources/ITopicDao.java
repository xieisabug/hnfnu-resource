package com.hnfnu.zyw.dao.resources;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.resources.TopicDto;

public interface ITopicDao extends IBaseDao<TopicDto>{
	public int getTotalCount(String hql);

}
