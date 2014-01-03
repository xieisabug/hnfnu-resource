package com.hnfnu.zyw.website.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hnfnu.zyw.dao.resources.IGradeGroupVoDao;
import com.hnfnu.zyw.dao.resources.IGroupDao;
import com.hnfnu.zyw.dao.resources.ISourceDao;
import com.hnfnu.zyw.dao.resources.ISourceVoDao;
import com.hnfnu.zyw.dao.resources.ISubjectGroupVoDao;
import com.hnfnu.zyw.dao.resources.ITopicDao;
import com.hnfnu.zyw.dao.resources.ITopicSourceDao;
import com.hnfnu.zyw.dao.system.IStudentDao;
import com.hnfnu.zyw.dao.system.IUserDao;
import com.hnfnu.zyw.dao.website.IPicturesDao;
import com.hnfnu.zyw.dto.resources.GroupDto;
import com.hnfnu.zyw.dto.resources.TopicDto;
import com.hnfnu.zyw.vo.GradeGroupVo;
import com.hnfnu.zyw.vo.SubjectGroupVo;
import com.hnfnu.zyw.website.utils.FreemarkerUtil;

@Service("ftl_indexService")
public class IndexServiceImpl implements IIndexService {

    public final static String FILE_PATH = "F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\";

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
    
    @Autowired
    @Qualifier("topicSourceDao")
    private ITopicSourceDao topicSourceDao;
    
    @Autowired
    @Qualifier("sourceDao")
    private ISourceDao sourceDao;
    
    @Autowired
    @Qualifier("userDao")
    private IUserDao userDao;
    
    @Autowired
    @Qualifier("studentDao")
    private IStudentDao studentDao;

    //@Scheduled(cron = "0 0 0,8,10,12,14,16,18,20 * * ?")
    @Async
    public void getPictures() {
        try {
            FreemarkerUtil fu = new FreemarkerUtil();
            Map<String, Object> root = null;
//			String filePath = null;

            //filePath = ServletActionContext.getServletContext().getRealPath("/");
//			filePath = "F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\";
            // 获得数据模型
            root = this.getPicturesRoot();
            // 打印到输出台，以便于测试
            //fu.print("index/gallery.ftl", root);
            // 输出到文件
            fu.fprint("index/gallery.ftl", root, FILE_PATH + "website\\",
                    "gallery.html");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //@Scheduled(cron = "0 0 0,8,10,12,14,16,18,20 * * ?")
    @Async
    public void getTopics() {
        try {
            FreemarkerUtil fu = new FreemarkerUtil();
            Map<String, Object> root = null;
//			String filePath = null;
//
//			filePath = ServletActionContext.getServletContext().getRealPath("/");
//			filePath = "F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\";
            // 获得数据模型
            root = this.getMakeTopicRoot();
            // 打印到输出台，以便于测试
            //fu.print("index/topic.ftl", root);
            // 输出到文件
            //System.out.println(filePath + "website\\");
            fu.fprint("index/topic.ftl", root, FILE_PATH + "website\\",
                    "topic.html");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //	@Scheduled(cron = "*/10 * * * * ?")
    @Scheduled(cron = "0 0 0,8,10,12,14,16,18,20 * * ?")
    @Async
    public void makeTabGroups() {
        try {
            FreemarkerUtil fu = new FreemarkerUtil();
            Map<String, Object> root = null;
//            String filePath = null;
            //		filePath = ServletActionContext.getServletContext().getRealPath("/");
//            filePath = "F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\";
            // 获得数据模型
            root = this.getMakeTabGroupRoot();
            // 打印到输出台，以便于测试
            //		fu.print("index/tabGroup.ftl", root);
            // 输出到文件
//            System.out.println(filePath + "website\\");
            fu.fprint("index/tabGroup.ftl", root, FILE_PATH + "website\\",
                    "tabGroup.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Async
    public void makeSourceCount() {
        try {
            FreemarkerUtil fu = new FreemarkerUtil();
            Map<String, Object> root = null;
//            String filePath = null;
            //		filePath = ServletActionContext.getServletContext().getRealPath("/");
//            filePath = "F:\\workspaces\\hnfnu-resource\\trunk\\hnfnuzyw\\WebRoot\\";
            // 获得数据模型
            root = this.getMakeSourceCount();
            // 打印到输出台，以便于测试
            		fu.print("index/sourceCount.ftl", root);
            // 输出到文件
//            System.out.println(filePath + "website\\");
            fu.fprint("index/sourceCount.ftl", root, FILE_PATH + "website\\",
                    "sourceCount.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String,Object> getMakeSourceCount() {
    	Map<String, Object> root = new HashMap<String, Object>();
    	String hql = "select count(*) as count from TopicSourceDto";
    	String hql2 = "select count(*) as count from SourceDto";
    	
    	String hql3 = "select sum(fileSize) from SourceDto";
    	String hql4 = "select sum(fileSize) from TopicSourceDto";
    	
    	
    	String hql5 = "select sum(useTimes) from SourceDto";
    	String hql6 = "select sum(useTimes) from TopicSourceDto";
    	
    	String hql7 = "select count(*) from TopicDto";
    	
    	String hql8 = "select count(*) as count from UserDto";
    	String hql9 = "select count(*) as count from StudentDto";
    	
    	
    	String hql10 = "select sum(viewTimes) from SourceDto";
    	String hql11 = "select sum(viewTimes) from TopicSourceDto";
    	try {
    		Float sourceCapacity = sourceDao.getTotalCapacity(hql3);
        	int topicSourceDownloads = topicSourceDao.getTotalCount(hql5);
        	
    		int topicSourceCount = topicSourceDao.getTotalCount(hql);
        	int sourceCount = sourceDao.getTotalCount(hql2);
        	Float topicSourceCapacity = topicSourceDao.getTotalCapacity(hql4);
        	
        	int sourceDownloads= sourceDao.getTotalCount(hql6);
        	int topicTotalCount= topicDao.getTotalCount(hql7);
        	int userCount = userDao.getTotalCount(hql8);
        	int stduentCount = studentDao.getTotalCount(hql9);
        	int sourceViews= sourceDao.getTotalCount(hql10);
        	int topicSourceViews= topicDao.getTotalCount(hql11);
        	root.put("totalCount", topicSourceCount+sourceCount);
        	root.put("totalCapacity", (topicSourceCapacity+sourceCapacity)/1024);
        	root.put("totalDownloads", topicSourceDownloads+sourceDownloads);
        	root.put("topicTotalCount", topicTotalCount);
        	root.put("userCount", userCount+stduentCount);
        	root.put("totalVisits", sourceViews+topicSourceViews);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return root;
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

        List<Map<String, Object>> subjects = null;

        // 查询后台设置显示并且已经上传了资源的分组
        String hql = "from GroupDto where isDisplay=1 and id in(select groupId from SourceVo group by groupId) order by isDisplay desc,id desc";

        try {
            groups = groupDao.complexList(hql);
            for (int i = 0; i < groups.size(); i++) {
                gradeList = new ArrayList<Map<String, Object>>();
                // System.out.println("分组："+i+"分组id="+groups.get(i).getId()+"分组名字="+groups.get(i).getName());
                groupMap = new HashMap<String, Object>();
                GroupDto tg = groups.get(i);
                // 查询每个分组下面的年级，并且该年级已经上传过资源,根据显示和id降序
                String hql1 = "from GradeGroupVo where groupId="
                        + tg.getId()
                        + " and id in(select gradeId from SourceVo group by gradeId) order by isDisplay desc,id desc ";
                grades = gradeGroupVoDao.complexList(hql1);

                for (int j = 0; j < grades.size() && j < 6; j++) {
                    GradeGroupVo tgv = grades.get(j);
                    String hql2 = "from SubjectGroupVo where groupId="
                            + tg.getId()
                            + " and id in(select subjectId from SourceVo "
                            + "where gradeId=" + tgv.getId()
                            + " group by subjectId) order by isDisplay desc,id desc";
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

    private Map<String, Object> getMakeTopicRoot() {
        String hql = "from TopicDto order by isDisPlay desc,id desc";
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

    private Map<String, Object> getPicturesRoot() {
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
