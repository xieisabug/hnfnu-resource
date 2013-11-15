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
	 * ����һ��ͼƬ
	 * @param һ��ͼƬ����
	 * @return �ɹ�����true��ʧ�ܷ���false
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
	 * ɾ��һ��ͼƬ
	 * @param Ҫɾ����ͼƬ��id
	 * @return �ɹ�����true��ʧ�ܷ���false
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
	 * ����һ��ͼƬ
	 * @param �Ѿ����µ�ͼƬ�Ķ���
	 * @return �ɹ�����true��ʧ�ܷ���false
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
	 * ��ȡһ��ͼƬ
	 * @param ��ȡ��ͼƬ��id
	 * @return ���ض�ȡ��ͼƬ����
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
	 * ��ȡ����ͼƬ
	 * @return ��ȡ����ͼƬ����
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
	 * �г����е�ͼƬ
	 * @return ����������ͼƬ��Map
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
