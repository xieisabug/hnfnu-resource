package com.hnfnu.zyw.service.website;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.website.INewsDao;
import com.hnfnu.zyw.dto.website.NewsDto;
import com.hnfnu.zyw.utils.FileUtils;
import com.hnfnu.zyw.utils.RegexUtil;

@Service("newsService")
public class NewsServiceImpl implements INewsService {

	private static final String UEDITOR_FILE = "F:/workspaces/hnfnu-resource/trunk/hnfnuzyw/WebRoot/ueditor/jsp/upload/";
	@Autowired
	@Qualifier("newsDao")
	public INewsDao newsDao;

	/**
	 * 增加一个新闻
	 * @param 一个新闻对象
	 * @return 成功返回true，失败返回false
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
	 * 删除一个新闻
	 * @param 要删除的新闻的id
	 * @return 成功返回true，失败返回false
	 */
	public boolean delete(NewsDto news) {
		try {
			List<String> a = RegexUtil.findUploadFilesATagHref(news.getContent());
			for(int i = 0;i < a.size();i++){
				String herf = a.get(i);
				herf = herf.replace("\\", "\\\\");
				FileUtils.deleteOneFile(UEDITOR_FILE+herf);
			}
			newsDao.delete(news.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 更新一个新闻
	 * @param 已经更新的新闻的对象
	 * @return 成功返回true，失败返回false
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
	 * 读取一个新闻
	 * @param 读取的新闻的id
	 * @return 返回读取的新闻对象
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
	 * 获取所有新闻
	 * @return 获取到的新闻集合
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
	 * 列出所有的新闻
	 * @return 保存了所有新闻的Map
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
