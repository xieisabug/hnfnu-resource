package com.hnfnu.zyw.website.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.website.IPicturesDao;
import com.hnfnu.zyw.dto.website.PicturesDto;

@Service("ftl_picturesService")
public class PicturesServiceImpl implements IPicturesService {

	//private static final int MAX_NEWS = 8;
	
	@Autowired
	@Qualifier("picturesDao")
	public IPicturesDao picturesDao;
	
	public Map<String, Object> getIndexPictures() {
		Map<String, Object> root = new HashMap<String, Object>();
		String hql1 = "from PicturesDto where display=1";
		List<PicturesDto> picturesList = null;
		try {
			picturesList = picturesDao.list(hql1);
			for(PicturesDto p : picturesList) {
				String src = p.getSrc();
				src = src.substring(src.indexOf("uploads"));
				src = "..\\" + src;
				p.setSrc(src);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		root.put("picturesList", picturesList);
		return root;
	}


}
