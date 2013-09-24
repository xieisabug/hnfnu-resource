package com.hnfnu.zyw.action.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

public class SourceDownloadAction extends ActionSupport{
	private static final long serialVersionUID = 7344069651943159764L;
	//fileNameÊÇ¾ø¶ÔÂ·¾¶
	private String url;
    
    public String getFileName() {
        return "201309211650035.doc"; 
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
   
    public String execute(){
            return "success";
    }

	

}
