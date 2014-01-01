package com.hnfnu.zyw.website.action;

import javax.servlet.http.HttpServletRequest;

import com.hnfnu.zyw.service.resources.ISourceCommentService;
import com.hnfnu.zyw.service.resources.ISourceVoService;
import com.hnfnu.zyw.service.resources.ITopicSubtitleSourceVoService;
import com.hnfnu.zyw.vo.SourceVo;
import com.hnfnu.zyw.vo.TopicSubtitleSourceVo;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;

@Controller("onlineViewAction")
@Scope("prototype")
@Namespace("/online")
public class OnlineViewAction extends ActionSupport{

	private static final long serialVersionUID = 8211651083165988085L;
	private boolean success;
	private String message;
	private int id;
    private String type;

	@Autowired
	@Qualifier("sourceVoService")
	private ISourceVoService sourceVoService;
	@Autowired
	@Qualifier("topicSubtitleSourceVoService")
	private ITopicSubtitleSourceVoService topicSubtitleSourceVoService;
	@Autowired
	@Qualifier("sourceCommentService")
	private ISourceCommentService sourceCommentService;

	@Action(value = "view", results={
			@Result(name="success", location="../../../website/online_source_view.jsp")
			})
	public String viewSource() {
        List<Map<String,Object>> sourceCommentTree = sourceCommentService.sourceCommentTree(id);
		HttpServletRequest request = ServletActionContext.getRequest();
        if(type.equals("source")) {
            SourceVo s = sourceVoService.load(id);
            request.setAttribute("source", s);
        } else {
            TopicSubtitleSourceVo topicSubtitleSourceVo = topicSubtitleSourceVoService.load(id);
            request.setAttribute("source", topicSubtitleSourceVo);
        }
		request.setAttribute("sourceCommentTree", sourceCommentTree);
        request.setAttribute("type",type);
		return SUCCESS;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public String getMessage() {
		return message;
	}
	public void setId(int id) {
		this.id = id;
	}
    public void setType(String type) {
        this.type = type;
    }
}
