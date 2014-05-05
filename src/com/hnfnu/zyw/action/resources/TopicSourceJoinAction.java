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
import com.hnfnu.zyw.dto.resources.TopicSourceJoinDto;
import com.hnfnu.zyw.service.resources.ITopicSourceJoinService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("topicSourceJoinAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class TopicSourceJoinAction extends AopNoSuchMethodErrorSolveBaseAction implements
		ModelDriven<TopicSourceJoinDto> {
	private TopicSourceJoinDto topicSourceJoin = new TopicSourceJoinDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> topicSourceJoinList;
	// 用户挂接角色，用；好隔开。
	private String seletedSourceIds;
	private int[] sourceIds;

	@Autowired
	@Qualifier("topicSourceJoinService")
	private ITopicSourceJoinService topicSourceJoinService;

	/**
	 * 批量更新一个专题挂接的角色
	 * 
	 * @return
	 */
	@Action(value = "updateTopicSourceJoins")
	public String updateTopicSourceJoins() {
		success = topicSourceJoinService.addTopicSourceJoins(seletedSourceIds,
				topicSourceJoin.getSubtitleId());
		if (success) {
			message = "专题更新资源成功！";
		} else {
			message = "专题更新资源失败！";
		}
		return SUCCESS;
	}

	/**
	 * 通过subtitleId得到改主题已经挂接的资源ids。
	 * @return
	 */
	@Action(value = "querySourceIdsByTopicId")
	public String querySourceIdsByTopicId() {
		sourceIds = topicSourceJoinService.QueryAllSourceidsByTopicId(topicSourceJoin.getSubtitleId());
		return SUCCESS;
	}

	/* get set */
	public TopicSourceJoinDto getModel() {
		return topicSourceJoin;
	}

	public TopicSourceJoinDto getUser() {
		return topicSourceJoin;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getUserList() {
		return topicSourceJoinList;
	}

	public void setSeletedSourceIds(String seletedSourceIds) {
		this.seletedSourceIds = seletedSourceIds;
	}


	public int[] getSourceIds() {
		return sourceIds;
	}

	public void setSourceIds(int[] sourceIds) {
		this.sourceIds = sourceIds;
	}

}
