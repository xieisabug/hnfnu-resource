package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.resources.TopicSubtitleDto;

public interface ITopicSubtitleService {

	public boolean add(TopicSubtitleDto topicSubtitle);

	public boolean delete(int id);

	public boolean update(TopicSubtitleDto topicSubtitle);

	public TopicSubtitleDto load(int id);

	/**
	 * 获取表中所有功能，是用List装的
	 * 
	 * @return
	 */
	public List<TopicSubtitleDto> list();

	/**
	 *获取专题下的所有二级标题，用Map装，为了分页的需要加上Rows和Total
	 * 
	 * @return
	 */
	public Map<String, Object> listTopicSubtitle(int topicId);
}
