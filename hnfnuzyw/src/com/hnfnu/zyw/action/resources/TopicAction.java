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
import com.hnfnu.zyw.dto.resources.TopicDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.service.resources.ITopicService;
import com.hnfnu.zyw.service.resources.ITopicSubtitleSourceVoService;
import com.hnfnu.zyw.website.service.FtlITopicService;
import com.hnfnu.zyw.website.service.IIndexService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller("topicAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/resources")
public class TopicAction extends AopNoSuchMethodErrorSolveBaseAction implements
		ModelDriven<TopicDto> {

	private TopicDto topic = new TopicDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private Map<String, Object> topicList;
	private List<Map<String, String>> topicTree;
	// private List<TopicSourceVo> topicSourceList;

	@Autowired
	@Qualifier("topicService")
	private ITopicService topicService;

	@Autowired
	@Qualifier("topicSubtitleSourceVoService")
	private ITopicSubtitleSourceVoService topicSubtitleSourceVoService;

	@Autowired
	@Qualifier("ftl_indexService")
	private IIndexService indexService;

	@Autowired
	@Qualifier("ftl_topicService")
	private FtlITopicService ftl_topicService;

	// 添加专题
	@Action(value = "addTopic")
	public String add() {
		// 获取当前时间
		Date date = new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		topic.setCreateDate(timeStamp);
		topic.setLastUpdateDate(timeStamp);
		// 获取当前用户
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		UserDto u = (UserDto) session.get("user");
		topic.setCreateUserId(u.getId());
		String kw = topic.getKeyWords();

		if (kw != null && !"".equals(kw)) {
			kw += ";" + topic.getName();
		} else {
			kw += topic.getName();
		}
		topic.setKeyWords(kw);
		// 资源的保存路劲要改成相对路径
		String[] s = topic.getImageUrl().split("\\\\");
		// System.out.println(s[s.length-1]);
		String tPath = s[s.length - 1];
		topic.setImageUrl(tPath);
		success = topicService.add(topic);
		if (success) {
			indexService.getTopics();
			ftl_topicService.getTopics();
			message = "添加专题成功！";
		} else {
			message = "添加专题失败！";
		}
		return SUCCESS;
	}

	// 修改专题
	@Action(value = "updateTopic")
	public String update() {

		// 获取当前时间
		Date date = new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		topic.setCreateDate(timeStamp);
		topic.setLastUpdateDate(timeStamp);
		// 获取当前用户
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		UserDto u = (UserDto) session.get("user");
		topic.setCreateUserId(u.getId());

		success = topicService.update(topic);
		if (success) {
			indexService.getTopics();
			message = "修改专题成功！";
		} else {
			message = "修改专题失败！";
		}
		return SUCCESS;
	}

	/*
	 * // 浏览一次浏览次数就加1
	 * 
	 * @Action(value = "topicAddViewTimes") public String topicAddViewTimes() {
	 * TopicDto t = topicService.load(topic.getId());
	 * t.setViewTimes(t.getViewTimes()+1); success = topicService.update(t); if
	 * (success) { indexService.getTopics(); message = "专题浏览次数增加成功！"; } else {
	 * message = "专题浏览次数增加失败！"; } return SUCCESS; }
	 */

	/**
	 * 根据专题ID查询一个专题
	 * 
	 * @return
	 */
	@Action(value = "loadTopic")
	public String load() {

		topic = topicService.load(topic.getId());
		if (topic != null) {
			topic.setViewTimes(topic.getViewTimes() + 1);
			topicService.update(topic);
		}
		return SUCCESS;
	}

	/**
	 * 根据专题id删除一个专题
	 * 
	 * @return
	 */

	@Action(value = "deleteTopic")
	public String delete() {
		success = topicService.delete(topic.getImageUrl(), topic.getId());
		if (success) {
			indexService.getTopics();
			message = "删除专题成功！";
		} else {
			message = "删除专题失败！";
		}
		return SUCCESS;
	}

	@Action(value = "clearTopicImage")
	public String clearTopicImage() {
		success = topicService.clearTopicImage();
		if (success) {
			indexService.getTopics();
			message = "清除专题图片成功！";
		} else {
			message = "清除专题图片失败！";
		}
		return SUCCESS;
	}

	// 获取表中所有专题，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "listTopic")
	public String list() {
		topicList = topicService.listTopic();
		if (topicList != null) {
			success = true;
			message = "获取专题列表成功！";
		} else {
			success = false;
			message = "获取专题列表失败！";
		}
		return SUCCESS;
	}

	/*
	 * // 获取表中所有专题，用Map装，为了分页的需要加上Rows和Total
	 * 
	 * @Action(value = "listSourceByTopicId") public String
	 * listSourceByTopicId() { topicSourceList =
	 * topicSourceVoService.listByTopicId(topic.getId()); return SUCCESS; }
	 */
	// 获取表中所有专题，用Map装，为了分页的需要加上Rows和Total
	@Action(value = "topicTree")
	public String topicTree() {
		topicTree = topicService.topicTree();
		return SUCCESS;
	}

	@Action(value = "clearTopicSourceFile")
	public String clearFile() {
		success = topicSubtitleSourceVoService.clearFile();
		if (success) {
			message = "冗余文件清除成功";
		} else {
			message = "冗余文件清除失败";
		}
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

	/*
	 * // public List<TopicSourceVo> getTopicSourceList() { // return
	 * topicSourceList; // }
	 */

}
