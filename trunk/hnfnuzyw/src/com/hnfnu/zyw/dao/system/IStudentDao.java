package com.hnfnu.zyw.dao.system;

import java.util.ArrayList;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.StudentDto;

public interface IStudentDao  extends IBaseDao<StudentDto>{

	/**
	 * ÅúÁ¿¸øÑ§Éú³äÖµ×ÊÔ´±Ò
	 * @param count
	 * @param studentIds
	 * @return
	 */
	public int addStudnetBalance(int count,String studentIds);
	
	/**
	 * ÅúÁ¿×¢²áÑ§Éú
	 * @param count
	 * @param studentIds
	 * @return
	 */
	public boolean addStudnets(ArrayList<StudentDto> students);
	/**
	 * Í¨¹ýÈÎºÎÒ»¸ö×Ö¶Î»ñÈ¡Ò»¸öÑ§ÉúÐÅÏ¢
	 * @param hql
	 * @return
	 */
	
	public StudentDto getStudent(String hql);
	
}
