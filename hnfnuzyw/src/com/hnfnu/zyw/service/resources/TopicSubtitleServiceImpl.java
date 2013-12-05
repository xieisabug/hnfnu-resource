package com.hnfnu.zyw.service.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ITopicSubtitleDao;
import com.hnfnu.zyw.dto.resources.TopicSubtitleDto;

@Service("topicSubtitleService")
public class TopicSubtitleServiceImpl implements ITopicSubtitleService{

	@Autowired
	@Qualifier("topicSubtitleDao")
	public ITopicSubtitleDao topicSubtitleDao;

	public boolean add(TopicSubtitleDto topicSubtitle) {
		try {
			topicSubtitleDao.add(topicSubtitle);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			topicSubtitleDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(TopicSubtitleDto topicSubtitle) {
		try {
			topicSubtitleDao.update(topicSubtitle);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public TopicSubtitleDto load(int id) {
		try {
			return topicSubtitleDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TopicSubtitleDto> list() {
		String hql = "from TopicSubtitleDto";
		List<TopicSubtitleDto> topicSubtitles = null;
		try {
			topicSubtitles = topicSubtitleDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topicSubtitles;
	}

	public Map<String, Object> listTopicSubtitle(int topicId) {
		String hql = "from TopicSubtitleDto where topicId="+topicId;
		Map<String, Object> topicSubtitleList = new HashMap<String, Object>();
		List<TopicSubtitleDto> l = null;

		try {
			l = topicSubtitleDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		topicSubtitleList.put("Rows", l);
		topicSubtitleList.put("Total", l.size());
		return topicSubtitleList;
	}

}
