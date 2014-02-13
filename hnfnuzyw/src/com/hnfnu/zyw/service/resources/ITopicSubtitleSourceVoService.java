package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.vo.TopicSubtitleSourceVo;

public interface ITopicSubtitleSourceVoService {
	public boolean add(TopicSubtitleSourceVo topicSubtitleSourceVo);

	public boolean delete(int id);

	public boolean update(TopicSubtitleSourceVo topicSubtitleSourceVo);

	public TopicSubtitleSourceVo load(int id);

	/**
	 * 获取表中所有功能，是用List装的
	 * 
	 * @return
	 */
	public List<TopicSubtitleSourceVo> list();

	/**
	 *获取表中所有功能，用Map装，为了分页的需要加上Rows和Total
	 * 
	 * @return
	 */
	public Map<String, Object> listTopicSubtitleSourceVo(int id);
	
	/**
	 * 获取表中前pagerSize条数据，是用List装的
	 * @return
	 */
	public List<TopicSubtitleSourceVo> listBySubtileId(int subtileId,int startIndex,int pageSize);
	/**
	 * 清除专题中的冗余文件
	 * @return
	 */
	public boolean clearFile();
	
}
