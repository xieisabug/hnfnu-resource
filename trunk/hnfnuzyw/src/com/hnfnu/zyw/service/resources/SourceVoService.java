package com.hnfnu.zyw.service.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.ICourseGradeSubjectDao;
import com.hnfnu.zyw.dao.resources.ISourceVoDao;
import com.hnfnu.zyw.vo.CourseGradeSubjectVo;
import com.hnfnu.zyw.vo.SourceVo;

@Service("sourceVoService")
public class SourceVoService implements ISourceVoService {
	@Autowired
	@Qualifier("sourceVoDao")
	public ISourceVoDao sourceVoDao;
	@Autowired
	@Qualifier("courseGradeSubjectDao")
	public ICourseGradeSubjectDao courseGradeSubjectDao;

	// @Autowired
	// @Qualifier("sourceMoreVoDao")
	// public ISourceMoreVoDao sourceMoreVoDao;

	public SourceVo load(int id) {
		try {
			return sourceVoDao.get(id);
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

		String sql = "from SourceVo where id in(select t2.id from SourceCategoryJoinDto as t1,SourceDto as t2,CategoryDto as t3 where t1.sourceId = t2.id and t1.categoryId = t3.id and t2.courseId ="
				+ courseId;// and t3.id = 1)";
		if (categoryId > 0) {
			sql += " and t3.id =" + categoryId;
		}
		sql += ")";
		Map<String, Object> sourceVoList = new HashMap<String, Object>();
		List<SourceVo> l = null;

		try {
			l = sourceVoDao.sourceVoList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sourceVoList.put("Rows", l);
		sourceVoList.put("Total", l.size());
		return sourceVoList;
	}

	public List<Map<String, Object>> allTree() {
		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();// �������ص�map
		Map<String, Object> grade = null;// ��������꼶��map
		List<Map<String, Object>> subjectList = null;
		Map<String, Object> subject = null;// ������ſ�Ŀ��map
		List<Map<String, Object>> courseList = new ArrayList<Map<String, Object>>();
		Map<String, Object> course = null;
		List<Map<String, String>> categoryList = new ArrayList<Map<String, String>>();
		Map<String, String> category = null;
		String voHQL = "FROM SourceVo ORDER BY gradeId,subjectId,courseId ASC";
		try {
			List<SourceVo> l = sourceVoDao.list(voHQL);
			int gradeId = 0;// ��ǰ���꼶id
			int subjectId = 0;// ��ǰ�Ŀ�Ŀid
			int courseId = 0;// ��ǰ�γ�id
			String categoryContain = "";// ���ڱ����Ѿ�����������
			for (int i = 0; i < l.size(); i++) {
				SourceVo sv = l.get(i);
				// �����ǰ���꼶������������ݵ��꼶����ͬ��˵���Ѿ������꼶�ˣ�
				// ��Ҫ�½�һ��map,ͬʱ����subjectId����ֹ����
				// �������ɿ�Ŀ�б�ȷ����Ŀ�б��Ϊ�գ����Ҽ���������ݡ�
				if (sv.getGradeId() != gradeId) {
					// �ǵ�һ�ν����Ͳ�����,��Ϊû�г�ʼ��,�ڶ��μӽ�ȥ���ӵ���֮ǰһ�ֵ�
					if (i != 0 && grade.get("name") != null) {
						course.put("children", categoryList);
						courseList.add(course);
						subject.put("children", courseList);
						subjectList.add(subject);
						grade.put("children", subjectList);
						ret.add(grade);
					}
					gradeId = sv.getGradeId();
					subjectId = 0;
					grade = new HashMap<String, Object>();// �����꼶����Ϣ
					subjectList = new ArrayList<Map<String, Object>>();// ���ÿ�Ŀ����Ϣ
					subject = new HashMap<String, Object>();
					courseList = new ArrayList<Map<String, Object>>();
					course = new HashMap<String, Object>();
					categoryList = new ArrayList<Map<String, String>>();
					// ������Ϣ����
					grade.put("id", sv.getGradeId());
					grade.put("name", sv.getGradeName());

				}
				// �����ǰ���꼶����ͬ���꼶����Ҫ��һ���жϿ�Ŀ�Ƿ�����ͬ
				// �����Ŀ����ͬ����˵������ͬ�꼶�¸����˿�Ŀ��Ҫ����Ŀ���뵽
				// ��Ŀ�б�
				if (sv.getSubjectId() != subjectId) {
					// ��һ�β��ӣ�ԭ��ͬ����
					if (i != 0 && subject.get("name") != null) {
						course.put("children", categoryList);
						courseList.add(course);
						subject.put("children", courseList);
						subjectList.add(subject);
						// subjectList.toString());
					}
					// ����һ���µĿ�ĿҪ���ÿγ��б�
					subjectId = sv.getSubjectId();
					courseId = 0;
					courseList = new ArrayList<Map<String, Object>>();
					subject = new HashMap<String, Object>();
					course = new HashMap<String, Object>();
					categoryList = new ArrayList<Map<String, String>>();
					subject.put("id", sv.getSubjectId());
					subject.put("name", sv.getSubjectName());

				}
				// �����ǰ�Ŀγ̲�����ͬ�Ŀγ̣��򴴽��µ�����������
				// ��ǰ�γ̵Ļ�����Ϣ
				if (courseId != sv.getCourseId()) {
					if (i != 0 && course.get("name") != null) {
						course.put("children", categoryList);
						courseList.add(course);
						// courseList.toString());
					}
					courseId = sv.getCourseId();
					categoryContain = "";
					categoryList = new ArrayList<Map<String, String>>();
					course = new HashMap<String, Object>();
					course.put("id", sv.getCourseId());
					course.put("name", sv.getCourseName());

				}
				// ȡ�����е����id��name,�ŵ�category��ȥ
				String categoryIds[] = sv.getCategoryIdList().split(",");
				String categoryNames[] = sv.getCategoryNameList().split(",");
				for (int j = 0; j < categoryIds.length; j++) {
					// �����������id��ӵ�categoryContain����%id%����ʽ
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
					subject.put("children", courseList);
					subjectList.add(subject);
					grade.put("children", subjectList);
					ret.add(grade);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public List<Map<String, Object>> courseTree() {
		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();// �������ص�map
		Map<String, Object> grade = null;// ��������꼶��map
		List<Map<String, Object>> subjectList = null;
		Map<String, Object> subject = null;// ������ſ�Ŀ��map
		List<Map<String, Object>> courseList = new ArrayList<Map<String, Object>>();
		Map<String, Object> course = null;
		String voHQL = "FROM CourseGradeSubjectVo";
		try {
			List<CourseGradeSubjectVo> l = courseGradeSubjectDao.list(voHQL);
			int gradeId = 0;// ��ǰ���꼶id
			int subjectId = 0;// ��ǰ�Ŀ�Ŀid
			int courseId = 0;// ��ǰ�γ�id
			for (int i = 0; i < l.size(); i++) {
				CourseGradeSubjectVo cgs = l.get(i);
				// �����ǰ���꼶������������ݵ��꼶����ͬ��˵���Ѿ������꼶�ˣ�
				// ��Ҫ�½�һ��map,ͬʱ����subjectId����ֹ����
				// �������ɿ�Ŀ�б�ȷ����Ŀ�б��Ϊ�գ����Ҽ���������ݡ�
				if (cgs.getGradeId() != gradeId) {
					// �ǵ�һ�ν����Ͳ�����,��Ϊû�г�ʼ��,�ڶ��μӽ�ȥ���ӵ���֮ǰһ�ֵ�
					if (i != 0 && grade.get("name") != null) {
						courseList.add(course);
						subject.put("children", courseList);
						subjectList.add(subject);
						grade.put("children", subjectList);
						ret.add(grade);
					}
					gradeId = cgs.getGradeId();
					subjectId = 0;
					grade = new HashMap<String, Object>();// �����꼶����Ϣ
					subjectList = new ArrayList<Map<String, Object>>();// ���ÿ�Ŀ����Ϣ
					subject = new HashMap<String, Object>();
					courseList = new ArrayList<Map<String, Object>>();
					course = new HashMap<String, Object>();
					// ������Ϣ����
					grade.put("id", cgs.getGradeId());
					grade.put("name", cgs.getGradeName());
				}
				// �����ǰ���꼶����ͬ���꼶����Ҫ��һ���жϿ�Ŀ�Ƿ�����ͬ
				// �����Ŀ����ͬ����˵������ͬ�꼶�¸����˿�Ŀ��Ҫ����Ŀ���뵽
				// ��Ŀ�б�
				if (cgs.getSubjectId() != subjectId) {
					// ��һ�β��ӣ�ԭ��ͬ����
					if (i != 0 && subject.get("name") != null) {
						courseList.add(course);
						subject.put("children", courseList);
						subjectList.add(subject);
						// subjectList.toString());
					}
					// ����һ���µĿ�ĿҪ���ÿγ��б�
					subjectId = cgs.getSubjectId();
					courseId = 0;
					courseList = new ArrayList<Map<String, Object>>();
					subject = new HashMap<String, Object>();
					course = new HashMap<String, Object>();
					subject.put("id", cgs.getSubjectId());
					subject.put("name", cgs.getSubjectName());
				}
				// �����ǰ�Ŀγ̲�����ͬ�Ŀγ̣��򴴽��µ�����������
				// ��ǰ�γ̵Ļ�����Ϣ
				if (courseId != cgs.getId()) {
					if (i != 0 && course.get("name") != null) {
						courseList.add(course);
						// courseList.toString());
					}
					courseId = cgs.getId();
					course = new HashMap<String, Object>();
					course.put("id", cgs.getId());
					course.put("name", cgs.getName());

				}

				if (i == l.size() - 1) {
					courseList.add(course);
					subject.put("children", courseList);
					subjectList.add(subject);
					grade.put("children", subjectList);
					ret.add(grade);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public List<SourceVo> listSourceVoOrder(int gradeId, int subjectId) {
		String hql = "from SourceVo where gradeId="+gradeId+" and subjectId="+subjectId+" order by viewTimes desc";
		List<SourceVo> l = null;
		try {
			l = sourceVoDao.list(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
}
