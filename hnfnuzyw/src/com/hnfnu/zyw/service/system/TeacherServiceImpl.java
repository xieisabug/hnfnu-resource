package com.hnfnu.zyw.service.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.system.ITeacherDao;
import com.hnfnu.zyw.dto.system.TeacherDto;

@Service("teacherService")
public class TeacherServiceImpl implements ITeacherService{

	@Autowired
	@Qualifier("teacherDao")
	public ITeacherDao teacherDao;

	/**
	 * ����һ����ʦ
	 * @param һ����ʦ����
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean add(TeacherDto teacher) {
		try {
			teacherDao.add(teacher);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ɾ��һ����ʦ
	 * @param Ҫɾ������ʦ��id
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean delete(TeacherDto teacher) {
		try {
			teacherDao.delete(teacher.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ����һ����ʦ
	 * @param �Ѿ����µ���ʦ�Ķ���
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean update(TeacherDto teacher) {
		try {
			teacherDao.update(teacher);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ��ȡһ����ʦ
	 * @param ��ȡ����ʦ��id
	 * @return ���ض�ȡ����ʦ����
	 */
	public TeacherDto load(TeacherDto teacher) {
		try {
			return teacherDao.load(teacher.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��ȡ������ʦ
	 * @return ��ȡ������ʦ����
	 */
	public List<TeacherDto> list() {
		String hql = "from TeacherDto";
		List<TeacherDto> teachers = null;
		try {
			teachers = teacherDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachers;
	}

	/**
	 * �г����е���ʦ
	 * @return ������������ʦ��Map
	 */
	public Map<String, Object> listTeach() {
		String hql = "from TeacherDto";
		Map<String, Object> teacherList = new HashMap<String, Object>();
		List<TeacherDto> l = null;
		
		try {
			l = teacherDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		teacherList.put("Rows", l);
		teacherList.put("Total", l.size());
		return teacherList;
	}
}
