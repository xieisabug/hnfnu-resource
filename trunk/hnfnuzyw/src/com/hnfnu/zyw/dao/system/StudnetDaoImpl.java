package com.hnfnu.zyw.dao.system;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.system.StudentDto;

@Repository("studentDao")
public class StudnetDaoImpl extends BaseDao<StudentDto> implements
IStudentDao{

}
