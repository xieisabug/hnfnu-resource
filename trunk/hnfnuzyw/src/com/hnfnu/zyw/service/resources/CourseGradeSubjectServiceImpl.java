package com.hnfnu.zyw.service.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ICourseGradeSubjectDao;
import com.hnfnu.zyw.vo.CourseGradeSubjectVo;

@Service("courseGradeSubjectService")
public class CourseGradeSubjectServiceImpl  implements ICourseGradeSubjectService{

	@Autowired
	@Qualifier("courseGradeSubjectDao")
	public ICourseGradeSubjectDao courseGradeSubjectDao;
	
	

	public Map<String, Object> listAllCourseGradeSubject() {
		String hql = "from CourseGradeSubjectVo";
		
		Map<String, Object> courseGradeSubjectList = new HashMap<String, Object>();
		List<CourseGradeSubjectVo> l = null;

		try {
			l = courseGradeSubjectDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		courseGradeSubjectList.put("Rows", l);
		courseGradeSubjectList.put("Total", l.size());
		return courseGradeSubjectList;
	}
}
