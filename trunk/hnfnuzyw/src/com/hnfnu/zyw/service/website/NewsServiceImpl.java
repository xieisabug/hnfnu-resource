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
	public boolean add(NewsDto function) {
		try {
			newsDao.add(function);
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
	public boolean delete(NewsDto function) {
		try {
			newsDao.delete(function.getId());
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
	public boolean update(NewsDto function) {
		try {
			newsDao.update(function);
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
	public NewsDto load(NewsDto function) {
		try {
			return newsDao.load(function.getId());
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
		List<NewsDto> functions = null;
		try {
			functions = newsDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return functions;
	}

	/**
	 * �г����е�����
	 * @return �������������ŵ�Map
	 */
	public Map<String, Object> listFun() {
		String hql = "from NewsDto";
		Map<String, Object> functionList = new HashMap<String, Object>();
		List<NewsDto> l = null;
		
		try {
			l = newsDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		functionList.put("Rows", l);
		functionList.put("Total", l.size());
		return functionList;
	}
}
