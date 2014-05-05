package com.hnfnu.zyw.dao.resources;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.resources.CourseDto;

public interface ICourseDao extends IBaseDao<CourseDto> {

	/**
	 * 根据课程id删除该课程的信息，同时（事务处理）删除该课程下的所有资源
	 * @return
	 */
	public boolean deleteCourseAndSources(int courseId);
	
}
