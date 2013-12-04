﻿package com.hnfnu.zyw.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.FileUploadBase.InvalidContentTypeException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.util.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;


import sun.misc.BASE64Decoder;
import javax.servlet.http.HttpServletRequest;
/**
 * UEditoræ–‡ä»¶ä¸Šä¼ è¾…åŠ©ç±?
 *
 */
public class Uploader {
	// è¾“å‡ºæ–‡ä»¶åœ°å€
	private String url = "";
	// ä¸Šä¼ æ–‡ä»¶å?
	private String fileName = "";
	// çŠ¶æ?
	private String state = "";
	// æ–‡ä»¶ç±»åž‹
	private String type = "";
	// åŽŸå§‹æ–‡ä»¶å?
	private String originalName = "";
	// æ–‡ä»¶å¤§å°
	private String size = "";

	private HttpServletRequest request = null;
	private String title = "";

	// ä¿å­˜è·¯å¾„
	private String savePath = "upload";
	// æ–‡ä»¶å…è®¸æ ¼å¼
	private String[] allowFiles = { ".rar", ".doc", ".docx", ".zip", ".pdf",".txt", ".swf", ".wmv", ".gif", ".png", ".jpg", ".jpeg", ".bmp" };
	// æ–‡ä»¶å¤§å°é™åˆ¶ï¼Œå•ä½KB
	private int maxSize = 10000;
	
	private HashMap<String, String> errorInfo = new HashMap<String, String>();

	public Uploader(HttpServletRequest request) {
		this.request = request;
		HashMap<String, String> tmp = this.errorInfo;
		tmp.put("SUCCESS", "SUCCESS"); //é»˜è®¤æˆåŠŸ
		tmp.put("NOFILE", "æœªåŒ…å«æ–‡ä»¶ä¸Šä¼ åŸŸ");
		tmp.put("TYPE", "ä¸å…è®¸çš„æ–‡ä»¶æ ¼å¼");
		tmp.put("SIZE", "æ–‡ä»¶å¤§å°è¶…å‡ºé™åˆ¶");
		tmp.put("ENTYPE", "è¯·æ±‚ç±»åž‹ENTYPEé”™è¯¯");
		tmp.put("REQUEST", "ä¸Šä¼ è¯·æ±‚å¼‚å¸¸");
		tmp.put("IO", "IOå¼‚å¸¸");
		tmp.put("DIR", "ç›®å½•åˆ›å»ºå¤±è´¥");
		tmp.put("UNKNOWN", "æœªçŸ¥é”™è¯¯");
	
	}

	public void upload() throws Exception {
		boolean isMultipart = ServletFileUpload.isMultipartContent(this.request);
		if (!isMultipart) {
			this.state = this.errorInfo.get("NOFILE");
			return;
		}
		DiskFileItemFactory dff = new DiskFileItemFactory();
		String savePath = this.getFolder(this.savePath);
		dff.setRepository(new File(savePath));
		try {
			ServletFileUpload sfu = new ServletFileUpload(dff);
			sfu.setSizeMax(this.maxSize * 1024);
			sfu.setHeaderEncoding("utf-8");
			FileItemIterator fii = sfu.getItemIterator(this.request);
			while (fii.hasNext()) {
				FileItemStream fis = fii.next();
				if (!fis.isFormField()) {
					this.originalName = fis.getName().substring(fis.getName().lastIndexOf(System.getProperty("file.separator")) + 1);
					if (!this.checkFileType(this.originalName)) {
						this.state = this.errorInfo.get("TYPE");
						continue;
					}
					this.fileName = this.getName(this.originalName);
					this.type = this.getFileExt(this.fileName);
					this.url = savePath + "/" + this.fileName;
					BufferedInputStream in = new BufferedInputStream(fis.openStream());
					FileOutputStream out = new FileOutputStream(new File(this.getPhysicalPath(this.url)));
					BufferedOutputStream output = new BufferedOutputStream(out);
					Streams.copy(in, output, true);
					this.state=this.errorInfo.get("SUCCESS");
					//UEä¸­åªä¼šå¤„ç†å•å¼ ä¸Šä¼ ï¼Œå®ŒæˆåŽå³é€?‡º
					break;
				} else {
					String fname = fis.getFieldName();
					//åªå¤„ç†titleï¼Œå…¶ä½™è¡¨å•è¯·è‡ªè¡Œå¤„ç†
					if(!fname.equals("pictitle")){
						continue;
					}
                    BufferedInputStream in = new BufferedInputStream(fis.openStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuffer result = new StringBuffer();  
                    while (reader.ready()) {  
                        result.append((char)reader.read());  
                    }
                    this.title = new String(result.toString().getBytes(),"utf-8");
                    reader.close();  
                    
				}
			}
		} catch (SizeLimitExceededException e) {
			this.state = this.errorInfo.get("SIZE");
		} catch (InvalidContentTypeException e) {
			this.state = this.errorInfo.get("ENTYPE");
		} catch (FileUploadException e) {
			this.state = this.errorInfo.get("REQUEST");
		} catch (Exception e) {
			this.state = this.errorInfo.get("UNKNOWN");
		}
	}
	
	/**
	 * æŽ¥å—å¹¶ä¿å­˜ä»¥base64æ ¼å¼ä¸Šä¼ çš„æ–‡ä»?
	 * @param fieldName
	 */
	public void uploadBase64(String fieldName){
		String savePath = this.getFolder(this.savePath);
		String base64Data = this.request.getParameter(fieldName);
		this.fileName = this.getName("test.png");
		this.url = savePath + "/" + this.fileName;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			File outFile = new File(this.getPhysicalPath(this.url));
			OutputStream ro = new FileOutputStream(outFile);
			byte[] b = decoder.decodeBuffer(base64Data);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			ro.write(b);
			ro.flush();
			ro.close();
			this.state=this.errorInfo.get("SUCCESS");
		} catch (Exception e) {
			this.state = this.errorInfo.get("IO");
		}
	}

	/**
	 * æ–‡ä»¶ç±»åž‹åˆ¤æ–­
	 * 
	 * @param fileName
	 * @return
	 */
	private boolean checkFileType(String fileName) {
		Iterator<String> type = Arrays.asList(this.allowFiles).iterator();
		while (type.hasNext()) {
			String ext = type.next();
			if (fileName.toLowerCase().endsWith(ext)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * èŽ·å–æ–‡ä»¶æ‰©å±•å?
	 * 
	 * @return string
	 */
	private String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * ä¾æ®åŽŸå§‹æ–‡ä»¶åç”Ÿæˆæ–°æ–‡ä»¶å?
	 * @return
	 */
	private String getName(String fileName) {
		Random random = new Random();
		return this.fileName = "" + random.nextInt(10000)
				+ System.currentTimeMillis() + this.getFileExt(fileName);
	}

	/**
	 * æ ¹æ®å­—ç¬¦ä¸²åˆ›å»ºæœ¬åœ°ç›®å½?å¹¶æŒ‰ç…§æ—¥æœŸå»ºç«‹å­ç›®å½•è¿”å›ž
	 * @param path 
	 * @return 
	 */
	private String getFolder(String path) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
		path += "/" + formater.format(new Date());
		File dir = new File(this.getPhysicalPath(path));
		if (!dir.exists()) {
			try {
				dir.mkdirs();
			} catch (Exception e) {
				this.state = this.errorInfo.get("DIR");
				return "";
			}
		}
		return path;
	}

	/**
	 * æ ¹æ®ä¼ å…¥çš„è™šæ‹Ÿè·¯å¾„èŽ·å–ç‰©ç†è·¯å¾?
	 * 
	 * @param path
	 * @return
	 */
	private String getPhysicalPath(String path) {
		String servletPath = this.request.getServletPath();
		String realPath = this.request.getSession().getServletContext()
				.getRealPath(servletPath);
		return new File(realPath).getParent() +"/" +path;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public void setAllowFiles(String[] allowFiles) {
		this.allowFiles = allowFiles;
	}

	public void setMaxSize(int size) {
		this.maxSize = size;
	}

	public String getSize() {
		return this.size;
	}

	public String getUrl() {
		return this.url;
	}

	public String getFileName() {
		return this.fileName;
	}

	public String getState() {
		return this.state;
	}
	
	public String getTitle() {
		return this.title;
	}

	public String getType() {
		return this.type;
	}

	public String getOriginalName() {
		return this.originalName;
	}
}
