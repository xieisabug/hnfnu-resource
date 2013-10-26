package com.hnfnu.zyw.action.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.hnfnu.zyw.dto.resources.SourceDto;
import com.hnfnu.zyw.service.resources.ISourceService;
import com.hnfnu.zyw.service.resources.SourcesServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class SourceDownloadAction extends ActionSupport {
	private static final long serialVersionUID = 7344069651943159764L;
	// fileNameÊÇ¾ø¶ÔÂ·¾¶
	private String url;
	private int id;
	private String fileName;
	private ISourceService sourceService = new SourcesServiceImpl();
	private boolean success;
	private String message;

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

	public String execute() {
		System.out.println("id="+id);
		SourceDto s = sourceService.load(id);
		if (s != null) {
			if (s.getUseTimes() == null) {
				s.setUseTimes(1);
			} else {
				s.setViewTimes(s.getUseTimes() + 1);
			}
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
