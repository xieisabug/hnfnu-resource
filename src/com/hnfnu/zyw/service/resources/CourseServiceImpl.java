package com.hnfnu.zyw.service.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ICourseDao;
import com.hnfnu.zyw.dto.resources.CourseDto;

@Service("courseService")
public class CourseServiceImpl implements ICourseService {

	@Autowired
	@Qualifier("courseDao")
	public ICourseDao courseDao;

	public boolean add(CourseDto course) {
		try {
			courseDao.add(course);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			courseDao.deleteCourseAndSources(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(CourseDto course) {
		try {
			courseDao.update(course);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public CourseDto load(int id) {
		try {
			return courseDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CourseDto> list() {
		String hql = "from CourseDto";
		List<CourseDto> courses = null;
		try {
			courses = courseDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	public Map<String, Object> listCourse() {
		String hql = "from CourseDto";
		Map<String, Object> courseList = new HashMap<String, Object>();
		List<CourseDto> l = null;

		try {
			l = courseDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		courseList.put("Rows", l);
		courseList.put("Total", l.size());
		return courseList;
	}
}
