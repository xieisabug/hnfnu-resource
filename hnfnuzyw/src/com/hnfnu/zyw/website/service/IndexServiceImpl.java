package com.hnfnu.zyw.website.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.IGradeGroupVoDao;
import com.hnfnu.zyw.dao.resources.IGroupDao;
import com.hnfnu.zyw.dao.resources.ISourceVoDao;
import com.hnfnu.zyw.dao.resources.ISubjectGroupVoDao;
import com.hnfnu.zyw.dao.resources.ITopicDao;
import com.hnfnu.zyw.dao.website.IPicturesDao;
import com.hnfnu.zyw.dto.resources.GroupDto;
import com.hnfnu.zyw.dto.resources.TopicDto;
import com.hnfnu.zyw.vo.GradeGroupVo;
import com.hnfnu.zyw.vo.SubjectGroupVo;
import com.hnfnu.zyw.website.utils.FreemarkerUtil;

@Service("ftl_indexService")
public class IndexServiceImpl implements IIndexService {

	@Autowired
	@Qualifier("picturesDao")
	private IPicturesDao picturesDao;

	@Autowired
	@Qualifier("topicDao")
	private ITopicDao topicDao;

	@Autowired
	@Qualifier("groupDao")
	private IGroupDao groupDao;

	@Autowired
	@Qualifier("gradeGroupVoDao")
	private IGradeGroupVoDao gradeGroupVoDao;

	@Autowired
	@Qualifier("subjectGroupVoDao")
	private ISubjectGroupVoDao subjectGroupVoDao;
	@Autowired
	@Qualifier("sourceVoDao")
	private ISourceVoDao sourceVoDao;

	public boolean getPictures() {
		FreemarkerUtil fu =new FreemarkerUtil();
		Map<String, Object> root = null;
		String filePath = null;

		filePath = ServletActionContext.getServletContext().getRealPath("/");
		// 获得数据模型
		root = this.getPicturesRoot();
		// 打印到输出台，以便于测试
		fu.print("index/gallery.ftl", root);
		// 输出到文件
		System.out.println(filePath + "website\\");
		return fu.fprint("index/gallery.ftl", root, filePath + "website\\",
				"gallery.html");
	}

	public boolean getTopics() {
		FreemarkerUtil fu =new FreemarkerUtil();
		Map<String, Object> root = null;
		String filePath = null;

		filePath = ServletActionContext.getServletContext().getRealPath("/");
		// 获得数据模型
		root = this.getMakeTopicRoot();
		// 打印到输出台，以便于测试
		fu.print("index/topic.ftl", root);
		// 输出到文件
		System.out.println(filePath + "website\\");
		return fu.fprint("index/topic.ftl", root, filePath + "website\\",
				"topic.html");
	}

	public boolean makeTabGroups() {
		FreemarkerUtil fu =new FreemarkerUtil();
		Map<String, Object> root = null;
		String filePath = null;

		filePath = ServletActionContext.getServletContext().getRealPath("/");
		// 获得数据模型
		root = this.getMakeTabGroupRoot();
		// 打印到输出台，以便于测试
		fu.print("index/tabGroup.ftl", root);
		// 输出到文件
		System.out.println(filePath + "website\\");
		return fu.fprint("index/tabGroup.ftl", root, filePath + "website\\",
				"tabGroup.html");

	}

	private List<Map<String, Object>> listToMap(List<SubjectGroupVo> l,
			int groupId, int gradeId) {
		Map<String, Object> t = null;
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < l.size(); i++) {
			t = new HashMap<String, Object>();
			SubjectGroupVo ts = l.get(i);
			t.put("dto", ts);
			t.put("viewTimes", sourceVoDao.getViewTimesBySubjectId(ts.getId(),
					groupId, gradeId));
			result.add(t);
		}
		return result;
	}

	private Map<String, Object> getMakeTabGroupRoot() {
		// 根
		Map<String, Object> root = new HashMap<String, Object>();
		// 一级孩子
		List<Map<String, Object>> groupList = new ArrayList<Map<String, Object>>();
		List<GroupDto> groups = null;

		Map<String, Object> groupMap = null;
		List<Map<String, Object>> gradeList = null;
		List<GradeGroupVo> grades = null;

		Map<String, Object> subjectMap = null;
		;
		List<Map<String, Object>> subjects = null;

		// 查询后台设置显示并且已经上传了资源的分组
		String hql = "from GroupDto where isDisplay=1 and id in(select groupId from SourceVo group by groupId)";

		try {
			groups = groupDao.complexList(hql);
			for (int i = 0; i < groups.size(); i++) {
				gradeList = new ArrayList<Map<String, Object>>();
				// System.out.println("分组："+i+"分组id="+groups.get(i).getId()+"分组名字="+groups.get(i).getName());
				groupMap = new HashMap<String, Object>();
				GroupDto tg = groups.get(i);
				// 查询每个分组下面的年级，并且该年级已经上传过资源
				String hql1 = "from GradeGroupVo where groupId="
						+ tg.getId()
						+ " and id in(select gradeId from SourceVo group by gradeId) ";
				grades = gradeGroupVoDao.complexList(hql1);

				for (int j = 0; j < grades.size() && j < 6; j++) {
					GradeGroupVo tgv = grades.get(j);
					String hql2 = "from SubjectGroupVo where groupId="
							+ tg.getId()
							+ " and id in(select subjectId from SourceVo "
							+ "where gradeId=" + tgv.getId()
							+ " group by subjectId)";
					List<SubjectGroupVo> subjectGroupVos = subjectGroupVoDao
							.complexList(hql2);
					subjects = this.listToMap(subjectGroupVos, tg.getId(),
							tgv.getId());
					subjectMap = new HashMap<String, Object>();
					subjectMap.put("subjects", subjects);
					subjectMap.put("subjectSize", subjects.size());
					gradeList.add(subjectMap);
				}

				groupMap.put("grades", grades);
				groupMap.put("gradeList", gradeList);
				groupList.add(groupMap);
			}

			root.put("groupList", groupList);
			root.put("groups", groups);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return root;
	}
	private Map<String, Object> getMakeTopicRoot(){
		String hql = "from TopicDto order by id desc";
		Map<String, Object> p = new HashMap<String, Object>();
		try {
			List<TopicDto> t = topicDao.list(hql);
			p.put("topics", t);
			p.put("topicSize", t.size());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return p;
	}
	private Map<String, Object> getPicturesRoot(){
		String hql = "from PicturesDto where display=1";
		Map<String, Object> p = new HashMap<String, Object>();
		try {
			p.put("pictures", picturesDao.list(hql));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return p;
	}

}
