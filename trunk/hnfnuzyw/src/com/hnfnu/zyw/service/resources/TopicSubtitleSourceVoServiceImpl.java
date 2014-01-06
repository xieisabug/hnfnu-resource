package com.hnfnu.zyw.service.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dao.resources.ITopicSubtitleSourceVoDao;
import com.hnfnu.zyw.vo.TopicSubtitleSourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("topicSubtitleSourceVoService")
public class TopicSubtitleSourceVoServiceImpl implements ITopicSubtitleSourceVoService {

	@Autowired
	@Qualifier("topicSubtitleSourceVoDao")
	public ITopicSubtitleSourceVoDao topicSubtitleSourceVoDao;

	public boolean add(TopicSubtitleSourceVo garde) {
		try {
			topicSubtitleSourceVoDao.add(garde);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			topicSubtitleSourceVoDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(TopicSubtitleSourceVo garde) {
		try {
			topicSubtitleSourceVoDao.update(garde);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public TopicSubtitleSourceVo load(int id) {
		try {
			return topicSubtitleSourceVoDao.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TopicSubtitleSourceVo> list() {
		String hql = "from TopicSubtitleSourceVo";
		List<TopicSubtitleSourceVo> gardes = null;
		try {
			gardes = topicSubtitleSourceVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gardes;
	}

	public Map<String, Object> listTopicSubtitleSourceVo(int id) {
		String hql = "from TopicSubtitleSourceVo where subtitleId="+id;
		Map<String, Object> gardeList = new HashMap<String, Object>();
		List<TopicSubtitleSourceVo> l = null;

		try {
			l = topicSubtitleSourceVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		gardeList.put("Rows", l);
		gardeList.put("Total", l.size());
		return gardeList;
	}

	public List<TopicSubtitleSourceVo> listBySubtileId(int subtitleId,int startIndex,int pageSize) {
		String hql = "from TopicSubtitleSourceVo where subtitleId="+subtitleId;
		List<TopicSubtitleSourceVo> gardes = null;
		try {
			gardes = topicSubtitleSourceVoDao.find(hql, startIndex, pageSize).getDatas();
					//queryForPage(hql, startIndex, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gardes;
	}
}
