package com.hnfnu.zyw.dao.resources;

import org.springframework.stereotype.Repository;

import com.hnfnu.zyw.dao.base.BaseDao;
import com.hnfnu.zyw.dto.resources.GradeDto;

@Repository("gradeDao")
public class GradeDaoImpl extends BaseDao<GradeDto> implements IGradeDao {

}
