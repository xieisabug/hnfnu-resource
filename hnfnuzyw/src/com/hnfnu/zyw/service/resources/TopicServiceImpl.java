package com.hnfnu.zyw.service.resources;

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
			return topicDao.load(id);
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
		String hql = "from TopicDto";
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

}
