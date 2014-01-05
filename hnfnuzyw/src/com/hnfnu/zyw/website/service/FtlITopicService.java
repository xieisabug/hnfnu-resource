package com.hnfnu.zyw.website.service;

import java.util.List;

import com.hnfnu.zyw.dto.resources.TopicDto;

public interface FtlITopicService {
	public void getTopics();
	/**
	 * 得到前十个最热专题
	 * @return
	 */
	public List<TopicDto> getTenHotTopics();

}
