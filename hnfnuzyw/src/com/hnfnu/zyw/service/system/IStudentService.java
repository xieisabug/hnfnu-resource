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
	
	/*
	 * 批量给学生充值资源币
	 */
	public int addStudnetBalance(int count,String studentIds);
	
	

	/*
	 * 解析excel表批量给学生注册
	 */
	public Map<String, Object> addStudnets(String url);
	
	//public StudentDto getStudent(String sql);
	/**
	 * 验证学生用户是否存在
	 * @param username
	 * @return
	 */
	public boolean validateStudent(String username);
	/**
	 * 批量给学生修改密码
	 * @param users
	 * @return
	 */
	public boolean editManyPassword(String studentIds,String newPassword);
	
	/**
	 * 批量给学生重置资源币，不管学生原有的资源币
	 */
	public int setStudnetBalance(int count,String studentIds);
	
	/**
	 * 批量删除学生,0是删除不成功，1是成功
	 */
	public int deleteStudents(String studentIds);

}
