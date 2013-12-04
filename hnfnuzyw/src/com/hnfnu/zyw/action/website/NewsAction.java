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

import com.hnfnu.zyw.action.base.AopNoSuchMethodErrorSolveBaseAction;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.dto.website.NewsDto;
import com.hnfnu.zyw.service.website.INewsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller("NewsAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/website")
public class NewsAction extends AopNoSuchMethodErrorSolveBaseAction implements
ModelDriven<NewsDto>{
		private NewsDto news = new NewsDto();// »ñÈ¡Ò³ÃæÌá½»²ÎÊý
		private boolean success;
		private String message;
		private Map<String, Object> newsList;

		@Autowired
		@Qualifier("newsService")
		private INewsService newsService;

		/**
		 * Ìí¼ÓÐÂÎÅ
		 * @return
		 */
		@Action(value = "addNews")
		public String add() {
			Date dt = new Date();
			// »ñÈ¡µ±Ç°ÓÃ»§
			ActionContext context = ActionContext.getContext();
			Map<String, Object> session = context.getSession();
			UserDto user = (UserDto) session.get("user");
			news.setDate(dt);
			news.setCreateUserId(user.getId());
			success = newsService.add(news);
			newsList = newsService.listNews();
			if (success) {
				message = "Ìí¼ÓÐÂÎÅ³É¹¦£¬Ë¢ÐÂÖ®ºó¿É²é¿´£¡";
			} else {
				message = "Ìí¼ÓÐÂÎÅÊ§°Ü£¡";
			}
			return SUCCESS;
		}

		/**
		 * ÐÞ¸ÄÐÂÎÅ
		 * @return
		 */
		@Action(value = "updateNews")
		public String update() {
			
			success = newsService.update(news);
			newsList = newsService.listNews();
			if (success) {
				message = "ÐÞ¸ÄÐÂÎÅ³É¹¦£¬Ë¢ÐÂÖ®ºó¿É²é¿´£¡";
			} else {
				message = "ÐÞ¸ÄÐÂÎÅÊ§°Ü£¡";
			}
			return SUCCESS;
		}

		/**
		 * ¸ù¾ÝÐÂÎÅID²éÑ¯Ò»¸öÐÂÎÅ
		 * @return
		 */
		@Action(value = "loadNews")
		public String load() {
			news = newsService.load(news);
			if (news != null) {
				success = true;
				message = "¼ÓÔØÐÂÎÅ³É¹¦£¡";
			} else {
				success = false;
				message = "¼ÓÔØÐÂÎÅÊ§°Ü£¡";
			}
			return SUCCESS;
		}

		/**
		 * ¸ù¾ÝÐÂÎÅidÉ¾³ýÒ»¸öÐÂÎÅ
		 * @return
		 */

		@Action(value = "deleteNews")
		public String delete() {
			success = newsService.delete(news);
			if (success) {
				message = "É¾³ýÐÂÎÅ³É¹¦£¡";
			} else {
				message = "É¾³ýÐÂÎÅÊ§°Ü£¡";
			}
			return SUCCESS;
		}

		/**
		 *  »ñÈ¡±íÖÐËùÓÐÐÂÎÅ
		 *  ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
		 * @return
		 */
		@Action(value = "listNews")
		public String list() {
			newsList = newsService.listNews();
			return SUCCESS;
		}

		
		/* get set */

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