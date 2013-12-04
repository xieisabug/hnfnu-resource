package com.hnfnu.zyw.action.website;

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
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.dto.website.PicturesDto;
import com.hnfnu.zyw.service.website.IPicturesService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller("PicturesAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/website")
public class PicturesAction extends AopNoSuchMethodErrorSolveBaseAction implements
ModelDriven<PicturesDto>{
	private PicturesDto pictures = new PicturesDto();// »ñÈ¡Ò³ÃæÌá½»²ÎÊý
	private boolean success;
	private String message;
	private Map<String, Object> picturesMap;
	private List<PicturesDto> picturesList;
	private int count;

	@Autowired
	@Qualifier("picturesService")
	private IPicturesService picturesService;

	/**
	 * Ìí¼ÓÍ¼Æ¬
	 * @return
	 */
	@Action(value = "addPictures")
	public String add() {
		Date dt = new Date();
		// »ñÈ¡µ±Ç°ÓÃ»§
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		UserDto user = (UserDto) session.get("user");
		pictures.setCreateDate(dt);
		pictures.setCreateUserId(user.getId());
		pictures.setCreateUserName(user.getName());
		System.out.println(pictures);
		success = picturesService.add(pictures);
		if (success) {
			message = "Ìí¼ÓÍ¼Æ¬³É¹¦£¡";
		} else {
			message = "Ìí¼ÓÍ¼Æ¬Ê§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ÐÞ¸ÄÍ¼Æ¬
	 * @return
	 */
	@Action(value = "updatePictures")
	public String update() {
		PicturesDto p = picturesService.load(pictures);
		pictures.setSrc(p.getSrc());
		success = picturesService.update(pictures);
		if (success) {
			message = "ÐÞ¸ÄÍ¼Æ¬³É¹¦£¬Ë¢ÐÂÖ®ºó¿É²é¿´£¡";
		} else {
			message = "ÐÞ¸ÄÍ¼Æ¬Ê§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ¸ù¾ÝÍ¼Æ¬ID²éÑ¯Ò»¸öÍ¼Æ¬
	 * @return
	 */
	@Action(value = "loadPictures")
	public String load() {
		pictures = picturesService.load(pictures);
		if (pictures != null) {
			success = true;
			message = "¼ÓÔØÍ¼Æ¬³É¹¦£¡";
		} else {
			success = false;
			message = "¼ÓÔØÍ¼Æ¬Ê§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 * ¸ù¾ÝÍ¼Æ¬idÉ¾³ýÒ»¸öÍ¼Æ¬
	 * @return
	 */

	@Action(value = "deletePictures")
	public String delete() {
		success = picturesService.delete(pictures);
		if (success) {
			message = "É¾³ýÍ¼Æ¬³É¹¦£¡";
		} else {
			message = "É¾³ýÍ¼Æ¬Ê§°Ü£¡";
		}
		return SUCCESS;
	}

	
	/**
	 * »ñÈ¡¿ÉÒÔÏÔÊ¾µÄÍ¼Æ¬µÄÊýÁ¿
	 * @return
	 */

	@Action(value = "count")
	public String count() {
		count = picturesService.getCount();
		if(count < 0){
			success = false;
			message = "»ñÈ¡Í¼Æ¬ÊýÁ¿³É¹¦£¡";
		}else {
			message = "»ñÈ¡Í¼Æ¬ÊýÁ¿Ê§°Ü£¡";
		}
		return SUCCESS;
	}

	/**
	 *  »ñÈ¡±íÖÐËùÓÐÍ¼Æ¬
	 *  ÓÃMap×°£¬ÎªÁË·ÖÒ³µÄÐèÒª¼ÓÉÏRowsºÍTotal
	 * @return
	 */
	@Action(value = "mapPictures")
	public String map() {
		picturesMap = picturesService.listPictures();
		return SUCCESS;
	}

	
	/**
	 *  »ñÈ¡±íÖÐËùÓÐÍ¼Æ¬
	 *  ÓÃList×°
	 * @return
	 */
	@Action(value = "listPictures")
	public String list() {
		picturesList = picturesService.list();
		return SUCCESS;
	}
	
	/* get set */

	public PicturesDto getModel() {
		return pictures;
	}

	public PicturesDto getPictures() {
		return pictures;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getPicturesMap() {
		return picturesMap;
	}

	public List<PicturesDto> getPicturesList() {
		return picturesList;
	}

	public int getCount() {
		return count;
	}
	
}
