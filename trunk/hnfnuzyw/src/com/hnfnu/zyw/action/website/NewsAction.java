package com.hnfnu.zyw.action.website;

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

import com.hnfnu.zyw.dto.website.NewsDto;
import com.hnfnu.zyw.service.website.INewsService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Controller("newsAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/website")
public class NewsAction extends ActionSupport implements
ModelDriven<NewsDto> {
	
	private static final long serialVersionUID = -7199971221300636848L;
	private NewsDto news = new NewsDto();// ��ȡҳ���ύ����
	private boolean success;
	private String message;
	private Map<String, Object> newsList;

	@Autowired
	@Qualifier("newsService")
	private INewsService newsService;

	/**
	 * ��������
	 * @return
	 */
	@Action(value = "addNews")
	public String add() {
		success = newsService.add(news);
		if (success) {
			message = "�������ųɹ���";
		} else {
			message = "��������ʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * �޸�����
	 * @return
	 */
	@Action(value = "updateNews")
	public String update() {
		success = newsService.update(news);
		if (success) {
			message = "�޸����ųɹ���";
		} else {
			message = "�޸�����ʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * ��������ID��ѯһ������
	 * @return
	 */
	@Action(value = "loadNews")
	public String load() {
		news = newsService.load(news);
		return SUCCESS;
	}

	/**
	 * ��������idɾ��һ������
	 * @return
	 */

	@Action(value = "deleteNews")
	public String delete() {
		success = newsService.delete(news);
		if (success) {
			message = "ɾ�����ųɹ���";
		} else {
			message = "ɾ������ʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 *  ��ȡ������������
	 *  ��Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * @return
	 */
	@Action(value = "listNews")
	public String list() {
		newsList = newsService.listNews();
		return SUCCESS;
	}

	
	/* get set */
	public INewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}

	public NewsDto getModel() {
		return news;
	}

	public NewsDto getNews() {
		return news;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getNewsList() {
		return newsList;
	}


}