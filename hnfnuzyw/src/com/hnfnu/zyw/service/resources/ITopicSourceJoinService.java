package com.hnfnu.zyw.service.resources;

import com.hnfnu.zyw.dto.resources.TopicSourceJoinDto;

public interface ITopicSourceJoinService {

	public boolean add(TopicSourceJoinDto topicSourceJoin);

	public boolean delete(int id);

	public boolean update(TopicSourceJoinDto topicSourceJoin);

	public TopicSourceJoinDto load(int id);
	
	public int[] QueryAllSourceidsByTopicId(int topicId);

	/**
	 * ͨ��topicId����ɾ����ר���Ѿ��ҽӵ�������Դ
	 * 
	 * @param topicId
	 * @return
	 */
	public boolean deleteByTopicId(int topicId);

	/**
	 * �������ר����Դ�ҽӼ�¼���ҽ�֮ǰɾ������Դ�����н�ɫ
	 * 
	 * @param topicSourceIds
	 * @return
	 */
	public boolean addTopicSourceJoins(String topicSourceIds, int topicId);

}
