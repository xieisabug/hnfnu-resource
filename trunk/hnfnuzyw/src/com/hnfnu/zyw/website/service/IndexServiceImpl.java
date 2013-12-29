package com.hnfnu.zyw.website.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ITopicDao;
import com.hnfnu.zyw.dao.website.IPicturesDao;
import com.hnfnu.zyw.dto.resources.TopicDto;

@Service("ftl_indexService")
public class IndexServiceImpl implements IIndexService {
	
	
	@Autowired
	@Qualifier("picturesDao")
	private IPicturesDao picturesDao; 
	
	@Autowired
	@Qualifier("topicDao")
	private ITopicDao topicDao; 

	public Map<String, Object> getPictures() {
		String hql = "from PicturesDto where display=1";
		Map<String, Object> p = new HashMap<String, Object>();
		try {
			p.put("pictures", picturesDao.list(hql)) ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return p;
	}

	public Map<String, Object> getTopics() {
		String hql = "from TopicDto order by id desc";
		Map<String, Object> p = new HashMap<String, Object>();
		try {
			List<TopicDto> t = topicDao.list(hql);
			p.put("topics", t) ;
			p.put("topicSize", t.size());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return p;
	}

	
	
	

}
