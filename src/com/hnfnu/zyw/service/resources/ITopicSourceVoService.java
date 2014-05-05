package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.vo.TopicSourceVo;

public interface ITopicSourceVoService{
	public  Map<String, Object> listBySubTitleId(int id);
	public List<TopicSourceVo> listBySubTitleId(int subTitleId,int startIndex,int pageSize);
}
