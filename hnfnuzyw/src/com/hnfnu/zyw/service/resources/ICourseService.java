package com.hnfnu.zyw.service.resources;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.resources.CourseDto;

public interface ICourseService {

	public boolean add(CourseDto course);

	public boolean delete(int id);

	public boolean update(CourseDto course);

	public CourseDto load(int id);

	/**
	 * 获取表中所有功能，是用List装的
	 * 
	 * @return
	 */
	public List<CourseDto> list();

	/**
	 *获取表中所有功能，用Map装，为了分页的需要加上Rows和Total
	 * 
	 * @return
	 */
	public Map<String, Object> listCourse();
}
