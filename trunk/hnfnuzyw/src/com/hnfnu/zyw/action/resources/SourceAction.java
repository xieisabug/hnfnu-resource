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
	private SourceDto source = new SourceDto();// »ñÈ¡Ò³ÃæÌá½»²ÎÊý
	private SourceVo sourceVo;// »ñÈ¡Ò³ÃæÌá½»²ÎÊý
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

	// Ìí¼Ó×ÊÔ´
	@Action(value = "addSource")
	public String add() {
		// »ñÈ¡µ±Ç°Ê±¼ä
		Date date = new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		source.setCreateDate(timeStamp);
		source.setViewTimes(0);
		// »ñÈ¡µ±Ç°ÓÃ»§
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		user = (UserDto) session.get("user");
		source.setCreateUserId(user.getId());
		source.setApprovalStatus("0");
		source.setUseTimes(0);
		String kw = source.getKeyWords();
		if (kw != null && !"".equals(kw)) {
			kw += ";" + source.getName();
		} else {
			kw += source.getName();
		}

		source.setKeyWords(kw);
		success = sourceService.add(source, categoryIdList);
		if (success) {
			message = "Ìí¼Ó×ÊÔ´³É¹¦£¡";
		} else {
			message = "Ìí¼Ó×ÊÔ´Ê§°Ü£¡";
		}
		return SUCCESS;
	}

	// ÐÞ¸Ä×ÊÔ´
	@Action(value = "updateSource")
	public String update() {
		success = sourceService.update(source, categoryIdList);
		if (success) {
			message = "ÐÞ¸Ä×ÊÔ´³É¹¦£¡";
		} else {
			message = "ÐÞ¸Ä×ÊÔ´Ê§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ¸ù¾Ý×ÊÔ´ID²éÑ¯Ò»¸ö×ÊÔ´,Ç°Ì¨Ã¿²éÑ¯Ò»´ÎviewTimesÔö¼ÓÒ»´Î
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

	// É¾³ýÎÄ¼þµÄ·½·¨£¬Èç¹û·µ»ØµÄÊÇ1ËµÃ÷É¾³ý³É¹¦£¬-1ËµÃ÷ÎÄ¼þ²»´æÔÚ¡£0ËµÃ÷ÎÄ¼þÉ¾³ý´íÎó£¬2ËµÃ÷ÎÄ¼þÉ¾³ý³É¹¦£¬ÐÅÏ¢É¾³ý´íÎó
	@Action(value = "deleteSource")
	public String delete() {

		success = sourceService.delete(source.getUrl(), source.getId());
		if (success) {
			message = "×ÊÔ´É¾³ý³É¹¦£¡";
		} else {
			message = "×ÊÔ´É¾³ýÊ§°Ü";
		}
		return SUCCESS;
	}

	// ³·ÏúÉÏ´«ÎÄ¼þµÄ·½·¨
	@Action(value = "deleteFile")
	public String deleteFile() {
		success = sourceService.deleteFile(source.getUrl());
		if (success) {
			message = "ÎÄ¼þ³·Ïú³É¹¦";
		} else {
			message = "ÎÄ¼þ³·ÏúÊ§°Ü";
		}
		return SUCCESS;
	}

	// ¸ù¾ÝcourceIdºÍcategoryId»ñÈ¡±íÖÐËùÓÐ×ÊÔ´£¬ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
	@Action(value = "sourceMoreVoList")
	public String list() {
		sourceMoreVoList = sourceVoService.listSourceVo(source.getCourseId(),
				categoryId);
		return SUCCESS;
	}

	// ¸ù¾ÝcourceIdºÍcategoryId»ñÈ¡±íÖÐ¸ÃÓÃ»§µÄ×ÊÔ´£¬ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
	@Action(value = "sourceMoreVoListByUserId")
	public String listByUserId() {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		user = (UserDto) session.get("user");
		sourceMoreVoList = sourceVoService.listSourceVoByUserId(
				source.getCourseId(), categoryId, user.getId());
		return SUCCESS;
	}

	// Ò³ÃæÉÏµÄÒ»¿ÅÏÔÊ¾ËùÓÐÊý¾ÝµÄÊ÷
	@Action(value = "allTree")
	public String allTree() {
		allTree = sourceVoService.allTree();
		return SUCCESS;
	}

	// Ò³ÃæÉÏµÄÒ»¿ÅÏÔÊ¾¸ÃÓÃ»§µÄÊý¾ÝµÄÊ÷
	@Action(value = "treeByUserId")
	public String treeByUserId() {
		// »ñÈ¡µ±Ç°ÓÃ»§
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

	// »ñÈ¡formÖÐµÄÏÂÀ­ÁÐ±íÖµ
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
