package com.hnfnu.zyw.dao.resources;

import com.hnfnu.zyw.dao.base.IBaseDao;
import com.hnfnu.zyw.dto.resources.CourseDto;

public interface ICourseDao extends IBaseDao<CourseDto> {

	/**
	 * ¸ù¾Ý¿Î³ÌidÉ¾³ý¸Ã¿Î³ÌµÄÐÅÏ¢£¬Í¬Ê±£¨ÊÂÎñ´¦Àí£©É¾³ý¸Ã¿Î³ÌÏÂµÄËùÓÐ×ÊÔ´
	 * @return
	 */
	public boolean deleteCourseAndSources(int courseId);
	
}
