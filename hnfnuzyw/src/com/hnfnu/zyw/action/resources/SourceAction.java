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

import com.hnfnu.zyw.dto.resources.CategoryDto;
import com.hnfnu.zyw.dto.resources.SourceDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.service.resources.ICategoryService;
import com.hnfnu.zyw.service.resources.ISourceService;
import com.hnfnu.zyw.service.resources.ISourceVoService;
import com.hnfnu.zyw.vo.SourceVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("sourceAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class SourceAction extends ActionSupport implements
		ModelDriven<SourceDto> {
	private static final long serialVersionUID = -7199971221300636848L;
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
		// 获取当前用户
		ActionContext context = ActionContext.getContext();
		Map<String,Object> session = context.getSession();
		user = (UserDto) session.get("user");
		source.setCreateUserId(user.getId());
		source.setApprovalStatus("0");
		source.setUseTimes(0);
		//System.out.println("Action类别列表categoryList" + categoryIdList);
		success = sourceService.add(source,categoryIdList);
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
		success = sourceService.update(source);
		if (success) {
			message = "修改资源成功！";
		} else {
			message = "修改资源失败！";
		}
		return SUCCESS;
	}

	/**
	 * 根据资源ID查询一个资源
	 * 
	 * @return
	 */
	@Action(value = "loadSourceVo")
	public String load() {
		sourceVo = sourceVoService.load(source.getId());
		return SUCCESS;
	}

	/**
	 * 根据资源id删除一个资源文件以及在数据库里面的信息,
	 * 
	 * @return
	 */

	@Action(value = "deleteSourceMessege")
	public String deleteMessege() {
		success = sourceService.deleteMessege(source.getId());
		if (success) {
			message = "删除资源信息成功！";
		} else {
			message = "删除资源信息失败！";
		}
		return SUCCESS;
	}

	@Action(value = "deleteSource")
	public String delete() {
		int i = sourceService.delete(source.getUrl());
		if (i == 1) {
			success = true;
			message = "删除资源文件成功！";
		} else if (i == -1) {
			success = true;//虽然删除失败，返回true代表此文件已经不存在，页面上的对话框自动消失
			message = "删除资源文件失败，因为该文件不存在！";
		} else if (i == 0) {
			success = false;
			message = "删除资源文件失败,因为不是文件！";
		}
		return SUCCESS;
	}

	// 根据courceId和categoryId获取表中所有资源，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "sourceMoreVoList")
	public String list() {
		sourceMoreVoList = sourceVoService.listSourceVo(source.getCourseId(),categoryId);
		return SUCCESS;
	}
	
	//页面上的一颗显示所有数据的树
	@Action(value = "allTree")
	public String allTree(){
		allTree = sourceVoService.allTree();
		return SUCCESS;
	}
	
	//页面上的一颗显示所有数据的树
	@Action(value = "courseTree")
	public String courseTree(){
		courseTree = sourceVoService.courseTree();
		return SUCCESS;
	}
	
	//获取form中的下拉列表值
	@Action(value = "formSelect")
	public String formSelect(){
		categoryList = categoryService.list();
		return SUCCESS;
	}

	/* get set */
	public ISourceService getSourceService() {
		return sourceService;
	}

	public void setSourceService(ISourceService sourceService) {
		this.sourceService = sourceService;
	}

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
