package com.hnfnu.zyw.service.resources;

import java.util.List;

import com.hnfnu.zyw.vo.TopicSourceVo;

public interface ITopicSourceVoService{
	public List<TopicSourceVo> listByTopicId(int id);
}