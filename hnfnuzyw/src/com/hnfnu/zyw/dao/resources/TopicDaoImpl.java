package com.hnfnu.zyw.dao.resources;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.TopicDto;


@Repository("topicDao")
public class TopicDaoImpl extends BaseDao<TopicDto> implements ITopicDao {

}
