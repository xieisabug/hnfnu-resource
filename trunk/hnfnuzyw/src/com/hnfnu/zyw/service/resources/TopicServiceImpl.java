package com.hnfnu.zyw.service.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ITopicDao;
import com.hnfnu.zyw.dto.resources.TopicDto;

@Service("topicService")
public class TopicServiceImpl implements ITopicService {

	@Autowired
	@Qualifier("topicDao")
	public ITopicDao topicDao;

	public boolean add(TopicDto topic) {
		try {
			topicDao.add(topic);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			topicDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(TopicDto topic) {
		try {
			topicDao.update(topic);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public TopicDto load(int id) {
		try {
			return topicDao.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TopicDto> list() {
		String hql = "from TopicDto";
		List<TopicDto> topics = null;
		try {
			topics = topicDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topics;
	}

	public Map<String, Object> listTopic() {
		String hql = "from TopicDto order by isDisPlay desc,id desc";
		Map<String, Object> topicList = new HashMap<String, Object>();
		List<TopicDto> l = null;

		try {
			l = topicDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		topicList.put("Rows", l);
		topicList.put("Total", l.size());
		return topicList;
	}

	public List<Map<String,String>> topicTree(){
		String hql = "from TopicDto";
		List<TopicDto> topics = null;
		try {
			topics = topicDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Map<String,String>> ret = new ArrayList<Map<String,String>>();
		for(int i = 0; i<topics.size(); i++){
			Map<String,String> topic = new HashMap<String, String>();
			topic.put("id", topics.get(i).getId().toString());
			topic.put("name", topics.get(i).getName());
			ret.add(topic);
		}
		return ret;
	}
}
