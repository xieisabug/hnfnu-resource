package com.hnfnu.zyw.action.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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

import com.hnfnu.zyw.action.base.AopNoSuchMethodErrorSolveBaseAction;
import com.hnfnu.zyw.dto.resources.SourceDto;
import com.hnfnu.zyw.dto.resources.TopicSourceDto;
import com.hnfnu.zyw.service.resources.ISourceService;
import com.hnfnu.zyw.service.resources.ITopicSourceService;

@Controller("sourceDownloadAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "stream", params = { "contentType",
		"application/octet-stream", "inputName", "inputStream",
		"contentDisposition", "filename='${fileName}'", "bufferSize", "4096" }) })
@Namespace("/file")
public class SourceDownloadAction extends AopNoSuchMethodErrorSolveBaseAction {
	// fileName是绝对路径
	private String url;
	private int id;
	private String fileName;
	private boolean success;
	private int type;// 0是课程资源，1是挂接资源，2是专题特有资源
	private String message;

	// public static final String FILEPATH =
	// "D:\\ruanjian\\apache-tomcat-7.0.39\\webapps\\hnfnuzyw\\uploads\\";

	@Autowired
	@Qualifier("sourceService")
	private ISourceService sourceService;

	@Autowired
	@Qualifier("topicSourceService")
	private ITopicSourceService topicSourceService;

	public String getFileName() {
		try {
			String[] s = url.split("\\\\");
			this.fileName = s[s.length - 1];
			fileName = java.net.URLEncoder.encode(fileName, "UTF-8");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return this.fileName;
	}

	public void setFileName(String fileName) {
		String[] s = url.split("\\");
		String f = s[s.length - 1];
		this.fileName = f;
	}

	public InputStream getInputStream() {
		try {
			return new FileInputStream(url);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Action(value = "download")
	public String execute() {
		SourceDto s = sourceService.load(id);
		if (s != null) {
			if (s.getUseTimes() == null) {
				s.setUseTimes(1);
			}
			s.setUseTimes(s.getUseTimes() + 1);
			success = sourceService.update(s);
		}

		return "success";
	}

	public void setId(int id) {
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/uploads");
		this.id = id;
		if (type < 2) {
			SourceDto s = sourceService.load(id);
			this.url = realpath + "\\" + s.getUrl();
		}else if(type == 2){
			TopicSourceDto topicSourceDto = topicSourceService.load(id);
			this.url = realpath + "\\" + topicSourceDto.getUrl();
		}

	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

}
