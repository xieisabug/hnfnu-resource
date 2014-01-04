package com.hnfnu.zyw.website.service;

import com.hnfnu.zyw.dao.resources.ISourceVoDao;
import com.hnfnu.zyw.dao.resources.ITopicDao;
import com.hnfnu.zyw.dao.resources.ITopicSubtitleDao;
import com.hnfnu.zyw.dao.resources.ITopicSubtitleSourceVoDao;
import com.hnfnu.zyw.dao.website.INewsDao;
import com.hnfnu.zyw.dto.website.NewsDto;
import com.hnfnu.zyw.vo.SourceVo;
import com.hnfnu.zyw.vo.TopicSubtitleSourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("searchService")
public class SearchServiceImpl implements ISearchService {

    @Autowired
    @Qualifier("sourceVoDao")
    private ISourceVoDao sourceVoDao;
    @Autowired
    @Qualifier("topicSubtitleSourceVoDao")
    private ITopicSubtitleSourceVoDao topicSubtitleSourceVoDao;
    @Autowired
    @Qualifier("topicDao")
    private ITopicDao topicDao;

    @Override
    public Map<String, Object> listSource(String keyWord) {
        Map<String, Object> ret = new HashMap<String, Object>();

        String hql = "FROM SourceVo WHERE keyWords like '%" + keyWord + "%'";
        String hql2 = "FROM TopicSubtitleSourceVo WHERE keyWords like '%" + keyWord + "%'";
        System.out.println(hql);
        try {
            List<SourceVo> sourceVoList = sourceVoDao.list(hql);
            ret.put("sourceVoList", sourceVoList);

            List<TopicSubtitleSourceVo> topicSubtitleSourceVoList = topicSubtitleSourceVoDao.list(hql2);
            ret.put("topicSubtitleSourceVoList", topicSubtitleSourceVoList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return ret;
    }

    @Override
    public Map<String, Object> listTopic(String keyWord) {

        return null;
    }

}
