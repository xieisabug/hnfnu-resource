package com.hnfnu.zyw.service.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ISourceMoreVoDao;
import com.hnfnu.zyw.dao.resources.ISourceVoDao;
import com.hnfnu.zyw.vo.SourceMoreVo;
import com.hnfnu.zyw.vo.SourceVo;

@Service("sourceVoService")
public class SourceVoService implements ISourceVoService {
	@Autowired
	@Qualifier("sourceVoDao")
	public ISourceVoDao sourceVoDao;

	@Autowired
	@Qualifier("sourceMoreVoDao")
	public ISourceMoreVoDao sourceMoreVoDao;

	public SourceVo load(int id) {
		try {
			return sourceVoDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<SourceVo> list() {
		String hql = "from SourceVo";
		List<SourceVo> sources = null;
		try {
			sources = sourceVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sources;
	}

	public Map<String, Object> listSourceVo() {
		String hql = "from SourceVo";
		Map<String, Object> sourceVoList = new HashMap<String, Object>();
		List<SourceVo> l = null;

		try {
			l = sourceVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sourceVoList.put("Rows", l);
		sourceVoList.put("Total", l.size());
		return sourceVoList;
	}

	public Map<String, Object> listSourceVo(int courseId, int categoryId) {

		String hql = "from SourceMoreVo where courseId=" + courseId;
		if (categoryId > 0) {
			hql += " and categoryId =" + categoryId;
		}

		Map<String, Object> sourceMoreVoList = new HashMap<String, Object>();
		List<SourceMoreVo> l = null;

		try {
			l = sourceMoreVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sourceMoreVoList.put("Rows", l);
		sourceMoreVoList.put("Total", l.size());
		return sourceMoreVoList;
	}

	public List<Map<String, Object>> allTree() {
		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();// 用来返回的map
		Map<String, Object> grade = null;// 用来存放年级的map
		List<Map<String, Object>> subjectList = null;
		Map<String, Object> subject = null;// 用来存放科目的map
		List<Map<String, Object>> courseList = new ArrayList<Map<String, Object>>();
		Map<String, Object> course = null;
		List<Map<String, String>> categoryList = new ArrayList<Map<String, String>>();
		Map<String, String> category = null;
		String voHQL = "FROM SourceVo ORDER BY gradeId,subjectId,courseId ASC";
		try {
			List<SourceVo> l = sourceVoDao.list(voHQL);
			int gradeId = 0;// 当前的年级id
			int subjectId = 0;// 当前的科目id
			int courseId = 0;// 当前课程id
			String categoryContain = "";// 用于保存已经加入过的类别
			for (int i = 0; i < l.size(); i++) {
				SourceVo sv = l.get(i);
//System.out.println(sv.toString());
				// 如果当前的年级和所处理的数据的年级不相同，说明已经换了年级了，
				// 需要新建一个map,同时重置subjectId，防止错误。
				// 重新生成科目列表，确保科目列表变为空，并且加入基础数据。
				if (sv.getGradeId() != gradeId) {
					// 是第一次进来就不加了,因为没有初始化,第二次加进去，加的是之前一轮的
					if (i != 0 && grade.get("name")!=null) {
						course.put("children", categoryList);
						courseList.add(course);
						subject.put("children", courseList);
						subjectList.add(subject);
						grade.put("children", subjectList);
						ret.add(grade);
//System.out.println("ret:" + ret.toString());
					}
					gradeId = sv.getGradeId();
					subjectId = 0;
					grade = new HashMap<String, Object>();// 重置年级的信息
					subjectList = new ArrayList<Map<String, Object>>();// 重置科目的信息
					subject = new HashMap<String, Object>();
					courseList = new ArrayList<Map<String, Object>>();
					course = new HashMap<String, Object>();
					categoryList = new ArrayList<Map<String, String>>();
					// 基础信息加入
					grade.put("id", sv.getGradeId());
					grade.put("name", sv.getGradeName());
					
//System.out.println(grade.toString());
				}
				// 如果当前的年级是相同的年级，则要进一步判断科目是否是相同
				// 如果科目不相同，则说明在相同年级下更换了科目，要将科目加入到
				// 科目列表
				if (sv.getSubjectId() != subjectId) {
					// 第一次不加，原理同上面
					if (i != 0 && subject.get("name")!=null) {
						course.put("children", categoryList);
						courseList.add(course);
						subject.put("children", courseList);
						subjectList.add(subject);
//System.out.println("subjectList:" + subjectList.toString());
					}
					// 进入一个新的科目要重置课程列表
					subjectId = sv.getSubjectId();
					courseId = 0;
					courseList = new ArrayList<Map<String, Object>>();
					subject = new HashMap<String, Object>();
					course = new HashMap<String, Object>();
					categoryList = new ArrayList<Map<String, String>>();
					subject.put("id", sv.getSourceId());
					subject.put("name", sv.getSubjectName());
					
//System.out.println(subject.toString());
				}
				// 如果当前的课程不是相同的课程，则创建新的类别表，并存入
				// 当前课程的基本信息
				if (courseId != sv.getCourseId()) {
					if (i != 0 && course.get("name")!=null) {
						course.put("children", categoryList);
						courseList.add(course);
//System.out.println("courseList:" + courseList.toString());
					}
					courseId = sv.getCourseId();
					categoryContain = "";
					categoryList = new ArrayList<Map<String, String>>();
					course = new HashMap<String, Object>();
					course.put("id", sv.getCourseId());
					course.put("name", sv.getCourseName());
					
//System.out.println(course.toString());
				}
				// 取出所有的类别id和name,放到category里去
				String categoryIds[] = sv.getCategoryIdList().split(",");
				String categoryNames[] = sv.getCategoryNameList().split(",");
				for (int j = 0; j < categoryIds.length; j++) {
					// 加入过的类别的id会加到categoryContain，以%id%的形式
					if (!categoryContain.contains("%" + categoryIds[j] + "%")) {
						category = new HashMap<String, String>();
						category.put("id", categoryIds[j]);
						category.put("name", categoryNames[j]);
						categoryList.add(category);
						categoryContain += "%" + categoryIds[j] + "%";
					}
				}

				if (i == l.size() - 1) {
					course.put("children", categoryList);
					courseList.add(course);
//System.out.println(courseList);
					subject.put("children", courseList);
					subjectList.add(subject);
//System.out.println(subjectList);
					grade.put("children", subjectList);
					ret.add(grade);
//System.out.println(ret);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}
