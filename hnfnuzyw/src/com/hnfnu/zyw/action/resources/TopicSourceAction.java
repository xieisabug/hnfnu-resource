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
import com.hnfnu.zyw.dto.resources.TopicSourceDto;
import com.hnfnu.zyw.service.resources.ITopicSourceService;
import com.hnfnu.zyw.service.resources.ITopicSourceVoService;
import com.hnfnu.zyw.service.resources.ITopicSubtitleSourceVoService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("topicSourceAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/resources")
public class TopicSourceAction extends AopNoSuchMethodErrorSolveBaseAction
		implements ModelDriven<TopicSourceDto> {

	private TopicSourceDto topicSource = new TopicSourceDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> topicSourceList;
	private Map<String, Object> topicJoinSourceList;
	@Autowired
	@Qualifier("topicSourceService")
	private ITopicSourceService topicSourceService;

	@Autowired
	@Qualifier("topicSubtitleSourceVoService")
	private ITopicSubtitleSourceVoService topicSubtitleSourceVoService;

	@Autowired
	@Qualifier("topicSourceVoService")
	private ITopicSourceVoService topicSourceVoService;

	// 添加专题独有资源
	@Action(value = "addTopicSource")
	public String add() {
		success = topicSourceService.add(topicSource);
		if (success) {
			message = "添加专题独有资源成功！";
		} else {
			message = "添加专题独有资源失败！";
		}
		return SUCCESS;
	}

	// 修改专题独有资源
	@Action(value = "updateTopicSource")
	public String update() {
		success = topicSourceService.update(topicSource);
		if (success) {
			message = "修改专题独有资源成功！";
		} else {
			message = "修改专题独有资源失败！";
		}
		return SUCCESS;
	}

	/**
	 * 根据专题独有资源ID查询一个专题独有资源
	 * 
	 * @return
	 */
	@Action(value = "loadTopicSource")
	public String load() {
		topicSource = topicSourceService.load(topicSource.getId());
		return SUCCESS;
	}

	/**
	 * 根据专题独有资源id删除一个专题独有资源
	 * 
	 * @return
	 */

	@Action(value = "deleteTopicSource")
	public String delete() {
		success = topicSourceService.delete(topicSource.getId());
		if (success) {
			message = "删除专题独有资源成功！";
		} else {
			message = "删除专题独有资源失败！";
		}
		return SUCCESS;
	}

	// 获取表中所有专题独有资源，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "listTopicSource")
	public String list() {
		topicSourceList = topicSubtitleSourceVoService
				.listTopicSubtitleSourceVo(topicSource.getTopicSubtitleId());
		return SUCCESS;
	}

	// 获取表中所有专题独有资源，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "listTopicJoinSource")
	public String listTopicJoinSource() {
		topicJoinSourceList = topicSourceVoService.listBySubTitleId(topicSource
				.getTopicSubtitleId());
		return SUCCESS;
	}

	/* get set */
	public TopicSourceDto getModel() {
		return topicSource;
	}

	public TopicSourceDto getTopicSource() {
		return topicSource;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getTopicSourceList() {
		return topicSourceList;
	}

	public Map<String, Object> getTopicJoinSourceList() {
		return topicJoinSourceList;
	}

}
