package com.hnfnu.zyw.service.resources;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ISubjectDao;
import com.hnfnu.zyw.dao.resources.ISubjectGroupVoDao;
import com.hnfnu.zyw.dto.resources.SubjectDto;
import com.hnfnu.zyw.utils.FileUtils;
import com.hnfnu.zyw.utils.Url;
import com.hnfnu.zyw.vo.SubjectGroupVo;

@Service("subjectService")
public class SubjectServiceImpl implements ISubjectService {

	@Autowired
	@Qualifier("subjectDao")
	public ISubjectDao subjectDao;

	@Autowired
	@Qualifier("subjectGroupVoDao")
	public ISubjectGroupVoDao subjectGroupVoDao;

	public boolean add(SubjectDto subject) {
		try {
			subjectDao.add(subject);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(String url, int id) {
		try {
			String filePath = ServletActionContext.getServletContext()
					.getRealPath("/");
			filePath = filePath + "uploads\\subject\\image\\" + url;
			if (FileUtils.deleteOneFile(filePath)) {
				subjectDao.delete(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(SubjectDto subject) {
		try {
			subjectDao.update(subject);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public SubjectDto load(int id) {
		try {
			return subjectDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<SubjectDto> list() {
		String hql = "from SubjectDto";
		List<SubjectDto> subjects = null;
		try {
			subjects = subjectDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjects;
	}

	public Map<String, Object> listSub() {
		String hql = "from SubjectGroupVo  order by isDisplay desc,id desc";
		Map<String, Object> subjectList = new HashMap<String, Object>();
		List<SubjectGroupVo> l = null;

		try {
			l = subjectGroupVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		subjectList.put("Rows", l);
		subjectList.put("Total", l.size());
		return subjectList;
	}

	public List<SubjectGroupVo> listSubjectByGroupId(int groupId) {
		String hql = "from SubjectGroupVo where groupId=" + groupId
				+ " order by isDisplay desc,id desc";
		List<SubjectGroupVo> subjects = null;
		try {
			subjects = subjectGroupVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjects;
	}

	public List<SubjectGroupVo> haveSubjectList() {
		String hql = "FROM SubjectGroupVo where id in(select subjectId from SourceVo)  order by isDisplay desc,id desc";
		List<SubjectGroupVo> l = null;
		try {
			l = subjectGroupVoDao.subjectList(hql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return l;
	}

	@Override
	public boolean clearImage() {
		String hql = "from SubjectDto";
		List<SubjectDto> s = null;
		String filePath = Url.realPath;
		filePath += "uploads\\subject\\image";
		HashSet<String> set = new HashSet<String>();
		try {
			s = subjectDao.list(hql);
			for (int i = 0; i < s.size(); i++) {
				set.add(s.get(i).getImageUrl());
			}
			File file = new File(filePath);
			String images[];
			images = file.list();
			for (int i = 0; i < images.length; i++) {
				//System.out.println(images[i]);
				//如果数据库不存在这个图片的记录则删除该图片
				if(!set.contains(images[i])&&!"default_subject.png".equals(images[i])){
					FileUtils.delete(filePath+"\\"+images[i]);
					//System.out.println(filePath+"\\"+images[i]+"已经删除了");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
