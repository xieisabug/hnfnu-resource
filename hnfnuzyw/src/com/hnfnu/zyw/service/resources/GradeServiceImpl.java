package com.hnfnu.zyw.service.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.IGradeDao;
import com.hnfnu.zyw.dao.resources.IGradeGroupVoDao;
import com.hnfnu.zyw.dto.resources.GradeDto;
import com.hnfnu.zyw.vo.GradeGroupVo;

@Service("gradeService")
public class GradeServiceImpl implements IGradeService{
	@Autowired
	@Qualifier("gradeDao")
	public IGradeDao gradeDao;
	
	@Autowired
	@Qualifier("gradeGroupVoDao")
	public IGradeGroupVoDao gradeGroupVoDao;

	public boolean add(GradeDto garde) {
		try {
			gradeDao.add(garde);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			gradeDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(GradeDto garde) {
		try {
			gradeDao.update(garde);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public GradeDto load(int id) {
		try {
			return gradeDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<GradeDto> list() {
		String hql = "from GradeDto";
		List<GradeDto> gardes = null;
		try {
			gardes = gradeDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gardes;
	}

	public Map<String, Object> listGrade() {
		String hql = "from GradeGroupVo";
		Map<String, Object> gardeList = new HashMap<String, Object>();
		List<GradeGroupVo> l = null;

		try {
			l = gradeGroupVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		gardeList.put("Rows", l);
		gardeList.put("Total", l.size());
		return gardeList;
	}

	public List<GradeGroupVo> listGradeByGroupId(int groupId) {
		String hql = "from GradeGroupVo where groupId="+groupId;
		List<GradeGroupVo> gardes = null;
		try {
			gardes = gradeGroupVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gardes;
	}

}
