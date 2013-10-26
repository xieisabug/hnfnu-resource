package com.hnfnu.zyw.action.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

public class SourceDownloadAction extends ActionSupport {
	private static final long serialVersionUID = 7344069651943159764L;
	// fileNameÊÇ¾ø¶ÔÂ·¾¶
	private String url;
	private String fileName;

	public String getFileName() {
		try {
			String[] s = url.split("\\\\");
			this.fileName = s[s.length-1];
			fileName = java.net.URLEncoder.encode(fileName, "UTF-8"); 

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.fileName;
	}
	
	public void setFileName(String fileName) {
		String[] s = url.split("\\");
		String f = s[s.length-1];
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
		return "success";
	}

}
