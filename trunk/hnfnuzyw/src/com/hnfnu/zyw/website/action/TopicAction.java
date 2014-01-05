package com.hnfnu.zyw.website.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.hnfnu.zyw.dto.resources.TopicDto;
import com.hnfnu.zyw.dto.resources.TopicSubtitleDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.service.resources.ITopicService;
import com.hnfnu.zyw.service.resources.ITopicSourceVoService;
import com.hnfnu.zyw.service.resources.ITopicSubtitleService;
import com.hnfnu.zyw.service.resources.ITopicSubtitleSourceVoService;
import com.hnfnu.zyw.service.system.IUserService;
import com.hnfnu.zyw.vo.TopicSourceVo;
import com.hnfnu.zyw.vo.TopicSubtitleSourceVo;
import com.hnfnu.zyw.website.service.FtlITopicService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("ftlTopicAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/topic")
public class TopicAction extends ActionSupport {

	private static final long serialVersionUID = 2222487976006742410L;
	private int topicId;
	private boolean success;
	private String message;
	private int pageIndex;
	private int subtitleId;
	private List<TopicSubtitleSourceVo> topicSources;
	private List<TopicSourceVo> joinSources;
	private final static int pageSize = 8;

	@Autowired
	@Qualifier("topicService")
	private ITopicService topicService;

	@Autowired
	@Qualifier("userService")
	private IUserService userService;

	@Autowired
	@Qualifier("topicSubtitleService")
	private ITopicSubtitleService topicSubtitleService;

	@Autowired
	@Qualifier("topicSubtitleSourceVoService")
	private ITopicSubtitleSourceVoService topicSubtitleSourceVoService;

	@Autowired
	@Qualifier("topicSourceVoService")
	private ITopicSourceVoService topicSourceVoService;
	
	@Autowired
	@Qualifier("ftl_topicService")
	private FtlITopicService ftl_topicService;

	@Action(value = "view", results = { @Result(name = "success", location = "../../../website/topic_view.jsp") })
	public String topicView() {
		try {
			TopicDto topic = topicService.load(topicId);
			//访问次数加1
//			topic.setViewTimes(topic.getViewTimes()+1);
//			topicService.update(topic);
			UserDto user = userService.load(topic.getCreateUserId());
			List<Map<String, Object>> subTopics = new ArrayList<Map<String, Object>>();
			Map<String, Object> subtitleMap = null;

			List<TopicSubtitleDto> topicSubtitleDtos = topicSubtitleService
					.listByTopicId(topicId);
			for (int i = 0; i < topicSubtitleDtos.size(); i++) {
				subtitleMap = new HashMap<String, Object>();
				subtitleMap.put("subtitle", topicSubtitleDtos.get(i));
				
				topicSources = topicSubtitleSourceVoService.listBySubtileId(
						topicSubtitleDtos.get(i).getId(), 0, pageSize);
				
				joinSources = topicSourceVoService.listBySubTitleId(
						topicSubtitleDtos.get(i).getId(), 0, pageSize);
				subtitleMap.put("topicSources", topicSources);
				subtitleMap.put("joinSources", joinSources);
				subTopics.add(subtitleMap);
			}

			HttpServletRequest request = ServletActionContext.getRequest();
			if (topic == null || user == null || subTopics == null) {
				request.setAttribute("message", message);
				request.setAttribute("success", success);
				return "error";
			}
			request.setAttribute("topic", topic);
			request.setAttribute("topicUser", user);
			request.setAttribute("subTopics", subTopics);
			request.setAttribute("message", message);
			request.setAttribute("success", success);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(topicService.topicAddViewTimes(topicId));
		return SUCCESS;
	}

	@Action(value = "page")
	public String page() {

		int startIndex = pageIndex * pageSize - 1;

		topicSources = topicSubtitleSourceVoService.listBySubtileId(subtitleId,
				startIndex, pageSize);
		joinSources = topicSourceVoService.listBySubTitleId(subtitleId,
				startIndex, pageSize);
		return SUCCESS;
	}


	@Action(value = "makeBigTopic")
	public String makeBigTopic() {
		ftl_topicService.getTopics();
		return SUCCESS;
	}
	/**
	 * 得到最热的前10个专题
	 */
	@Action(value = "tenHotTopics")
	public String tenHotTopics() {
		List<TopicDto> tenHotTopics = ftl_topicService.getTenHotTopics();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		if (tenHotTopics == null) {
			request.setAttribute("message", message);
			request.setAttribute("success", success);
			return "error";
		}
		request.setAttribute("tenHotTopics", tenHotTopics);
		request.setAttribute("message", message);
		request.setAttribute("success", success);
		return SUCCESS;
	}
	
	
	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void setSubtitleId(int subtitleId) {
		this.subtitleId = subtitleId;
	}

	public List<TopicSubtitleSourceVo> getTopicSources() {
		return topicSources;
	}

	public List<TopicSourceVo> getJoinSources() {
		return joinSources;
	}
	
	
}
