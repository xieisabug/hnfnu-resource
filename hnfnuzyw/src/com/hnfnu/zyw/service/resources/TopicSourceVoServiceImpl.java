package com.hnfnu.zyw.service.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Map<String, Object> listBySubTitleId(int id){
		Map<String, Object> t = new HashMap<String, Object>();
		List<TopicSourceVo> l = null;
		String hql = "from TopicSourceVo where subtitleId="+id;
		try {
			l = topicSourceVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		t.put("Rows", l);
		t.put("Total", l.size());
		return t;
	}

	public List<TopicSourceVo> listBySubTitleId(int subTitleId, int startIndex,int pageSize) {
		String hql = "from TopicSourceVo where subtitleId="+subTitleId;
		List<TopicSourceVo> l = null;
		try {
			l = topicSourceVoDao.queryForPage(hql, startIndex, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
}
