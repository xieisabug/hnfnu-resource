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
	 * 增加一个老师
	 * @param 一个老师对象
	 * @return 成功返回true，失败返回false
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
	 * 删除一个老师
	 * @param 要删除的老师的id
	 * @return 成功返回true，失败返回false
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
	 * 更新一个老师
	 * @param 已经更新的老师的对象
	 * @return 成功返回true，失败返回false
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
	 * 读取一个老师
	 * @param 读取的老师的id
	 * @return 返回读取的老师对象
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
	 * 获取所有老师
	 * @return 获取到的老师集合
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
	 * 列出所有的老师
	 * @return 保存了所有老师的Map
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
