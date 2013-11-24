package com.hnfnu.zyw.action.website;

import java.util.Date;
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

import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.dto.website.NewsDto;
import com.hnfnu.zyw.service.website.INewsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("NewsAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/website")
public class NewsAction extends ActionSupport implements
ModelDriven<NewsDto>{
		private static final long serialVersionUID = -7199971221300636848L;
		private NewsDto news = new NewsDto();// 获取页面提交参数
		private boolean success;
		private String message;
		private Map<String, Object> newsList;

		@Autowired
		@Qualifier("newsService")
		private INewsService newsService;

		/**
		 * 添加新闻
		 * @return
		 */
		@Action(value = "addNews")
		public String add() {
			Date dt = new Date();
			// 获取当前用户
			ActionContext context = ActionContext.getContext();
			Map<String, Object> session = context.getSession();
			UserDto user = (UserDto) session.get("user");
			news.setDate(dt);
			news.setCreateUserId(user.getId());
			success = newsService.add(news);
			newsList = newsService.listNews();
			if (success) {
				message = "添加新闻成功，刷新之后可查看！";
			} else {
				message = "添加新闻失败！";
			}
			return SUCCESS;
		}

		/**
		 * 修改新闻
		 * @return
		 */
		@Action(value = "updateNews")
		public String update() {
			
			success = newsService.update(news);
			newsList = newsService.listNews();
			if (success) {
				message = "修改新闻成功，刷新之后可查看！";
			} else {
				message = "修改新闻失败！";
			}
			return SUCCESS;
		}

		/**
		 * 根据新闻ID查询一个新闻
		 * @return
		 */
		@Action(value = "loadNews")
		public String load() {
			news = newsService.load(news);
			if (news != null) {
				success = true;
				message = "加载新闻成功！";
			} else {
				success = false;
				message = "加载新闻失败！";
			}
			return SUCCESS;
		}

		/**
		 * 根据新闻id删除一个新闻
		 * @return
		 */

		@Action(value = "deleteNews")
		public String delete() {
			success = newsService.delete(news);
			if (success) {
				message = "删除新闻成功！";
			} else {
				message = "删除新闻失败！";
			}
			return SUCCESS;
		}

		/**
		 *  获取表中所有新闻
		 *  用Map装，为了分页的需要加上Rows和Total
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