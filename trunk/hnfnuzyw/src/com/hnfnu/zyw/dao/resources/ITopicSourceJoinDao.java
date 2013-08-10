package com.hnfnu.zyw.dao.resources;

import java.util.List;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.resources.TopicSourceJoinDto;

public interface ITopicSourceJoinDao extends IBaseDao<TopicSourceJoinDto>{

/**
 * 	ͨ��topicId����ɾ����ר���Ѿ��ҽӵ�������Դ
 * @param userId
 * @return
 * @throws Exception
 */
	public boolean deleteByTopicId(int topicId) throws Exception;
	
	/**
	 * �������ר����Դ�ҽӼ�¼,�����֮ǰ��ɾ����ר��Ľ�ɫ
	 * @param userId
	 * @param userRoleJoins
	 * @return
	 * @throws Exception
	 */
	public boolean addTopicSourceJoins(int topicId,List<TopicSourceJoinDto> topicSourceJoins) throws Exception;
}
