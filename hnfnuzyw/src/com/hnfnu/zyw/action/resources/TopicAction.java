package com.hnfnu.zyw.action.resources;

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
import com.hnfnu.zyw.dto.resources.TopicDto;
import com.hnfnu.zyw.service.resources.ITopicService;
import com.hnfnu.zyw.service.resources.ITopicSourceVoService;
import com.hnfnu.zyw.vo.TopicSourceVo;
import com.opensymphony.xwork2.ModelDriven;


@Controller("topicAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class TopicAction extends AopNoSuchMethodErrorSolveBaseAction implements
ModelDriven<TopicDto>{
	
	private TopicDto topic = new TopicDto();// »ñÈ¡Ò³ÃæÌá½»²ÎÊý
	private boolean success;
	private String message;
	private Map<String, Object> topicList;
	private List<Map<String, String>> topicTree;
	private List<TopicSourceVo> topicSourceList;

	@Autowired
	@Qualifier("topicService")
	private ITopicService topicService;

	@Autowired
	@Qualifier("topicSourceVoService")
	private ITopicSourceVoService topicSourceVoService;

	// Ìí¼Ó×¨Ìâ
	@Action(value = "addTopic")
	public String add() {
		success = topicService.add(topic);
		if (success) {
			message = "Ìí¼Ó×¨Ìâ³É¹¦£¡";
		} else {
			message = "Ìí¼Ó×¨ÌâÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	// ÐÞ¸Ä×¨Ìâ
	@Action(value = "updateTopic")
	public String update() {
		success = topicService.update(topic);
		if (success) {
			message = "ÐÞ¸Ä×¨Ìâ³É¹¦£¡";
		} else {
			message = "ÐÞ¸Ä×¨ÌâÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ¸ù¾Ý×¨ÌâID²éÑ¯Ò»¸ö×¨Ìâ
	 * 
	 * @return
	 */
	@Action(value = "loadTopic")
	public String load() {
		topic = topicService.load(topic.getId());
		return SUCCESS;
	}

	/**
	 * ¸ù¾Ý×¨ÌâidÉ¾³ýÒ»¸ö×¨Ìâ
	 * 
	 * @return
	 */

	@Action(value = "deleteTopic")
	public String delete() {
		success = topicService.delete(topic.getId());
		if (success) {
			message = "É¾³ý×¨Ìâ³É¹¦£¡";
		} else {
			message = "É¾³ý×¨ÌâÊ§°Ü£¡";
		}
		return SUCCESS;
	}

	// »ñÈ¡±íÖÐËùÓÐ×¨Ìâ£¬ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
	@Action(value = "listTopic")
	public String list() {
		topicList = topicService.listTopic();
		return SUCCESS;
	}
	
	// »ñÈ¡±íÖÐËùÓÐ×¨Ìâ£¬ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
	@Action(value = "listSourceByTopicId")
	public String listSourceByTopicId() {
		topicSourceList = topicSourceVoService.listByTopicId(topic.getId());
		return SUCCESS;
	}

	// »ñÈ¡±íÖÐËùÓÐ×¨Ìâ£¬ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
	@Action(value = "topicTree")
	public String topicTree() {
		topicTree = topicService.topicTree();
		return SUCCESS;
	}

	/* get set */
	public TopicDto getModel() {
		return topic;
	}

	public TopicDto getTopic() {
		return topic;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getTopicList() {
		return topicList;
	}

	public List<Map<String, String>> getTopicTree() {
		return topicTree;
	}

	public List<TopicSourceVo> getTopicSourceList() {
		return topicSourceList;
	}
	
	

}
