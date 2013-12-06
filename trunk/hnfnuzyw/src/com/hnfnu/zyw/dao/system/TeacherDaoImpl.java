package com.hnfnu.zyw.dao.system;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.system.TeacherDto;

@Repository("teacherDao")
public class TeacherDaoImpl extends BaseDao<TeacherDto> implements
ITeacherDao{

}
