package com.hnfnu.zyw.utils;

import java.io.File;

public class FileUtils {
	
	public static boolean deleteOneFile(String url){
		File file = new File(url);

		// 判断目录或文件是否存在
		if (!file.exists()) { // 不存在返回 true,当做已经删除
			return true;
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
