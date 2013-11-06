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
	 * ��ȡ��������ѧ��������Listװ��
	 * @return
	 */
	public List<StudentDto> list();
	/**
	 *��ȡ��������ѧ������Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * @return
	 */
	public Map<String, Object> listStu();
	
	/*
	 * ������ѧ����ֵ��Դ��
	 */
	public boolean addStudnetBalance(int count,String studentIds);
	

}
