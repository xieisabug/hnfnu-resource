package com.hnfnu.zyw.dao.resources;

import java.util.List;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.resources.TopicSourceJoinDto;

public interface ITopicSourceJoinDao extends IBaseDao<TopicSourceJoinDto>{

/**
 * 	通过topicId批量删除该专题已经挂接的所有资源
 * @param userId
 * @return
 * @throws Exception
 */
	public boolean deleteByTopicId(int topicId) throws Exception;
	
	/**
	 * 批量添加专题资源挂接记录,在添加之前先删除该专题的角色
	 * @param userId
	 * @param userRoleJoins
	 * @return
	 * @throws Exception
	 */
	public boolean addTopicSourceJoins(int topicId,List<TopicSourceJoinDto> topicSourceJoins) throws Exception;
}
