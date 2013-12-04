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

import com.hnfnu.zyw.dto.resources.TopicDto;
import com.hnfnu.zyw.service.resources.ITopicService;
import com.hnfnu.zyw.service.resources.ITopicSourceVoService;
import com.hnfnu.zyw.vo.TopicSourceVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Controller("topicAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class TopicAction extends ActionSupport implements
ModelDriven<TopicDto>{
	
	private static final long serialVersionUID = -7199971221300636848L;
	private TopicDto topic = new TopicDto();// ��ȡҳ���ύ����
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

	// ���ר��
	@Action(value = "addTopic")
	public String add() {
		success = topicService.add(topic);
		if (success) {
			message = "���ר��ɹ���";
		} else {
			message = "���ר��ʧ�ܣ�";
		}
		return SUCCESS;
	}

	// �޸�ר��
	@Action(value = "updateTopic")
	public String update() {
		success = topicService.update(topic);
		if (success) {
			message = "�޸�ר��ɹ���";
		} else {
			message = "�޸�ר��ʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * ����ר��ID��ѯһ��ר��
	 * 
	 * @return
	 */
	@Action(value = "loadTopic")
	public String load() {
		topic = topicService.load(topic.getId());
		return SUCCESS;
	}

	/**
	 * ����ר��idɾ��һ��ר��
	 * 
	 * @return
	 */

	@Action(value = "deleteTopic")
	public String delete() {
		success = topicService.delete(topic.getId());
		if (success) {
			message = "ɾ��ר��ɹ���";
		} else {
			message = "ɾ��ר��ʧ�ܣ�";
		}
		return SUCCESS;
	}

	// ��ȡ��������ר�⣬��Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	@Action(value = "listTopic")
	public String list() {
		topicList = topicService.listTopic();
		return SUCCESS;
	}
	
	// ��ȡ��������ר�⣬��Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	@Action(value = "listSourceByTopicId")
	public String listSourceByTopicId() {
		topicSourceList = topicSourceVoService.listByTopicId(topic.getId());
		return SUCCESS;
	}

	// ��ȡ��������ר�⣬��Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
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
