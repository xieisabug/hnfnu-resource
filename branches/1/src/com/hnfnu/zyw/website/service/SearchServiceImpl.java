package com.hnfnu.zyw.website.service;

import com.hnfnu.zyw.dao.base.Pager;
import com.hnfnu.zyw.dao.resources.ISourceVoDao;
import com.hnfnu.zyw.dao.resources.ITopicDao;
import com.hnfnu.zyw.dao.resources.ITopicSubtitleSourceVoDao;
import com.hnfnu.zyw.dto.resources.TopicDto;
import com.hnfnu.zyw.vo.SourceVo;
import com.hnfnu.zyw.vo.TopicSubtitleSourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public Map<String, Object> listSource(String keyWord, int page, int pageSize) {
        Map<String, Object> ret = new HashMap<>();

        String hql = "from SourceVo WHERE keyWords like '%" + keyWord + "%'";
        String hql2 = "from TopicSubtitleSourceVo WHERE keyWords like '%" + keyWord + "%'";
        Pager<SourceVo> sourceVoPager;
        Pager<TopicSubtitleSourceVo> topicSubtitleSourceVoPager;
        try {
            int pageOffset = (page - 1) * pageSize;
            sourceVoPager = sourceVoDao.find(hql, pageOffset, pageSize);
            ret.put("sourceVoPager", sourceVoPager);
            topicSubtitleSourceVoPager = topicSubtitleSourceVoDao.find(hql2,pageOffset,pageSize);
            ret.put("topicSubtitleSourceVoPager", topicSubtitleSourceVoPager);
            ret.put("keyWord",keyWord);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return ret;
    }

    @Override
    public Map<String, Object> listTopic(String keyWord, int page, int pageSize) {
        Map<String, Object> ret = new HashMap<>();
        String hql = "FROM TopicDto WHERE keyWords like '%" + keyWord + "%'";
        Pager<TopicDto> topicDtoPager;
        try {
            int pageOffset = (page - 1) * pageSize;
            topicDtoPager = topicDao.find(hql, pageOffset, pageSize);
            ret.put("topicDtoPager",topicDtoPager);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return ret;
    }

}
