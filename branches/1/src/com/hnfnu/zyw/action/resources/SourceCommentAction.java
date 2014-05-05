package com.hnfnu.zyw.action.resources;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hnfnu.zyw.dto.system.UserDto;
import com.opensymphony.xwork2.ActionContext;
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
import com.hnfnu.zyw.dto.resources.SourceCommentDto;
import com.hnfnu.zyw.service.resources.ISourceCommentService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("sourceCommentAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/resources")
public class SourceCommentAction extends AopNoSuchMethodErrorSolveBaseAction
		implements ModelDriven<SourceCommentDto> {
	private SourceCommentDto sourceComment = new SourceCommentDto();// 获取页面提交参数
	private boolean success;
	private String message;
	private List<Map<String, Object>> sourceCommentTree;
	private List<SourceCommentDto> sourceComments;
    private String name;
    private String icon;

	@Autowired
	@Qualifier("sourceCommentService")
	private ISourceCommentService sourceCommentService;

	// 添加评论
	@Action(value = "addSourceComment")
	public String add() {
		//判断是否是回复的回复
		if (sourceComment.getParentId() > 0) {
			SourceCommentDto parentComment = sourceCommentService
					.load(sourceComment.getParentId());
			//判断父评论是否是一级回复，如果不是就把自己变成父评论的兄弟评论
			if (parentComment.getParentId() > 0) {
				sourceComment.setParentId(parentComment.getParentId());
			}
        }
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = context.getSession();
        UserDto user = (UserDto) session.get("user");
        sourceComment.setCreateDate(new Date());
        sourceComment.setCreateId(user.getId());
        name = user.getName();
        icon = user.getIcon();
		success = sourceCommentService.add(sourceComment);
		if (success) {
			message = "添加评论成功！";
		} else {
			message = "添加评论失败！";
		}
		return SUCCESS;
	}

	// 修改评论
	@Action(value = "updateSourceComment")
	public String update() {
		success = sourceCommentService.update(sourceComment);
		if (success) {
			message = "修改评论成功！";
		} else {
			message = "修改评论失败！";
		}
		return SUCCESS;
	}

	/**
	 * 根据评论ID查询一个评论
	 * 
	 * @return
	 */
	@Action(value = "loadSourceComment")
	public String load() {
		sourceComment = sourceCommentService.load(sourceComment.getId());
		return SUCCESS;
	}

	/**
	 * 根据评论id删除一个评论
	 * 
	 * @return
	 */

	@Action(value = "deleteSourceComment")
	public String delete() {
		success = sourceCommentService.delete(sourceComment.getId());
		if (success) {
			message = "删除评论成功！";
		} else {
			message = "删除评论失败！";
		}
		return SUCCESS;
	}

	// 获取一个资源的所有评论，树形显示
	@Action(value = "sourceCommentTree")
	public String sourceCommentTree() {
		sourceCommentTree = sourceCommentService.sourceCommentTree(sourceComment.getSourceId());
		return SUCCESS;
	}

	// 获取表中所有评论，用List装
	@Action(value = "listSourceComments")
	public String listSourceComments() {
		sourceComments = sourceCommentService.list();
		return SUCCESS;
	}

	/* get set */
	public SourceCommentDto getModel() {
		return sourceComment;
	}

	public SourceCommentDto getSourceComment() {
		return sourceComment;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public List<Map<String, Object>> getSourceCommentTree() {
		return sourceCommentTree;
	}

	public List<SourceCommentDto> getSourceComments() {
		return sourceComments;
	}

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }
}
