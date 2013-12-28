package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ISourceCommentDao;
import com.hnfnu.zyw.dao.resources.ISourceCommentVoDao;
import com.hnfnu.zyw.dto.resources.SourceCommentDto;

@Service("sourceCommentService")
public class SourceCommentService implements ISourceCommentService{
	
	@Autowired
	@Qualifier("sourceCommentDao")
	public ISourceCommentDao sourceCommentDao;
	
	
	@Autowired
	@Qualifier("sourceCommentVoDao")
	public ISourceCommentVoDao sourceCommentVoDao;

	public boolean add(SourceCommentDto sourceComment) {
		try {
			sourceCommentDao.add(sourceComment);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			sourceCommentDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(SourceCommentDto sourceComment) {
		try {
			sourceCommentDao.update(sourceComment);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public SourceCommentDto load(int id) {
		try {
			return sourceCommentDao.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<SourceCommentDto> list() {
		String hql = "from SourceCommentDto";
		List<SourceCommentDto> sourceComments = null;
		try {
			sourceComments = sourceCommentDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sourceComments;
	}

	public List<Map<String, Object>> sourceCommentTree(int sourceId) {
		try {
			return sourceCommentVoDao.sourceCommentTree(sourceId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
