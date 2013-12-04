package com.hnfnu.zyw.dao.resources;

import java.util.List;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.resources.TopicSourceJoinDto;

public interface ITopicSourceJoinDao extends IBaseDao<TopicSourceJoinDto>{

/**
 * 	Í¨¹ýtopicIdÅúÁ¿É¾³ý¸Ã×¨ÌâÒÑ¾­¹Ò½ÓµÄËùÓÐ×ÊÔ´
 * @param userId
 * @return
 * @throws Exception
 */
	public boolean deleteByTopicId(int topicId) throws Exception;
	
	/**
	 * ÅúÁ¿Ìí¼Ó×¨Ìâ×ÊÔ´¹Ò½Ó¼ÇÂ¼,ÔÚÌí¼ÓÖ®Ç°ÏÈÉ¾³ý¸Ã×¨ÌâµÄ½ÇÉ«
	 * @param userId
	 * @param userRoleJoins
	 * @return
	 * @throws Exception
	 */
	public boolean addTopicSourceJoins(int topicId,List<TopicSourceJoinDto> topicSourceJoins) throws Exception;
}
