package com.hnfnu.zyw.website.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.base.Pager;
import com.hnfnu.zyw.dao.resources.ITopicDao;
import com.hnfnu.zyw.dto.resources.TopicDto;
import com.hnfnu.zyw.website.utils.FreemarkerUtil;

@Service("ftl_topicService")
public class FtlTopicServiceImpl implements FtlITopicService {

	@Autowired
	@Qualifier("topicDao")
	private ITopicDao topicDao;
	
	@Scheduled(cron = "0 0 0 * * ?")
    @Async
	public void getTopics() {
		String hql = "from TopicDto";
		Map<String, Object> root = new HashMap<String, Object>();
		List<TopicDto> topics = null;
		try {
			topics = topicDao.list(hql);
			root.put("topics", topics);
			root.put("topic_size", topics.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
            FreemarkerUtil fu = new FreemarkerUtil();
            // 打印到输出台，以便于测试
            fu.print("topic/topic_source.ftl", root);
            // 输出到文件
//            System.out.println(filePath + "website\\");
            fu.fprint("topic/topic_source.ftl", root, IndexServiceImpl.FILE_PATH + "website\\",
                    "topic_source.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	/**
	 * 得到最热的前10个专题
	 */
	public List<TopicDto> getTenHotTopics() {
		String hql ="from TopicDto order by viewTimes desc"; 
		Pager<TopicDto> tPager;
		try {
			tPager = topicDao.find(hql, 0, 10);
			return tPager.getDatas();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
