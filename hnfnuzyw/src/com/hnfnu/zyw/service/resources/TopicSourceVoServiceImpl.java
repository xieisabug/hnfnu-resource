package com.hnfnu.zyw.service.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ITopicSourceVoDao;
import com.hnfnu.zyw.vo.TopicSourceVo;

@Service("topicSourceVoService")
public class TopicSourceVoServiceImpl implements ITopicSourceVoService{
	@Autowired
	@Qualifier("topicSourceVoDao")
	public ITopicSourceVoDao topicSourceVoDao;
	
	public List<TopicSourceVo> listByTopicId(int id){
		String hql = "from TopicSourceVo where topicId="+id;
		List<TopicSourceVo> l = null;
		try {
			l = topicSourceVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
}
