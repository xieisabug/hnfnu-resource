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

import com.hnfnu.zyw.dto.resources.CategoryDto;
import com.hnfnu.zyw.dto.resources.SourceDto;
import com.hnfnu.zyw.dto.system.UserDto;
import com.hnfnu.zyw.service.resources.ICategoryService;
import com.hnfnu.zyw.service.resources.ISourceService;
import com.hnfnu.zyw.service.resources.ISourceVoService;
import com.hnfnu.zyw.vo.SourceVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("sourceAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results( { @Result(name = "success", type = "json", params = { "root",
		"action" }) })
@Namespace("/resources")
public class SourceAction extends ActionSupport implements
		ModelDriven<SourceDto> {
	private static final long serialVersionUID = -7199971221300636848L;
	private SourceDto source = new SourceDto();// ��ȡҳ���ύ����
	private SourceVo sourceVo;// ��ȡҳ���ύ����
	private boolean success;
	private String message;
	private Map<String, Object> sourceVoList;
	private Map<String, Object> sourceMoreVoList;
	private UserDto user;
	private Integer categoryId;
	private String categoryIdList;
	private List<Map<String, Object>> allTree;
	private List<Map<String, Object>> courseTree;
	private List<CategoryDto> categoryList;

	@Autowired
	@Qualifier("sourceService")
	private ISourceService sourceService;

	@Autowired
	@Qualifier("sourceVoService")
	private ISourceVoService sourceVoService;

	@Autowired
	@Qualifier("categoryService")
	private ICategoryService categoryService;

	// �����Դ
	@Action(value = "addSource")
	public String add() {
		// ��ȡ��ǰʱ��
		Date date = new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		source.setCreateDate(timeStamp);
		source.setViewTimes(0);
		// ��ȡ��ǰ�û�
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		user = (UserDto) session.get("user");
		source.setCreateUserId(user.getId());
		source.setApprovalStatus("0");
		source.setUseTimes(0);
		String kw = source.getKeyWords();
		if(kw != null && !"".equals(kw)){
			kw += ";"+ source.getName();
		}else{
			kw += source.getName();
		}
		
		source.setKeyWords(kw);
		success = sourceService.add(source, categoryIdList);
		if (success) {
			message = "�����Դ�ɹ���";
		} else {
			message = "�����Դʧ�ܣ�";
		}
		return SUCCESS;
	}

	// �޸���Դ
	@Action(value = "updateSource")
	public String update() {
		success = sourceService.update(source,categoryIdList);
		if (success) {
			message = "�޸���Դ�ɹ���";
		} else {
			message = "�޸���Դʧ�ܣ�";
		}
		return SUCCESS;
	}

	/**
	 * ������ԴID��ѯһ����Դ,ǰ̨ÿ��ѯһ��viewTimes����һ��
	 * 
	 * 
	 * @return
	 */
	@Action(value = "loadSourceVo")
	public String load() {
		sourceVo = sourceVoService.load(source.getId());
		source = sourceService.load(source.getId());
		source.setViewTimes(source.getViewTimes()+1);
		sourceService.update(source);
		return SUCCESS;
	}


	// ɾ���ļ��ķ�����������ص���1˵��ɾ���ɹ���-1˵���ļ������ڡ�0˵���ļ�ɾ������2˵���ļ�ɾ���ɹ�����Ϣɾ������
	@Action(value = "deleteSource")
	public String delete() {
		
		int i = sourceService.delete(source.getUrl(),source.getId());
		if (i == 1) {
			success = true;
			message = "ɾ����Դ�ļ��ɹ���";
		} else if (i == -1) {
			success = true;// ��Ȼɾ��ʧ�ܣ�����true������ļ��Ѿ������ڣ�ҳ���ϵĶԻ����Զ���ʧ
			message = "�ļ�������,��Դ��Ϣ�Ѿ�ɾ��";
		} else if (i == 0) {
			success = false;
			message = "ɾ����Դ�ļ�ʧ�ܣ�";
		}
		return SUCCESS;
	}

	// ����courceId��categoryId��ȡ����������Դ����Mapװ��Ϊ�˷�ҳ����Ҫ����Rows��Total
	@Action(value = "sourceMoreVoList")
	public String list() {
		sourceMoreVoList = sourceVoService.listSourceVo(source.getCourseId(),
				categoryId);
		return SUCCESS;
	}

	// ҳ���ϵ�һ����ʾ�������ݵ���
	@Action(value = "allTree")
	public String allTree() {
		allTree = sourceVoService.allTree();
		return SUCCESS;
	}

	// ҳ���ϵ�һ����ʾ�������ݵ���
	@Action(value = "courseTree")
	public String courseTree() {
		courseTree = sourceVoService.courseTree();
		return SUCCESS;
	}

	// ��ȡform�е������б�ֵ
	@Action(value = "formSelect")
	public String formSelect() {
		categoryList = categoryService.list();
		return SUCCESS;
	}

	/* get set */
	public ISourceService getSourceService() {
		return sourceService;
	}

	public void setSourceService(ISourceService sourceService) {
		this.sourceService = sourceService;
	}

	public SourceDto getModel() {
		return source;
	}

	public SourceDto getSource() {
		return source;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Map<String, Object> getSourceList() {
		return sourceVoList;
	}

	public SourceVo getSourceVo() {
		return sourceVo;
	}

	public void setSourceVo(SourceVo sourceVo) {
		this.sourceVo = sourceVo;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryIdList() {
		return categoryIdList;
	}

	public void setCategoryIdList(String categoryIdList) {
		this.categoryIdList = categoryIdList;
	}

	public List<Map<String, Object>> getAllTree() {
		return allTree;
	}

	public Map<String, Object> getSourceMoreVoList() {
		return sourceMoreVoList;
	}

	public void setSourceMoreVoList(Map<String, Object> sourceMoreVoList) {
		this.sourceMoreVoList = sourceMoreVoList;
	}

	public List<CategoryDto> getCategoryList() {
		return categoryList;
	}

	public List<Map<String, Object>> getCourseTree() {
		return courseTree;
	}

}
