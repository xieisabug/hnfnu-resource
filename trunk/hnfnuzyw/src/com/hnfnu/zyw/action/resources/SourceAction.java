package com.hnfnu.zyw.action.resources;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnfnu.zyw.action.base.AopNoSuchMethodErrorSolveBaseAction;
import com.hnfnu.zyw.dto.resources.CategoryDto;
import com.hnfnu.zyw.dto.resources.SourceDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.service.resources.ICategoryService;
import com.hnfnu.zyw.service.resources.ISourceService;
import com.hnfnu.zyw.service.resources.ISourceVoService;
import com.hnfnu.zyw.vo.SourceVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller("sourceAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/resources")
public class SourceAction extends AopNoSuchMethodErrorSolveBaseAction implements
		ModelDriven<SourceDto> {
	private SourceDto source = new SourceDto();// 获取页面提交参数
	private SourceVo sourceVo;// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> sourceVoList;
	private Map<String, Object> sourceMoreVoList;
	private UserDto user;
	private Integer categoryId;
	private String categoryIdList;
	private List<Map<String, Object>> allTree;
	private List<Map<String, Object>> courseTree;
	private List<CategoryDto> categoryList;

	@Autowired
	@Qualifier("sourceService")
	private ISourceService sourceService;

	@Autowired
	@Qualifier("sourceVoService")
	private ISourceVoService sourceVoService;

	@Autowired
	@Qualifier("categoryService")
	private ICategoryService categoryService;

	// 添加资源
	@Action(value = "addSource")
	public String add() {
		// 获取当前时间
		Date date = new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		source.setCreateDate(timeStamp);
		source.setViewTimes(0);
		// 获取当前用户
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		user = (UserDto) session.get("user");
		source.setCreateUserId(user.getId());
		source.setCreateUserName(user.getName());
		source.setApprovalStatus("0");
		source.setUseTimes(0);
		String kw = source.getKeyWords();
		
		
		if (kw != null && !"".equals(kw)) {
			kw += ";" + source.getName();
		} else {
			kw += source.getName();
		}
		//资源的保存路劲要改成相对路径
		String[] s= source.getUrl().split("\\\\");
		//System.out.println(s[s.length-1]);
		String tPath = s[s.length-1];
		String[] tt = tPath.split("\\.");
		tPath = tt[tt.length-1]+"\\"+tPath;
		//System.out.println(tPath);
		source.setKeyWords(kw);
		source.setUrl(tPath);
		success = sourceService.add(source, categoryIdList);
		if (success) {
			message = "添加资源成功！";
		} else {
			message = "添加资源失败！";
		}
		return SUCCESS;
	}

	// 修改资源
	@Action(value = "updateSource")
	public String update() {
		success = sourceService.update(source, categoryIdList);
		if (success) {
			message = "修改资源成功！";
		} else {
			message = "修改资源失败！";
		}
		return SUCCESS;
	}

	/**
	 * 根据资源ID查询一个资源,前台每查询一次viewTimes增加一次
	 * 
	 * 
	 * @return
	 */
	@Action(value = "loadSourceVo")
	public String load() {
		sourceVo = sourceVoService.load(source.getId());
		source = sourceService.load(source.getId());
		if (source != null) {
			if (source.getViewTimes() == null) {
				source.setViewTimes(1);
			}
			source.setViewTimes(source.getViewTimes() + 1);
			sourceService.update(source);
		}
		return SUCCESS;
	}

	// 删除文件的方法，如果返回的是1说明删除成功，-1说明文件不存在。0说明文件删除错误，2说明文件删除成功，信息删除错误
	@Action(value = "deleteSource")
	public String delete() {

		success = sourceService.delete(source.getUrl(), source.getId());
		if (success) {
			message = "资源删除成功！";
		} else {
			message = "资源删除失败";
		}
		return SUCCESS;
	}

	// 撤销上传文件的方法
	@Action(value = "deleteFile")
	public String deleteFile() {
		success = sourceService.deleteFile(source.getUrl());
		if (success) {
			message = "文件撤销成功";
		} else {
			message = "文件撤销失败";
		}
		return SUCCESS;
	}

	// 根据courceId和categoryId获取表中所有资源，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "sourceMoreVoList")
	public String list() {
		sourceMoreVoList = sourceVoService.listSourceVo(source.getCourseId(),
				categoryId);
		return SUCCESS;
	}

	// 根据courceId和categoryId获取表中该用户的资源，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "sourceMoreVoListByUserId")
	public String listByUserId() {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		user = (UserDto) session.get("user");
		sourceMoreVoList = sourceVoService.listSourceVoByUserId(
				source.getCourseId(), categoryId, user.getId());
		return SUCCESS;
	}

	// 页面上的一颗显示所有数据的树
	@Action(value = "allTree")
	public String allTree() {
		allTree = sourceVoService.allTree();
		return SUCCESS;
	}

	// 页面上的一颗显示该用户的数据的树
	@Action(value = "treeByUserId")
	public String treeByUserId() {
		// 获取当前用户
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		user = (UserDto) session.get("user");
		allTree = sourceVoService.treeByUserId(user.getId());
		return SUCCESS;
	}

	@Action(value = "courseTree")
	public String courseTree() {
		courseTree = sourceVoService.courseTree();
		return SUCCESS;
	}

	// 获取form中的下拉列表值
	@Action(value = "formSelect")
	public String formSelect() {
		categoryList = categoryService.list();
		return SUCCESS;
	}

	/* get set */

	public SourceDto getModel() {
		return source;
	}

	public SourceDto getSource() {
		return source;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getSourceList() {
		return sourceVoList;
	}

	public SourceVo getSourceVo() {
		return sourceVo;
	}

	public void setSourceVo(SourceVo sourceVo) {
		this.sourceVo = sourceVo;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryIdList() {
		return categoryIdList;
	}

	public void setCategoryIdList(String categoryIdList) {
		this.categoryIdList = categoryIdList;
	}

	public List<Map<String, Object>> getAllTree() {
		return allTree;
	}

	public Map<String, Object> getSourceMoreVoList() {
		return sourceMoreVoList;
	}

	public void setSourceMoreVoList(Map<String, Object> sourceMoreVoList) {
		this.sourceMoreVoList = sourceMoreVoList;
	}

	public List<CategoryDto> getCategoryList() {
		return categoryList;
	}

	public List<Map<String, Object>> getCourseTree() {
		return courseTree;
	}

}
