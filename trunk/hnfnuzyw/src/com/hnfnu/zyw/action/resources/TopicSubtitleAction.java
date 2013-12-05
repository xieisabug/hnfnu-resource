package com.hnfnu.zyw.action.resources;

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
import com.hnfnu.zyw.dto.resources.TopicSubtitleDto;
import com.hnfnu.zyw.service.resources.ITopicSubtitleService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("topicSubtitleAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class TopicSubtitleAction extends AopNoSuchMethodErrorSolveBaseAction implements ModelDriven<TopicSubtitleDto>{

	private TopicSubtitleDto topicSubtitle = new TopicSubtitleDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> topicSubtitleList;

	@Autowired
	@Qualifier("topicSubtitleService")
	private ITopicSubtitleService topicSubtitleService;

	// 添加专题的二级标题
	@Action(value = "addTopicSubtitle")
	public String add() {
		success = topicSubtitleService.add(topicSubtitle);
		if (success) {
			message = "添加专题的二级标题成功！";
		} else {
			message = "添加专题的二级标题失败！";
		}
		return SUCCESS;
	}

	// 修改专题的二级标题
	@Action(value = "updateTopicSubtitle")
	public String update() {
		success = topicSubtitleService.update(topicSubtitle);
		if (success) {
			message = "修改专题的二级标题成功！";
		} else {
			message = "修改专题的二级标题失败！";
		}
		return SUCCESS;
	}

	/**
	 * 根据专题的二级标题ID查询一个专题的二级标题
	 * 
	 * @return
	 */
	@Action(value = "loadTopicSubtitle")
	public String load() {
		topicSubtitle = topicSubtitleService.load(topicSubtitle.getId());
		return SUCCESS;
	}

	/**
	 * 根据专题的二级标题id删除一个专题的二级标题
	 * 
	 * @return
	 */

	@Action(value = "deleteTopicSubtitle")
	public String delete() {
		success = topicSubtitleService.delete(topicSubtitle.getId());
		if (success) {
			message = "删除专题的二级标题成功！";
		} else {
			message = "删除专题的二级标题失败！";
		}
		return SUCCESS;
	}

	// 获取表中所有专题的二级标题，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "listTopicSubtitle")
	public String list() {
		topicSubtitleList = topicSubtitleService.listTopicSubtitle(topicSubtitle.getTopicId());
		return SUCCESS;
	}

	/* get set */
	public TopicSubtitleDto getModel() {
		return topicSubtitle;
	}

	public TopicSubtitleDto getTopicSubtitle() {
		return topicSubtitle;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getTopicSubtitleList() {
		return topicSubtitleList;
	}
}
