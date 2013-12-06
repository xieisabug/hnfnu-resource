package com.hnfnu.zyw.service.resources;

import com.hnfnu.zyw.dto.resources.TopicSourceJoinDto;

public interface ITopicSourceJoinService {

	public boolean add(TopicSourceJoinDto topicSourceJoin);

	public boolean delete(int id);

	public boolean update(TopicSourceJoinDto topicSourceJoin);

	public TopicSourceJoinDto load(int id);
	
	public int[] QueryAllSourceidsByTopicId(int topicId);

	/**
	 * 通过topicId批量删除该专题已经挂接的所有资源
	 * 
	 * @param topicId
	 * @return
	 */
	public boolean deleteByTopicId(int topicId);

	/**
	 * 批量添加专题资源挂接记录，挂接之前删除改资源的所有角色
	 * 
	 * @param topicSourceIds
	 * @return
	 */
	public boolean addTopicSourceJoins(String topicSourceIds, int subtitleId);

}
