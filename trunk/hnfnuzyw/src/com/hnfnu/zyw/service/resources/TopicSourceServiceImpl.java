package com.hnfnu.zyw.service.resources;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.system.UserDto;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ITopicSourceDao;
import com.hnfnu.zyw.dto.resources.TopicSourceDto;

@Service("topicSourceService")
public class TopicSourceServiceImpl implements ITopicSourceService{
	@Autowired
	@Qualifier("topicSourceDao")
	public ITopicSourceDao topicSourceDao;

	public boolean add(TopicSourceDto topicSource) {
		try {
            ActionContext context = ActionContext.getContext();
            Map<String, Object> session = context.getSession();
            UserDto user = (UserDto) session.get("user");
            topicSource.setCreateUserId(user.getId());
            topicSource.setCreateDate(new Date());
			topicSourceDao.add(topicSource);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			topicSourceDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(TopicSourceDto topicSource) {
		try {
			topicSourceDao.update(topicSource);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public TopicSourceDto load(int id) {
		try {
			return topicSourceDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TopicSourceDto> list() {
		String hql = "from TopicSourceDto";
		List<TopicSourceDto> topicSources = null;
		try {
			topicSources = topicSourceDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topicSources;
	}

	public Map<String, Object> listTopicSource() {
		String hql = "from TopicSourceDto";
		Map<String, Object> topicSourceList = new HashMap<String, Object>();
		List<TopicSourceDto> l = null;

		try {
			l = topicSourceDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		topicSourceList.put("Rows", l);
		topicSourceList.put("Total", l.size());
		return topicSourceList;
	}
}
