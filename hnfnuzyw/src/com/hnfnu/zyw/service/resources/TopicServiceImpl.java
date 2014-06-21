package com.hnfnu.zyw.service.resources;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ITopicDao;
import com.hnfnu.zyw.dto.resources.TopicDto;
import com.hnfnu.zyw.utils.FileUtils;
import com.hnfnu.zyw.utils.Url;

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

	public boolean delete(String url,int id) {
		try {
			String filePath = ServletActionContext.getServletContext().getRealPath("/");
			filePath = filePath + "uploads\\topic\\image\\"+url;
			if (FileUtils.deleteOneFile(filePath)) {
				topicDao.delete(id);
			}
			
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

	public boolean topicAddViewTimes(int id) {
		TopicDto t = null;
		try {
			t = topicDao.get(id);
			t.setViewTimes(t.getViewTimes()+1);
			topicDao.updateByTran(id, t.getViewTimes());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean clearTopicImage() {
		String hql = "from TopicDto";
		List<TopicDto> s = null;
		String filePath = Url.realPath;
		filePath += "uploads\\topic\\image";
		HashSet<String> set = new HashSet<String>();
		try {
			s = topicDao.list(hql);
			for (int i = 0; i < s.size(); i++) {
				set.add(s.get(i).getImageUrl());
			}
			System.out.println("filePath"+filePath);
			File file = new File(filePath);
			String images[];
			images = file.list();
			for (int i = 0; i < images.length; i++) {
				//System.out.println(images[i]);
				//如果数据库不存在这个图片的记录则删除该图片
				if(!set.contains(images[i]) && !"default_topic.png".equals(images[i])){
					FileUtils.delete(filePath+"\\"+images[i]);
					//System.out.println(filePath+"\\"+images[i]+"已经删除了");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
