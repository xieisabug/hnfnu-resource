package com.hnfnu.zyw.service.website;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.website.INewsDao;
import com.hnfnu.zyw.dto.website.NewsDto;

@Service("newsService")
public class NewsServiceImpl implements INewsService {

	@Autowired
	@Qualifier("newsDao")
	public INewsDao newsDao;

	/**
	 * ����һ������
	 * @param һ�����Ŷ���
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean add(NewsDto news) {
		try {
			newsDao.add(news);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ɾ��һ������
	 * @param Ҫɾ�������ŵ�id
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean delete(NewsDto news) {
		try {
			newsDao.delete(news.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ����һ������
	 * @param �Ѿ����µ����ŵĶ���
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean update(NewsDto news) {
		try {
			newsDao.update(news);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ��ȡһ������
	 * @param ��ȡ�����ŵ�id
	 * @return ���ض�ȡ�����Ŷ���
	 */
	public NewsDto load(NewsDto news) {
		try {
			return newsDao.get(news.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ȡ��������
	 * @return ��ȡ�������ż���
	 */
	public List<NewsDto> list() {
		String hql = "from NewsDto";
		List<NewsDto> newss = null;
		try {
			newss = newsDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newss;
	}

	/**
	 * �г����е�����
	 * @return �������������ŵ�Map
	 */
	public Map<String, Object> listNews() {
		String hql = "from NewsDto";
		Map<String, Object> newsList = new HashMap<String, Object>();
		List<NewsDto> l = null;
		
		try {
			l = newsDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		newsList.put("Rows", l);
		newsList.put("Total", l.size());
		return newsList;
	}
}
