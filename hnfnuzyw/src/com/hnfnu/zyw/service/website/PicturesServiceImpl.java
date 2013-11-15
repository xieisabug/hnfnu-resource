package com.hnfnu.zyw.service.website;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.website.IPicturesDao;
import com.hnfnu.zyw.dto.website.PicturesDto;

@Service("picturesService")
public class PicturesServiceImpl implements IPicturesService{

	@Autowired
	@Qualifier("picturesDao")
	public IPicturesDao picturesDao;
	
	
	/**
	 * 增加一个图片
	 * @param 一个图片对象
	 * @return 成功返回true，失败返回false
	 */
	public boolean add(PicturesDto pictures) {
		try {
			picturesDao.add(pictures);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 删除一个图片
	 * @param 要删除的图片的id
	 * @return 成功返回true，失败返回false
	 */
	public boolean delete(PicturesDto pictures) {
		try {
			picturesDao.delete(pictures.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 更新一个图片
	 * @param 已经更新的图片的对象
	 * @return 成功返回true，失败返回false
	 */
	public boolean update(PicturesDto pictures) {
		try {
			picturesDao.update(pictures);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 读取一个图片
	 * @param 读取的图片的id
	 * @return 返回读取的图片对象
	 */
	public PicturesDto load(PicturesDto pictures) {
		try {
			return picturesDao.get(pictures.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取所有图片
	 * @return 获取到的图片集合
	 */
	public List<PicturesDto> list() {
		String hql = "from PicturesDto";
		List<PicturesDto> pictures = null;
		try {
			pictures = picturesDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pictures;
	}

	/**
	 * 列出所有的图片
	 * @return 保存了所有图片的Map
	 */
	public Map<String, Object> listPictures() {
		String hql = "from PicturesDto";
		Map<String, Object> picturesList = new HashMap<String, Object>();
		List<PicturesDto> l = null;
		
		try {
			l = picturesDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		picturesList.put("Rows", l);
		picturesList.put("Total", l.size());
		return picturesList;
	}
}
