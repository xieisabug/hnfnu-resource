package com.hnfnu.zyw.action.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class SourceUploadAction extends ActionSupport implements
		ServletRequestAware {
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;

	private List<File> fileName;// ÕâÀïµÄ"fileName"Ò»¶¨ÒªÓë±íµ¥ÖÐµÄÎÄ¼þÓòÃûÏàÍ¬

	private List<String> fileNameContentType;// ¸ñÊ½Í¬ÉÏ"fileName"+ContentType

	private List<String> fileNameFileName;// ¸ñÊ½Í¬ÉÏ"fileName"+FileName

	private String savePath;// ÎÄ¼þÉÏ´«ºó±£´æµÄÂ·¾¶

	/**
	 * @return
	 * @author lijf
	 * @description ÉÏ´«ÎÄ¼þ
	 * @update 2013-1-26 ÏÂÎç02:15:26
	 */
	public void upload() throws Exception {// intentionPicture

		String uploadFileName = "";

		File dir = new File(getSavePath());

		String savePath = getSavePath();// ±£´æÉÏ´«ÎÄ¼þµÄµØÖ·
		//System.out.println("savePath"+savePath);
		

		if (!dir.exists()) {

			dir.mkdirs();

		}

		List<File> files = getFileName();

		for (int i = 0; i < files.size(); i++) {
			//ÅÐ¶ÏÎÄ¼þÃûÊÇ·ñÖØ¸´£¬Èç¹ûÖØ¸´¾Í¼ÓÉÏ£¨Êý×Ö£©
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//ÉèÖÃÈÕÆÚ¸ñÊ½
			String fn = df.format(new Date()) + Math.round(Math.random() * 10);
			//¼ÓÉÏÎÄ¼þºó×ºÃû
			fn = fn+getFileNameFileName().get(i);
			FileOutputStream fos = new FileOutputStream(getSavePath() + "\\"
					+ fn);
			FileInputStream fis = new FileInputStream(getFileName().get(i));

			byte[] buffers = new byte[1024];

			int len = 0;

			while ((len = fis.read(buffers)) != -1) {

				fos.write(buffers, 0, len);

			}

			fos.close();

			fis.close();

			uploadFileName = fn;

		}

		// ÉèÖÃÏìÓ¦ÄÚÈÝµÄ×Ö·û´®±àÂë

		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");

		ServletActionContext.getResponse().setContentType("text/plain");

		ServletActionContext.getResponse().getWriter().print(
				uploadFileName + "," + savePath + "\\" + uploadFileName);

	}

	/*
	 * (non-Javadoc)ÏÂÔØÎÄ¼þ
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */

	@Override
	public String execute() throws Exception {


		return "success";

	}

	public InputStream getInputStream() {
		
		return ServletActionContext.getServletContext().getResourceAsStream(
				"/" + fileName);

	}

	public void setServletRequest(HttpServletRequest req) {

		this.request = req;

	}

	public List<File> getFileName() {

		return fileName;

	}

	public void setFileName(List<File> fileName) {

		this.fileName = fileName;

	}

	public List<String> getFileNameContentType() {

		return fileNameContentType;

	}

	public void setFileNameContentType(List<String> fileNameContentType) {

		this.fileNameContentType = fileNameContentType;

	}

	public List<String> getFileNameFileName() {

		return fileNameFileName;

	}

	public void setFileNameFileName(List<String> fileNameFileName) {

		this.fileNameFileName = fileNameFileName;

	}

	//@SuppressWarnings("deprecation")
	public String getSavePath() {
		return request.getSession().getServletContext().getRealPath(savePath);

	}

	public void setSavePath(String savePath) {

		
		this.savePath = savePath;
		

	}

}
