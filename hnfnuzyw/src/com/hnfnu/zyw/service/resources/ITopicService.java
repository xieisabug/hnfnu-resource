package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.resources.TopicDto;

public interface ITopicService {

	public boolean add(TopicDto topic);

	public boolean delete(String url,int id);

	public boolean update(TopicDto topic);

	public TopicDto load(int id);

	/**
	 * 获取表中所有专题，是用List装的
	 * @return
	 */
	public List<TopicDto> list();
	/**
	 *获取表中所有专题，用Map装，为了分页的需要加上Rows和Total
	 * @return
	 */
	public Map<String, Object> listTopic();
	/**
	 * 生成专题树
	 * @return
	 */
	public List<Map<String,String>> topicTree();
	/**
	 * 专题每被访问一次viewTimes就加1
	 * @param topic
	 * @return
	 */
	public boolean topicAddViewTimes(int id);

}
