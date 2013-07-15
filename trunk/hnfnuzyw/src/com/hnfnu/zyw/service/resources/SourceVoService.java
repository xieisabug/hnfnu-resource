package com.hnfnu.zyw.service.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ISourceVoDao;
import com.hnfnu.zyw.vo.SourceVo;

@Service("sourceVoService")
public class SourceVoService implements ISourceVoService {
	@Autowired
	@Qualifier("sourceVoDao")
	public ISourceVoDao sourceVoDao;

	public SourceVo load(int id) {
		try {
			return sourceVoDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<SourceVo> list() {
		String hql = "from SourceVo";
		List<SourceVo> sources = null;
		try {
			sources = sourceVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sources;
	}

	public Map<String, Object> listSourceVo() {
		String hql = "from SourceVo";
		Map<String, Object> sourceVoList = new HashMap<String, Object>();
		List<SourceVo> l = null;

		try {
			l = sourceVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sourceVoList.put("Rows", l);
		sourceVoList.put("Total", l.size());
		return sourceVoList;
	}

	public Map<String, Object> listSourceVo(int courseId, int categoryId) {
		
		String hql = "from SourceVo where courseId="+courseId;
		if(categoryId > 0){
			hql += " and categoryId ="+categoryId;
		}
		
		Map<String, Object> sourceVoList = new HashMap<String, Object>();
		List<SourceVo> l = null;

		try {
			l = sourceVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sourceVoList.put("Rows", l);
		sourceVoList.put("Total", l.size());
		return sourceVoList;
	}
}
