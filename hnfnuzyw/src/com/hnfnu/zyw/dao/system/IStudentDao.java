package com.hnfnu.zyw.dao.system;

import java.util.ArrayList;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.StudentDto;

public interface IStudentDao  extends IBaseDao<StudentDto>{

	/**
	 * 批量给学生充值资源币
	 * @param count
	 * @param studentIds
	 * @return
	 */
	public int addStudnetBalance(int count,String studentIds);
	
	/**
	 * 批量注册学生
	 * @param count
	 * @param studentIds
	 * @return
	 */
	public boolean addStudnets(ArrayList<StudentDto> students);
	/**
	 * 通过任何一个字段获取一个学生信息
	 * @param hql
	 * @return
	 */
	
	public StudentDto getStudent(String hql);
	
}
