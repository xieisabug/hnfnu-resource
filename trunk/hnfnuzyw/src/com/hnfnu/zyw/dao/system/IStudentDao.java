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
	/**
	 * 批量给用户修改密码
	 * @param users
	 * @return
	 */
	public boolean editManyPassword(ArrayList<StudentDto> users);
	
	/**
	 * 批量给学生重置资源币，不管学生原有的资源币
	 */
	public int setStudnetBalance(int count,String studentIds);
	
	/**
	 * 批量删除学生,0是删除不成功，1是成功
	 */
	public int deleteStudents(String studentIds);
	
}
