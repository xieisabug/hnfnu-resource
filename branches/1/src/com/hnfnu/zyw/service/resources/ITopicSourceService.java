package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.resources.TopicSourceDto;

public interface ITopicSourceService {

	public boolean add(TopicSourceDto topicSource);

	public boolean delete(int id);

	public boolean update(TopicSourceDto topicSource);

	public TopicSourceDto load(int id);

	/**
	 * 获取所有资源
	 * 
	 * @return
	 */
	public List<TopicSourceDto> list();

	/**
	 *用于分页的获取所有资源
	 * 
	 * @return
	 */
	public Map<String, Object> listTopicSource();
	
	public int getTotalCount();
	
}
