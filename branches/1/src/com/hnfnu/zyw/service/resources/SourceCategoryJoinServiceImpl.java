package com.hnfnu.zyw.service.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ISourceCategoryJoinDao;
import com.hnfnu.zyw.dto.resources.SourceCategoryJoinDto;

@Service("sourceCategoryJoinService")
public class SourceCategoryJoinServiceImpl implements ISourceCategoryJoinService{

	@Autowired
	@Qualifier("sourceCategoryJoinDao")
	public ISourceCategoryJoinDao sourceCategoryJoinDao;

	public boolean add(SourceCategoryJoinDto sourceCategoryJoin) {
		try {
			sourceCategoryJoinDao.add(sourceCategoryJoin);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			sourceCategoryJoinDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(SourceCategoryJoinDto sourceCategoryJoin) {
		try {
			sourceCategoryJoinDao.update(sourceCategoryJoin);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public SourceCategoryJoinDto load(int id) {
		try {
			return sourceCategoryJoinDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<SourceCategoryJoinDto> list() {
		String hql = "from SourceCategoryJoinDto";
		List<SourceCategoryJoinDto> sourceCategoryJoins = null;
		try {
			sourceCategoryJoins = sourceCategoryJoinDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sourceCategoryJoins;
	}
	
}
