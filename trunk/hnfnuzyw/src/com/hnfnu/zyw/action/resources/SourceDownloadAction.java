package com.hnfnu.zyw.action.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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
import com.hnfnu.zyw.service.resources.ISourceService;

@Controller("sourceDownloadAction")
@Scope("prototype")
@ParentPackage("json-default")
@Results({ @Result(name = "success", type = "stream", params = { "contentType", "application/octet-stream","inputName","inputStream","contentDisposition","filename='${fileName}'","bufferSize","4096" }) })
@Namespace("/file")
public class SourceDownloadAction extends AopNoSuchMethodErrorSolveBaseAction {
	// fileName是绝对路径
	private String url;
	private int id;
	private String fileName;
	private boolean success;
	private String message;

	@Autowired
	@Qualifier("sourceService")
	private ISourceService sourceService;
	
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

	public void setUrl(String url) {
		this.url = url;
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
		System.out.println("id="+id);
		SourceDto s = sourceService.load(id);
		System.out.println("SourceDto"+s);
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
		this.id = id;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

}
