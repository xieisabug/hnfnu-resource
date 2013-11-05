package com.hnfnu.zyw.service.system;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.system.TeacherDto;

public interface ITeacherService {
	public boolean add(TeacherDto teacher);

	public boolean delete(TeacherDto teacher);

	public boolean update(TeacherDto teacher);

	public TeacherDto load(TeacherDto teacher);

	
	/**
	 * 获取表中所有老师，是用List装的
	 * @return
	 */
	public List<TeacherDto> list();
	/**
	 *获取表中所有老师，用Map装，为了分页的需要加上Rows和Total
	 * @return
	 */
	public Map<String, Object> listTeach();
	
	
}
