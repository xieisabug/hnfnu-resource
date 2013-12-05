package com.hnfnu.zyw.dao.resources;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.TopicSourceDto;

@Repository("topicSourceDao")
public class TopicSourceDaoImpl extends BaseDao<TopicSourceDto> implements ITopicSourceDao{

}
