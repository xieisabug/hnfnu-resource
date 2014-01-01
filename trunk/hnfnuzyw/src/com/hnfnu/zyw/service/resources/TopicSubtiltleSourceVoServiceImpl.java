package com.hnfnu.zyw.service.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ITopicSubtiltleSourceVoDao;
import com.hnfnu.zyw.vo.TopicSubtiltleSourceVo;


@Service("topicSubtiltleSourceVoService")
public class TopicSubtiltleSourceVoServiceImpl implements  ITopicSubtiltleSourceVoService{

	@Autowired
	@Qualifier("topicSubtiltleSourceVoDao")
	public ITopicSubtiltleSourceVoDao topicSubtiltleSourceVoDao;

	public boolean add(TopicSubtiltleSourceVo garde) {
		try {
			topicSubtiltleSourceVoDao.add(garde);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			topicSubtiltleSourceVoDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(TopicSubtiltleSourceVo garde) {
		try {
			topicSubtiltleSourceVoDao.update(garde);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public TopicSubtiltleSourceVo load(int id) {
		try {
			return topicSubtiltleSourceVoDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TopicSubtiltleSourceVo> list() {
		String hql = "from TopicSubtiltleSourceVo";
		List<TopicSubtiltleSourceVo> gardes = null;
		try {
			gardes = topicSubtiltleSourceVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gardes;
	}

	public Map<String, Object> listTopicSubtiltleSourceVo() {
		String hql = "from TopicSubtiltleSourceVo";
		Map<String, Object> gardeList = new HashMap<String, Object>();
		List<TopicSubtiltleSourceVo> l = null;

		try {
			l = topicSubtiltleSourceVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		gardeList.put("Rows", l);
		gardeList.put("Total", l.size());
		return gardeList;
	}

	public List<TopicSubtiltleSourceVo> listBySubtileId(int subtitleId,int startIndex,int pageSize) {
		String hql = "from TopicSubtiltleSourceVo where subtitleId="+subtitleId+" limit "+startIndex+","+pageSize;
		List<TopicSubtiltleSourceVo> gardes = null;
		try {
			gardes = topicSubtiltleSourceVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gardes;
	}
}
