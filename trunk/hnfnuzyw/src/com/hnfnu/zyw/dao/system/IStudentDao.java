package com.hnfnu.zyw.dao.system;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.system.StudentDto;

public interface IStudentDao  extends IBaseDao<StudentDto>{

	public boolean addStudnetBalance(int count,String studentIds);
}
