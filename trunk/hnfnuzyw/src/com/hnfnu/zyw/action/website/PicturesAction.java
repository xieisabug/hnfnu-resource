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

import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.dto.website.PicturesDto;
import com.hnfnu.zyw.service.website.IPicturesService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("PicturesAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "json", params = { "root", "action" }) })
@Namespace("/website")
public class PicturesAction extends ActionSupport implements
ModelDriven<PicturesDto>{
	private static final long serialVersionUID = -7199971221300636848L;
	private PicturesDto pictures = new PicturesDto();// ��ȡҳ���ύ����
	private boolean success;
	private String message;
	private Map<String, Object> picturesMap;
	private List<PicturesDto> picturesList;

	@Autowired
	@Qualifier("picturesService")
	private IPicturesService picturesService;

	/**
	 * ���ͼƬ
	 * @return
	 */
	@Action(value = "addPictures")
	public String add() {
		Date dt = new Date();
		// ��ȡ��ǰ�û�
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		UserDto user = (UserDto) session.get("user");
		pictures.setCreateDate(dt);
		pictures.setCreateUserId(user.getId());
		pictures.setCreateUserName(user.getName());
		System.out.println(pictures);
		success = picturesService.add(pictures);
		if (success) {
			message = "���ͼƬ�ɹ���";
		} else {
			message = "���ͼƬʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * �޸�ͼƬ
	 * @return
	 */
	@Action(value = "updatePictures")
	public String update() {
		success = picturesService.update(pictures);
		if (success) {
			message = "�޸�ͼƬ�ɹ���ˢ��֮��ɲ鿴��";
		} else {
			message = "�޸�ͼƬʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * ����ͼƬID��ѯһ��ͼƬ
	 * @return
	 */
	@Action(value = "loadPictures")
	public String load() {
		pictures = picturesService.load(pictures);
		if (pictures != null) {
			success = true;
			message = "����ͼƬ�ɹ���";
		} else {
			success = false;
			message = "����ͼƬʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * ����ͼƬidɾ��һ��ͼƬ
	 * @return
	 */

	@Action(value = "deletePictures")
	public String delete() {
		success = picturesService.delete(pictures);
		if (success) {
			message = "ɾ��ͼƬ�ɹ���";
		} else {
			message = "ɾ��ͼƬʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 *  ��ȡ��������ͼƬ
	 *  ��Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	 * @return
	 */
	@Action(value = "mapPictures")
	public String map() {
		picturesMap = picturesService.listPictures();
		return SUCCESS;
	}

	
	/**
	 *  ��ȡ��������ͼƬ
	 *  ��Listװ
	 * @return
	 */
	@Action(value = "listPictures")
	public String list() {
		picturesList = picturesService.list();
		return SUCCESS;
	}
	
	/* get set */
	public IPicturesService getPicturesService() {
		return picturesService;
	}

	public void setPicturesService(IPicturesService picturesService) {
		this.picturesService = picturesService;
	}

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
}
