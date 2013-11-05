package com.hnfnu.zyw.service.system;

import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.system.StudentDto;

public interface IStudentService {
	
	public boolean add(StudentDto student);

	public boolean delete(StudentDto student);

	public boolean update(StudentDto student);

	public StudentDto load(StudentDto student);

	
	/**
	 * 获取表中所有学生，是用List装的
	 * @return
	 */
	public List<StudentDto> list();
	/**
	 *获取表中所有学生，用Map装，为了分页的需要加上Rows和Total
	 * @return
	 */
	public Map<String, Object> listStu();
	

}
