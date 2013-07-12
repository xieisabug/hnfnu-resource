package com.hnfnu.zyw.action.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class SourceUploadAction extends ActionSupport implements
		ServletRequestAware {
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;

	private List<File> fileName;// �����"fileName"һ��Ҫ������е��ļ�������ͬ

	private List<String> fileNameContentType;// ��ʽͬ��"fileName"+ContentType

	private List<String> fileNameFileName;// ��ʽͬ��"fileName"+FileName

	private String savePath;// �ļ��ϴ��󱣴��·��

	/**
	 * 
	 * 
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @author lijf
	 * 
	 * @description �ϴ��ļ�
	 * 
	 * @update 2013-1-26 ����02:15:26
	 */

	public void upload() throws Exception {// intentionPicture

		String uploadFileName = "";

		File dir = new File(getSavePath());

		String savePath = getSavePath();// �����ϴ��ļ��ĵ�ַ

		if (!dir.exists()) {

			dir.mkdirs();

		}

		List<File> files = getFileName();

		for (int i = 0; i < files.size(); i++) {

			FileOutputStream fos = new FileOutputStream(getSavePath() + "\\"
					+ getFileNameFileName().get(i));

			FileInputStream fis = new FileInputStream(getFileName().get(i));

			byte[] buffers = new byte[1024];

			int len = 0;

			while ((len = fis.read(buffers)) != -1) {

				fos.write(buffers, 0, len);

			}

			fos.close();

			fis.close();

			uploadFileName = getFileNameFileName().get(i);

		}

		// ������Ӧ���ݵ��ַ�������

		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");

		ServletActionContext.getResponse().setContentType("text/plain");

		ServletActionContext.getResponse().getWriter().print(
				uploadFileName + "," + savePath + "\\" + uploadFileName);

	}

	/*
	 * (non-Javadoc)�����ļ�
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */

	@Override
	public String execute() throws Exception {

		// TODO Auto-generated method stub

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