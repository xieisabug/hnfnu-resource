package com.hnfnu.zyw.dao.system;

import java.util.ArrayList;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.StudentDto;

public interface IStudentDao  extends IBaseDao<StudentDto>{

	/**
	 * ������ѧ����ֵ��Դ��
	 * @param count
	 * @param studentIds
	 * @return
	 */
	public int addStudnetBalance(int count,String studentIds);
	
	/**
	 * ����ע��ѧ��
	 * @param count
	 * @param studentIds
	 * @return
	 */
	public boolean addStudnets(ArrayList<StudentDto> students);
	
	public StudentDto getStudent(String hql);
	
}
