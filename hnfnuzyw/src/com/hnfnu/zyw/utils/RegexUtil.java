package com.hnfnu.zyw.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	
	//获取上传文件附件后生成的html文件中的a标签的href中文件的地址与文件名
	public static List<String> findUploadFilesATagHref(String html){
		
		String regex = "(?<=[\\s+]?href[\\s+]?=[\\s+]?('|\")?/hnfnuzyw/ueditor/jsp/upload/)[^(\"|')>]+?(?=\"|')";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(html);
		
		List<String> ret = new ArrayList<String>();

		while(m.find()) {
			ret.add(m.group());
		}
		
		return ret;
	}
	
}
