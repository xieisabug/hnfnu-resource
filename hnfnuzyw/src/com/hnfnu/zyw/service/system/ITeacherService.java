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
	 * ��ȡ����������ʦ������Listװ��
	 * @return
	 */
	public List<TeacherDto> list();
	/**
	 *��ȡ����������ʦ����Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * @return
	 */
	public Map<String, Object> listTeach();
	
	
}
