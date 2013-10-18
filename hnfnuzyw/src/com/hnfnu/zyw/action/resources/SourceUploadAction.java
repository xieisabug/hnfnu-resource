package com.hnfnu.zyw.action.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class SourceUploadAction extends ActionSupport implements
		ServletRequestAware {
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;

	private List<File> fileName;// 这里的"fileName"一定要与表单中的文件域名相同

	private List<String> fileNameContentType;// 格式同上"fileName"+ContentType

	private List<String> fileNameFileName;// 格式同上"fileName"+FileName

	private String savePath;// 文件上传后保存的路径

	/**
	 * @return
	 * @author lijf
	 * @description 上传文件
	 * @update 2013-1-26 下午02:15:26
	 */
	public void upload() throws Exception {// intentionPicture

		String uploadFileName = "";

		File dir = new File(getSavePath());

		String savePath = getSavePath();// 保存上传文件的地址
		//System.out.println("savePath"+savePath);
		

		if (!dir.exists()) {

			dir.mkdirs();

		}

		List<File> files = getFileName();

		for (int i = 0; i < files.size(); i++) {
			//判断文件名是否重复，如果重复就加上（数字）
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
			String fn = df.format(new Date()) + Math.round(Math.random() * 10);
			//加上文件后缀名
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

		// 设置响应内容的字符串编码

		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");

		ServletActionContext.getResponse().setContentType("text/plain");

		ServletActionContext.getResponse().getWriter().print(
				uploadFileName + "," + savePath + "\\" + uploadFileName);

	}

	/*
	 * (non-Javadoc)下载文件
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
