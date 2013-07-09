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
	 * ��ȡ�������й��ܣ�����Listװ��
	 * 
	 * @return
	 */
	public List<CourseDto> list();

	/**
	 *��ȡ�������й��ܣ���Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * 
	 * @return
	 */
	public Map<String, Object> listCourse();
}
