package com.hnfnu.zyw.website.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnfnu.zyw.dao.base.Pager;
import com.hnfnu.zyw.vo.SourceVo;
import com.hnfnu.zyw.website.service.ISourceListService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("ftlSourceListAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({@Result(name = "success", type = "json", params = {"root", "action"})})
@Namespace("/source")
public class SourceListAction extends ActionSupport {
    private static final long serialVersionUID = -6797136426456854163L;
    private boolean success;
    private String message;
    private int groupId;
    private int subjectId;
    private int gradeId;
    private int courseId;
    // 当前是第几页,从1开始
    private int pageIndex;
    // 资源类型
    //private String type;
    // 关键字
    //private String keyWords;
    // 返回给界面的一页的数据
    private Pager<SourceVo> sourcePager;

    @Autowired
    @Qualifier("ftl_sourceListService")
    private ISourceListService sourceListService;

    /*@Autowired
    @Qualifier("subjectService")
    private ISubjectService subjectService;*/

    /*@Autowired
    @Qualifier("gradeService")
    private IGradeService gradeService;*/

    /*private FreemarkerUtil fu = new FreemarkerUtil();
    private Map<String, Object> root = null;*/

	/*@Action(value = "makeListFtl")
    public String makeList() {
		String filePath = null;

		filePath = ServletActionContext.getServletContext().getRealPath("/");

		// 获得数据模型
		root = sourceListService.getDataModel(subjectId, gradeId, 1, 10);
		// 打印到输出台，以便于测试
		//fu.print("list.ftl", root);
		// 输出到文件
		success = fu.fprint("list.ftl", root, filePath+"website//","sourceList_" + subjectId + "_" + gradeId
				+ ".html");
		if(success){
			message = "列表页面生成成功";
		}else{
			message = "列表页面生成失败";
		}
		return SUCCESS;
	}

	@Action(value = "makeAllListFtl")
	public String makeAllList() {
		String filePath = null;
		filePath = ServletActionContext.getServletContext().getRealPath("/");
		List<SubjectDto> subjects = subjectService.list();
		List<GradeDto> grades = gradeService.list();
		
		int i = 0;
		for (i = 0; i < subjects.size(); i++) {
			SubjectDto subject = subjects.get(i);
			for (int j = 0; j < grades.size(); j++) {
				GradeDto grade = grades.get(j);
				// 获得数据模型
				root = sourceListService.getDataModel(subject.getId(),
						grade.getId(), 1, 10);
				// 打印到输出台，以便于测试
				//fu.print("list.ftl", root);
				// 输出到文件
				success = fu.fprint("list.ftl", root,filePath+"website//","sourceList_" + subject.getId()
						+ "_" + grade.getId() + ".html");
				if(success == false)break;
			}
		}
		if(i < subjects.size()){
			success = false;
			message = "列表页面生成失败";
			
		}else{
			success = true;
			message = "所有列表页面生成成功";
		}
		
		
		return SUCCESS;
	}

	@Action(value = "pager")
	public String pager() {
		sourcePager = sourceListService.getPager(subjectId, gradeId, type,
				keyWords, page, 10);
		return SUCCESS;
	}*/

    /**
     * 学科资源的第一个界面
     *
     * @return
     */
    @Action(value = "index", results = {@Result(name = "success", location = "../../../website/choose_index.jsp")})
    public String index() {
        Map<String, Object> indexRoot = sourceListService.getGroupsAndGrades();
        HttpServletRequest request = ServletActionContext.getRequest();
        if (indexRoot == null) {
            request.setAttribute("message", message);
            request.setAttribute("success", success);
            return "error";
        }
        request.setAttribute("indexRoot", indexRoot);
        request.setAttribute("message", message);
        request.setAttribute("success", success);
        return SUCCESS;
    }

    /**
     * 学科资源的第一个界面的分页方法
     *
     * @return
     */
    @Action(value = "indexPage")
    public String indexPage() {
        sourcePager = sourceListService.indexPage(pageIndex);
        if (sourcePager == null) {
            message = "读取分页错误";
            success = false;
            return "error";
        }
        success = true;
        message = "读取分页成功";
        return SUCCESS;
    }

    /**
     * 根据分组id和年级id获得CourseGradeSubjectVo的列表和前八个SourceVo
     *
     * @return
     */
    @Action(value = "subject", results = {@Result(name = "success", location = "../../../website/choose_subject.jsp")})
    public String subjectByGroupAndGrade() {
        Map<String, Object> subjectMap = sourceListService.getSubjectByGroupAndGrade(groupId, gradeId);
        HttpServletRequest request = ServletActionContext.getRequest();
        if (subjectMap == null) {
            request.setAttribute("message", message);
            request.setAttribute("success", success);
            return "error";
        }
        request.setAttribute("subjectMap", subjectMap);
        request.setAttribute("message", message);
        request.setAttribute("success", success);
        return SUCCESS;
    }

    /**
     * 根据分组id和年级id和第几页获得该页的八个SourceVo
     *
     * @return
     */
    @Action(value = "subjectPage")
    public String subjectByGroupAndGradePage() {
        sourcePager = sourceListService.indexPage(pageIndex, groupId, gradeId);
        if (sourcePager == null) {
            message = "读取分页错误";
            success = false;
            return "error";
        }
        success = true;
        message = "读取分页成功";
        return SUCCESS;
    }

    /**
     * 根据分组id和年级id和科目id获得和CourseGradeSubjectVo的列表和前八个SourceVo
     *
     * @return
     */
    @Action(value = "course", results = {@Result(name = "success", location = "../../../website/choose_course.jsp")})
    public String courseByGroupAndGradeAndSubject() {
        Map<String, Object> courseMap = sourceListService.getCourseByGroupAndGradeAndSubject(groupId, gradeId, subjectId);
        HttpServletRequest request = ServletActionContext.getRequest();
        if (courseMap == null) {
            request.setAttribute("message", message);
            request.setAttribute("success", success);
            return "error";
        }
        request.setAttribute("courseMap", courseMap);
        request.setAttribute("message", message);
        request.setAttribute("success", success);
        return SUCCESS;
    }

    /**
     * 根据分组id和年级id和科目id和第几页获得该页的八个SourceVo
     *
     * @return
     */
    @Action(value = "coursePage")
    public String courseByGroupAndGradeAndSubjectPage() {
        sourcePager = sourceListService.indexPage(pageIndex, groupId, gradeId, subjectId);
        if (sourcePager == null) {
            message = "读取分页错误";
            success = false;
            return "error";
        }
        success = true;
        message = "读取分页成功";
        return SUCCESS;
    }

    /**
     * 根据分组id和年级id和科目id和课程id获得和CourseGradeSubjectVo的列表和前八个SourceVo
     *
     * @return
     */
    @Action(value = "final", results = {@Result(name = "success", location = "../../../website/choose_final.jsp")})
    public String finalByGroupAndGradeAndSubjectAndCourse() {
        Map<String, Object> finalMap = sourceListService.getFinalByGroupAndGradeAndSubjectAndCourse(groupId, gradeId, subjectId, courseId);
        HttpServletRequest request = ServletActionContext.getRequest();
        if (finalMap == null) {
            request.setAttribute("message", message);
            request.setAttribute("success", success);
            return "error";
        }
        request.setAttribute("finalMap", finalMap);
        request.setAttribute("message", message);
        request.setAttribute("success", success);
        return SUCCESS;
    }

    /**
     * 根据分组id和年级id和科目id和第几页获得该页的八个SourceVo
     *
     * @return
     */
    @Action(value = "finalPage")
    public String finalByGroupAndGradeAndSubjectAndCoursePage() {
        sourcePager = sourceListService.indexPage(pageIndex, groupId, gradeId, subjectId, courseId);
        if (sourcePager == null) {
            message = "读取分页错误";
            success = false;
            return "error";
        }
        success = true;
        message = "读取分页成功";
        return SUCCESS;
    }


    // get set
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Pager<SourceVo> getSourcePager() {
        return sourcePager;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
