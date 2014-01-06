package com.hnfnu.zyw.utils;

import java.io.File;

import org.apache.struts2.ServletActionContext;

public class FileUtils {
	
	public static boolean deleteOneFile(String url){
		File file = new File(url);
		String filePath = null;
		//System.out.println(url);
        filePath = ServletActionContext.getServletContext().getRealPath("/");
		// 判断目录或文件是否存在
		if (!file.exists()) { // 不存在就添加文件后缀名做
			String[] s = url.split("\\\\");
			String[] temp = s[s.length-1].split("\\.");
			String fileFormat = temp[temp.length-1];
			//System.out.println(fileFormat);
			String path =s[0];
			for (int i = 1; i < s.length-1; i++) {
				path = path +"\\"  + s[i];
			}
			path = path + "\\" + fileFormat+"\\"+s[s.length-1];
			File file2  = new File(path);
			if(file2.exists()){
				if (file2.delete()) {
					return true;
				} else {
					return false;
				}
			}else{
				//System.out.println(filePath+"\\uploads\\"+url);
				File file3 = new File(filePath+"\\uploads\\"+url);
				if(file3.exists()){
					if (file3.delete()) {
						return true;
					} else {
						return false;
					}
				}
				return true;
			}
		} else {
			//存在就删除该文件
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		}
	}

}
