package com.hnfnu.zyw.website.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dao.system.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.website.INewsDao;
import com.hnfnu.zyw.dto.website.NewsDto;

@Service("ftl_newsService")
public class NewsServiceImpl implements INewsService {

	private static final int MAX_NEWS = 8;
	
	@Autowired
	@Qualifier("newsDao")
	public INewsDao newsDao;

    @Autowired
    @Qualifier("userDao")
    public IUserDao userDao;

	public Map<String, Object> getIndexNews() {
		Map<String, Object> root = new HashMap<String, Object>();
		String hql1 = "from NewsDto order by priority desc,id desc limit 0," + MAX_NEWS;
		List<NewsDto> newsList = null;
		try {
			newsList = newsDao.list(hql1);
			if( newsList.size() > MAX_NEWS ) {
				newsList = newsList.subList(0, MAX_NEWS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        if (newsList != null) {
            for (NewsDto n : newsList) {
                n.setContent(null);
            }
        }
        root.put("newsList", newsList);
		return root;
	}

    public NewsDto get(int id) {
        try {
            NewsDto n = newsDao.get(id);
            System.out.println("n"+n);
            System.out.println("userDao.get(n.getCreateUserId())"+userDao.get(n.getCreateUserId()));
            n.setCreateUserName(userDao.get(n.getCreateUserId()).getName());
            return n;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
